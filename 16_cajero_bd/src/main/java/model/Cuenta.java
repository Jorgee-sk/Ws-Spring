package model;

import java.util.List;

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
	private double saldo;
	private String tipocuenta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cuenta")
	List<Titular> titulares;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cuenta")
	List<Movimiento> movimientos;

	public Cuenta(int numeroCuenta, double saldo, String tipocuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}
	
	
}
