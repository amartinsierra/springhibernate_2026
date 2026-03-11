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
	public String findBookByTheme(Model model,@RequestParam("idTema")int idTema) {
		List <Libro> lista;
		if(Integer.compare(idTema, 0)<0) {
			lista = libroService.getBooksByTheme(idTema);
		}else {
			lista  = libroService.getBooks();
		}
		
		if(lista == null || lista.isEmpty()) {
			model.addAttribute("mensaje", "No se encuentra ningún libro");
		}
		model.addAttribute("lista",lista);
		return "mensaje";
	}
	
	@GetMapping("goSearchLibro")
	public String goBuscarLibro(Model model) {
		model.addAttribute("lista",temaService.findThemes());
		return "buscarLibro";
	}
	
}
