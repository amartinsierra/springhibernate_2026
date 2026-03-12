package init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import init.dtos.PaisDto;
import init.service.PaisesService;
@CrossOrigin("*")
@RestController
public class PaisesController {
	@Autowired
	PaisesService paisesService;
	@GetMapping("paises/continentes")
	public ResponseEntity<List<String>> continentes(){
		return ResponseEntity.ok(paisesService.continentes());
	}
	@GetMapping("paises")
	public ResponseEntity<List<PaisDto>> paisesContinentes(String continente){
		return ResponseEntity.ok(paisesService.paisesPorContinente(continente));
	}
}
