package service;

import java.util.List;

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
		Alumno a = alumnosDao.findById(usuario);
		Curso c = cursosDao.findById(idCurso);
		if(c!=null && a!=null) {
			a.getCurso().add(c);
			alumnosDao.update(a);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Alumno> listaAlumnos() {
		return alumnosDao.findAll();	
	}
	
}
