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
import Service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {serviceConfig.class})
public class TestEscuelaService {
	@Autowired
	EscuelaService bs;
	
	@Test
	void testAlumnoCurso() {
		List<Alumno> a = bs.alumnoCurso("java");
		assertEquals(4,a.size());
	}
	@Test
	void testAlumnoCursoDuracion() {
		List<Alumno> a = bs.alumnoCursoDuracion(60);
		assertEquals(0,a.size());
	}
	
	@Test
	void testCursoMatriculado(){
		Curso c = bs.cursoMatriculado("1111A");
		assertEquals("java",c.getNombre());
	}
	@Test
	void testAlumnosSenior() {
		List<Curso> a = bs.alumnosSenior(30);
		assertEquals(3,a.size());
	}
	
	@Test
	void testEdadMediaCurso() {
		double edad = bs.edadMediaCurso("java");
		assertEquals(25,edad);
	}
	
	@Test
	void testPrecioCurso() {
		double precio = bs.precioCurso("primero@gmail.com");
		assertEquals(precio,250);
	}

}
