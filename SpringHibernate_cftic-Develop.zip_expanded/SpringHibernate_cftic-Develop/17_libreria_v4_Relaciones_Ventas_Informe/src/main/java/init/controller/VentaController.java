package init.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.dto.ClienteDto;
import init.dto.LibroDto;
import init.dto.VentaDto;
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
	
	@GetMapping("comprar")
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
	
	@GetMapping("checkByDates")
	public String checkByDates(Model model,HttpSession session,
				@RequestParam("f1") LocalDate f1,
				@RequestParam("f2") LocalDate f2){
		LocalDateTime f_inicio =  LocalDateTime.of(f1,LocalTime.parse("00:00"));
		LocalDateTime f_fin =  LocalDateTime.of(f2,LocalTime.parse("23:59"));
		ClienteDto  c = (ClienteDto)session.getAttribute("user");
		List<VentaDto> compras = ventaService.findCompraByClientDate(c.getIdCliente(),f_inicio,f_fin);
		model.addAttribute("compras",compras);
		return "venta";

	}
	
	@GetMapping("goVentas")
	public String goVenta() {
		return "venta.html";
	}
}
