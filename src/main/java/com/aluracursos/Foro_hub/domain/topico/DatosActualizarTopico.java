package com.aluracursos.Foro_hub.domain.topico;

import com.aluracursos.Foro_hub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        @NotBlank
        String mensaje,
        @NotBlank
        String fechaCreacion,
        @NotNull
        String status,
        @NotNull
        String autor,
        @NotNull
        Curso curso
) {
}
