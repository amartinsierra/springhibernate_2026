package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alumno;
import service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;

	@GetMapping("goFindAlumnoByCourse")
	public String findAlumno(Model model,
			@RequestParam("course")String course
			) {
		List<Alumno> lista = alumnoService.findAlumnoByCourse(course);
		if(!lista.isEmpty()) {
			model.addAttribute("lista",lista);
		}
		model.addAttribute("mensaje","Alumnos para el Curso seleccionado no encontrados");
		return "mensaje";
	} 
	
	@GetMapping("goFindAll")
	public String findAllCourses(Model model) {
		List<String> cursos = alumnoService.findAllCourses();
		if(!cursos.isEmpty()) {
			model.addAttribute("cursos",cursos);
		}
		return "mensaje";
	}
	
	@PostMapping("goSaveAlumno")
	public String saveAlumno(Model model,
			@RequestParam("name")String name,
			@RequestParam("course")String course,
			@RequestParam("email")String email,
			@RequestParam("nota")double nota
			
			) {
		Alumno alumno = new Alumno(name,course,email,nota);
		if(alumnoService.save(alumno)) {
			model.addAttribute("mensaje", "Alumno creado correctamente");
		}else {
		model.addAttribute("mensaje","Error al crear alumno: Duplicado");
		}
		
		return "mensaje";
	}
	
	
	@PostMapping("/delAlumno")
	public String delete(Model model,@RequestParam("id")int id) {
		if(alumnoService.deleteAlumno(id)) {
			model.addAttribute("mensaje","Eliminado correctamente");
		}
		return "mensaje";
	}
	
	@GetMapping({"goMenu","/"})
	public String menu() {
		return "menu";
	}
	
	@GetMapping("goBuscar")
	public String buscar(Model model) {
		model.addAttribute("cursos", alumnoService.findAllCourses());
		return "buscar";
	}
	
	@GetMapping("goNuevo")
	public String nuevo() {
		return "nuevo";
	}
	
	@GetMapping("mensajes")
	public String mensaje() {
		return "mensaje";
	}

}
