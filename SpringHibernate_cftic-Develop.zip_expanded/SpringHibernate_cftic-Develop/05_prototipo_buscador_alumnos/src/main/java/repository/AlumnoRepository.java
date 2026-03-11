package repository;

import java.util.List;

import model.Alumno;

public interface AlumnoRepository {

	boolean save(Alumno alumno);
	Alumno findByNameAndCourse(String nombre,String curso);
	List<Alumno> findAlumnoByCourse(String course);
	List<String> findAllCourses();
	boolean deleteAlumno(int id);
}
