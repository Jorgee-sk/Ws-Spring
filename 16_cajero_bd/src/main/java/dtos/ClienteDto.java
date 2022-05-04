package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteDto {
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
}
