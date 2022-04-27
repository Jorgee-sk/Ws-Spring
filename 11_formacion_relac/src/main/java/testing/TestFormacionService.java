package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.serviceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {serviceConfig.class})
public class TestFormacionService {
	@Autowired
	FormacionService bs;
	
	
	@Test
	void testAlumno() {
		Alumno a = bs.validarAlumno("admin", "a");
		assertEquals("tomates",a.getNombre());
	}
	
	@Test
	void testAlumnoMatric() {
		List<Curso> c = bs.cursosAlumno("aaa");
		assertEquals(3,c.size());
	}
	
	@Test
	void testListaCursos() {
		List<Curso> c = bs.listaCursos();
		assertEquals(18,c.size());
	}
	
	@Test 
	void testAlumnosCurso() {
		List<Alumno> a = bs.alumnosCurso("python");
		assertEquals(4,a.size());
	}
	@Test
	void testMatricular() {
		bs.matricular("aaa", 5);
		assertEquals(2, bs.alumnosCurso("ordenador").size());
	}
	
}
