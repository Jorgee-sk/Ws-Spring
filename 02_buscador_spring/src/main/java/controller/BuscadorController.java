package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired //Inyecta dependencias de la logica de negocios
	BuscadorService bs;
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("tema") String tematica, HttpServletRequest request) {
		List<Pagina> paginas = bs.buscar(tematica);
		request.setAttribute("paginas", paginas);
		return "listado";
	}
	
	/*@PostMapping(value="Anadir")
	public String añadirPagina(@RequestParam("direccion") String direccion,
			@RequestParam("tematica")	String tematica, 
			@RequestParam("descripcion") String descripcion, 
			HttpServletRequest request) {
		Pagina pag = new Pagina(direccion,tematica,descripcion);
		bs.añadirPagina(pag);
		
		return "datos";
	}*/
	
	@PostMapping(value="Anadir")
	public String añadirPagina(@ModelAttribute Pagina pag) {
		bs.añadirPagina(pag);
		return "datos";
	}
}
