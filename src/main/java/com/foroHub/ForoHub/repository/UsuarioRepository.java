package com.foroHub.ForoHub.repository;

import com.foroHub.ForoHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return Un Optional con el usuario si existe.
     */
    Optional<Usuario> findById(Long id);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correoElectronico Correo electrónico del usuario.
     * @return UserDetails del usuario si existe.
     */
    UserDetails findByCorreoElectronico(String correoElectronico);

    /**
     * Verifica si un usuario existe por correo electrónico.
     *
     * @param correoElectronico Correo electrónico del usuario.
     * @return true si el usuario existe, de lo contrario false.
     */
    boolean existsByCorreoElectronico(String correoElectronico);
}
