package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import model.Producto;

@Service  //Notation of core module in spring //Hace que spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Producto> buscar(String seccion) {
		
	 List<Producto> productos = entityManager.createQuery("SELECT p from Producto p where p.seccion = :seccion") //
		        .setParameter("seccion", seccion) //
		        .getResultList();
	 return productos;

	}
	
	@Transactional
	@Override
	public void alta(Producto p) {
		
		entityManager.persist(p);
		
	}
	
	@Transactional
	@Override
	public void eliminar(String nombre) {
		
		String jpql="Delete from Producto p where p.nombre = :nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nombre",nombre);
		
		int res=query.executeUpdate();

	}
	@Transactional
	@Override
	public void modificar(String nombre, double precio) {
		String jpql="UPDATE Producto p SET p.precio = :precio where p.nombre =:nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("precio",precio);
		query.setParameter("nombre",nombre);
		int res=query.executeUpdate();

	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}
	@Transactional
	@Override
	public Producto buscarProducto(String nombre) {
		
		String jpql="SELECT p from Producto p where p.nombre = :nombre";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("nombre",nombre);
		Producto p = (Producto) query.getSingleResult();
		return p;

	}
	


}
