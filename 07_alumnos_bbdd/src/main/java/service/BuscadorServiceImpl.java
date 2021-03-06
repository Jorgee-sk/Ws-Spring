package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;

@Service  //Notation of core module in spring //Hace que spring cree una instancia de la clase
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Alumno> buscar(String curso) {
		String sql = "select * from alumnos where curso=?";
		
		return template.query(sql, (rs,f)->new Alumno(
					rs.getInt("idAlumno"),
					rs.getString("nombre"),
					rs.getString("curso"),
					rs.getDouble("nota")),
					curso);
		
	}

	@Override
	public void alta(Alumno a) {
		if(!buscarNombre(a.getNombre())) {
			String sql = "insert into alumnos(nombre,curso,nota) values(?,?,?)";
			template.update(sql, a.getNombre(),a.getCurso(),a.getNota());
		}
		
	}

	@Override
	public boolean buscarNombre(String nombre) {
		String sql = "select * from alumnos where nombre=?";
		List<Alumno> alumnos = template.query(sql, (rs,f)->new Alumno(
				rs.getInt("idAlumno"),
				rs.getString("nombre"),
				rs.getString("curso"),
				rs.getDouble("nota")),
				nombre);
		return alumnos.size()>0;
		
	}

	@Override
	public List<String> cursos() {
		String sql = "select distinct(curso) from alumnos";
		return template.query(sql, (r,f)->r.getString(1));
	}

	

}
