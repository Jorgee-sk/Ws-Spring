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

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
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
		 AlumnoDto a = formacionService.validarAlumno(usuario,password);
		 if(a!=null)
			 return "menu";
		 else
			 return "login";
	}
	
	@GetMapping(value="Cursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursos() {
		return formacionService.listaCursos();
	}
	
	@GetMapping(value="cursosAlumno",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> cursosAlumno(@RequestParam("usuario") String usuario) {
		return formacionService.cursosAlumno(usuario);
	}
	
	@GetMapping(value="alumnosCurso",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnosCurso(@RequestParam("nombre") String nombre) {
		return formacionService.alumnosCurso(nombre);
	}
	
	@GetMapping(value="Alumnos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> alumnos() {
		return formacionService.listaAlumnos();
	}
	
	@GetMapping(value="noMatriculados",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> alumnosNoMatric(@RequestParam("usuario") String usuario) {
		return formacionService.cursosAlumnoNoMatric(usuario);
	}
	
	@GetMapping(value="fechasCursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MatriculaDto> fechasCursos(@RequestParam("fechaInicio") @DateTimeFormat(pattern="yyyy-MM-dd") Date fInit,
												  @RequestParam("fechaFin") @DateTimeFormat(pattern="yyyy-MM-dd") Date fFin) {
		 
		return formacionService.cursosFechas(fInit,fFin);
	}
	
	@PostMapping(value="altaAlumno",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String altaAlumno(@ModelAttribute AlumnoDto a) {
		return formacionService.aņadirAlumno(a)?"menu":"altaAlumno";
		
	}
	
	@PostMapping(value="altaCurso",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String altaCurso(@ModelAttribute CursoDto c) {
		return formacionService.aņadirCurso(c)?"menu":"altaCurso";
		
	}
	
	@PostMapping(value="matricular",produces = MediaType.APPLICATION_JSON_VALUE)
	public String matricular(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario) {
		formacionService.matricular(usuario, idCurso);
		return "";
	}
	
	
	
}
