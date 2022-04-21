package service;

import java.util.List;

import model.Producto;

public interface BuscadorService {
	List <Producto> buscar(String seccion);
	void alta(Producto p);
	void eliminar(String nombre);
	void modificar(String nombre, double p);
	Producto buscarProducto(int idProducto);
	
}
