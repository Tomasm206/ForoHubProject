package com.foroHub.ForoHub.service;

import com.foroHub.ForoHub.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario crearUsuario (Usuario usuario);
    Optional<Usuario> findByUsername(String username);
}
