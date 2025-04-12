package Empleado;

public class cajero extends empleado{
	
	private String puntoAsignado;
	
	public cajero(String tipoEmpleado, String nombre, String turno, Boolean horaExtra, int iD, int salario,
			String rangoAtraccion, int bonusHoraExtra, String lugarAsignado,String puntoAsignado) {
		super(tipoEmpleado, nombre, turno, horaExtra, iD, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado);
		this.puntoAsignado = puntoAsignado;
	}

	public String getPuntoAsignado() {
		return puntoAsignado;
	}
	
}
