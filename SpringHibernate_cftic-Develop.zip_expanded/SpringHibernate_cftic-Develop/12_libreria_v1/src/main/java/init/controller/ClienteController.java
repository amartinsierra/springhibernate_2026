package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.service.ClienteService;
import init.service.TemaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	@Autowired
	TemaService temaService;
	
	
	@PostMapping("alta")
	public String alta(Model model,@ModelAttribute Cliente cliente) {
		if(clienteService.alta(cliente)!=null) {
			return menu();
		}else {
			model.addAttribute("mensaje", "Ya estás registrado!!");
		}
		return "mensaje";
	}
	@GetMapping("consulta")
	public String consultar(Model model,HttpSession session,@RequestParam("usuario")String usuario,@RequestParam("password")String pwd) {
		Cliente cliente = clienteService.buscar(usuario, pwd);
		if(cliente!=null) {
			session.setAttribute("user",cliente.getUsuario());
			session.setAttribute("temas",temaService.findThemes());
			model.addAttribute("mensaje","Bienvenido");
		}else {
		
			model.addAttribute("mensaje","El usuario o contraseña no existen");
		}
		return searchLibro(model);
	}
	
	@GetMapping("goNuevo")
	public String nuevo(Model model) {
		return "nuevo";
	}
	@GetMapping({"/","goLogin"})
	public String menu() {
		return "login";
	}
	
	@GetMapping("goBuscar")
	public String buscar() {
		return "buscar";
	}
	
	@GetMapping("goMensaje")
	public String mensaje() {
		return "mensaje";
	}
	@GetMapping("goBuscarLibro")
	public String searchLibro(Model model) {
		model.addAttribute("lista",temaService.findThemes());
		return "buscarLibro";
	}
	
}
