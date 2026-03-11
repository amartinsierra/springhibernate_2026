package init.service;

import java.util.List;

import init.dto.AlumnoDto;
import init.dto.CursoDto;
import init.dto.MatriculaInfoDto;

public interface EscuelaService {
	
	boolean matricular(String dni,int codCurso);
	List<MatriculaInfoDto> getMatriculas(int codCurso);
	List<CursoDto> getAllCursos();
	List<AlumnoDto> getAlumnos(int codCurso);
	
}
