package test;

import Empleado.operadorMecanica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class OperadorMecanicaTest {

    @Test
    void testCertification() {
        List<String> hab = new ArrayList<>();
        operadorMecanica op = new operadorMecanica("Operador", "Luis", "tarde", false, 12, 1400, "A4", 0, "mecánica", hab, hab);
        op.certificarAtraccion("Montaña Rusa");
        assertTrue(op.getHabilitadasOperar().contains("Montaña Rusa"));
    }
}