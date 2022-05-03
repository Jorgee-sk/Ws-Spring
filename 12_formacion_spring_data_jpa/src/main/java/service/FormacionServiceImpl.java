package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursoDao;
import model.Alumno;
import model.Curso;


@Service
public class FormacionServiceImpl implements FormacionService{
	
	AlumnosDao alumnosDao;
	CursoDao cursosDao;
	
	public FormacionServiceImpl(@Autowired 	AlumnosDao alumnosDao , @Autowired CursoDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	@Override
	public Alumno validarAlumno(String usuario, String contraseña) {
		return alumnosDao.findByUsuarioAndPassword(usuario, contraseña);
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> listaCursos() {
		return cursosDao.findAll();	
		
	}

	@Override
	public List<Alumno> alumnosCurso(String nombre) {
		return alumnosDao.findByCurso(nombre);
	}
	
	@Transactional
	@Override
	public boolean matricular(String usuario, int idCurso) {
		/*Alumno a = alumnosDao.findById(usuario).orElse(null);
		Curso c = cursosDao.findById(idCurso).orElse(null); //OrElse te devuelve lo que haya en el método y si no te pone
															// la variable al valor que quieras, en este caso null
		if(c!=null && a!=null) {
			a.getCurso().add(c);
			alumnosDao.save(a);
			return true;
		}
		return false;*/
		
		Optional<Alumno> a = alumnosDao.findById(usuario);
		Optional<Curso> c = cursosDao.findById(idCurso); 
		if(c.isPresent() && a.isPresent()) {
			a.get().getCurso().add(c.get());
			alumnosDao.save(a.get());
			return true;
		}
		return false;
		
	}

	@Override
	public List<Alumno> listaAlumnos() {
		return alumnosDao.findAll();	
	}
	
}
