package service;

import java.util.ArrayList;
import java.util.List;

import model.Pagina;

public class BuscadorService {
	ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorService() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y m�s cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","M�sica de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","M�sica de actualidad"));
	}
	//bucamos las p�ginas cuya tem�tica coincida con la recibida
	//como par�metro
	public List<Pagina> buscar(String tematica){
		//en este arraylist auxiliar guardamos las p�ginas
		//cuya tem�tica coincida con la recibida como par�metro
		List<Pagina> auxiliar=new ArrayList<>();
		for(int i=0;i<paginas.size();i++) {
			Pagina pagina=paginas.get(i);
			if(pagina.getTematica().equals(tematica)) {
				auxiliar.add(pagina);
			}
		}
		return auxiliar;
	}
	
}
