package Service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnoCurso(String nombre);
	List<Alumno> alumnoCursoDuracion(int duracionMax);
	
	Curso cursoMatriculado(String dni);
	List<Curso> alumnosSenior(int edad);
	
	double edadMediaCurso(String nombreCurso);
	double precioCurso(String email);
}
