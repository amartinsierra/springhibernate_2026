package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.service.ClientesService;
//@RequestMapping("clientes")
@Controller
public class ClientesController {
	@Autowired
	ClientesService clientesService;
	@GetMapping("login")
	public String autenticar(Model model, @RequestParam("usuario") String usuario, 
			@RequestParam("password") String password) {
		Cliente cliente=clientesService.autenticarUsuario(usuario, password);
		if(cliente!=null) {
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
	
	@GetMapping({"/","goLogin"})
	public String inicio() {
		return "login";
	}
	@GetMapping("goRegistro")
	public String goRegistro() {
		return "registro";
	}
	
	
}
