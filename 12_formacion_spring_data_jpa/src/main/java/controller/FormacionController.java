package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {
	
	@Autowired //Inyecta dependencias de la logica de negocios
	FormacionService formacionService;
	
	@PostMapping(value="validar",produces = MediaType.APPLICATION_JSON_VALUE)
	public String validar(@RequestParam("usuario") String usuario,@RequestParam("password") String password) {
		 Alumno a = formacionService.validarAlumno(usuario,password);
		 if(a!=null)
			 return "Menu";
		 else
			 return "login";
	}
	
	@GetMapping(value="Cursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos() {
		return formacionService.listaCursos();
	}
	
	@GetMapping(value="cursosAlumno",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario) {
		return formacionService.cursosAlumno(usuario);
	}
	
	@GetMapping(value="alumnosCurso",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombre") String nombre) {
		return formacionService.alumnosCurso(nombre);
	}
	
	@GetMapping(value="Alumnos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos() {
		return formacionService.listaAlumnos();
	}
	
	
}
