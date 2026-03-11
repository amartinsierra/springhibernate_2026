package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.dto.ItemDto;
import init.mapper.Mappeador;
import init.service.ItemsService;

@RestController
public class ItemController {
	
	@Autowired
	ItemsService itemsService;
	@Autowired
	Mappeador mapper;
	
	@GetMapping("buscar")
	public ResponseEntity<List<ItemDto>> findItems(@RequestParam("tematica") String tematica) {
		if(itemsService.findByTematica(tematica)== null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
		}
		return ResponseEntity.ok(itemsService.findByTematica(tematica)); 	
	}
	
	@PostMapping("crear")
	public void createItem(@RequestBody ItemDto item) {
		itemsService.saveItem(item);
	}
	
	@DeleteMapping("eliminar")
	public ResponseEntity<ItemDto> createItem(@RequestParam String url) {
		ItemDto item = itemsService.findByUrl(url);
		if(item!=null) {
			itemsService.deleteItem(url);
			return ResponseEntity.ok(item);
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
	}

}
