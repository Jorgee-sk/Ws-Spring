package Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImpl implements EscuelaService{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> alumnoCurso(String nombre) {
		String jpql = "select a from Alumno a where a.curso.denominacion=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,nombre);
		List<Alumno> alumnos = query.getResultList();
		return alumnos;
	}

	@Override
	public List<Alumno> alumnoCursoDuracion(int duracionMax) {
		String jpql = "select a from Alumno a where a.curso.duracion<=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,duracionMax);
		List<Alumno> alumnos = query.getResultList();
		return alumnos;
	}

	@Override
	public Curso cursoMatriculado(String dni) {
		String jpql = "select c from Curso c join c.alumnos a where a.dni=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,dni);
		Curso curso = (Curso) query.getSingleResult();
		return curso;
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.edad>=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,edad);
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql = "select avg(a.edad) from Alumno a join a.curso c where c.denominacion=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,nombreCurso);
		double edad = (double) query.getSingleResult();
		return edad;
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select c.precio from Curso c join c.alumnos a where a.email=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,email);
		double precio = (double) query.getSingleResult();
		return precio;
	}

}
