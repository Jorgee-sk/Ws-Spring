package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.serviceConfig;
import dto.AlumnoDto;
import dto.CursoDto;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {serviceConfig.class})
public class TestFormacionService {
	@Autowired
	FormacionService bs;
	
	
	@Test
	void testAlumno() {
		
		assertNotNull(bs.validarAlumno("admin", "a"));
		assertNull(bs.validarAlumno("text", "myText"));
	}
	
	@Test
	void testAlumnoMatric() {
		assertEquals(4,bs.cursosAlumno("admin").size());
	}
	

	@Test 
	void testAlumnosCurso() {
		assertEquals(4,bs.alumnosCurso("kafka").size());
	}
	
	
	@Test
	void testAltaCurso() {
		CursoDto c = new CursoDto();
		c.setNombre("java 10");
		assertEquals(false,bs.añadirCurso(c));
	}
	
	@Test
	void testAltaAlumno() {
		AlumnoDto a = new AlumnoDto();
		a.setUsuario("admin");
		assertEquals(false,bs.añadirAlumno(a));
	}
	
	@Test
	void testAlumnosNoMatric() {
		assertEquals(14,bs.cursosAlumnoNoMatric("admin").size());
	}
	
	@Test
	void testFechasCursosRango() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2020, 8, 20);
		c2.set(2022, 2, 10);
		Date f1 = c1.getTime();
		Date f2 = c2.getTime();
		
		assertEquals(16,bs.cursosFechas(f1, f2).size());
	}
	
}
