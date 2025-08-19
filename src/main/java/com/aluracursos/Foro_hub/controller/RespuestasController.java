package com.aluracursos.Foro_hub.controller;


import com.aluracursos.Foro_hub.domain.respuesta.Respuesta;
import com.aluracursos.Foro_hub.domain.respuesta.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestasController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public ResponseEntity<List<Respuesta>> listar() {
        return ResponseEntity.ok(respuestaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Respuesta respuesta) {
        return ResponseEntity.ok(respuestaRepository.save(respuesta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtener(@PathVariable Long id) {
        return respuestaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
