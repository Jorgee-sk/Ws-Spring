package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente, Integer> {

}
