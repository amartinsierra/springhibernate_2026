package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	
	boolean save(Alumno alumno);
	Alumno findByNameAndCourse(String name,String course);
	List<String> findAllCourses();
	List<Alumno> findAlumnoByCourse(String course);
	boolean deleteAlumno(int id);

}
