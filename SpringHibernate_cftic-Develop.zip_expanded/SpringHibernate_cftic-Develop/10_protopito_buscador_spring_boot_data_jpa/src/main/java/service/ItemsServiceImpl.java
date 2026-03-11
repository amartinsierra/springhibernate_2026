package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Item;
import repository.ItemRepository;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> findByTematica(String tematica) {
		return itemRepository.findByTematica(tematica);
	}
	
	public boolean saveItem(Item item) {
		return itemRepository.save(item)!=null?true:false;
	}
}
