package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.Alumno;
import repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Transactional
	public boolean save(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	public Alumno findByNameAndCourse(String nombre, String curso) {
		return alumnoRepository.findByNameAndCourse(nombre, curso);
	}

	public List<String> findAllCourses() {
		return alumnoRepository.findAllCourses();
	}

	public List<Alumno> findAlumnoCourse(String course) {
		return alumnoRepository.findAlumnoByCourse(course);
	}

	@Override
	public List<Alumno> findAlumnoByCourse(String course) {
		return alumnoRepository.findAlumnoByCourse(course);
	}

	@Override
	public boolean deleteAlumno(int id) {
		return alumnoRepository.deleteAlumno(id);
	}

	
	
	
}
