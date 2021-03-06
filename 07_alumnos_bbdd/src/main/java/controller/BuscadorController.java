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
import service.BuscadorService;

@CrossOrigin("*")
@Controller
public class BuscadorController {
	
	@Autowired //Inyecta dependencias de la logica de negocios
	BuscadorService buscadorService;
	
	@GetMapping(value="Buscador",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso) {
		return buscadorService.buscar(curso);
	}
	
	@GetMapping(value="Cursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> cursos() {
		return buscadorService.cursos();
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Alumno alum) {
		if(!buscadorService.buscarNombre(alum.getNombre())) {
			buscadorService.alta(alum);
			return "inicio";
		}else
			return "inicio";
			
		
	}
	
}
