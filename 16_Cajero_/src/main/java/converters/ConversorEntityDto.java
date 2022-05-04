package converters;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;

public interface ConversorEntityDto {
	public ClienteDto clienteToDto(Cliente cliente);
	public Cliente dtoToCliente(ClienteDto dto);
	public CuentaDto cuentaToDto(Cuenta cuenta);
	public Cuenta dtoDoCuenta(CuentaDto dto);
	public MovimientoDto movimientoToDto(Movimiento movimiento);
	public Movimiento dtoToMovimiento(MovimientoDto dto);
	public TitularDto titularToDto(Titular titular);
	public Titular dtoToTitular(TitularDto dto);
	

}
