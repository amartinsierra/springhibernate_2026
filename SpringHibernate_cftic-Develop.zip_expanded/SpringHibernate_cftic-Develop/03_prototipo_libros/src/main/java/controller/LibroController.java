package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Libro;
import service.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("getLibro")
	public String buscarLibro(Model model,@RequestParam("isbn") String isbn) {
		List<Libro> lista = libroService.buscarLibroByIsbn(isbn);
		if(!lista.isEmpty()) {
			model.addAttribute("lista",lista);
		}else {
			model.addAttribute("mensaje", "No existe el libro: "+isbn);
			return "mensaje";
		}
		
		return "resultados";
	}
	@PostMapping("crear")
	public String crearLibro(Model model,
			@RequestParam("isbn") String isbn,
			@RequestParam("titulo") String titulo,
			@RequestParam("autor") String autor,
			@RequestParam("precio") Double precio) {
		
		Libro libro = new Libro(isbn,titulo,autor,precio);
		if(libroService.nuevoLibro(libro)) {
			model.addAttribute("mensaje","libro creado correctamente");
		}else {
			model.addAttribute("mensaje","El libro ya existe en la BD");
		}
		return "mensaje";
	}
	
	@GetMapping("delLibro")
	public String delLibro(Model model,@RequestParam("isbn") String isbn) {
		if(libroService.delLibro(isbn)) {
			model.addAttribute("mensaje","Libro"+isbn+ " eliminado correctamente");
		}else {
			model.addAttribute("mensaje","El libro no existe");
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
	@GetMapping("goEliminar")
	public String eliminar() {
		return "eliminar";
	}
	@GetMapping("goMensaje")
	public String mensaje () {
		return "mensaje";
	}
	@GetMapping("goBuscar")
	public String buscar () {
		return "buscar";
	}
	
	
	

}
