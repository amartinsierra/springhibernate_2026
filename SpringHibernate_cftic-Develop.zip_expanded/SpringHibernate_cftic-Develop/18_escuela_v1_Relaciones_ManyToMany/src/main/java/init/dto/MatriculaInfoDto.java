package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaInfoDto {

	private AlumnoDto alumno;
	private CursoDto curso;
}
