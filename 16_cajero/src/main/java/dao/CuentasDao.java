package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {
 
	List<Cuenta> findByNumeroCuenta(int numeroCuenta);
	
	@Query("select c.saldo from Cuenta c where c.numeroCuenta =?1 ")
	Double findBySaldo(int numeroCuenta);
}
