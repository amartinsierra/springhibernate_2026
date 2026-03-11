package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Item;

public interface ItemsRepository extends JpaRepository<Item,Integer>{
	
	List<Item> findByTematica(String tematica);
	Item findFirstByUrl(String url);
	
	//elimine iten por url
	@Transactional
	@Modifying
	void deleteByUrl(String url);
	
	//método que devuelva todos los items, cuya descripción contenga
	//el texto recibido como parámetro
	@Query("select i from Item i where i.descripcion like %?1%")
	List<Item> findLikeDescripcion(String texto);
	
	//List<Item> findByDescriptionLike(String texto)
	
	
	//método que devuelve el total de items de una determinada temática
	@Query(value="select count(*) from items where tematica=?",nativeQuery = true)
	int countByTematica(String tematica);
}
