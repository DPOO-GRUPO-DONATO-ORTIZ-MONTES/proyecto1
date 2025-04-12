package atraccion;

public class AtraccionMecanica extends Atraccion{	
	private int pesoUsuario;
	private int alturaUusario;
	private boolean esDiscapacitado;
	private boolean existeVertigo;
	private boolean esTemporada;
	private String fechaTemporada;
	public AtraccionMecanica(int cupo, int numEmpleado, String nivelAtraccion, String tipoAtraccion,
			String nombreAtraccion) {
		super(cupo, numEmpleado, nivelAtraccion, tipoAtraccion, nombreAtraccion);
		// TODO Auto-generated constructor stub
		
	}
	public int getPesoUsuario() {
		return pesoUsuario;
	}
	public void setPesoUsuario(int pesoUsuario) {
		this.pesoUsuario = pesoUsuario;
	}
	public int getAlturaUusario() {
		return alturaUusario;
	}
	public void setAlturaUusario(int alturaUusario) {
		this.alturaUusario = alturaUusario;
	}
	public boolean isExisteVertigo() {
		return existeVertigo;
	}
	public void setExisteVertigo(boolean existeVertigo) {
		this.existeVertigo = existeVertigo;
	}
	public boolean isEsDiscapacitado() {
		return esDiscapacitado;
	}
	public void setEsDiscapacitado(boolean esDiscapacitado) {
		this.esDiscapacitado = esDiscapacitado;
	}
	public String getFechaTemporada() {
		return fechaTemporada;
	}
	public void setFechaTemporada(String fechaTemporada) {
		this.fechaTemporada = fechaTemporada;
	}
	public boolean isEsTemporada() {
		return esTemporada;
	}
	public void setEsTemporada(boolean esTemporada) {
		this.esTemporada = esTemporada;
	}

}
