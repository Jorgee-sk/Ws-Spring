package model;


import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class TitularPK implements Serializable{
	
	private int idCuenta;
	private int idCliente;
	
	public TitularPK(int idCuenta, int idCliente) {
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
	}
}
