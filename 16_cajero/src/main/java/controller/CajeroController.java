package controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientosDto;
import dto.TitularesDto;
import model.Cuenta;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {
	
	@Autowired //Inyecta dependencias de la logica de negocios
	CajeroService cajeroService;
	
	@PostMapping(value="validar",produces = MediaType.APPLICATION_JSON_VALUE)
	public String validar(@RequestParam("numeroCuenta") int numeroCuenta) {
		 CuentaDto acc = cajeroService.validarCuenta(numeroCuenta);
		 if(acc!=null)
			 return "menu";
		 else
			 return "login";
	}
	
	@PostMapping(value="ingresar",produces = MediaType.APPLICATION_JSON_VALUE)
	public String ingresar(@RequestParam("movimiento") MovimientosDto movimiento) {
		return cajeroService.ingresar(movimiento)?"menu":"ingreso"; 
	}
	
	@PostMapping(value="extraer",produces = MediaType.APPLICATION_JSON_VALUE)
	public String extraccion(@RequestParam("movimiento") MovimientosDto movimiento) {
		return cajeroService.extraccion(movimiento)?"menu":"extraccion"; 
	}
	
	@PostMapping(value="transferencia",produces = MediaType.APPLICATION_JSON_VALUE)
	public String transferir(@RequestParam("movimiento") MovimientosDto movimiento,@RequestParam("numeroCuenta") int numeroCuenta) {
		return cajeroService.transferencia(movimiento,numeroCuenta)?"menu":"transferencia"; 
	}
	
	@GetMapping(value="movimientos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientosDto> fechasMovimientos(
												  @RequestParam("fechaInicio") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
												  Date fInit,
												  @RequestParam("fechaFin") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
												  Date fFin) {
		 
		return cajeroService.listaMovimientos(fInit,fFin);
	}
	
}
