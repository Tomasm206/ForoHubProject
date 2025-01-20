package com.foroHub.ForoHub.controller;

import com.foroHub.ForoHub.dto.LoginRequestDTO;
import com.foroHub.ForoHub.infra.security.DatosJWTToken;
import com.foroHub.ForoHub.infra.security.TokenService;
import com.foroHub.ForoHub.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid LoginRequestDTO loginRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                loginRequest.correoElectronico(),
                loginRequest.contrasena()
        );

        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Obtener el usuario autenticado y generar el token
        Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();
        var jwtToken = tokenService.generarToken(usuarioAutenticado);

        return ResponseEntity.ok( new DatosJWTToken(jwtToken));


    }
}