package com.example.foroHub.service;

import com.example.foroHub.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario crearUsuario (Usuario usuario);
    Optional<Usuario> findByUsername(String username);
}
