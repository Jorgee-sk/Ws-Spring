package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;

@Service  //Notation of core module in spring //Hace que spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Producto> buscar(String seccion) {
		String sql = "select * from productos where seccion=?";
		
		return template.query(sql, (rs,f)->new Producto(
					rs.getInt("idProducto"),
					rs.getString("nombre"),
					rs.getString("seccion"),
					rs.getDouble("precio"),
					rs.getInt("stock")),
					seccion);
		
	}

	@Override
	public void alta(Producto p) {
		String sql = "insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, p.getNombre(),p.getSeccion(),p.getPrecio(),p.getStock());
	}

	@Override
	public void eliminar(String nombre) {
		String sql = "delete from productos where nombre=?";
		template.update(sql, nombre);
		
	}

	@Override
	public void modificar(String nombre, double p) {
		String sql = "update productos set precio=? where nombre=?";
		template.update(sql,p,nombre);
		
	}
	
	@Override
	public Producto buscarProducto(int idProducto) {
		String sql = "select * from productos where seccion=?";
		
		List<Producto> productos = template.query(sql, (rs,f)->new Producto(
					rs.getInt("idProducto"),
					rs.getString("nombre"),
					rs.getString("seccion"),
					rs.getDouble("precio"),
					rs.getInt("stock")),
					idProducto);
		//Si la lista es mayor que 0 devolvemos el elemento cero, si no null
		return productos.size()>0?productos.get(0):null;
	}
	

}
