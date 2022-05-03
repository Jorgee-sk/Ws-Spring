package converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientosDto;
import dto.TitularesDto;
import model.Cliente;
import model.Cuenta;
import model.Movimientos;
import model.Titulares;
import model.TitularPK;
@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto{

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipoCuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(),dto.getSaldo(),dto.getTipoCuenta());
	}

	@Override
	public ClienteDto clienteToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono());
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		return new Cliente(dto.getDni(),dto.getNombre(),dto.getDireccion(),dto.getTelefono());
	}

	@Override
	public MovimientosDto movimientoToDto(Movimientos movimiento) {
		return new MovimientosDto(movimiento.getIdMovimiento(),movimiento.getCuenta(),movimiento.getFecha(),movimiento.getCantidad(),
				movimiento.getOperacion());
	}

	@Override
	public Movimientos dtoToMovimientos(MovimientosDto dto) {
		return new Movimientos(dto.getIdMovimiento(),dto.getFecha(),dto.getCantidad(),dto.getOperacion());
	}


}
