package com.aluracursos.Foro_hub.domain.topico;

import com.aluracursos.Foro_hub.domain.curso.Curso;

import com.aluracursos.Foro_hub.domain.respuesta.Respuesta;
import com.aluracursos.Foro_hub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id") // referencia a Usuario
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id") // referencia a Curso
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico() {}

    public Topico(DatosResgitroTopico datosResgitroTopico, Usuario autor, Curso curso) {
        this.titulo = datosResgitroTopico.titulo();
        this.mensaje = datosResgitroTopico.mensaje();
        this.autor = autor;
        this.curso = curso;
        this.status = "ABIERTO";
    }
}
