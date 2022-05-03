package converters;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientosDto;
import dto.TitularesDto;
import model.Cliente;
import model.Cuenta;
import model.Movimientos;
import model.Titulares;

public interface ConversorEntityDto {
	
	public CuentaDto cuentaToDto(Cuenta cuenta);
	public Cuenta dtoToCuenta(CuentaDto dto);
	public ClienteDto clienteToDto(Cliente cliente);
	public Cliente dtoToCliente(ClienteDto dto);
	public MovimientosDto movimientoToDto(Movimientos movimiento);
	public Movimientos dtoToMovimientos(MovimientosDto dto);
	
}
