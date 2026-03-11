package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import init.dto.ClienteDto;
import init.dto.LibroDto;
import init.mapper.Mappeador;
import init.service.ClienteService;
import init.service.VentaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class VentaController {

	@Autowired
	private VentaService ventaService;
	@Autowired
	ClienteService clienteService;
	@Autowired
	private Mappeador mapper;
	
	@RequestMapping("comprar")
	public String saveSale(Model model,HttpSession session) {
		
		ClienteDto cliente = (ClienteDto) session.getAttribute("user");
		List<LibroDto> carrito = (List<LibroDto>) session.getAttribute("carrito");
		if (cliente == null || carrito == null || carrito.isEmpty()) {
	        model.addAttribute("mensaje", "No se puede realizar la compra en estos momentos");
	        return "mensaje";
	    }
		if(ventaService.saveSale(cliente,carrito)){
			model.addAttribute("mensaje",cliente.getUsuario().toString()+" Compra realizada!!");
		}else {
			model.addAttribute("mensaje","No se puede realizar la compra en estos momentos");
		}
		session.invalidate();
		return "mensaje";
	}
}
