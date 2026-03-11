package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Libro;
import init.model.Tema;
import init.service.LibroService;
import init.service.TemaService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("findBookByTheme")
	public String findBookByTheme(Model model,@RequestParam("idTemaSel")int idTemaSel) {
		List <Libro> lista;
		if(idTemaSel==0) {
			lista  = libroService.getBooks();
		}else {
			lista = libroService.getBooksByTheme(idTemaSel);
		}
		
		if(lista == null || lista.isEmpty()) {
			model.addAttribute("mensaje", "No se encuentra ningún libro");
		}
		model.addAttribute("lista",lista);
		model.addAttribute("idTemaSel",idTemaSel);
		return "buscarLibro";
	}
}
