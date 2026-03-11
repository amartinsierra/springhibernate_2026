package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
	
	private int codCurso;
	private String nombreCurso;
	private int duracion;
	private String horario;
		
	
}
