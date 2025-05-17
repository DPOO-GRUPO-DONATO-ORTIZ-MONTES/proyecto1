package test;

import Tiquete.Tiquete;
import Tiquete.EntradaIndividual;
import Tiquete.VentaOnline;
import cliente.Cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class VentaOnlineTest {

	private Cliente c;
    private VentaOnline venta;
    private List<Tiquete> tiquetes;

    @BeforeEach
    public void setUp() {
    	c = new Cliente("Ana", 1, "a@b.com", 111);
        tiquetes = new ArrayList<>();
        venta = new VentaOnline(new Date(), "Tarjeta", tiquetes, c);
    }
    @Test
    public void testRegistrarVenta() {
        Tiquete tiquete = new EntradaIndividual("001", "Basico", new Date(), false, c, null);
        venta.registrarVenta(tiquete);

        assertEquals(1, venta.getListaTiquetes().size());
        assertEquals(tiquete, venta.getListaTiquetes().get(0));
    }

    @Test
    public void testCalcularVenta() {
        Tiquete tiquete1 = new EntradaIndividual("001", "Diamante", new Date(), false, c, null);
        Tiquete tiquete2 = new EntradaIndividual("002", "Basico", new Date(), false, c, null);
        Tiquete tiquete3 = new EntradaIndividual("003", "Familiar", new Date(), false, c, null);
        List<Tiquete> lista = Arrays.asList(tiquete1, tiquete2, tiquete3);
        
        float total = venta.calcularVenta(lista);
        assertEquals(90000 + 15000 + 30000, total);
    }
    
    
    @Test
    public void testVenderTiqueteDiamanteEnTemporada() {
        String fecha = "2025-05-10";
        Map<String, Map<String, String>> resultado = venta.venderTiquete("Pedro", "Diamante", fecha, fecha, "001", c);
        Map<String, String> tiqueteInfo = resultado.get("001");
        assertEquals("30000", tiqueteInfo.get("valor Tiquete"));
        assertEquals("Diamante", tiqueteInfo.get("tipo"));
        assertTrue(c.getTiquetesComprados().containsKey("001"));
    }
    @Test
    public void testVenderTiqueteFamiliarFueraTemporada() {
        String fecha = "2025-06-01";
        Map<String, Map<String, String>> resultado = venta.venderTiquete("Pedro", "Familiar", fecha, "2025-05-01", "002", c);

        Map<String, String> tiqueteInfo = resultado.get("002");
        assertEquals("25000", tiqueteInfo.get("valor Tiquete"));
    }
}
