package init;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

	@GetMapping(value="saludar",produces = "text/plain")
	public String saluda() {
		return "holaaaaaaaaaaaaaa";
	}
	
	@GetMapping(value="saludar/{name}",produces = MediaType.TEXT_PLAIN_VALUE)//MediaType...
	public String saludoPersonalizado(@PathVariable String name) {
		return "holaaaaaaaaaaaaaa "+name;
	}
	
	@GetMapping(value="saludar/completo",produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludoPersonalizado_b(@RequestParam String name,@RequestParam int edad) {
		return "holaaaaaaaaaaaaaa "+name+"\t y tienes "+edad+"\taños";
	}
	
	@GetMapping(value="saludar_/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ficha> saludoPersonalizado_c(@RequestParam String name,@RequestParam String email,@RequestParam int edad) {
		return  ResponseEntity.ok(new Ficha(name,email,edad));
	}
	
	@PostMapping(value="alta",produces = MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Ficha ficha) {
		System.out.println(ficha.getName()+"\t"+ficha.getEmail()+"\t"+ficha.getEdad());
	}
	
	@DeleteMapping(value="eliminar")
	public void eliminar(@RequestParam String name) {
		System.out.println("Eliminando a: "+name);
	}
	
}
