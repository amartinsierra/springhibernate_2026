package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	List<Item> findByTematica(String tematica);
	Item findByUrl(String url);
	
	Item deleteByUrl(String url);

}
