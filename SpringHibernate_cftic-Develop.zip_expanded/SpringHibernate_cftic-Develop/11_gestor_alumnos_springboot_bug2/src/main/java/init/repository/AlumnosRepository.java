package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import init.model.Alumno;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {
	List<Alumno> findByCurso(String curso);
	Alumno findByFirstNombreAndCurso(String nombre, String curso);
	@Query(value="select distinct(a.curso) from Alumno a")
	List<String> findAllCursos();
	@Query(value="select avg(nota) from Alumno a where curso=?1",nativeQuery=true)
	double averageByCurso(String curso);
}
