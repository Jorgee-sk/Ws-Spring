package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service  //Notation of core module in spring //Hace que spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	@Override
	public List<Alumno> buscar(String curso) {
		 
		List<Alumno> alumnos = entityManager.createQuery("SELECT a from Alumno a where a.curso = :curso")
			        .setParameter("curso", curso)
			        .getResultList();
		 return alumnos;
	}
	@Transactional
	@Override
	public void alta(Alumno a) {
		
		entityManager.persist(a);
		
	}
	@Transactional
	@Override
	public boolean buscarNombre(String nombre) {
		
		String jpql="SELECT a from Alumno a where a.nombre = :nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nombre",nombre);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0;
		
	}
	@Transactional
	@Override
	public List<String> cursos() {
		String jpql="SELECT distinct(curso) from Alumno a";
		Query query=entityManager.createQuery(jpql);
		List<String> cursos = query.getResultList();
		return cursos;
		
	}
	

	

}
