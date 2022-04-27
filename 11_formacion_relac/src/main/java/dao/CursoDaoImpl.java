package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursoDaoImpl implements CursoDao{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Curso findById(int idCurso) {
		return entityManager.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> findAll() {
		String jpql = "select distinct(c) from Curso c";
		Query query=entityManager.createQuery(jpql);
		List<Curso> curso = query.getResultList();
		return curso;
	}

	@Override
	public List<Curso> findByAlumno(String usuario) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.usuario=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1,usuario);
		List<Curso> curso = query.getResultList();
		return curso;
	}

}
