package Tiquete;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cliente.Cliente;

public class VentaOnline {
	private Date fecha;
	private String metodoPago;
	private List<Tiquete> listaTiquetes;
	private Cliente comprador;
	
	
	
	public VentaOnline(Date fecha, String metodoPago, List<Tiquete> listaTiquetes, Cliente comprador) {
		super();
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		this.listaTiquetes = listaTiquetes;
		this.comprador = comprador;
	}
	
	
	public void registrarVenta(Tiquete tiquete) {
		listaTiquetes.add(tiquete);
	}
	
	public float calcularVenta(List<Tiquete> listaTiquetes) {
		float total=0;
		
		for (Tiquete tiq: listaTiquetes) {
			String tipo=tiq.getTipo();
			int valor=0;
			//uso el equalsIgnoreCase porque evita errores a la hora de que se comparen los caracteres 
			if(tipo.equalsIgnoreCase("diamante")) {
				valor=90000;
			}else if(tipo.equalsIgnoreCase("oro")) {
				valor=50000;
			}else if(tipo.equalsIgnoreCase("familiar")) {
				valor=30000;			
			}else if(tipo.equalsIgnoreCase("basico")) {
				valor=15000;
			}
			
			total+=valor;
			
		}
		return total;
	}
	
	public static void tiqueteUsado(ArrayList<String> listaTiquete, String codigoTiquete) {
		if(listaTiquete.contains(codigoTiquete)) {
			System.out.println("El tiquete ya esta usado");
		}
		else{
			listaTiquete.add(codigoTiquete);
			System.out.println("El tiquete ha sido registrado");
		}	
	}
	public Map<String, Map<String, String>> venderTiquete(String nombre, String tipo, String fechaActual, String fechaTemporada, String codigoTiquete,Cliente cliente){
		String valorfinalO;
		String valorfinalF;
		String valorfinalD;
		Map<String, String> informacionTiquete= new HashMap<>();
		Map<String, Map<String, String>> ventaTiquete= new HashMap<>();
		informacionTiquete.put("codigo", codigoTiquete);
		informacionTiquete.put("nombre", nombre);
		informacionTiquete.put("tipo", tipo);
		informacionTiquete.put("fecha de venta", fechaActual);
		if (fechaActual==fechaTemporada && tipo=="Diamante") {
			valorfinalD="30000";
			informacionTiquete.put("valor Tiquete", valorfinalD);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
			}
		if (fechaActual==fechaTemporada && tipo=="Oro") {
			valorfinalO="25000";
			informacionTiquete.put("valor Tiquete", valorfinalO);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
			}
		if (fechaActual==fechaTemporada && tipo=="Familiar") {
			valorfinalF="20000";
			informacionTiquete.put("valor Tiquete", valorfinalF);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
		}
		if (tipo=="Oro") {
			valorfinalO="30000";
			informacionTiquete.put("valor Tiquete", valorfinalO);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
		}
		if ( tipo=="Diamante") {
			valorfinalD="35000";
			informacionTiquete.put("valor Tiquete", valorfinalD);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
		}
		if (tipo=="Familiar") {
			valorfinalF="25000";
			informacionTiquete.put("valor Tiquete", valorfinalF);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
		}
		if (tipo=="Basico") {
			String valorfinalBasico="15000";
			informacionTiquete.put("valor Tiquete",valorfinalBasico);
			ventaTiquete.put(codigoTiquete, informacionTiquete);
			return ventaTiquete;
		}
		Tiquete nuevoTiquete = null;
	    String tipoTiquete = informacionTiquete.get("tipo");
	    Date fechaCompra = new Date();
	    boolean marcadorUso = false;

	    if (tipoTiquete.equals("Diamante") || tipoTiquete.equals("Oro") || tipoTiquete.equals("Familiar")) {
	        nuevoTiquete = new TiqueteConRango(codigoTiquete, tipoTiquete, fechaCompra, marcadorUso, cliente, fechaCompra, null);
	    } else if (tipoTiquete.equals("Basico")) {
	        nuevoTiquete = new EntradaIndividual(codigoTiquete, tipoTiquete, fechaCompra, marcadorUso, cliente, null); // Aquí no hay atracciones asignadas.
	    }

	    if (nuevoTiquete != null) {
	        cliente.tiqueteComprado(codigoTiquete,nuevoTiquete);
	    }
		return ventaTiquete;
	}

	
	public List<Tiquete> getListaTiquetes() {
		return listaTiquetes;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public Cliente getComprador() {
		return comprador;
	}

	
	
}
