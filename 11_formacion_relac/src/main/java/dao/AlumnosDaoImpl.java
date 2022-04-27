package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Repository
public class AlumnosDaoImpl implements AlumnosDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql = "select a from Alumno a where a.usuario=?1 and a.password=?2";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,usuario);
		query.setParameter(2,password);
		try {
			return (Alumno) query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}
		
		
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.curso c where c.nombre=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,nombreCurso);
		return query.getResultList();
		
	}

	@Override
	public Alumno findById(String usuario) {
		return entityManager.find(Alumno.class, usuario);
	}
	
	@Override
	public void update(Alumno alumno) {
		entityManager.merge(alumno);
		
	}

	@Override
	public List<Alumno> findAll() {
		String jpql = "select distinct(a) from Alumno a";
		Query query=entityManager.createQuery(jpql);
		List<Alumno> alumno = query.getResultList();
		return alumno;
	}

}
