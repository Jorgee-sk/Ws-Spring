package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="alumnos")
public class Alumno {
	@Id
	private String usuario;
	@Column(name="password")
	private String password;
	@Column(name="nombre")
	private String nombre;
	@Column(name="email")
	private String email;
	@Column(name="edad")
	private int edad;

	@OneToMany(mappedBy="alumno")
	private List<Matricula> matricula;  
	 
	 
	public Alumno(String usuario, String password,String nombre,String email,int edad) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
}
