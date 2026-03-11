package service;

import java.util.List;

import model.Item;

public interface ItemsService {
	Item buscarPorTematicaSingle(String tematica);
	List<Item> buscarPorTematica(String tematica);
	boolean nuevoItem(Item item);
}
