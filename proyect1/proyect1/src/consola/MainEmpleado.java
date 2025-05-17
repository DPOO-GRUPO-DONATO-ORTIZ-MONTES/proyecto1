package consola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Empleado.empleado;
import Tiquete.VentaOnline;
import cliente.Cliente;
import parqueDeDiversiones.ParqueDeDiversiones;

public class MainEmpleado {
	private static Map<String,Cliente> listaClientes =cliente.Cliente.listaClientes; // Usamos el mapa de Cliente
	private static List<empleado> listaEmpleados = new ArrayList<>();
	private static  String contra="102886";
	private static final String ARCHIVO_CLIENTES = "datosDeCarga/DatosUsuarios";
	private static final String ARCHIVO_ATRACCIONES = "datosDeCarga/DatosAtracciones";
	public static void main(String[] args) {
		Cliente.cargarUsuariosDesdeArchivo(ARCHIVO_CLIENTES);
	    ParqueDeDiversiones.cargarAtracciones(ARCHIVO_ATRACCIONES);
		Scanner sc = new Scanner(System.in);
		System.out.println("contraseña:102886 .dado que se tiene una constraseña unica,con el fin de que se pueda probar la consola se da la contraseña");
		System.out.println("ingrese la contraseña correspondiente. ");
		String contraf = sc.nextLine();
		if (!contra.equals(contraf)) {
			System.out.println("Contraseña incorrecta.");
			System.out.println("cerrando consola...");
			return;
		}
		while (true) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Registrar Usuario");
			System.out.println("2. Vender Tiquete");
			System.out.println("3. Cargar Usuarios desde archivo");
			System.out.println("4. ver calatalogo de atracciones");
			System.out.println("5. consultar tipo de pase");
			System.out.println("6. validar uso del tiquete");
			System.out.println("0. Salir");

			String inputOpcion = sc.nextLine();
			int opcion1;
			try {
				opcion1 = Integer.parseInt(inputOpcion);
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Debe ingresar un número.");
				continue;
			}

			switch (opcion1) {
			case 1:
				registrarUsuario(sc);
				break;
			case 2:
				venderTiquete();
				break;
			case 3:
				System.out.println("ingrese la ruta del archivo");
				String rutaArchivo1 = sc.nextLine();
				Cliente.cargarUsuariosDesdeArchivo(rutaArchivo1);
				break;
			case 4:
				System.out.println("ingrese 1 si quiere ver todas las atracciones");
				System.out.println("ingrese 2 si quiere ver las atracciones mecanicas");
				System.out.println("ingrese 3 si quiere ver las atracciones culturales");
				String sel = sc.nextLine();
				int selec;
				try {
					selec = Integer.parseInt(sel);
				} catch (NumberFormatException e) {
					System.out.println("Entrada inválida. Debe ingresar un número.");
					break;
				}
				ParqueDeDiversiones.mostrarAtracciones(selec);
				break;
			case 5:
				consultarTipoDeTiquete(sc);
				break;
			case 6:
				validarTiquete(sc);
				break;
			case 0:
				guardarUsuariosEnArchivo(listaClientes);
				guardarEmpleadosEnArchivo();
				System.out.println("Datos guardados. Saliendo...");
				return;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}
	public static void guardarEmpleadosEnArchivo() {
		System.out.println("ingrese la contraseña de administrador");
		Scanner scEntra = new Scanner(System.in);
		String contrasenia = scEntra.nextLine();
		if (contrasenia.equals(contra)) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleados.txt"))) {
				for (empleado emp : listaEmpleados) {
					writer.write(emp.getNombre() + "," + emp.getID() + "," + emp.getTipoEmpleado() + "," + emp.getTurno());
					writer.newLine();
				}
				System.out.println("Empleados guardados en el archivo.");
			} catch (IOException e) {
				System.out.println("Error al guardar empleados: " + e.getMessage());
			}
		}else {
			System.out.println("contraseña invalida");
		}
	}

	
	// Método para registrar un usuario (Cliente)
		public static void registrarUsuario(Scanner sc) {
			System.out.println("Ingrese el nombre del cliente:");
			String nombre = sc.nextLine();
			int ID = obtenerEnteroValido(sc, "Ingrese el ID del cliente:");
			System.out.println("Ingrese el correo del cliente:");
			String correo = sc.nextLine();
			int password = obtenerEnteroValido(sc, "Ingrese la contraseña del cliente:");

			// Crear un nuevo cliente y agregarlo a la lista
			Cliente nuevoCliente = new Cliente(nombre, ID, correo, password);
			listaClientes.put(correo, nuevoCliente);

			System.out.println("Cliente registrado con éxito.");
		}
		
		
		public static int obtenerEnteroValido(Scanner sc, String mensaje) {
			int valor = -1;
			while (true) {
				System.out.println(mensaje);
				try {
					valor = sc.nextInt();
					sc.nextLine(); 
					break; 
				} catch (Exception e) {
					System.out.println("¡Error! Debe ingresar un número entero.");
					sc.nextLine(); 
				}
			}
			return valor;
		}

		public static Boolean obtenerValido(Scanner sc, String mensaje) {
			Boolean valor = null;
			while (true) {
				System.out.println(mensaje);
				String input = sc.nextLine().trim().toLowerCase();
				if (input.equals("true") || input.equals("false")) {
					valor = Boolean.parseBoolean(input);
					break;
				} else {
					System.out.println("Debe ingresar true o false ");
				}
			}
			return valor;
		}
		public static void guardarUsuariosEnArchivo(Map<String, Cliente> listaClientes) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt"))) {
				for (Map.Entry<String, Cliente> entry : listaClientes.entrySet()) {
					Cliente cliente = entry.getValue();
					writer.write(cliente.getNombre() + "," + cliente.getID() + "," + cliente.getCorreo() + "," + cliente.getPassword());
					writer.newLine();
				}
				System.out.println("Usuarios guardados en el archivo.");
			} catch (IOException e) {
				System.out.println("Error al guardar usuarios: " + e.getMessage());
			}
		}
		
		public static void venderTiquete() {
			System.out.println("Vendiendo tiquete...");
			Scanner sc = new Scanner(System.in);
			System.out.println("ingrese el nombre del cliente: ");
			String nombre=sc.nextLine();
			System.out.println("ingrese el correo del cliente: ");
			String correo=sc.nextLine();
			String tipo=null;
			while (tipo == null) {
				System.out.println("ingrese el tipo de tiquete (1 para diamante,2 para oro,3 para familiar,4 para basico)");

				String opcion=sc.nextLine();

				switch (opcion) {
				case "1":
					tipo="Diamante";
					break;
				case "2":
					tipo="Oro";
					break;
				case "3":
					tipo="Familiar";
					break;
				case "4":
					tipo="Basico";
					break;
				default:
					System.out.println("opcion invalida intentelo de nuevo (si concidera que esta ingresando una opcion correcta,verifique los espacios en blanco)");

				}
				String fechaActual = leerFecha(sc, "Ingrese la fecha actual (por ejemplo 2025-04-12): ");
				String fechaTemporada = leerFecha(sc, "Ingrese la fecha de temporada (por ejemplo 2025-04-12): ");
				System.out.println("ingrese el codigo del tiquete: ");
				String id=sc.nextLine();

				VentaOnline ventas = new VentaOnline(new Date(), "efectivo", new ArrayList<>(), null);

				Cliente cliente = listaClientes.get(correo);

				if(cliente==null) {
					registrarUsuario(sc);
					cliente = listaClientes.get(correo);
				}
				if (cliente != null) {
					Map<String, Map<String, String>> venta =ventas.venderTiquete(nombre, tipo, fechaActual, fechaTemporada, id, cliente);

					if (venta.containsKey(id)) {
						System.out.println("el tiquete se ha vendio: ");
						Map<String, String> info = venta.get(id);
						for (Map.Entry<String, String> valor : info.entrySet()) {
							System.out.println(valor.getKey() + ": " + valor.getValue());
						}
						System.out.println("se agrego correctamente tiquete a "+cliente.getNombre());
					}else {
						System.out.println("no se logre vender el tiquete");
					}

				}else {
					System.out.println("no se encontro el cliente");
				}
			}
		}
		public static String leerFecha(Scanner sc, String mensaje) {
			//para evitar errores se implementa esta funcion que verifica si la fecha esta en un formato correcto,tuve que consultar en internet como implementarlo.
			String formatoFecha = "\\d{4}-\\d{2}-\\d{2}"; // yyyy-MM-dd
			while (true) {
				System.out.println(mensaje);
				String fecha = sc.nextLine();
				if (fecha.matches(formatoFecha)) {
					return fecha;
				} else {
					System.out.println("Formato incorrecto. Debe ser yyyy-MM-dd.");
				}
			}
		}
		public static void validarTiquete(Scanner sc) {
			System.out.println("Ingrese el correo del cliente:");
			String correo = sc.nextLine();

			Cliente cliente = Cliente.listaClientes.get(correo);

			if (cliente == null) {
				System.out.println("Cliente no encontrado.");
				return;
			}

			System.out.println("Ingrese el código del tiquete:");
			String codigo = sc.nextLine();

			VentaOnline.tiquetesUsados(codigo);
		}
		public static void consultarTipoDeTiquete(Scanner sc) {
			System.out.println("ingrese el correo del usuario ");
			String correo=sc.nextLine();
			Cliente cliente=listaClientes.get(correo);
			System.out.println("cliente:"+ cliente);
			if (cliente != null) {
				cliente.mostrarTiposDeTiquetesComprados();
			}else {
				System.out.println("cliente no encontrado");
			}
		}
	}