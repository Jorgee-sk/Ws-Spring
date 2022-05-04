package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name="movimientos")
public class Movimiento {

	@Id
	private int idMovimiento;
	private int idCuenta;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private double cantidad;
	private String operacion;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="idCuenta", referencedColumnName = "numeroCuenta", insertable = false, updatable = false)
	Cuenta cuenta;
	
	public Movimiento( int idCuenta, Date fecha, double cantidad, String operacion) {
		super();
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
}
