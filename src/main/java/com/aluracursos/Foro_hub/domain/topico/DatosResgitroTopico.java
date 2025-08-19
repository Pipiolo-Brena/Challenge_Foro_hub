package com.aluracursos.Foro_hub.domain.topico;

import com.aluracursos.Foro_hub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosResgitroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId
) {}
