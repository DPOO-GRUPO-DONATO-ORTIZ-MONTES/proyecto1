package test;

import administrador.Administrador;
import Empleado.empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class AdministradorTest {

    @Test
    void testConstructorAndGetters() {
        ArrayList<empleado> empleados = new ArrayList<>();
        empleado emp1 = new empleado("tipo", "Juan", "mañana", false, 1, 1000, "rango", 0, "lugar");
        empleados.add(emp1);

        Administrador admin = new Administrador("Ana", 42, "ana@example.com", 1234, empleados);

        assertEquals("Ana", admin.getNombre());
        assertEquals(42, admin.getId());
        assertEquals("ana@example.com", admin.getCorreo());
        assertEquals(1234, admin.getPasword());
        assertEquals(empleados, admin.getEmpleados());
    }
}