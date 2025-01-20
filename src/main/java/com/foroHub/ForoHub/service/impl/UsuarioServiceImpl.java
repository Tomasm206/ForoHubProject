package com.foroHub.ForoHub.service.impl;

import com.foroHub.ForoHub.model.Usuario;
import com.foroHub.ForoHub.repository.UsuarioRepository;
import com.foroHub.ForoHub.service.UsuarioService;
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
