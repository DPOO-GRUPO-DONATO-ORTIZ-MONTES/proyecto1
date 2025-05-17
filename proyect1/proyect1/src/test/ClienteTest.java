package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tiquete.Tiquete;
import cliente.Cliente;

class ClienteTest {

	private Cliente cliente;
	
	
    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan", 123, "juan@example.com", 456);
    }
    
    @Test
    void testCrearCliente() {
        assertEquals("Juan", cliente.getNombre());
        assertEquals(123, cliente.getID());
        assertEquals("juan@example.com", cliente.getCorreo());
        assertEquals(456, cliente.getPassword());
    }

    @Test
    void testCarnetSalud() {
        Map<String, String> carnet = cliente.carnetSalud("Juan", "No", "No", "170", "70", "25", "No");
        assertEquals("Juan", carnet.get("Nombre "));
        assertEquals("No", carnet.get("Vertigo "));
        assertEquals("170", carnet.get("Altura"));
        assertEquals("70", carnet.get("Peso"));
        assertEquals("25", carnet.get("Edad"));
        assertEquals("No", carnet.get("Discapacidad"));
        assertEquals("No", carnet.get("Problemas cardiacos"));
    }

    @Test
    void testAgregarTiqueteComprado() throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date fecha = sdf.parse("2025-05-10");
        Tiquete tiquete = new Tiquete("100", "Diamante",fecha, false, cliente) {
            public String getTipo() {
                return "Diamante";
            }


            public boolean getMarcadorUso() {
                return false;
            }
        };

        cliente.tiqueteComprado("100", tiquete);
        Map<String, Map<String, String>> comprados = cliente.getTiquetesComprados();

        assertTrue(comprados.containsKey("100"));
        assertEquals("Diamante", comprados.get("100").get("Tipo"));
        assertEquals("Sat May 10 00:00:00 GMT-05:00 2025", comprados.get("100").get("fechaCompra"));
        assertEquals("false", comprados.get("100").get("estadoUso"));
    }
}
