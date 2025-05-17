package test;

import atraccion.AtraccionMecanica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtraccionMecanicaTest {

    @Test
    void testUserRequirementsAndSeason() {
        AtraccionMecanica mech = new AtraccionMecanica(20, 2, "alto", "mecánica", "Montaña Rusa");
        mech.setPesoUsuario(70);
        mech.setAlturaUusario(150);
        mech.setExisteVertigo(false);
        mech.setEsDiscapacitado(false);
        mech.setEsTemporada(false);
        mech.setFechaTemporada("");

        assertEquals(70, mech.getPesoUsuario());
        assertEquals(150, mech.getAlturaUusario());
        assertFalse(mech.isExisteVertigo());
        assertFalse(mech.isEsDiscapacitado());
        assertFalse(mech.isEsTemporada());
    }
}