package Empleado;

import java.util.HashMap;
import java.util.Map;

public class empleado {
	private String TipoEmpleado;
	private String Nombre;
	private String Turno;
	private Boolean HoraExtra;
	private int ID;
	private int Salario;
	private String RangoAtraccion;
	private int BonusHoraExtra;
	private String lugarAsignado;
	
	
	
	public empleado(String tipoEmpleado, String nombre, String turno, Boolean horaExtra, int iD, int salario,
			String rangoAtraccion, int bonusHoraExtra, String lugarAsignado) {
		super();
		this.TipoEmpleado = tipoEmpleado;
		this.Nombre = nombre;
		this.Turno = turno;
		this.HoraExtra = horaExtra;
		this.ID = iD;
		this.Salario = salario;
		this.RangoAtraccion = rangoAtraccion;
		this.BonusHoraExtra = bonusHoraExtra;
		this.lugarAsignado = lugarAsignado;
		
	}

	public String getTipoEmpleado() {
		return TipoEmpleado;
	}


	public String getNombre() {
		return Nombre;
	}


	public String getTurno() {
		return Turno;
	}

	public int getSalario() {
		return Salario;
	}
	
	public Boolean getHoraExtra() {
		return HoraExtra;
	}

	public int getID() {
		return ID;
	}
	
	public String getRangoAtraccion() {
		return RangoAtraccion;
	}
	
	public String getLugarAsignado() {
		return lugarAsignado;
	}
	
	public int getBonusHoraExtra() {
		return BonusHoraExtra;
	}
	
	public  Map<String, Map<String, Object>> getInfoPorEmpleado(String Nombre,int ID,int Salario,String RangoAtraccion,String turno,String TipoEmpleado){
		Map<String, Object> datosEmpleado=new HashMap<>();
		
		datosEmpleado.put("ID",this.ID);
		datosEmpleado.put("Salario",this.Salario);
		datosEmpleado.put("rangoAtraccion",this.RangoAtraccion);
		datosEmpleado.put("Turno",this.Turno);
		datosEmpleado.put("TipoEmpleado",this.TipoEmpleado);
		
		Map<String, Map<String, Object>> data=new HashMap<>();
		data.put(this.Nombre, datosEmpleado);
		
		return data;
		
	}
	
	public void cambiarLugarAsignado(String lugarAsignado) {
		this.lugarAsignado = lugarAsignado;
	}
}
