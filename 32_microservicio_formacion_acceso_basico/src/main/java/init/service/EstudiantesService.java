package init.service;

import java.util.List;

import init.dtos.EstudianteDto;

public interface EstudiantesService {
	List<EstudianteDto> estudiantesRangoCalificaciones(double min, double max);
	boolean altaEstudiante(EstudianteDto estudiante);
}
