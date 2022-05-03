package model;


import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class MatriculaPK implements Serializable{
	
	private String usuario;
	private int idCurso;
	
	public MatriculaPK(int idCurso, String usuario) {
		this.idCurso = idCurso;
		this.usuario = usuario;
	}
}
