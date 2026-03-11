package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import init.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query(value = "select * from libros WHERE idTema = :idTema", nativeQuery = true)
    List<Libro> findByIdTema(@Param("idTema") int idTema);

    @Query(value = "select distinct t.tema FROM temas t LEFT JOIN libros l ON l.idTema = t.idTema", nativeQuery = true)
    List<String> findThemes();
    
    Libro findByIsbn(Long isbn);
}