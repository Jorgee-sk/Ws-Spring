package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.TitularPK;
import model.Titulares;

public interface TitularesDao extends JpaRepository<Titulares,TitularPK>{

}
