package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta,Integer>{
	
	
	
}
