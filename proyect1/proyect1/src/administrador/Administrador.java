package administrador;

import java.util.ArrayList;

import Empleado.empleado;

public class Administrador {
	private String nombre;
	private int id;
	private String correo;
	private int pasword;
	private ArrayList<empleado> empleados;
	
	public Administrador(String nombre, int id, String correo, int pasword,ArrayList<empleado> empleados) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.correo = correo;
		this.pasword = pasword;
		this.empleados=empleados;
	}
	
	public empleado agregarEmpleado(empleado nuevoEmpleado) {
		empleados.add(nuevoEmpleado);
		return nuevoEmpleado;
		
	}
	
	public void consultarEmpleado(int id) {
		for (empleado emp:empleados) {
			if(emp.getID()==id) {
				System.out.println("el empleado es "+ emp.getNombre());
			}
		}
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public int getPasword() {
		return pasword;
	}

	public ArrayList<empleado> getEmpleados() {
		return empleados;
	}




}
