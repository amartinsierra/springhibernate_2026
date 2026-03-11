package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.ItemDto;
import init.mapper.Mappeador;
import init.model.Item;
import init.repository.ItemRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private Mappeador mapper;
	
	public List<ItemDto> findByTematica(String tematica) {
		return itemRepository.findByTematica(tematica).stream().map(mapper::entityToDto).toList();
	}
	
	public boolean saveItem(ItemDto item) {
		if(itemRepository.findByUrl(item.getUrl()) == null) {
			itemRepository.save(mapper.dtoToEntity(item));
			return true;
		}
		return false;
	}

	public ItemDto deleteItem(String url) {
		return mapper.entityToDto(itemRepository.deleteByUrl(url));
	}

	public ItemDto findByUrl(String url) {
		return mapper.entityToDto(itemRepository.findByUrl(url));
	}
}
