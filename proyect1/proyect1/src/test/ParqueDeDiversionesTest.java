package test;

import parqueDeDiversiones.ParqueDeDiversiones;
import atraccion.AtraccionCultural;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ParqueDeDiversionesTest {

	@Test
	void testGetNivelExclusividad() {
		ParqueDeDiversiones.mapaExclusividad.put("Rueda", "oro");
		assertEquals("oro", new ParqueDeDiversiones().getNivelExclusividad("Rueda"));
	}

	@Test
	void testGetNivelExclusividadInexistente() {
		String nivel = new ParqueDeDiversiones().getNivelExclusividad("NoExiste");
		assertEquals("basico", nivel);
	}

	@Test
	void testGetAtracciones() {
		AtraccionCultural cult = new AtraccionCultural(30, 2, "bajo", "cultural", "Museo");
		ParqueDeDiversiones.atracciones.add(cult);
		List<?> lista = new ParqueDeDiversiones().getAtracciones();
		assertEquals(1, lista.size());
		assertTrue(lista.get(0) instanceof AtraccionCultural);
	}

}
