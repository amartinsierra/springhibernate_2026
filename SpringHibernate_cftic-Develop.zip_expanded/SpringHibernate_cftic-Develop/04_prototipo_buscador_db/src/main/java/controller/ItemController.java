package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Item;
import service.ItemsService;

@Controller
public class ItemController {
	
	@Autowired
	ItemsService itemsService;
	
	@GetMapping("goFind")
	public String findItems(Model model,@RequestParam("tematica") String tematica) {
		List<Item> items=itemsService.buscarPorTematica(tematica);
		model.addAttribute("lista", items);
		return "resultados";
		
	}
	@GetMapping("goFindSingle")
	public String findItemSingle(Model model,@RequestParam("tematica") String tematica) {
		List<Item> items= itemsService.buscarPorTematica(tematica);
		model.addAttribute("lista", items);
		return "resultados";
		
	}
	
	@PostMapping("goCreate")
	public String createItem(Model model,
							@RequestParam("url") String url,
									@RequestParam("tematica") String descripcion,
										@RequestParam("descripcion") String tematica) {
		Item item = new Item(url,tematica,descripcion);
		if(itemsService.nuevoItem(item)) {
			model.addAttribute("mensaje", "Item creado");
		}else {
			model.addAttribute("mensaje", "Item Duplicado");
		}
		
		return "mensaje";
	}
	
	@GetMapping({"/","goMenu"})
	public String menu() {
		return "menu";
	}
	
	@GetMapping("goNuevo")
	public String nuevo() {
		return "nuevo";
	}
	
	@GetMapping("goBuscar")
	public String buscar() {
		return "buscar";
	}
	
	@GetMapping("goMensaje")
	public String mensaje() {
		return "mensaje";
	}
	
	

}
