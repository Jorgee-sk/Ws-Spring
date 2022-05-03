package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursoDao extends JpaRepository<Curso,Integer>{
	
	@Query("select c from Curso c join c.matricula m where m.alumno.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	
	Optional<Curso> findByNombre(String nombre);
	
	@Query("select c from Curso c where c not in(select c from Curso c join c.matricula m where m.alumno.usuario=?1)")
	List<Curso> findByAlumnoNoMatric(String usuario);
	
}
