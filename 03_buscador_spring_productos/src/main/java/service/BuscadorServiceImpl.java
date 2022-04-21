package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;

@Service  //Notation of core module in spring //Hace que spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	
	ArrayList<Producto> productos = new ArrayList<>();
	public BuscadorServiceImpl() {
		productos.add(new Producto("vino","alimentación",8.4,25));
		productos.add(new Producto("leche","alimentación",1.2,70));
		productos.add(new Producto("cable usb","informática",5.6,30));
		productos.add(new Producto("arroz","alimentación",3.1,16));
		productos.add(new Producto("silla","hogar",30.6,10));
		productos.add(new Producto("monitor","informática",125.0,5));
		productos.add(new Producto("escritorio","hogar",230,4));
	}
	@Override
	public List<Producto> buscar(String seccion) {
		// TODO Auto-generated method stub
		return productos
				.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.collect(Collectors.toList());
	}
	@Override
	public void alta(Producto p) {
		productos.add(p);
	}
	@Override
	public void eliminar(String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
		
		/*for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getNombre().equals(nombre))
				productos.remove(i);
		}*/
		
	}
	@Override
	public void modificar(String nombre, double pr) {
		/*for (Producto producto : productos) {
			if(producto.getNombre().equals(nombre))
				producto.setPrecio(pr);
		}*/
		productos.forEach(p->{
			if(p.getNombre().equals(nombre))
				p.setPrecio(pr);
		});
	}

}
