package interfazAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Empleado.empleado;

@SuppressWarnings("serial")
public class ventanaAdministrador extends JFrame {

	private JButton botonRegistrarEmpleado;
    private JButton botonGestionarEmpleado;
    private JButton botonCargarUsuarios;
    private JButton botonCargarAtracciones;
    private JButton botonVerCatalogoAtracciones;
    private JButton botonVerEmpleados;
    
    public ventanaAdministrador() {
    	setTitle("bienvenido administrador");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(600,500);
    	setLayout(new BorderLayout());
    	
    	
    	JLabel titulo = new JLabel("bienvenido administrador", SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titulo.setForeground(new Color(255, 215, 0));
        add(titulo, BorderLayout.NORTH);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(0,3,5,5));
        panelCentral.setBackground(Color.BLACK);
        add(panelCentral, BorderLayout.CENTER);
        
        JPanel panelSeccion1 = new JPanel();
        panelSeccion1.setLayout(new GridLayout(2,2,5,5));
        panelSeccion1.setBackground(Color.BLACK);
        botonRegistrarEmpleado = new JButton("Registrar Empleado");
        botonGestionarEmpleado = new JButton("Gestionar Empleado");
        panelSeccion1.add(botonRegistrarEmpleado);
        panelSeccion1.add(botonGestionarEmpleado);
        panelCentral.add(panelSeccion1,BorderLayout.NORTH);
        
        JPanel panelSeccion2 = new JPanel();
        panelSeccion2.setLayout(new GridLayout(2,2,5,5));
        panelSeccion2.setBackground(Color.BLACK);
        botonCargarUsuarios = new JButton("Cargar usuarios desde un archivo");
        botonCargarAtracciones = new JButton("Cargar atracciones desde un archivo");
        panelSeccion2.add(botonCargarUsuarios);
        panelSeccion2.add(botonCargarAtracciones);
        panelCentral.add(panelSeccion2,BorderLayout.NORTH);

        
        JPanel panelSeccion3 = new JPanel();
        panelSeccion3.setLayout(new GridLayout(2,2,5,5));
        panelSeccion3.setBackground(Color.BLACK);
        botonVerCatalogoAtracciones = new JButton("Ver el catálogo de atracciones");
        botonVerEmpleados = new JButton("Ver empleados");
        panelSeccion3.add(botonVerCatalogoAtracciones);
        panelSeccion3.add(botonVerEmpleados);
        panelCentral.add(panelSeccion3,BorderLayout.NORTH);
        
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(3,3,5,5));
        panelInferior.setBackground(Color.BLACK);
        JLabel etiquetaEjemplo = new JLabel("Imagenes)");
        panelInferior.add(etiquetaEjemplo);
        add(panelInferior, BorderLayout.SOUTH);
        
        botonRegistrarEmpleado.addActionListener(e -> new VentanaRegistrarEmpleado());
        botonGestionarEmpleado.addActionListener(e -> {
        	//si se preguntan de el porque de los logos que aparecen al ejecutar gestionar empleado es porque JOptionPane.showInputDialog los genera automaticamente 
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado:");
            if (nombre != null && !nombre.isEmpty()) {
                empleado emp = empleado.empleadosPorNombre.get(nombre);
                if (emp != null) {
                    new VentanaGestionarEmpleado(emp);
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                }
            }
        });
        botonCargarUsuarios.addActionListener(e -> new VentanaCargarUsuarios());
        botonCargarAtracciones.addActionListener(e -> new VentanaCargarAtracciones());
        botonVerCatalogoAtracciones.addActionListener(e -> new VentanaCatalogoAtracciones());
        botonVerEmpleados.addActionListener(e -> new VentanaVerEmpleados());

        setVisible(true);
        
    }
    public static void main( String[] args )
    {
        new ventanaAdministrador();
    }
}
