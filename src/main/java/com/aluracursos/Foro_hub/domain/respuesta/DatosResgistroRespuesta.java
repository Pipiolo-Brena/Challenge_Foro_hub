package com.aluracursos.Foro_hub.domain.respuesta;


public record DatosResgistroRespuesta(
        String mensaje,
        Long topicoId,
        Long usuarioId
) {}
