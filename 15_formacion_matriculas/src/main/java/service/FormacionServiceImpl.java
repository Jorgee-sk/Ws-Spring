package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursoDao;
import dao.MatriculaDao;
import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPK;


@Service
public class FormacionServiceImpl implements FormacionService{
	
	@Autowired
	ConversorEntityDto conversor;
	
	AlumnosDao alumnosDao;
	CursoDao cursosDao;
	MatriculaDao matriculasDao;
	
	public FormacionServiceImpl(@Autowired 	AlumnosDao alumnosDao , @Autowired CursoDao cursosDao, @Autowired MatriculaDao matriculasDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
		this.matriculasDao = matriculasDao;
	}
	
	@Override
	public AlumnoDto validarAlumno(String usuario, String contraseña) {
		return conversor.alumnoToDto(alumnosDao.findByUsuarioAndPassword(usuario, contraseña));  
	}

	@Override
	public List<CursoDto> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> listaCursos() {
		return cursosDao.findAll()
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());	
		
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String nombre) {
		return alumnosDao.findByCurso(nombre)
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}
	

	@Override
	public List<AlumnoDto> listaAlumnos() {
		return alumnosDao.findAll()
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());	
	}
	
	@Transactional
	@Override
	public boolean matricular(String usuario, int idCurso) {
		
		Optional<Curso> curso=cursosDao.findById(idCurso);
		Optional<Alumno> alumno=alumnosDao.findById(usuario);
		if(curso.isPresent()&&alumno.isPresent()) {
			matriculasDao.save(new Matricula(new MatriculaPK(idCurso,usuario),0,curso.get(),alumno.get()));
			return true;
		}
		return false;
		
		
	}
	
	@Transactional
	@Override
	public boolean añadirAlumno(AlumnoDto a) {
		
		Optional<Alumno> alum = alumnosDao.findById(a.getUsuario());
		if(alum.isPresent()) {
			return false;
		}
		alumnosDao.save(conversor.dtoToAlumno(a));
		return true;
		
	}
	
	@Transactional
	@Override
	public boolean añadirCurso(CursoDto curso) {
		
		Optional<Curso> c = cursosDao.findByNombre(curso.getNombre());
		if(!c.isPresent()) {
			cursosDao.save(conversor.dtoToCurso(curso));
			return true;
		}
		return false;
		
	}

	@Override
	public List<CursoDto> cursosAlumnoNoMatric(String usuario) {
		Optional<Alumno> a = alumnosDao.findById(usuario);
		return cursosDao.findByAlumnoNoMatric(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<MatriculaDto> cursosFechas(Date fInicio, Date fFin) {
		
		return matriculasDao.findMatriculasFechas(fInicio, fFin)
				.stream()
				.map(m->conversor.matriculaToDto(m))
				.collect(Collectors.toList());
	}
	
	
	
}
