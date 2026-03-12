package init.dtos;

import init.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstudianteDto {
	private String nombre;
	private String curso;
	private String email;
	private double calificacion;
}
