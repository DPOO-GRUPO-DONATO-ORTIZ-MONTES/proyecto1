package Tiquete;

import java.util.Date;

import cliente.Cliente;

public class EntradaIndividual extends Tiquete{
	private String atraccionAsignada;
	
	public EntradaIndividual(String id,String tipo, Date fechaCompra, boolean marcadorUso, Cliente Cliente,String atraccionAsignada) {
		super(id,tipo, fechaCompra, marcadorUso, Cliente);
		this.atraccionAsignada = atraccionAsignada;
		
	}
	
	public String getAtraccionAsignada() {
		return atraccionAsignada;
	}

	
}
