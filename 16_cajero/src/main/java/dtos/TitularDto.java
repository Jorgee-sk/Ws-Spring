package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Cliente;
import model.Cuenta;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TitularDto {
	
	private Cuenta cuenta;
	private Cliente cliente;
	
}
