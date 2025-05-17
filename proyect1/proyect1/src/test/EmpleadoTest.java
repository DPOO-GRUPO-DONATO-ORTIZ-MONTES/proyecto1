package test;

import Empleado.empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

public class EmpleadoTest {

	private empleado emp;

	@BeforeEach
	void setUp() {
		emp = new empleado("Cocinero","Pedro","Mañana",true,101,150000,"cafeteria",30000,"restaurante central");
	}
	@Test
	void testStaticRegistryAndGetters() {
		empleado emp1 = new empleado("Cajero", "Ana", "tarde", true, 5, 1200, "A1", 200, "caja");
		empleado.empleadosPorNombre.put(emp1.getNombre(), emp1);

		assertEquals(emp1, empleado.empleadosPorNombre.get("Ana"));
		assertEquals("Cajero", emp1.getTipoEmpleado());
		assertEquals("tarde", emp1.getTurno());
		assertTrue(emp1.getHoraExtra());
		assertEquals(5, emp1.getID());
		assertEquals(1200, emp1.getSalario());
		assertEquals("A1", emp1.getRangoAtraccion());
		assertEquals(200, emp1.getBonusHoraExtra());
		assertEquals("caja", emp1.getLugarAsignado());
	}
	@Test
	void testCambiarSalario() {
		emp.setSalario(200000);
		assertEquals(200000, emp.getSalario());
	}

	@Test
	void testCambiarTurno() {
		emp.setTurno("tarde");
		assertEquals("tarde", emp.getTurno());
	}

	@Test
	void testCambiarHoraExtra() {
		emp.setHoraExtra(false);
		assertFalse(emp.getHoraExtra());
	}

	@Test
	void testCambiarLugarAsignado() {
		emp.cambiarLugarAsignado("cocina3");
		assertEquals("cocina3", emp.getLugarAsignado());
	}

	@Test
	void testAgregarYBuscarEmpleado() {
		emp.agregarEmpleado(emp);
		empleado resultado = emp.buscarEmpleado("Pedro");
		assertNotNull(resultado);
		assertEquals("Pedro", resultado.getNombre());
	}

	@Test
	void testGetInfoPorEmpleado() {
		Map<String, Map<String, Object>> info = emp.getInfoPorEmpleado(
				emp.getNombre(),
				emp.getID(),
				emp.getSalario(),
				emp.getRangoAtraccion(),
				emp.getTurno(),
				emp.getTipoEmpleado()
				);

		assertTrue(info.containsKey("Pedro"));
		Map<String, Object> datos = info.get("Pedro");
		assertEquals(150000, datos.get("Salario"));
		assertEquals("Mañana", datos.get("Turno"));
		assertEquals("Cocinero", datos.get("TipoEmpleado"));
	}
}