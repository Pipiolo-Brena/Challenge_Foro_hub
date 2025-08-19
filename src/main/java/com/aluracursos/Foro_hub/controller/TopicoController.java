// src/main/java/com/aluracursos/Foro_hub/controller/TopicoController.java

package com.aluracursos.Foro_hub.controller;

import com.aluracursos.Foro_hub.domain.topico.DatosResgitroTopico;
import com.aluracursos.Foro_hub.domain.topico.DatosResgitroTopico;
import com.aluracursos.Foro_hub.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> crearTopico(@RequestBody @Valid DatosResgitroTopico datos) {
        topicoService.crearTopico(datos);
        return ResponseEntity.ok().build();
    }
}