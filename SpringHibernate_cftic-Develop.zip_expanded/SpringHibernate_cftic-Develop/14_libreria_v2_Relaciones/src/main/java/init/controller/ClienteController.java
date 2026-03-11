package init.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Cliente;
import init.model.Libro;
import init.service.ClienteService;
import init.service.LibroService;
import init.service.TemaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	@Autowired
	TemaService temaService;
	@Autowired
	LibroService libroService;
	
	@GetMapping("loginUser")
	public String login(Model model,HttpSession session,@RequestParam("usuario")String usuario,@RequestParam("password")String pwd) {
		Cliente cliente = clienteService.buscar(usuario, pwd);
		if(cliente!=null) {
			session.setAttribute("user",cliente.getUsuario());
			session.setAttribute("temas",temaService.findThemes());
		}else {
			model.addAttribute("mensaje","El usuario o contraseña no existen");
		}
		model.addAttribute("idTemaSel",0);
		return "buscarLibro";
	}
	
	@PostMapping("goRegistrarUser")
	public String goRegistrarUser(Model model,@ModelAttribute Cliente cliente) {
		if(clienteService.alta(cliente)!=null) {
			return "login";
		}else {
			model.addAttribute("mensaje", "Ya estás registrado!!");
		}
		return "mensaje";
	}
	
	@PostMapping("añadirCarrito")
	public String añadirCarrito(Model model, HttpSession session,
	        @RequestParam("isbn") long isbn,
	        @RequestParam("idTemaSel") int idTemaSel) {

	    Libro libro = libroService.findById(isbn);

	    List<Libro> carrito = (List<Libro>) session.getAttribute("carrito");

	    if (carrito == null) {
	        carrito = new ArrayList<>();
	    }

	    if (!carrito.stream().anyMatch(c -> c.getIsbn().equals(libro.getIsbn()))) {
	        carrito.add(libro);
	    }

	    session.setAttribute("carrito", carrito);
	    model.addAttribute("idTemaSel",idTemaSel);
	    model.addAttribute("lista", idTemaSel == 0 ? libroService.getBooks(): libroService.getBooksByTheme(idTemaSel));

	    return "buscarLibro";
	}
	
	@PostMapping("quitarCarrito")
	public String quitarCarrito(Model model, HttpSession session,@RequestParam("isbn") Long isbn,@RequestParam("idTemaSel") Integer idTemaSel) {

	    List<Libro> carrito = (List<Libro>) session.getAttribute("carrito");

	    if (carrito != null) {
	        carrito.removeIf(c -> c.getIsbn().equals(isbn));
	    }

	    session.setAttribute("carrito", carrito);
	    model.addAttribute("idTemaSel",idTemaSel);
	    model.addAttribute("lista", idTemaSel == 0 ? libroService.getBooks(): libroService.getBooksByTheme(idTemaSel));

	    return "buscarLibro";
	}
	
	
	
}
