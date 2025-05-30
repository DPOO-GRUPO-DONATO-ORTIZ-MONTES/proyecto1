 package interfazUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class pantallaPrincipal extends JFrame {

    private JButton administrador, usuario, empleado;

    public pantallaPrincipal() {
        super("pantalla Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
    	setLayout(new BorderLayout());
    	
    	JLabel titulo = new JLabel("parque de diversiones", SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titulo.setForeground(new Color(255, 215, 0));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        add(titulo, BorderLayout.NORTH);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(0,3,5,5));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panelCentral.setBackground(Color.BLACK);
        add(panelCentral);
        
        
        administrador = new JButton("Administrador");
        administrador.setPreferredSize(new Dimension(200, 60));
        usuario= new JButton("Usuario");
        usuario.setPreferredSize(new Dimension(200, 60));
        empleado = new JButton("Empleado");
        empleado.setPreferredSize(new Dimension(200, 60));
        
       
        setLayout(new FlowLayout()); 
        panelCentral.add(administrador);
        panelCentral.add(usuario);
        panelCentral.add(empleado);

        
        administrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	inicioSesionAdmin iniciarSesionAdministrador= new inicioSesionAdmin(); 
            	
            }
        });

        usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	inicioSesionUser iniciarSesionUsuario= new inicioSesionUser(); 
                
            }
        });

        empleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	inicioSesionEmp iniciarSesionEmpleado= new inicioSesionEmp();                 	
            	
            	
            }
        });

        setVisible(true); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new pantallaPrincipal();
            }
        });
    }
}
