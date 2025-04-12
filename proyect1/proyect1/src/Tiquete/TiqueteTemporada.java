package Tiquete;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import cliente.Cliente;
import parqueDeDiversiones.ParqueDeDiversiones;

public class TiqueteTemporada extends Tiquete {
	private Date fechaInicio;
	private Date fechaFin;
	private List<String> atraccionesAsignadas;
	
	public TiqueteTemporada(String id,String tipo, Date fechaCompra, boolean marcadorUso, Cliente Cliente,Date fechaInicio,Date fechaFin,List<String> atraccionesAsignadas) {
		super(id,tipo, fechaCompra, marcadorUso, Cliente);
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.atraccionesAsignadas = atraccionesAsignadas;
	}
	public boolean esValidoEnFecha(LocalDate fecha) {
		Instant tiempoAhora = fechaInicio.toInstant();
		ZonedDateTime fechaZona= tiempoAhora.atZone(ZoneId.systemDefault());
		LocalDate fechaFinal=fechaZona.toLocalDate();
		Instant tiempoAhora1 = fechaFin.toInstant();
		ZonedDateTime fechaZona1= tiempoAhora1.atZone(ZoneId.systemDefault());
		LocalDate fechaFinal1=fechaZona1.toLocalDate();
		//consulte en internet como funciona isAfter y isBefore
		boolean inicioDef=fecha.isEqual(fechaFinal) || fecha.isAfter(fechaFinal);
		boolean finDef=fecha.isEqual(fechaFinal1) || fecha.isBefore(fechaFinal1);
		return inicioDef && finDef;
	}
	
	public void asignarAtracciones (List<String> atracciones, ParqueDeDiversiones parque){
		for (String atrac:atracciones) {
			String nivel=parque.getNivelExclusividad(atrac);
			String tipo=this.getTipo();
			if (tipo.equals("diamante") || (tipo.equals("oro") && (nivel.equals("familiar") || nivel.equals("oro"))) ||  (tipo.equals("familiar") && nivel.equals("familiar"))){
				atraccionesAsignadas.add(atrac);
			}else {
				System.out.println("acceso no permitido a la atraccón");
			}
		}
	}
		
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public List<String> getAtraccionesAsignadas() {
		return atraccionesAsignadas;
	}
}