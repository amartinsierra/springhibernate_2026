package init.mapper;

import org.springframework.stereotype.Component;

import init.dto.ItemDto;
import init.model.Item;

@Component
public class Mappeador {

	public ItemDto entityToDto(Item i) {
		return new ItemDto(i.getIdItem(),i.getUrl(),i.getTematica(),i.getDescripcion());
	}
	public Item dtoToEntity(ItemDto i) {
		return new Item(i.getIdItem(),i.getUrl(),i.getTematica(),i.getDescripcion());
	}
}
