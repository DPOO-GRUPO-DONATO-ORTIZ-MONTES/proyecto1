package test;

import Tiquete.EntradaIndividual;
import cliente.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
public class TiqueteTest {

    @Test
    void testAbstractGetters() {
        Cliente c = new Cliente("Ana", 1, "a@b.com", 111);
        EntradaIndividual e = new EntradaIndividual(null, "general", new Date(), false, c, "Atrac1");
        assertNotNull(e.getid());
        assertEquals("general", e.getTipo());
        assertFalse(e.validarUso());
        assertEquals("Atrac1", e.getAtraccionAsignada());
    }
}
