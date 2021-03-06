package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.BuscadorService;

@Controller
public class BuscadorController {
	
	@Autowired //Inyecta dependencias de la logica de negocios
	BuscadorService buscadorService;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto> productos = buscadorService.buscar(seccion);
		request.setAttribute("productos", productos);
		return "listado";
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Producto prod) {
		buscadorService.alta(prod);
		return "inicio";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		buscadorService.eliminar(nombre);
		return "inicio";
	}
	
	@GetMapping(value="Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") double pr) {
		buscadorService.modificar(nombre,pr);
		return "inicio";
	}
	
}
