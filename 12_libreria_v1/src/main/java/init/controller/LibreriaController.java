package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.service.ClientesService;
import init.service.LibrosService;
//@RequestMapping("clientes")
@Controller
public class LibreriaController {
	@Autowired
	ClientesService clientesService;
	
	@Autowired
	LibrosService librosService;
	
	@GetMapping("login")
	public String autenticar(Model model, @RequestParam("usuario") String usuario, 
			@RequestParam("password") String password) {
		Cliente cliente=clientesService.autenticarUsuario(usuario, password);
		if(cliente!=null) {
			model.addAttribute("temas", librosService.temas());
			return "libros";
		}else {
			model.addAttribute("mensaje", "Cliente no válido!!");
			return "mensaje";
		}
	}
	@PostMapping("alta")
	public String registrar(Model model, @ModelAttribute Cliente cliente) {
		
		if(!clientesService.guardar(cliente)) {
			model.addAttribute("mensaje", "No se puede repetir nombre de usuario!!");
			return "mensaje";
		}
		return "login";
	}
	@GetMapping("libros")
	public String verLibros(Model model, @RequestParam("temaSel") int idTemaSel) {
		model.addAttribute("temas", librosService.temas()); //para que no se pierdan al volver a la página
		model.addAttribute("libros", librosService.librosTema(idTemaSel));
		return "libros";
	}
	
	
	@GetMapping({"/","goLogin"})
	public String inicio() {
		return "login";
	}
	@GetMapping("goRegistro")
	public String goRegistro() {
		return "registro";
	}
	
	
}
