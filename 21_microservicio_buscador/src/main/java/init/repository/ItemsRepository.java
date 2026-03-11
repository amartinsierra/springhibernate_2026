package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import init.model.Item;

public interface ItemsRepository extends JpaRepository<Item,Integer>{
	
	List<Item> findByTematica(String tematica);
	Item findFirstByUrl(String url);
	
	//elimine iten por url
	@Transactional
	@Modifying
	void deleteByUrl(String url);
	
	
	
	
}
