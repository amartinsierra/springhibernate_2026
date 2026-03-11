package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import model.Item;


public interface ItemRepository extends JpaRepository<Item,Integer>{

	List<Item> findByTematica(String tematica);
	@Transactional
	@Modifying
	void deleteByUrl();
	
	List<Item> findByDescripcionLike(String descripcion);
	
	@Query(value="select count(id) from Item i where i.tematica=?",nativeQuery = true)
	int countByTematica(String tematica);
}
