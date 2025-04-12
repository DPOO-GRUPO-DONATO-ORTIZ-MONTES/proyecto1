package Tiquete;

import java.util.Date;
import java.util.UUID;

import cliente.Cliente;
public abstract class Tiquete {
	protected String id;
	protected String tipo;
	protected Date fechaCompra;
	protected boolean marcadorUso;
	protected Cliente cliente;
	
	public Tiquete (String id,String tipo,Date fechaCompra,boolean marcadorUso,Cliente Cliente) {
		//busque como generar un valor aleatorio de id y me salio esto como una opcion entonces lo implemente
		this.id=UUID.randomUUID().toString();
		this.fechaCompra=fechaCompra;
		this.marcadorUso=marcadorUso;
		this.tipo=tipo;
		this.cliente=Cliente;
	}
	
	public String getid() {
		return id;	
	}
	
	public String getTipo() {
		return tipo;	
	}
	
	public boolean getMarcadorUso() {
		return marcadorUso;
	}
		
	public Cliente getCliente() {
		return cliente;
	
	}
	
	public Date getFechaCompra() {
		return fechaCompra;
	
	}
	
	public boolean validarUso() {
		return marcadorUso;
		
	}
}
