package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.dto.AlumnoDto;
import init.service.EscuelaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EscuelaController {

	@Autowired
	private EscuelaService escuelaService;
	
	@GetMapping({"/","goInicio"})
	public String inicio(Model model,HttpSession session) {
		model.addAttribute("cursos", escuelaService.getAllCursos());
		session.setAttribute("cursos", escuelaService.getAllCursos());
		return "buscarAlumno";
	}
	
	
	@GetMapping("getAlumnosByCurso")
	public String getAlumnosByCurso(Model model, HttpSession session,@RequestParam("codCursoSel")int codCursoSel) {
		model.addAttribute("codCursoSel", codCursoSel);
		model.addAttribute("lista",escuelaService.getMatriculas(codCursoSel));
		return "buscarAlumno";
	}
}
