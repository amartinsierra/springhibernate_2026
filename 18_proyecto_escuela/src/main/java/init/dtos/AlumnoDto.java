package init.dtos;

import java.util.List;

import init.model.Alumno;
import init.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnoDto {
	private String nombre;
	private String dni;
	private String email;
	private int edad;
}
