package service;

import java.util.Date;
import java.util.List;

import dtos.CuentaDto;
import dtos.MovimientoDto;

public interface CajeroService {
	public CuentaDto obtenerCuenta(int numCuenta); 
	public boolean ingresarDinero(int numCuenta, double cantidad);
	public boolean extraerDinero(int numCuenta, double cantidad);
	public boolean transferencia(int nCuentaOrg, int nCuentaDst, double cantidad);
	public List<MovimientoDto> movimientos (int numCuenta, Date f1, Date f2);
	public double verSaldo(int numCuenta);
}
