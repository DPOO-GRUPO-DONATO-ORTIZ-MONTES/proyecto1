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
	public static List<Atraccion> atracciones = new ArrayList<>();
	public static Map<String, String> mapaExclusividad = new HashMap<>();
	

	public static void cargarAtracciones(String rutaArchivo) {
		
		//en esta funcion requeri consultar en internet para ver  como cargar en base a un archivo plano,tambien use el equalsIgnoreCase para evitar errores al evaluar el tipo de atraccion y compararlo.
		
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
			String linea;
			while((linea = br.readLine()) != null) {
				String[]secciones = linea.split(",");
				
				//aqui tambien consulte para poder verificar el formato del archivo de texto
				if (secciones.length < 5) {
	                System.out.println("Error datos incompletos "+ linea);
	                continue;
	            }
				
				String tipoAtraccion=secciones[0];
				String nombreAtraccion=secciones[1];
				int cupo = valoresDefecto(secciones[2], 0);
				int numEmpleado=valoresDefecto(secciones[3],0);
				String nivelAtraccion=secciones[4];
				
				if (tipoAtraccion.equalsIgnoreCase("cultural")) {
					int edadMinima = 0;
					if (secciones.length > 5) {
						try {
							edadMinima = Integer.parseInt(secciones[5]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar la edad minima: " + secciones[5] + " linea: " + linea);
						}
					}
					boolean esTemporada = false;
					if (secciones.length > 6) {
						try {
							esTemporada = Boolean.parseBoolean(secciones[6]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar si es temporada: " + secciones[6] + " linea: " + linea);
						}
					}
					String fecha = "Desconocida";;
					if (secciones.length > 7) {
	                    try {
	                    	fecha = secciones[7];
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar fecha: " + secciones[7] + " linea: " + linea);
						}
					}
					
					AtraccionCultural cul = new AtraccionCultural(cupo, numEmpleado, nivelAtraccion, tipoAtraccion, nombreAtraccion);
					cul.setEdadMinima(edadMinima);
					cul.setEsTemporada(esTemporada);
					cul.setFechaTemporada(fecha);
					atracciones.add(cul);
					mapaExclusividad.put(nombreAtraccion,nivelAtraccion);
					
				}else if (tipoAtraccion.equalsIgnoreCase("mecanica")) {
					int peso=0;
					if (secciones.length > 5) {
					    try {
					    	peso = Integer.parseInt(secciones[5]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar peso: " + secciones[5] + " linea: " + linea);
						}
					}
					int altura=0;
					if (secciones.length > 6) {
	                    try {
	                    	altura = Integer.parseInt(secciones[6]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar altura: " + secciones[6] + " linea: " + linea);
						}
	                }
					boolean discapacitado=false;
					if (secciones.length > 7) {
					    try {
					    	discapacitado = Boolean.parseBoolean(secciones[7]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar si es valido para discapacitados: " + secciones[7] + " linea: " + linea);
						}
					}
					boolean vertigo=false;
					if (secciones.length > 8) {
					    try {
					    	vertigo = Boolean.parseBoolean(secciones[8]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar si podruce vertigo: " + secciones[8] + " linea: " + linea);
						}
					}
					
					boolean esTemporada=false;
					if (secciones.length > 9) {
						try {
							esTemporada = Boolean.parseBoolean(secciones[9]);
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar si es de temporada: " + secciones[9] + " linea: " + linea);
						}
					}
					String fecha="desconocida";
					
					if (secciones.length > 10) {
	                    try {
	                    	fecha = secciones[10];
						} catch (NumberFormatException e) {
							System.out.println("error al evaluar,convertir y almacenar fecha: " + secciones[10] + " linea: " + linea);
						}
					}
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
	
	private static int valoresDefecto(String valor, int valorPorDefecto) {
		try {
			return Integer.parseInt(valor);
		}catch (NumberFormatException e) {
			return valorPorDefecto;
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
	public static void mostrarAtracciones2() {
		System.out.println("se le mostrara un documento con las atracciones del parque,la disponibilidad esta sujeta a las condiciones del administrador.");
		System.out.println("https://docs.google.com/document/d/1e5JwMiq-RgOteZKgc5gnyZGPTLaKty2HWOt57Jb8sek/edit?usp=sharing");
	}
	//─▄▄▀▀█▀▀▄▄
    //▐▄▌─▀─▀─▐▄▌
    //──█─▄▄▄─█──▄▄
    //──▄█▄▄▄█▄─▐──▌
    //▄█▀█████▐▌─▀─▐
    //▀─▄██▀██▀█▀▄▄▀	
}