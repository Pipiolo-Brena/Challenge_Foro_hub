// src/main/java/com/aluracursos/Foro_hub/domain/usuarios/UsuarioRepository.java

package com.aluracursos.Foro_hub.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Cambia findByLogin a findByEmail
    UserDetails findByEmail(String email);
}