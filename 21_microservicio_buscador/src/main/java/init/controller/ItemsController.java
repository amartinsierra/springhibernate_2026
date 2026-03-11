package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.ItemDto;
import init.service.ItemsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class ItemsController {
	@Autowired
	ItemsService itemsService;
	@Operation(summary = "Lista de resultados por temática",description = "Recibe como variable en URL el nombre de la temática y devuelve los items asociados a dicha temática")
	@GetMapping(value="items/{tematica}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemDto>> buscarPorTematica(@Parameter(description = "Nombre de la temática de búsqueda") @PathVariable String tematica){
		return new ResponseEntity<>(itemsService.buscarPorTematica(tematica),HttpStatus.OK);
	}
	@PostMapping(value="items",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody ItemDto item) {
		if(itemsService.nuevoItem(item)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@DeleteMapping(value="items",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDto> eliminarPorUrl(@RequestParam String url) {
		return ResponseEntity.ok(itemsService.eliminarItem(url));
	}
}
