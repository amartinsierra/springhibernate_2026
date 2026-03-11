package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.AlumnoDto;
import init.dto.CursoDto;
import init.dto.MatriculaInfoDto;
import init.mappeador.Mapper;
import init.repository.AlumnoRepository;
import init.repository.CursoRepository;

@Service
public class EscuelaServiceImpl implements EscuelaService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private Mapper mapper;
	
	public boolean matricular(String dni, int codCurso) {
		if(alumnoRepository.findById(dni).isPresent() && cursoRepository.findById(codCurso).isPresent()) {
			cursoRepository.matricular(codCurso, dni);
			return true;
		}
		return false;
	}

	public List<MatriculaInfoDto> getMatriculas(int codCurso) {
		 CursoDto curso = cursoRepository.findById(codCurso).map(mapper::entityCursoToDto).orElse(null);
		 if(curso==null) {
			 return List.of();
		 }
		 return  alumnoRepository.findByCursoCodCurso(codCurso).stream()
				 .map(a -> new MatriculaInfoDto(mapper.entityAlumnoToDto(a),curso)).toList();
	}

	public List<CursoDto> getAllCursos() {
		return cursoRepository.findAll().stream().map(mapper::entityCursoToDto).toList();
	}

	public List<AlumnoDto> getAlumnos(int codCurso) {
		return null;
	}

}
