package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Alumno;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {
	
	@PersistenceContext
	private EntityManager eManager;

	public Alumno findByNameAndCourse(String nombre, String curso) {
		String jpql = "select a from Alumno a where a.nombre=?1 and a.curso=?2";
		TypedQuery<Alumno> query = eManager.createQuery(jpql,Alumno.class);
		query.setParameter(1, nombre);
		query.setParameter(1, curso);
		List<Alumno> lista = query.getResultList();
		return lista.size()>0 ?null:lista.get(0);
	}

	public boolean save(Alumno alumno) {
		String jpql = "select a from Alumno a where a.nombre=?1 and a.curso=?2";
		TypedQuery<Alumno> query = eManager.createQuery(jpql,Alumno.class);
		query.setParameter(1, alumno.getNombre());
		query.setParameter(2, alumno.getCurso());
		List<Alumno> lista = query.getResultList();
		if(!lista.isEmpty()) {
			return false;
		}
		eManager.persist(alumno);
		return true;
	}
	
	public List<String> findAllCourses() {
		String jpql = "select distinct(a.curso) from Alumno a";
		TypedQuery<String> query = eManager.createQuery(jpql,String.class);
		return query.getResultList();
	}

	public List<Alumno> findAlumnoByCourse(String course) {
		String jpql= "select a from Alumno a where a.curso=?1";
		TypedQuery<Alumno> query = eManager.createQuery(jpql,Alumno.class);
		query.setParameter(1, course);
		List<Alumno> lista = query.getResultList();
		if(!lista.isEmpty()) {
			return lista;
		}
		return null;
	}

	@Override
	public boolean deleteAlumno(int id) {
		Alumno al = eManager.find(Alumno.class, id);
		if(al!=null) {
			eManager.remove(al);
			return true;
		}
		return false;
	}


}
