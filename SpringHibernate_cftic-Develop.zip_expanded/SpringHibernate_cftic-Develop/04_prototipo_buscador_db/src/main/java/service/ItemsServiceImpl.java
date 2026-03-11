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
	
	public List<Item> buscarPorTematica(String tematica) {
		return itemRepository.findByTematica(tematica);
	}
	
	public boolean nuevoItem(Item item) {
		if(itemRepository.findFirstByUrl(item.getUrl())==null){
			itemRepository.save(item);
			return true;
		}
		return false;
	}

	@Override
	public Item buscarPorTematicaSingle(String tematica) {
		return itemRepository.findFirstByUrl(tematica);
	}

}
