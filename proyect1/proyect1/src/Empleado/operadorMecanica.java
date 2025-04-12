package Empleado;

import java.util.List;

public class operadorMecanica extends empleado {
	private List<String> habilitadasOperar;
	
	public operadorMecanica(String tipoEmpleado, String nombre, String turno, Boolean horaExtra, int iD, int salario,
			String rangoAtraccion, int bonusHoraExtra, String lugarAsignado,List<String> habilidadesOperar, List<String> habilitadasOperar) {
		super(tipoEmpleado, nombre, turno, horaExtra, iD, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado);
		this.habilitadasOperar=habilitadasOperar;
	}
	
	public void certificarAtraccion(String atraccion) {
		if (!this.habilitadasOperar.contains(atraccion)) {
			this.habilitadasOperar.add(atraccion);
		}
	}
	
	public List<String> getHabilitadasOperar() {
		return habilitadasOperar;
	}

	
}
