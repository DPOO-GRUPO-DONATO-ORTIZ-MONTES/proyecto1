package parqueDeDiversiones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import atraccion.Atraccion;
import atraccion.AtraccionCultural;
import atraccion.AtraccionMecanica;

public class ParqueDeDiversiones {
    private List<Atraccion> atracciones;
    private Map<String, String> mapaExclusividad;
    
    public ParqueDeDiversiones() {
        this.atracciones = new ArrayList<>();
        this.mapaExclusividad = new HashMap<>();
    }

	private void cargarAtracciones(String rutaArchivo) {//implementarla en la consola
		
		//en esta funcion requeri consultar en internet para ver } como cargar en base a un archivo plano,tambien use el equalsIgnoreCase para evitar errores al evaluar el tipo de atraccion y compararlo.
		
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
			String linea;
			while((linea = br.readLine()) != null) {
				String[]secciones = linea.split(",");
				int cupo = Integer.parseInt(secciones[0]);
				int numEmpleado=Integer.parseInt(secciones[1]);
				String nivelAtraccion=secciones[2];
				String tipoAtraccion=secciones[3];
				String nombreAtraccion=secciones[4];
				
				if (tipoAtraccion.equalsIgnoreCase("cultural")) {
					int edadMinima=Integer.parseInt(secciones[5]);
					boolean esTemporada=Boolean.parseBoolean(secciones[6]);
					String fecha=secciones[7];
					
					AtraccionCultural cul = new AtraccionCultural(cupo, numEmpleado, nivelAtraccion, tipoAtraccion, nombreAtraccion);
					cul.setEdadMinima(edadMinima);
					cul.setEsTemporada(esTemporada);
					cul.setFechaTemporada(fecha);
					atracciones.add(cul);
					mapaExclusividad.put(nombreAtraccion,nivelAtraccion);
				}else if (tipoAtraccion.equalsIgnoreCase("mecanica")) {
					int peso=Integer.parseInt(secciones[5]);
					int altura=Integer.parseInt(secciones[6]);
					boolean discapacitado=Boolean.parseBoolean(secciones[7]);
					boolean vertigo=Boolean.parseBoolean(secciones[8]);
					boolean esTemporada=Boolean.parseBoolean(secciones[9]);
					String fecha=secciones[10];
					
					AtraccionMecanica mec = new AtraccionMecanica(cupo, numEmpleado, nivelAtraccion, tipoAtraccion, nombreAtraccion);
					mec.setPesoUsuario(peso);
					mec.setAlturaUusario(altura);
					mec.setEsDiscapacitado(discapacitado);
					mec.setExisteVertigo(vertigo);
					mec.setEsTemporada(esTemporada);
					mec.setFechaTemporada(fecha);
					atracciones.add(mec);
					mapaExclusividad.put(nombreAtraccion,nivelAtraccion);
				}
			}
		System.out.println("se leyeron las atracciones corretamente");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error leyendo las atracciones");
		}
	}
	
	public String getNivelExclusividad(String AtraccionNom) {
		if (mapaExclusividad.containsKey(AtraccionNom)) {
			return mapaExclusividad.get(AtraccionNom);
		}else {
			return "basico";
		}
	}
	public List<Atraccion> getAtracciones() {
        return atracciones;
    }
}