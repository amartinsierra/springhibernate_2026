package init.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnoDto {
	private int idAlumno;
	private String nombre;
	private String curso;
	private String email;
	private double nota;
	
	public AlumnoDto(String nombre, String curso, String email, double nota) {
		this.nombre = nombre;
		this.curso = curso;
		this.email = email;
		this.nota = nota;
	}
	
}
