package interfazUsuario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import cliente.Cliente;
import parqueDeDiversiones.ParqueDeDiversiones;

public class VistaUsuariosEmpleado extends JFrame{ 
	private JButton listaUser, tipoUser, cargarUser;	
	private static Map<String,Cliente> listaClientes =cliente.Cliente.listaClientes;
	private static final String ARCHIVO_CLIENTES = "datosDeCarga/DatosUsuarios";
	
    public VistaUsuariosEmpleado() {
        super("pantalla Vista Usuarios Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
       
        listaUser = new JButton("lista");
        tipoUser = new JButton("tipo");
        cargarUser= new JButton("Cargar");       

       
        setLayout(new FlowLayout()); 
        add(listaUser);
        add(tipoUser);
        add(cargarUser);
      
        
        listaUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mostrarClientes(listaClientes);
            	
            }
        });

        tipoUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaValidacionTiquete validarTiquete= new VentanaValidacionTiquete();//valida el tipo de tiquete falta implementar
                
            }
        });     
        cargarUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Cliente.cargarUsuariosDesdeArchivo(ARCHIVO_CLIENTES);
            }
        });     

        setVisible(true); 
    }
	
private void mostrarClientes(Map<String, Cliente> listaClientes) {
	Cliente.cargarUsuariosDesdeArchivo(ARCHIVO_CLIENTES);
	JFrame ventana = new JFrame("Lista de Clientes");
    ventana.setSize(400, 400);
    JTextArea areaTexto = new JTextArea();
    areaTexto.setEditable(false);
    if (listaClientes == null || listaClientes.isEmpty()) {
        areaTexto.setText("No hay clientes registrados.");
    } else {
        String texto = "";
        for (String key : listaClientes.keySet()) {
        	Cliente cliente = listaClientes.get(key);
            texto += "Cliente: " + cliente.getNombre() + "\n"; 
        }
        areaTexto.setText(texto);
    }
    ventana.add(areaTexto);
    ventana.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new inicioSesionEmp();
        }
    });
}

}

