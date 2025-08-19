

package com.aluracursos.Foro_hub.domain.topico;

import com.aluracursos.Foro_hub.domain.curso.CursoRepository;
import com.aluracursos.Foro_hub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public void crearTopico(DatosResgitroTopico datos) {
        var autor = usuarioRepository.findById(datos.autorId()).orElseThrow();
        var curso = cursoRepository.findById(datos.cursoId()).orElseThrow();

        var nuevoTopico = new Topico(datos, autor, curso);
        topicoRepository.save(nuevoTopico);
    }
}
