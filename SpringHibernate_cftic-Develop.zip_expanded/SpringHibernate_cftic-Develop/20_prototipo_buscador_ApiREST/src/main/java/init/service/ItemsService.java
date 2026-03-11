package init.service;

import java.util.List;

import init.dto.ItemDto;
import init.model.Item;

public interface ItemsService {
	
	List<ItemDto> findByTematica(String tematica);
	ItemDto findByUrl(String url);
	boolean saveItem(ItemDto item);
	ItemDto deleteItem(String url);
}
