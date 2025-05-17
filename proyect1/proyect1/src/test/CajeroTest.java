package test;

import Empleado.cajero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajeroTest {

    @Test
    void testPuntoAsignado() {
        cajero c = new cajero("Cajero", "Pedro", "noche", false, 10, 1500, "A2", 0, "entradas", "Caja 3");
        assertEquals("Caja 3", c.getPuntoAsignado());
    }
}