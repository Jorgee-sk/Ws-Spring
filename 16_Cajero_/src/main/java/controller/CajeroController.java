package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.CuentaDto;
import dtos.MovimientoDto;
import service.CajeroService;

@CrossOrigin("*")
@Controller
public class CajeroController {
	
	@Autowired
	CajeroService cajeroService;
	
	private int nCuenta=1000;
	
	@PostMapping("Login")
	public String login(@RequestParam("numeroCuenta") int numeroCuenta, HttpSession sesion, HttpServletRequest request) {
		CuentaDto cuenta =  cajeroService.obtenerCuenta(numeroCuenta);
		if (cuenta!= null) {
			sesion.setAttribute("numeroCuenta", numeroCuenta);
			nCuenta = numeroCuenta;
			return "menu"; 
		}else {
			sesion.setAttribute("mensaje", "numero de cuenta incorrecto");
			return "login";
		}
	}
	
	@GetMapping(value = "Saldo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Double saldo() {
		return cajeroService.verSaldo(nCuenta);
	}
	
	@GetMapping(value = "Movimientos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<MovimientoDto> movimientos(@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("fechaIni") Date fechaIni,
			@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("fechaFin") Date fechaFin) {
		
		return cajeroService.movimientos(nCuenta, fechaIni, fechaFin);
	}
	
	@PostMapping("Ingreso")
	public String ingreso(@RequestParam("cantidad") double cantidad) {
		return (cajeroService.ingresarDinero(nCuenta, cantidad))? "menu": "Ingreso";
	}
	
	@PostMapping("Extraer")
	public String extraer(@RequestParam("cantidad") double cantidad) {
		return (cajeroService.extraerDinero(nCuenta, cantidad))? "menu":"Extraer";
	}
	
	@PostMapping("Transferencia")
	public String transferir(@RequestParam("nCuentaDestino") int nCuentaDestino , @RequestParam("cantidad") double cantidad) {
		return (cajeroService.transferencia(nCuenta, nCuentaDestino, cantidad)) ? "menu": "Transferencia";
	}

}
