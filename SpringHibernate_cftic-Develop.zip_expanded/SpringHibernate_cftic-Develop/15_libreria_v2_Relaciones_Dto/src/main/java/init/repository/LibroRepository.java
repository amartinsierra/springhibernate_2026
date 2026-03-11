package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import init.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByIsbn(Long isbn);
    List<Libro> findByTemaRelacionadoIdTema(@Param("idTema") int idTema);

    /*Ejemplo de Query Explícita
    @Query("select l from Libro l where l.temaRelacionado.idTema = ?1")*/
    
    // Ejemplo de Query Implícita:
    //List<Libro> findByTemaRelacionadoIdTema(@Param("idTema") int idTema); - mas el eager o lazy
}