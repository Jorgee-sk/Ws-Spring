package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	Alumno validarAlumno(String usuario, String contrase�a);
	List<Curso> cursosAlumno(String usuario);
	List<Curso> listaCursos();
	List<Alumno> alumnosCurso(String nombre);
	List<Alumno> listaAlumnos();
	boolean matricular(String usuario,int idCurso);
	
	boolean a�adirAlumno(Alumno a);
	boolean a�adirCurso(Curso c);
	List<Curso> cursosAlumnoNoMatric(String usuario);
	List<Curso> cursosFechas(Date fInicio, Date fFin);	
	
}
