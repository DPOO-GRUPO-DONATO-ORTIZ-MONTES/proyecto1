package atraccion;

public class Atraccion {
	private int cupo;
	private int numeroEmpleadosMinimos;
	private String nivelAtraccion;
	private String tipoAtraccion;
	private String nombreAtraccion;
	
	public Atraccion(int cupo, int numEmpleado, String nivelAtraccion, String tipoAtraccion, String nombreAtraccion) {
		this.cupo=cupo;
		this.numeroEmpleadosMinimos=numEmpleado;
		this.setNivelAtraccion(nivelAtraccion);
		this.setTipoAtraccion(tipoAtraccion);
		this.setNombreAtraccion(nombreAtraccion);
		
	}
	public int getCupo(){	
		return cupo;
	}
	public int getNumEmpleado() {
		return numeroEmpleadosMinimos;
	}
	public String getNivelAtraccion() {
		return nivelAtraccion;
	}
	public void setNivelAtraccion(String nivelAtraccion) {
		this.nivelAtraccion = nivelAtraccion;
	}
	public String getTipoAtraccion() {
		return tipoAtraccion;
	}
	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}
	public String getNombreAtraccion() {
		return nombreAtraccion;
	}
	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}
	
}
