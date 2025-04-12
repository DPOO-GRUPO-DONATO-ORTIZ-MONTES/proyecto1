package atraccion;

public class AtraccionCultural extends Atraccion{
	private int edadMinima;
	private boolean esTemporada;
	private String fechaTemporada;
	
	public AtraccionCultural(int cupo, int numEmpleado, String nivelAtraccion, String tipoAtraccion,
			String nombreAtraccion) {
		super(cupo, numEmpleado, nivelAtraccion, tipoAtraccion, nombreAtraccion);
		// TODO Auto-generated constructor stub
		
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public boolean isEsTemporada() {
		return esTemporada;
	}

	public void setEsTemporada(boolean esTemporada) {
		this.esTemporada = esTemporada;
	}

	public String getFechaTemporada() {
		return fechaTemporada;
	}

	public void setFechaTemporada(String fechaTemporada) {
		this.fechaTemporada = fechaTemporada;
	}
	
}

