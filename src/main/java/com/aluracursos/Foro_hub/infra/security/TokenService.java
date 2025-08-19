// src/main/java/com/aluracursos/Foro_hub/infra/security/TokenService.java

package com.aluracursos.Foro_hub.infra.security;

import com.aluracursos.Foro_hub.domain.usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String apiSecret;
    private final String apiIssuer;

    public TokenService(@Value("${api.security.secret}") String apiSecret,
                        @Value("${api.security.issuer}") String apiIssuer) {
        this.apiSecret = apiSecret;
        this.apiIssuer = apiIssuer;
    }

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer(apiIssuer)
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar el token JWT", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("Token inválido o nulo.");
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer(apiIssuer) // Aquí se valida que el emisor sea el mismo
                    .build()
                    .verify(token);
            if (verifier.getSubject() == null) {
                throw new RuntimeException("Verifier inválido");
            }
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error: " + exception.getMessage(), exception);
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
    }
}