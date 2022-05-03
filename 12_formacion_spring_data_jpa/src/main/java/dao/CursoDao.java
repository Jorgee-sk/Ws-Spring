package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursoDao extends JpaRepository<Curso,Integer>{
	
	@Query("select distinct(c) from Curso c join c.alumnos a where a.usuario=?1")
	List<Curso> findByAlumno(String usuario);
}
