package repository;

import java.util.List;

import model.Item;


public interface ItemRepository {
	
	List<Item> findByTematica(String tematica);
	boolean save(Item item);

}
