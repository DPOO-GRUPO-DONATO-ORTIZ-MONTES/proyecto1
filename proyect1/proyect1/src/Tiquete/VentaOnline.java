package Tiquete;

import java.util.Date;
import java.util.List;

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
	
	public void venderTiquete(Tiquete tiquete) {
		listaTiquetes.add(tiquete);
		comprador.tiqueteComprado((tiquete.getid()), tiquete);
		System.out.println("tiquete vendido " + "id " + tiquete.getid());
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
