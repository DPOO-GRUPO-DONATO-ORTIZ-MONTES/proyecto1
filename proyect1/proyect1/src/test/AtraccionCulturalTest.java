package test;

import atraccion.AtraccionCultural;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtraccionCulturalTest {

    @Test
    void testSeasonSettings() {
        AtraccionCultural cult = new AtraccionCultural(100, 5, "bajo", "cultural", "Teatro");
        cult.setEdadMinima(12);
        cult.setEsTemporada(true);
        cult.setFechaTemporada("2025-06-01 to 2025-08-31");

        assertEquals(12, cult.getEdadMinima());
        assertTrue(cult.isEsTemporada());
        assertEquals("2025-06-01 to 2025-08-31", cult.getFechaTemporada());
    }
}
