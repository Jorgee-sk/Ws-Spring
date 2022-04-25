package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.serviceConfig;
import service.BuscadorService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {serviceConfig.class})
public class TestProductosService {
	@Autowired
	BuscadorService bs;
	
	@Test
	void testProducto() {
		assertEquals(35,bs.buscarProducto(4).getPrecio());
		assertNull(bs.buscarProducto(800));
	}
	
	/*@Test
	void testMedia() {
		assertEquals(35,bs.mediaSeccion("alimentación"));
		
	}*/
	
}
