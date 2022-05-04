package dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Cuenta;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {

	private int idMovimiento;
	private int idCuenta;
	private Date fecha;
	private double cantidad;
	private String operacion;
	private Cuenta cuenta;
	
}
