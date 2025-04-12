package Tiquete;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import cliente.Cliente;
import parqueDeDiversiones.ParqueDeDiversiones;

public class TiqueteConRango extends Tiquete {
	private Date fechaUso;
	private List<String> atraccionesAsignadas;

	public TiqueteConRango(String id,String tipo,Date fechaCompra, boolean marcadorUso, Cliente cliente, Date fechaUso, List<String> atraccionesAsignadas) {
        super(id,tipo, fechaCompra, marcadorUso, cliente);
        this.fechaUso = fechaUso;
        this.atraccionesAsignadas = atraccionesAsignadas;
    }

	public Date getFechaUso() {
		return fechaUso;
	}

	public List<String> getAtraccionesAsignadas() {
		return atraccionesAsignadas;
	}
	
	public boolean esValidoEnFecha(LocalDate fecha) {
		//aqui consulte en internet como usar la libreria local date para poder hacer mas facil la ejecución de esta funcionalidad del codigo.
		
		Instant tiempoAhora = fechaUso.toInstant();
		ZonedDateTime fechaZona= tiempoAhora.atZone(ZoneId.systemDefault());
		LocalDate fechaFinal=fechaZona.toLocalDate();
		return fechaFinal.equals(fecha);
		
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
	
}
