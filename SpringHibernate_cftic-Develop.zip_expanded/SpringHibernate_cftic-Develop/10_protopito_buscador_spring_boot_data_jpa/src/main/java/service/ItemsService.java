package service;

import java.util.List;

import model.Item;

public interface ItemsService {
	List<Item> findByTematica(String tematica);
	boolean saveItem(Item item);
}
