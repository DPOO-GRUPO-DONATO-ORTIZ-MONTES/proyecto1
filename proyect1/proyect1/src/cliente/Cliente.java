package cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Tiquete.Tiquete;

public class Cliente {
	private String nombre;
	private int ID;
	private String correo;
	private int password;
	private Map<String, String> carnetSalud;
	private Map<String, Map<String, String>> tiqueteComprado=new HashMap<>();
	public static Map<String,Cliente> listaClientes = new HashMap<>(); 
	
	public Cliente(String nombre, int ID, String correo, int password) {
		this.setCorreo(correo);
		this.setID(ID);
		this.setNombre(nombre);
		this.setPassword(password);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	public Map<String, Map<String, String>> getTiquetesComprados() {
		return tiqueteComprado;
	}
	
	public Map<String, String> getCarnetSalud(){
		return carnetSalud;
	}
	
	public Map<String, String> carnetSalud(String nombreUsuario, String vertigo, String esDiscapacitado, String alturaUsuario, String pesoUsuario, String edad, String problemasCoronarios){
		Map<String, String> carnetSalud= new HashMap<>();
		carnetSalud.put("Nombre ", nombreUsuario);
		carnetSalud.put("Vertigo ",vertigo);
		carnetSalud.put("Peso", pesoUsuario);
		carnetSalud.put("Altura", alturaUsuario);
		carnetSalud.put("Edad", edad);
		carnetSalud.put("Discapacidad", esDiscapacitado);
		carnetSalud.put("Problemas cardiacos", problemasCoronarios);
		this.carnetSalud=carnetSalud;
		return carnetSalud;
		
	}
	public void tiqueteComprado(String idTiquete, Tiquete tiquete){
		Map<String, String> mapaTiquete= new HashMap<>();
		mapaTiquete.put("Tipo", tiquete.getTipo());
		mapaTiquete.put("fechaCompra", tiquete.getFechaCompra().toString());
		mapaTiquete.put("estadoUso", String.valueOf(tiquete.getMarcadorUso()));
		tiqueteComprado.put(idTiquete, mapaTiquete);
		
	}

	
	public static void cargarUsuariosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int ID = Integer.parseInt(datos[1]);
                String correo = datos[2];
                int password = Integer.parseInt(datos[3]);

                // Crear un nuevo cliente y agregarlo a la lista
                Cliente cliente = new Cliente(nombre, ID, correo, password);
                listaClientes.put(correo, cliente);
            }
            System.out.println("Usuarios cargados desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
        }
    }
	public void mostrarTiposDeTiquetesComprados() {
	    if (tiqueteComprado.isEmpty()) {
	        System.out.println("El cliente no ha comprado ningún tiquete.");
	        return;
	    }

	    System.out.println("Tiquetes comprados por " + this.getNombre() + ":");
	    for (Map.Entry<String, Map<String, String>> entrada : tiqueteComprado.entrySet()) {
	        String idTiquete = entrada.getKey();
	        String tipo = entrada.getValue().get("Tipo");
	        System.out.println(" la id es: " + idTiquete + "el tipo es: " + tipo);
	    }
	}
}

