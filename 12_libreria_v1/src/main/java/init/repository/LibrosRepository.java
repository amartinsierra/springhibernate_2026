package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByIdTema(int idTema);
}
