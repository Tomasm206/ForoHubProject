package com.example.foroHub.service.impl;

import com.example.foroHub.model.Usuario;
import com.example.foroHub.repository.UsuarioRepository;
import com.example.foroHub.service.UsuarioService;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {

        if (usuario.getNombre() == null || usuario.getCorreoElectronico() == null || usuario.getContrasena() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.empty();
    }


}
