package com.example.foroHub.service;

import com.example.foroHub.dto.TopicoRequestDTO;
import com.example.foroHub.dto.TopicoResponseDTO;
import com.example.foroHub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TopicoService {
    Topico crearTopico(TopicoRequestDTO dto);
    Page<TopicoRequestDTO> obtenerTodosLosTopicos(Pageable pageable);
    TopicoResponseDTO obtenerTopicoPorId(Long id);
    Topico actualizarTopico(Long id, Boolean status);
    void eliminarTopico(Long id);
}
