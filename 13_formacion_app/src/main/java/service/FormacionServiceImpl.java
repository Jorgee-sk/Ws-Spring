package service;

import java.util.Date;
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
	

	@Override
	public List<Alumno> listaAlumnos() {
		return alumnosDao.findAll();	
	}
	
	@Transactional
	@Override
	public boolean matricular(String usuario, int idCurso) {
		
		Optional<Alumno> a = alumnosDao.findById(usuario);
		Optional<Curso> c = cursosDao.findById(idCurso); 
		if(c.isPresent() && a.isPresent()) {
			a.get().getCurso().add(c.get());
			alumnosDao.save(a.get());
			return true;
		}
		return false;
		
	}
	
	@Transactional
	@Override
	public boolean añadirAlumno(Alumno a) {
		
		Optional<Alumno> alum = alumnosDao.findById(a.getUsuario());
		if(alum.isPresent()) {
			return false;
		}
		alumnosDao.save(alum.get());
		return true;
		
	}
	
	@Transactional
	@Override
	public boolean añadirCurso(Curso curso) {
		
		Optional<Curso> c = cursosDao.findByNombre(curso.getNombre());
		if(!c.isPresent()) {
			cursosDao.save(c.get());
			return true;
		}
		return false;
		
	}

	@Override
	public List<Curso> cursosAlumnoNoMatric(String usuario) {
		Optional<Alumno> a = alumnosDao.findById(usuario);
		return cursosDao.findByAlumnoNoMatric(usuario);
	}

	@Override
	public List<Curso> cursosFechas(Date fInicio, Date fFin) {
		
		return cursosDao.findByFechaInicioBetween(fInicio, fFin);
	}
	
	
	
}
