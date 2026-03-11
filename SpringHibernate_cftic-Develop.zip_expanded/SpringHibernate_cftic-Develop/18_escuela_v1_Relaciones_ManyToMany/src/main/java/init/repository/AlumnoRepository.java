package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{
	
	@Query("select a from Alumno a join a.cursos c where c.codCurso=?1")
	List<Alumno> findByCursoCodCurso(int code);
}
