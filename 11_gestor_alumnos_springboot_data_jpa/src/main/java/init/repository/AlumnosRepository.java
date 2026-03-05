package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno,Integer>{
	
	List<Alumno> findByCurso(String curso);
	Alumno findFirstByNombreAndCurso(String nombre, String curso);
	boolean existsByNombreAndCurso(String nombre, String curso);
	@Query("select distinct(a.curso) from Alumno a")
	List<String> findAllCursos();
	
	@Query(value="select avg(nota) from alumnos where curso=?",nativeQuery = true)
	double averageByCurso(String curso);
}
