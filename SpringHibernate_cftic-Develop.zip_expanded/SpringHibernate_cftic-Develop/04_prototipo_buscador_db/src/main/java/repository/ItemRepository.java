package repository;

import java.util.List;

import model.Item;


public interface ItemRepository {
	
	Item findFirstByUrl(String tematica);
	List<Item> findByTematica(String tematica);
	void save(Item item);

}
