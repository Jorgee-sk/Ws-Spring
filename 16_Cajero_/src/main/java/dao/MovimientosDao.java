package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer>{
	
	@Query("select m from Movimiento m where m.idCuenta =?1 and m.fecha between ?2 and ?3")
	List<Movimiento> findMovimientosFechas(int numCuenta, Date fechaIni, Date fechaFin);
}
