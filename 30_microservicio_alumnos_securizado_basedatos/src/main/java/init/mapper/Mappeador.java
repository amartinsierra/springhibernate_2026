package init.mapper;

import org.springframework.stereotype.Component;

import init.dto.AlumnoDto;
import init.model.Alumno;

@Component
public class Mappeador {

	public AlumnoDto entityAlumnoToDto(Alumno al) {
		return new AlumnoDto(al.getIdAlumno(),al.getNombre(),al.getCurso(),al.getEmail(),al.getNota());
	}
	
	public Alumno dtoAlumnoToEntity(AlumnoDto al) {
		return new Alumno(al.getIdAlumno(),al.getNombre(),al.getCurso(),al.getEmail(),al.getNota());
	}
}
