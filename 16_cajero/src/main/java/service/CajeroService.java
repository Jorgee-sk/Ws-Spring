package service;

import java.util.Date;
import java.util.List;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientosDto;
import dto.TitularesDto;

public interface CajeroService {
	
	CuentaDto validarCuenta(int nCuenta);
	boolean ingresar(MovimientosDto m);
	boolean extraccion(MovimientosDto m);
	boolean transferencia(MovimientosDto m, int nCuenta);
	List<MovimientosDto> listaMovimientos(Date fInicio, Date fFin);
	
	
	
}
