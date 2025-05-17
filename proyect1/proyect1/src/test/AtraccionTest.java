package test;

import atraccion.Atraccion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtraccionTest {

    @Test
    void testConstructorAndGetters() {
        Atraccion atr = new Atraccion(50, 3, "alto", "mecánica", "Montaña Rusa");

        assertEquals(50, atr.getCupo());
        assertEquals(3, atr.getNumEmpleado());
        assertEquals("alto", atr.getNivelAtraccion());
        assertEquals("mecánica", atr.getTipoAtraccion());
        assertEquals("Montaña Rusa", atr.getNombreAtraccion());

        atr.setNivelAtraccion("medio");
        assertEquals("medio", atr.getNivelAtraccion());

        atr.setTipoAtraccion("cultural");
        assertEquals("cultural", atr.getTipoAtraccion());

        atr.setNombreAtraccion("Museo");
        assertEquals("Museo", atr.getNombreAtraccion());
    }
}
