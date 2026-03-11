package init.mappeador;

import org.springframework.stereotype.Component;

import init.dto.AlumnoDto;
import init.dto.CursoDto;
import init.model.Alumno;
import init.model.Curso;

@Component
public class Mapper {
	
	public AlumnoDto entityAlumnoToDto(Alumno a) {
		return new AlumnoDto(a.getDni(),a.getNombre(),a.getEmail(),a.getEdad());
	}
	
	public Alumno dtoAlumnoToEntity(AlumnoDto a) {
		return new Alumno(a.getDni(),a.getNombre(),a.getEmail(),a.getEdad());
	}
	
	public CursoDto entityCursoToDto(Curso c) {
		return new CursoDto(c.getCodCurso(),c.getDenominacion(),c.getDuracion(),c.getHorario());
	}
	
	public Curso dtoCursoToEntity(CursoDto c) {
		return new Curso(c.getCodCurso(),c.getNombreCurso(),c.getDuracion(),c.getHorario());
	}
}
