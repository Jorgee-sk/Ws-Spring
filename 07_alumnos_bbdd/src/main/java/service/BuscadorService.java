package service;

import java.util.List;

import model.Alumno;

public interface BuscadorService {
	List <Alumno> buscar(String seccion);
	void alta(Alumno a);
	boolean buscarNombre(String nombre);
	List <String> cursos();
}
