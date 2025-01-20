package com.foroHub.ForoHub.repository;

import com.foroHub.ForoHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    /**
     * Verifica si un tópico con un título y mensaje específicos existe.
     *
     * @param titulo  Título del tópico.
     * @param mensaje Mensaje del tópico.
     * @return true si el tópico existe, de lo contrario false.
     */
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    /**
     * Busca todos los tópicos por el estado.
     *
     * @param status Estado del tópico.
     * @return Lista de tópicos que coinciden con el estado.
     */

}
