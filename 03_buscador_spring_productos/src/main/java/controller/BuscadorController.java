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
	BuscadorService bs;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto> productos = bs.buscar(seccion);
		request.setAttribute("productos", productos);
		return "listado";
	}
	
	@PostMapping(value="Alta")
	public String alta(@ModelAttribute Producto prod) {
		bs.alta(prod);
		return "inicio";
	}
	
	@GetMapping(value="Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		bs.eliminar(nombre);
		return "inicio";
	}
	
	@GetMapping(value="Modificar")
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("precio") double pr) {
		bs.modificar(nombre,pr);
		return "inicio";
	}
	
}
