package init.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno {
	private String nombre;
	private String curso;
	private String email;
	private double nota;
}
