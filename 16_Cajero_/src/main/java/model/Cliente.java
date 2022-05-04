package model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	
	@OneToMany(mappedBy = "cliente")
	List<Titular> titulares;

	public Cliente(int dni, String nombre, String direccion, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
}
