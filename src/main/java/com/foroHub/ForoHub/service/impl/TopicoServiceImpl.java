package com.foroHub.ForoHub.service.impl;

import com.foroHub.ForoHub.dto.TopicoRequestDTO;
import com.foroHub.ForoHub.dto.TopicoResponseDTO;
import com.foroHub.ForoHub.model.Curso;
import com.foroHub.ForoHub.model.Topico;
import com.foroHub.ForoHub.model.Usuario;
import com.foroHub.ForoHub.repository.CursoRepository;
import com.foroHub.ForoHub.repository.TopicoRepository;
import com.foroHub.ForoHub.repository.UsuarioRepository;
import com.foroHub.ForoHub.service.TopicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoServiceImpl(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Topico crearTopico(TopicoRequestDTO request) {

        boolean topicoDuplicado = topicoRepository.existsByTituloAndMensaje(request.titulo(), request.mensaje());
        if (topicoDuplicado) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        Usuario autor = usuarioRepository.findById(request.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(request.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));


        Topico topico = new Topico();
        topico.setTitulo(request.titulo());
        topico.setMensaje(request.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);

        return topicoRepository.save(topico);
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<TopicoRequestDTO> obtenerTodosLosTopicos(Pageable pageable) {
        Page<Topico> topicosPaginados = topicoRepository.findAll(pageable);

        return topicosPaginados.map(topico -> new TopicoRequestDTO(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        ));
    }

    @Override
    public TopicoResponseDTO obtenerTopicoPorId(Long id) {
        // Buscar el tópico por ID
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado."));

        // Mapear el modelo Topico al DTO TopicoResponseDTO
        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

    @Override
    public Topico actualizarTopico(Long id, Boolean status) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (!optionalTopico.isPresent()) {
            throw new IllegalArgumentException("Tópico no encontrado.");
        }


        // Solo actualizar el estado
        Topico topico = optionalTopico.get();
        topico.setStatus(String.valueOf(status));

        // Guardar el tópico actualizado en la base de datos
        return topicoRepository.save(topico);
    }


    @Override
    public void eliminarTopico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (!optionalTopico.isPresent()) {
            throw new IllegalArgumentException("Tópico no encontrado.");
        }

        topicoRepository.deleteById(id);
    }


}

