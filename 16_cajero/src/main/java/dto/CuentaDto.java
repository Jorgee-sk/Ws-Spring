package dto;

import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CuentaDto {
	
	private int numeroCuenta;
	private int saldo;
	private String tipoCuenta;
	
}
