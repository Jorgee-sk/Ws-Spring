package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Cuenta;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientosDto {
	
	private int idMovimiento;
	private Cuenta idCuenta;
	private Date fecha;
	private double cantidad;
	private String operacion;
}
