package com.foroHub.ForoHub.service;

import com.foroHub.ForoHub.dto.TopicoRequestDTO;
import com.foroHub.ForoHub.dto.TopicoResponseDTO;
import com.foroHub.ForoHub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicoService {
    Topico crearTopico(TopicoRequestDTO dto);
    Page<TopicoRequestDTO> obtenerTodosLosTopicos(Pageable pageable);
    TopicoResponseDTO obtenerTopicoPorId(Long id);
    Topico actualizarTopico(Long id, Boolean status);
    void eliminarTopico(Long id);
}