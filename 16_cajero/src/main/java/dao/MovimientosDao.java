package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimientos;
import model.Titulares;

public interface MovimientosDao extends JpaRepository<Movimientos,Integer>{

	@Query("select distinct(m) from Movimientos m where m.fecha between ?1 and ?2")
	List<Movimientos> findMovimientosFechas(Date fInit, Date fFin);
	
}
