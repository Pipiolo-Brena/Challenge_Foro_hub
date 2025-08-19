package com.aluracursos.Foro_hub.domain.respuesta;


import java.time.LocalDateTime;

public record DatosrespuestaRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean solucion,
        String autorNombre,
        Long topicoId
) {}

