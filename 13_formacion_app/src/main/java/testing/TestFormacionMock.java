package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.serviceConfig;
import dao.AlumnosDao;
import dao.CursoDao;
import model.Alumno;
import model.Curso;
import service.FormacionService;
import service.FormacionServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {serviceConfig.class})
public class TestFormacionMock {
	@Mock
	AlumnosDao alumnosDao;
	
	@Mock
	CursoDao cursosDao;
	
	FormacionService bs;
	
	List<Alumno> alumnos;
	List<Curso> cursos;
	
	@BeforeEach
	void init() {
		cursos=List.of(new Curso(1,"curso1",100,10,null),
				new Curso(2,"curso2",200,20,null),
				new Curso(3,"curso3",300,30,null));
		alumnos=List.of(new Alumno("user1","pwd1","n1","e1",10,new ArrayList<>(List.of(cursos.get(0),cursos.get(1)))),
				new Alumno("user2","pwd2","n2","e2",20,new ArrayList<>(List.of(cursos.get(0)))),
				new Alumno("user3","pwd3","n3","e3",30,new ArrayList<>(List.of(cursos.get(2)))),
				new Alumno("user4","pwd4","n4","e4",10,new ArrayList<>(List.of(cursos.get(0),cursos.get(2)))));
		lenient().when(alumnosDao.findByUsuarioAndPassword("user1", "pwd1")).thenReturn(alumnos.get(0));
		lenient().when(alumnosDao.findByUsuarioAndPassword("user3", "pwd3")).thenReturn(alumnos.get(2));
		lenient().when(alumnosDao.findByUsuarioAndPassword("user7", "aaa")).thenReturn(null);
		lenient().when(alumnosDao.findByCurso("curso1")).thenReturn(List.of(alumnos.get(0),alumnos.get(1),alumnos.get(3)));
		lenient().when(alumnosDao.findById("user3")).thenReturn(Optional.of(alumnos.get(2)));
		lenient().doNothing().when(alumnosDao).save(alumnos.get(2)); //para que no haga nada al llamar a update
		lenient().when(cursosDao.findById(2)).thenReturn(Optional.of(cursos.get(1)));
		lenient().when(cursosDao.findAll()).thenReturn(cursos);
		lenient().when(cursosDao.findByAlumno("user3")).thenReturn(alumnos.get(2).getCurso());
		
		
		bs = new FormacionServiceImpl(alumnosDao,cursosDao);
	}
	
	@Test
	void testBuscarAlumno() {
		assertEquals("e1",bs.validarAlumno("user1", "pwd1").getEmail());
		assertNull(bs.validarAlumno("user7", "aaa"));
	}
	
	@Test
	void testCursosAlumno() {
		assertEquals(1, bs.cursosAlumno("user3").size());
		
	}
	@Test
	void testAlumnosCurso() {
		assertEquals(3, bs.alumnosCurso("curso1").size());
	}
	
	@Test
	void testCursos() {
		assertEquals(3, bs.listaCursos().size());
	}
	
	@Test
	void testMatricular() {
		assertTrue(bs.matricular("user3", 2));
		//tras matricular al alumno en un nuevo curso, obtenemos el alumno
		//y comprobamos que tiene un curso m�s al creado inicialmente
		assertEquals(2,bs.validarAlumno("user3", "pwd3").getCurso().size());
	}
}
