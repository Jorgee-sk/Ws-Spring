package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Movimientos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name="cantidad")
	private double cantidad;
	@Column(name="operacion")
	private String operacion;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCuenta", referencedColumnName="numeroCuenta",insertable=false,updatable=false)
    private Cuenta cuenta;

	
	
	
	public Movimientos(int idMovimiento,Date fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
}
