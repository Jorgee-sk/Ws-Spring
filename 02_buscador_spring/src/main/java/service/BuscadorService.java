package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List <Pagina> buscar(String tematica);
	void a�adirPagina(Pagina p);
}
