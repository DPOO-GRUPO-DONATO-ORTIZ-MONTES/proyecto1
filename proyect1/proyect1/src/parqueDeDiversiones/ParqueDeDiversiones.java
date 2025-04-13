package parqueDeDiversiones;

import java.io.BufferedReader;
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
    private static List<Atraccion> atracciones;
    private static Map<String, String> mapaExclusividad;
    
    public ParqueDeDiversiones() {
        ParqueDeDiversiones.atracciones = new ArrayList<>();
        ParqueDeDiversiones.mapaExclusividad = new HashMap<>();
    }

	public static void cargarAtracciones(String rutaArchivo) {//implementarla en la consola
		
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
	
	public static void mostrarAtracciones(int selec) {
		if (atracciones.isEmpty()) {
			System.out.println("no hay atracciones");
			return;
		}
		String busqueda;
		
		if (selec == 1) {
			busqueda="todas";
		}else if(selec == 2) {
			busqueda="mecanicas";
		}else if(selec == 3) {
			busqueda="culturales";
		}else {
			System.out.println("error opcion invalida.Volviendo al menu");
			return;
		}
		
		System.out.println("catalogo de: " + busqueda );
		
		for (Atraccion atrac:atracciones) {
			boolean function=false;
			if ((atrac instanceof AtraccionCultural) || (atrac instanceof AtraccionMecanica)) {
				function=true;
			}
			if (function) {
				System.out.println("nombre: " + atrac.getNombreAtraccion() );
				System.out.println("nivel de la atracción: " + atrac.getNivelAtraccion() );
				System.out.println("tipo de atraccion: " + atrac.getTipoAtraccion() );
				
				if (atrac instanceof AtraccionCultural) {
					//no me salia el get que necesitaba asi que consulte y vi que para que atrac sea tratado como lo que corresponde ya sea atraccion mecanica o cultural se necesita lo que puse en la linea siguiente
					AtraccionCultural cult = (AtraccionCultural) atrac;
					System.out.println("Edad minima: " + cult.getEdadMinima());
				}else if (atrac instanceof AtraccionMecanica) {
					AtraccionMecanica mecanic = (AtraccionMecanica) atrac;
					System.out.println("Altura minima: " + mecanic.getAlturaUusario());
					System.out.println("peso minimo: " + mecanic.getPesoUsuario());
					System.out.println("existe vertigo: " + mecanic.isExisteVertigo() );
					System.out.println("existe vertigo: " + mecanic.isExisteVertigo() );
					System.out.println("discapacitado: " + mecanic.isEsDiscapacitado());
				}
			}
		}
	}
}