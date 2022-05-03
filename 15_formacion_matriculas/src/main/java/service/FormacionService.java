package service;

import java.util.Date;
import java.util.List;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;

public interface FormacionService {
	AlumnoDto validarAlumno(String usuario, String contraseña);
	List<CursoDto> cursosAlumno(String usuario);
	List<CursoDto> listaCursos();
	List<AlumnoDto> alumnosCurso(String nombre);
	List<AlumnoDto> listaAlumnos();
	boolean matricular(String usuario,int idCurso);
	
	boolean añadirAlumno(AlumnoDto a);
	boolean añadirCurso(CursoDto c);
	List<CursoDto> cursosAlumnoNoMatric(String usuario);
	List<MatriculaDto> cursosFechas(Date fInicio, Date fFin);	
	
	
	
}
