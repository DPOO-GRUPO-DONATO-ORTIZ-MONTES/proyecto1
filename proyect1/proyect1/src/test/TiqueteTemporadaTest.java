package test;

import static org.junit.jupiter.api.Assertions.*;
import static parqueDeDiversiones.ParqueDeDiversiones.mapaExclusividad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tiquete.TiqueteTemporada;
import cliente.Cliente;
import parqueDeDiversiones.ParqueDeDiversiones;

class TiqueteTemporadaTest {

	private Cliente cliente;
	private Date fechaInicio;
	private Date fechaFin;
	private ParqueDeDiversiones parque;

	@BeforeEach

	void setUp() {
		//aqui me toco consultar para poder poner una fecha y usarla para probar si es valido en la fecha dada,para esto vi que es util calendar
		cliente = new Cliente("Juan", 123, "juan@example.com", 456);
		Calendar cal = Calendar.getInstance();
		cal.set(2025, Calendar.MAY, 1);
		fechaInicio = cal.getTime();
		cal.set(2025, Calendar.MAY, 10);
		fechaFin = cal.getTime();
		parque = new ParqueDeDiversiones();
	}
	@Test
	void testEsValidoEnFechaDentroRango() {
		TiqueteTemporada tiquete = new TiqueteTemporada("001", "diamante", new Date(), false, cliente, fechaInicio, fechaFin, new ArrayList<>());
		LocalDate fecha = LocalDate.of(2025, 5, 10);
		assertTrue(tiquete.esValidoEnFecha(fecha));
	}
	@Test
	void testEsValidoEnFechaFueraRango() {
		TiqueteTemporada tiquete = new TiqueteTemporada("001", "diamante", new Date(), false, cliente, fechaInicio, fechaFin, new ArrayList<>());
		LocalDate fecha = LocalDate.of(2025, 6, 1);
		assertFalse(tiquete.esValidoEnFecha(fecha));
	}
	@Test
	void testAsignarAtraccionesPermitidas() {
		mapaExclusividad.put("Montaña Rusa", "oro");
		mapaExclusividad.put("Museo", "familiar");
		List<String> atracciones = Arrays.asList("Montaña Rusa", "Museo");
		List<String> asignadas = new ArrayList<>();
		TiqueteTemporada tiquete = new TiqueteTemporada("001", "diamante", new Date(), false, cliente, fechaInicio, fechaFin, asignadas);
		tiquete.asignarAtracciones(atracciones, parque);
		assertEquals(2, tiquete.getAtraccionesAsignadas().size());
		assertTrue(tiquete.getAtraccionesAsignadas().contains("Montaña Rusa"));
		assertTrue(tiquete.getAtraccionesAsignadas().contains("Museo"));
	}

}
