package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente,Integer>{
	
	
	
}
