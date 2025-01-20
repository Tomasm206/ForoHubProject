package com.foroHub.ForoHub.controller;

import com.foroHub.ForoHub.dto.TopicoRequestDTO;
import com.foroHub.ForoHub.dto.TopicoResponseDTO;
import com.foroHub.ForoHub.model.Topico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topicos")
public class ControllerTopicos {

    private final TopicoService topicoService;

    public ControllerTopicos(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody TopicoRequestDTO topicoRequestDTO) {
        Topico topicoCreado = topicoService.crearTopico(topicoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoCreado);
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> obtenerTodosLosTopicos() {
        List<TopicoResponseDTO> topicos = topicoService.obtenerTodosLosTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> obtenerTopicoPorId(@PathVariable Long id) {
        TopicoResponseDTO topico = topicoService.obtenerTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Topico> actualizarStatusTopico(@PathVariable Long id, @RequestBody Map<String, Boolean> status) {
        Topico topicoActualizado = topicoService.actualizarStatusTopico(id, status.get("status"));
        return ResponseEntity.ok(topicoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
