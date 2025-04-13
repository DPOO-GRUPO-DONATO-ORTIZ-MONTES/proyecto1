package consola;

import java.io.*;
import java.util.*;

import cliente.Cliente;
import Empleado.empleado;
import Empleado.cajero;
import Empleado.cocinero;
import Empleado.operadorMecanica;
import parqueDeDiversiones.ParqueDeDiversiones;

public class Main {

    // Lista para almacenar usuarios y empleados
    private static Map<String,Cliente> listaClientes =cliente.Cliente.listaClientes; // Usamos el mapa de Cliente
    private static List<empleado> listaEmpleados = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Opciones del menú
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Empleado");
            System.out.println("3. Vender Tiquete");
            System.out.println("4. Gestionar Empleado,camibar lugar y cambiar turno ");
            System.out.println("5. Cargar Usuarios desde archivo");
            System.out.println("6. Cargar atracciones desde archivo");
            System.out.println("7. ver calatalogo de atracciones");
            System.out.println("8. consultar tipo de pase");
            System.out.println("0. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer

            switch (opcion) {
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
                	Scanner scEmp=new Scanner(System.in);
                	String nombreEmp = scEmp.nextLine();
                	empleado emp = empleado.empleadosPorNombre.get(nombreEmp);
                	if (emp!= null) {
                		gestionarEmpleados(emp, sc);
                	} else {
                		System.out.println("Empleado no encontrado.");
                	}
                    break;
                    
                case 5:
                	System.out.println("ingrese la ruta del archivo ");
                	Scanner scRuta1 = new Scanner(System.in);
                	String rutaArchivo1 = scRuta1.nextLine();
                    Cliente.cargarUsuariosDesdeArchivo(rutaArchivo1);  // Cargar los usuarios desde el archivo
                    break;
                case 6:
                	System.out.println("ingrese la ruta del archivo ");
                	Scanner scRuta = new Scanner(System.in);
                	String rutaArchivo = scRuta.nextLine();
                	ParqueDeDiversiones.cargarAtracciones(rutaArchivo);
                	break;
                case 7:
                	System.out.println("ingrese 1 si quiere ver todas las atracciones");
                	System.out.println("ingrese 2 si quiere ver las atracciones mecanicas");
                	System.out.println("ingrese 3 si quiere ver las atracciones culturales");
                	Scanner scSelec = new Scanner(System.in);
                	String sel = scSelec.nextLine();
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
                case 0:
                    guardarUsuariosEnArchivo(listaClientes);
                    guardarEmpleadosEnArchivo();
                    System.out.println("Datos guardados. Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para registrar un usuario (Cliente)
    public static void registrarUsuario(Scanner sc) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el ID del cliente:");
        int ID = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.println("Ingrese el correo del cliente:");
        String correo = sc.nextLine();
        System.out.println("Ingrese la contraseña del cliente:");
        int password = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Crear un nuevo cliente y agregarlo a la lista
        Cliente nuevoCliente = new Cliente(nombre, ID, correo, password);
        listaClientes.put(correo, nuevoCliente);

        System.out.println("Cliente registrado con éxito.");
    }

    // Método para registrar un empleado
    public static void registrarEmpleado(Scanner sc) {
        System.out.println("Ingrese el tipo de empleado (cajero/cocinero/operadorMecanica):");
        String tipoEmpleado = sc.nextLine();
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el turno del empleado:");
        String turno = sc.nextLine();
        System.out.println("¿El empleado tiene horas extra? (true/false):");
        Boolean horaExtra = sc.nextBoolean();
        System.out.println("Ingrese el ID del empleado:");
        int ID = sc.nextInt();
        System.out.println("Ingrese el salario del empleado:");
        int salario = sc.nextInt();
        sc.nextLine();  // Limpiar buffer
        System.out.println("Ingrese el rango de la atracción del empleado:");
        String rangoAtraccion = sc.nextLine();
        System.out.println("Ingrese el bonus por horas extra:");
        int bonusHoraExtra = sc.nextInt();
        sc.nextLine();  // Limpiar buffer
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleados.txt"))) {
            for (empleado emp : listaEmpleados) {
                writer.write(emp.getNombre() + "," + emp.getID() + "," + emp.getTipoEmpleado() + "," + emp.getTurno());
                writer.newLine();
            }
            System.out.println("Empleados guardados en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    // Método de venta de tiquete 
    public static void venderTiquete() {
        
        System.out.println("Vendiendo tiquete...");
    }

    // Método para gestionar empleados 
    public static void gestionarEmpleados(empleado emp, Scanner sc) {
    	boolean salir = true;
        System.out.println("Gestionando empleados...");
        while (salir) {
        System.out.println("Gestion de empleado: " + emp.getNombre());
        System.out.println("ingrese una de las siguientes opciones ");
        System.out.println("1 para cambiar turno");
        System.out.println("2 para subir salario");
        System.out.println("3 para subir horas extra");
        System.out.println("4 para cambiar lugar asignado ");
        System.out.println("5 para volver al menu principal ");
        
        String seleccion = sc.nextLine();
        
        if (seleccion.equals("1")) {
        	System.out.println("nuevo turno asignado: ");
        	String turno = sc.nextLine();
        	emp.setTurno(turno);
        	System.out.println("turno asignado ");
        	
        }else if (seleccion.equals("2")) {
        	System.out.println("nuevo salario asignado: ");
        	int salario = Integer.parseInt(sc.nextLine());
        	emp.setSalario(salario);
        	System.out.println("salario nuevo asignado");
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
