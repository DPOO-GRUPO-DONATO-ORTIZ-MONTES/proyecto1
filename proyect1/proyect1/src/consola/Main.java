package consola;

import java.io.*;
import java.util.*;
import cliente.Cliente;
import Empleado.empleado;
import Empleado.cajero;
import Empleado.cocinero;
import Empleado.operadorMecanica;
import Tiquete.VentaOnline;
import parqueDeDiversiones.ParqueDeDiversiones;

public class Main {
	// Lista para almacenar usuarios y empleados
    private static Map<String,Cliente> listaClientes =cliente.Cliente.listaClientes; // Usamos el mapa de Cliente
    private static List<empleado> listaEmpleados = new ArrayList<>();
    private static  String contra="102886";
    private static  String contra1="102086";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("seleccione 1 si es usuario, seleccione 2 si es empleado o administrador");
            String ope = sc.nextLine();
            int op;
            try {
                op = Integer.parseInt(ope);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar 1 o 2");
                continue;
            }

            if (op == 1) {
                while (true) {
                    System.out.println("bienvenido a la interfaz de usuario");
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Vender Tiquete");
                    System.out.println("2. ver calatalogo de atracciones");
                    System.out.println("3. consultar tipo de pase");
                    System.out.println("0. Salir");

                    String inputOpcion1 = sc.nextLine();
                    int opcion;
                    try {
                        opcion = Integer.parseInt(inputOpcion1);
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un número.");
                        continue;
                    }

                    switch (opcion) {
                        case 1:
                            venderTiquete();
                            break;
                        case 2:
                            ParqueDeDiversiones.mostrarAtracciones2();
                            break;
                        case 3:
                            consultarTipoDeTiquete(sc);
                            break;
                        case 0:
                            guardarUsuariosEnArchivo(listaClientes);
                            System.out.println("Datos guardados. Saliendo...");
                            return;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }

            } else if (op == 2) {
                System.out.println("ingrese la contraseña correspondiente");
                String contraf = sc.nextLine();
                if (!contra1.equals(contraf)) {
                    System.out.println("Contraseña incorrecta.");
                    continue;
                }

                while (true) {
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Registrar Usuario");
                    System.out.println("2. Registrar Empleado");
                    System.out.println("3. Vender Tiquete");
                    System.out.println("4. Gestionar Empleado, cambiar lugar y cambiar turno");
                    System.out.println("5. Cargar Usuarios desde archivo");
                    System.out.println("6. Cargar atracciones desde archivo");
                    System.out.println("7. ver calatalogo de atracciones");
                    System.out.println("8. consultar tipo de pase");
                    System.out.println("9. ver empleados");
                    System.out.println("10. validar uso del tiquete");
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
                            registrarEmpleado(sc);
                            break;
                        case 3:
                            venderTiquete();
                            break;
                        case 4:
                            System.out.println("ingrese el nombre del empleado: ");
                            String nombreEmp = sc.nextLine();
                            empleado emp = empleado.empleadosPorNombre.get(nombreEmp);
                            if (emp != null) {
                                gestionarEmpleados(emp, sc);
                            } else {
                                System.out.println("Empleado no encontrado.");
                            }
                            break;
                        case 5:
                            System.out.println("ingrese la ruta del archivo");
                            String rutaArchivo1 = sc.nextLine();
                            Cliente.cargarUsuariosDesdeArchivo(rutaArchivo1);
                            break;
                        case 6:
                            System.out.println("ingrese la ruta del archivo");
                            String rutaArchivo = sc.nextLine();
                            ParqueDeDiversiones.cargarAtracciones(rutaArchivo);
                            break;
                        case 7:
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
                        case 8:
                            consultarTipoDeTiquete(sc);
                            break;
                        case 9:
                            System.out.println("cargando empleados...");
                            empleado.mostrarTodosEmpleados();
                            break;
                        case 10:
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
            } else {
                System.out.println("Opción principal no válida.");
            }
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

    // Método para registrar un empleado
    public static void registrarEmpleado(Scanner sc) {
    	System.out.println("ingrese la contraseña de administrador");
    	Scanner scEntra = new Scanner(System.in);
    	String contrasenia = scEntra.nextLine();
    	if (contrasenia.equals(contra)) {
    		System.out.println("Ingrese el tipo de empleado (cajero/cocinero/operadorMecanica):");
            String tipoEmpleado = sc.nextLine();
            System.out.println("Ingrese el nombre del empleado:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el turno del empleado:");
            String turno = sc.nextLine();
            Boolean horaExtra = obtenerValido(sc, "¿El empleado tiene horas extra? (true/false):");
            int ID = obtenerEnteroValido(sc, "Ingrese el ID del empleado:");
            int salario = obtenerEnteroValido(sc, "Ingrese el salario del empleado:");
            System.out.println("Ingrese el rango de la atracción del empleado:");
            String rangoAtraccion = sc.nextLine();
            int bonusHoraExtra = obtenerEnteroValido(sc, "Ingrese el bonus por horas extra:");
            System.out.println("Ingrese el lugar asignado:");
            String lugarAsignado = sc.nextLine();

            empleado nuevoEmpleado = null;

            // Crear el empleado según su tipo
            switch (tipoEmpleado.toLowerCase()) {
                case "cajero":
                    System.out.println("Ingrese el punto asignado al cajero:");
                    String puntoAsignado = sc.nextLine();
                    nuevoEmpleado = new cajero(tipoEmpleado, nombre, turno, horaExtra, ID, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado, puntoAsignado);
                    break;
                case "cocinero":
                    System.out.println("Ingrese el certificado de alimentos del cocinero:");
                    String certificadoAlimentos = sc.nextLine();
                    nuevoEmpleado = new cocinero(tipoEmpleado, nombre, turno, horaExtra, ID, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado, certificadoAlimentos);
                    break;
                case "operadormecanica":
                    System.out.println("Ingrese las habilidades del operador (separadas por coma):");
                    String habilidades = sc.nextLine();
                    List<String> habilitadasOperar = Arrays.asList(habilidades.split(","));
                    nuevoEmpleado = new operadorMecanica(tipoEmpleado, nombre, turno, horaExtra, ID, salario, rangoAtraccion, bonusHoraExtra, lugarAsignado, habilitadasOperar, habilitadasOperar);
                    break;
                default:
                    System.out.println("Tipo de empleado no válido.");
                    return;
            }

            // Agregar empleado a la lista
            listaEmpleados.add(nuevoEmpleado);
            empleado.empleadosPorNombre.put(nombre, nuevoEmpleado);
            System.out.println("Empleado registrado con éxito.");
    	}
    	else {
    		System.out.println("contraseña invalida");
    	}
        
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
    
    // Método para guardar usuarios en archivo
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

    // Método para guardar empleados en archivo
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

    // Método de venta de tiquete 
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

    // Método para gestionar empleados 
    public static void gestionarEmpleados(empleado emp, Scanner sc) {
    	System.out.println("ingrese la contraseña de administrador");
    	Scanner scEntra = new Scanner(System.in);
    	String contrasenia = scEntra.nextLine();
    	if (contrasenia.equals(contra)) {
    		boolean salir = true;
            System.out.println("Gestionando empleados...");
            while (salir) {
            try {	
            System.out.println("Gestion de empleado: " + emp.getNombre());
            System.out.println("ingrese una de las siguientes opciones ");
            System.out.println("1 para cambiar turno");
            System.out.println("2 para subir salario");
            System.out.println("3 para subir horas extra");
            System.out.println("4 para cambiar lugar asignado ");
            System.out.println("5 para volver al menu principal ");
            }catch (Exception e) {
                System.out.println("¡Error! Debe ingresar un número entero.");
                sc.nextLine(); 
            }
            
            String seleccion = sc.nextLine();
            
            if (seleccion.equals("1")) {
            	System.out.println("nuevo turno asignado: ");
            	String turno = sc.nextLine();
            	emp.setTurno(turno);
            	System.out.println("turno asignado ");
            	
            }else if (seleccion.equals("2")) {
            	System.out.println("nuevo salario asignado: ");
            	try {
            	int salario = Integer.parseInt(sc.nextLine());
            	emp.setSalario(salario);
            	System.out.println("salario nuevo asignado");
            	}catch(Exception e) {
            		System.out.println("¡Error! Debe ingresar un número entero (oprima enter)");
                    sc.nextLine();
            	}
            }else if(seleccion.equals("3")) {
            	emp.setHoraExtra(true);
            	System.out.println("hay horas extra");
            }else if(seleccion.equals("4")) {
            	System.out.println("nuevo lugar asignado: ");
            	String lugar = sc.nextLine();
            	emp.cambiarLugarAsignado(lugar);
            }else if(seleccion.equals("5")) {
            	salir=false;
            }else {
                System.out.println("Opcion no valida ");
            }
            }
    	}else {
    		System.out.println("contraseña invalida");
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
    	
    	if (cliente != null) {
    		cliente.mostrarTiposDeTiquetesComprados();
    	}else {
    		System.out.println("cliente no encontrado");
    	}
    }
}
