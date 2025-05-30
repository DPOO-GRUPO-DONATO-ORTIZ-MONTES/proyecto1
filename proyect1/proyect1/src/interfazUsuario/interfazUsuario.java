package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import interfazAdministrador.VentanaCatalogoAtracciones;
import parqueDeDiversiones.ParqueDeDiversiones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class interfazUsuario extends JFrame{
	private JButton tiquete, catalog;
	private static final String ARCHIVO_ATRACCIONES = "datosDeCarga/DatosAtracciones";
    public interfazUsuario() {
        super("pantalla usuario");
        ParqueDeDiversiones.cargarAtracciones(ARCHIVO_ATRACCIONES);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel("USUARIO", SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titulo.setForeground(new Color(255, 215, 0));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        add(titulo, BorderLayout.NORTH);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(0,2,5,5));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panelCentral.setBackground(Color.BLACK);
        add(panelCentral);
        
        tiquete = new JButton("Tickets");
        tiquete.setPreferredSize(new Dimension(200, 60));
        catalog = new JButton("catalogo");
        catalog.setPreferredSize(new Dimension(200, 60));

       
        setLayout(new FlowLayout()); 
        panelCentral.add(tiquete);
        panelCentral.add(catalog);
      
        
        tiquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VistaTiqueteEmpleado VistaTiqueteEMP= new VistaTiqueteEmpleado(); 
            	
            }
        });

        catalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaCatalogoAtracciones ventanaCatalogo = new VentanaCatalogoAtracciones();
                ventanaCatalogo.setVisible(true);
                
            }
        });     

        setVisible(true); 
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

		