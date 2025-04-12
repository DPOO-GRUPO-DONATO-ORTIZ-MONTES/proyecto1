package Empleado;

public class cocinero extends empleado {
	private String certificadoAlimentos;
	
	public cocinero(String tipoEmpleado, String nombre, String turno, Boolean horaExtra, int iD, int salario,
			String rangoAtraccion, int bonusHoraExtra, String lugarAsignado,String certificadoAlimentos) {
		super(tipoEmpleado, nombre, turno, horaExtra, iD, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado);
		this.certificadoAlimentos = certificadoAlimentos;
	}

	public String getCertificadoAlimentos() {
		return certificadoAlimentos;
	}
}
