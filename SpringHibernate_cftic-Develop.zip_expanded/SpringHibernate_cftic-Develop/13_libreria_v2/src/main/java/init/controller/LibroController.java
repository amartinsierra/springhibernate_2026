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
	@Autowired
	private TemaService temaService;
	
	@GetMapping("getThemes")
	public String getThemes(Model model) {
		List <Tema> lista = temaService.findThemes();
		if(lista!= null && !lista.isEmpty()) {
			model.addAttribute("lista",lista);
		}
		model.addAttribute("mensaje", "No hay temas");
		return "mensaje";
	}
	
	@GetMapping("getBooks")
	public String getAllBooks(Model model) {
		List <Libro> lista = libroService.getBooks();
		if(lista!= null && !lista.isEmpty()) {
			model.addAttribute("lista",lista);
		}
		model.addAttribute("mensaje", "No se encuentra ningún libro");
		return "mensaje";
	}
	
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
		model.addAttribute("idTema",idTemaSel);
		return "buscarLibro";
	}
	
	@GetMapping("goSearchLibro")
	public String goBuscarLibro(Model model) {
		return "buscarLibro";
	}
	
}
