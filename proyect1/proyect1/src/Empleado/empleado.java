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
	public static Map<String, empleado> empleadosPorNombre = new HashMap<>();
	
	
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
	
	public void setSalario(int salario) {
	    this.Salario = salario;
	}

	public void setTurno(String turno) {
	    this.Turno = turno;
	}

	public void setHoraExtra(boolean horaExtra) {
	    this.HoraExtra = horaExtra;
	}
	
	public empleado buscarEmpleado(String nombre) {
        return empleadosPorNombre.get(nombre);
    }
	
	public void agregarEmpleado(empleado e) {
        empleadosPorNombre.put(e.getNombre(), e);
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
	
	public static void mostrarTodosEmpleados() {
		if (empleadosPorNombre.isEmpty()) {
	        System.out.println("No hay empleados registrados.");
	        return;
	    }
		
		System.out.println("informacion de los empleados: ");
		
		for (Map.Entry<String, empleado> emp : empleadosPorNombre.entrySet()) {
			empleado em = emp.getValue();
			
			System.out.println("nombre del empleado: "+ em.getNombre());
			System.out.println("tipo de empleado: "+ em.getTipoEmpleado());
			System.out.println("ID del empleado: "+ em.getID());
			System.out.println("salario del empleado: "+ em.getSalario());
			System.out.println("rango de atraccion del empleado (si le corresponde,si no es 0): "+ em.getRangoAtraccion());
			System.out.println("turno del empleado: "+ em.getTurno());
			System.out.println("horaExtra del empleado: "+ em.getHoraExtra());
			System.out.println("bonus por horas extra del empleado: "+ em.getBonusHoraExtra());
			System.out.println("lugar asignado del empleado: "+ em.getLugarAsignado());
			
		}
	}
	
}
