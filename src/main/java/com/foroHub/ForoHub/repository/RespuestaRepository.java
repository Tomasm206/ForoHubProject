package com.foroHub.ForoHub.repository;

import com.foroHub.ForoHub.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    /**
     * Cuenta las respuestas que están marcadas como solución.
     *
     * @param solucion Estado de la solución (true/false).
     * @return Número de respuestas que coinciden con el estado de solución.
     */
    long countBySolucion(boolean solucion);

}
