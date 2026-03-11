package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Tema;

public interface TemaRepository extends  JpaRepository<Tema, Integer>{
	
	@Query("select t from Tema t join t.libros l where l.isbn=?1")
	Tema findByIsbn(int isbn);
}
