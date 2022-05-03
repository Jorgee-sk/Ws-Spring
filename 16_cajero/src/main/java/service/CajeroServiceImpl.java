package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentaDao;
import dao.MovimientosDao;
import dao.TitularesDao;
import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientosDto;
import dto.TitularesDto;
import model.Cuenta;
import model.TitularPK;
import model.Titulares;


@Service
public class CajeroServiceImpl implements CajeroService{
	
	@Autowired
	ConversorEntityDto conversor;
	
	ClientesDao clientesDao;
	CuentaDao cuentaDao;
	MovimientosDao movimientosDao;
	TitularesDao titularesDao;
	
	public CajeroServiceImpl(@Autowired 	ClientesDao clientesDao , @Autowired CuentaDao cuentaDao, @Autowired MovimientosDao movimientosDao
			, @Autowired TitularesDao titularesDao) {
		this.clientesDao = clientesDao;
		this.cuentaDao = cuentaDao;
		this.movimientosDao = movimientosDao;
		this.titularesDao = titularesDao;
	}
	
	@Override
	public CuentaDto validarCuenta(int numeroCuenta) {
		
		Optional<Cuenta> c = cuentaDao.findById(numeroCuenta);
		return c.isPresent()?conversor.cuentaToDto(c.get()):null;
	}
	
	@Transactional
	@Override
	public boolean ingresar(MovimientosDto m) {
		
		movimientosDao.save(conversor.dtoToMovimientos(m));
		Optional<Cuenta> c = cuentaDao.findById(m.getIdCuenta().getNumeroCuenta());
		if(!c.isPresent()) { 
			cuentaDao.save(c.get());
			return true;
		}
		return false;
		
		
	}
	
	@Transactional
	@Override
	public boolean extraccion(MovimientosDto m) {
		
		movimientosDao.save(conversor.dtoToMovimientos(m));
		Optional<Cuenta> c = cuentaDao.findById(m.getIdCuenta().getNumeroCuenta());
		if(!c.isPresent()) { 
			cuentaDao.save(c.get());
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean transferencia(MovimientosDto m, int nCuenta) {
		
		Optional<Cuenta> c = cuentaDao.findById(nCuenta);
		if(c.isPresent()) { //Es decir existe una cuenta con ese numero de cuenta
			movimientosDao.save(conversor.dtoToMovimientos(m)); //Guardamos el movimiento
			cuentaDao.save(c.get()); //Guardamos los valores en la cuenta
			return true;
		}
		return false;
			
	}
	
	@Override
	public List<MovimientosDto> listaMovimientos(Date fInicio, Date fFin) {
		return movimientosDao.findMovimientosFechas(fInicio, fFin)
				.stream()
				.map(m->conversor.movimientoToDto(m))
				.collect(Collectors.toList());	
		
	}
	
	/*@Override
	public List<CuentaDto> cursosAlumno(String usuario) {
		return cuentaDao.findByAlumno(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CuentaDto> listaCursos() {
		return cuentaDao.findAll()
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());	
		
	}

	@Override
	public List<ClienteDto> alumnosCurso(String nombre) {
		return clientesDao.findByCurso(nombre)
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}
	

	@Override
	public List<ClienteDto> listaAlumnos() {
		return clientesDao.findAll()
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());	
	}
	
	@Transactional
	@Override
	public boolean matricular(String usuario, int idCurso) {
		
		Optional<Cuenta> curso=cuentaDao.findById(idCurso);
		Optional<Alumno> alumno=clientesDao.findById(usuario);
		if(curso.isPresent()&&alumno.isPresent()) {
			movimientosDao.save(new Titulares(new TitularPK(idCurso,usuario),0,curso.get(),alumno.get()));
			return true;
		}
		return false;
		
		
	}
	
	@Transactional
	@Override
	public boolean añadirAlumno(ClienteDto a) {
		
		Optional<Alumno> alum = clientesDao.findById(a.getUsuario());
		if(alum.isPresent()) {
			return false;
		}
		clientesDao.save(conversor.dtoToAlumno(a));
		return true;
		
	}
	
	@Transactional
	@Override
	public boolean añadirCurso(CuentaDto curso) {
		
		Optional<Cuenta> c = cuentaDao.findByNombre(curso.getNombre());
		if(!c.isPresent()) {
			cuentaDao.save(conversor.dtoToCurso(curso));
			return true;
		}
		return false;
		
	}

	@Override
	public List<CuentaDto> cursosAlumnoNoMatric(String usuario) {
		Optional<Alumno> a = clientesDao.findById(usuario);
		return cuentaDao.findByAlumnoNoMatric(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<TitularesDto> cursosFechas(Date fInicio, Date fFin) {
		
		return movimientosDao.findMatriculasFechas(fInicio, fFin)
				.stream()
				.map(m->conversor.matriculaToDto(m))
				.collect(Collectors.toList());
	}
	*/
	
	
}
