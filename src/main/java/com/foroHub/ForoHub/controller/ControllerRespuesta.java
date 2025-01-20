package com.foroHub.ForoHub.controller;

import com.foroHub.ForoHub.model.Respuesta;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/respuestas")
public class ControllerRespuesta {

    private final RespuestaService respuestaService;

    public ControllerRespuesta(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@Valid @RequestBody Respuesta respuesta) {
        Respuesta respuestaCreada = respuestaService.crearRespuesta(respuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaCreada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuestaPorId(@PathVariable Long id) {
        Respuesta respuesta = respuestaService.obtenerRespuestaPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}/solucion")
    public ResponseEntity<Respuesta> marcarComoSolucion(@PathVariable Long id) {
        Respuesta respuestaActualizada = respuestaService.marcarComoSolucion(id);
        return ResponseEntity.ok(respuestaActualizada);
    }
}
