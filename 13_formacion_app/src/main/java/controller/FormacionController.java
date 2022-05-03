package controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	
	@GetMapping(value="noMatriculados",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> alumnosNoMatric(@RequestParam("usuario") String usuario) {
		return formacionService.cursosAlumnoNoMatric(usuario);
	}
	
	@GetMapping(value="fechasCursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> fechasCursos(@RequestParam("fechaInicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date fInit,
												  @RequestParam("fechaFin") @DateTimeFormat(pattern="yyyy-MM-dd") Date fFin) {
	/*	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fInicio = null;
		Date fFinal = null;
		try {
			fInicio = formatter.parse(fInit);
			fFinal = formatter.parse(fFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		return formacionService.cursosFechas(fInit,fFin);
	}
	
	@PostMapping(value="altaAlumno",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String altaAlumno(@ModelAttribute Alumno a) {
		return formacionService.añadirAlumno(a)?"Menu":"altaAlumno";
		
	}
	
	@PostMapping(value="altaCurso",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String altaCurso(@ModelAttribute Curso c) {
		return formacionService.añadirCurso(c)?"Menu":"altaCurso";
		
	}
	
	
}
