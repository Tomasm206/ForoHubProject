package com.foroHub.ForoHub.repository;

import com.foroHub.ForoHub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    /**
     * Busca un curso por su ID.
     *
     * @param id ID del curso.
     * @return Un Optional con el curso si existe, de lo contrario vacío.
     */
    Optional<Curso> findById(Long id);

    /**
     * Busca un curso por su nombre y categoría.
     *
     * @param nombre    Nombre del curso.
     * @param categoria Categoría del curso.
     * @return Un Optional con el curso si existe.
     */
    Optional<Curso> findByNombreAndCategoria(String nombre, String categoria);

}
