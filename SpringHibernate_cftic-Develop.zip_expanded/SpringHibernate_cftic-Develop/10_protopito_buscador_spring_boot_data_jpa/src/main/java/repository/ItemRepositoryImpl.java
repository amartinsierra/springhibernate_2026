package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import model.Item;

@Repository
public class ItemRepositoryImpl{

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findByTematica(String tematica) {
		return itemRepository.findByTematica(tematica);
	}

	@Transactional
	public Item save(Item item) {
		final var Item = itemRepository.save(item);
		if(item!= null) {
			return item;
		}
		return null;
	}
	
}
