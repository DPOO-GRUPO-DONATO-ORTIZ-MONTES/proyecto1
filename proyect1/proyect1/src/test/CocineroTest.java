package test;

import Empleado.cocinero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CocineroTest {

    @Test
    void testCertificadoAlimentos() {
        cocinero ck = new cocinero("Cocinero", "Maria", "mañana", false, 11, 1300, "A3", 0, "cocina", "Cert123");
        assertEquals("Cert123", ck.getCertificadoAlimentos());
    }
}
