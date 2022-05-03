package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cuentas")
public class Cuenta {
	
	@Id
	private int numeroCuenta;
	@Column(name="saldo")
	private int saldo;
	@Column(name="tipoCuenta")
	private String tipoCuenta;
	
	@JsonIgnore
	@OneToMany(mappedBy="cuenta")
	private List<Movimientos> movimientos;

	
	
	public Cuenta(int numeroCuenta,int saldo,String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

}
