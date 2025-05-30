package cliente;

import java.util.HashMap;
import java.util.Map;

public class GestorClientes {
	private static final String ARCHIVO_CLIENTES = "datosDeCarga/DatosUsuarios";
    public static Map<String, Cliente> listaClientes = new HashMap<>();
    public static void cargarUsuariosDesdeArchivo(String rutaArchivo) {
    	Cliente.cargarUsuariosDesdeArchivo(ARCHIVO_CLIENTES);
    	listaClientes = Cliente.listaClientes;
    }
}
