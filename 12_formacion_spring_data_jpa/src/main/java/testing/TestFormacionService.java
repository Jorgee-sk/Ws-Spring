package testing;

import static org.junit.jupiter.api.Assertions.*;

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
	
	
}
