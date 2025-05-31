package interfazUsuario;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")

public class VistaTiqueteEmpleado extends JFrame{
	private JButton venderTiq, validarTiq, consultarTiq;	
    public VistaTiqueteEmpleado() {
        super("pantalla Vista Tiquete Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
       
        venderTiq = new JButton("comprar");
        validarTiq = new JButton("Validar");
        consultarTiq= new JButton("Consultar");       

       
        setLayout(new FlowLayout()); 
        add(venderTiq);
        add(validarTiq);
        add(consultarTiq);
      
        
        venderTiq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaVentaTiqueteSimple vendertiq= new VentanaVentaTiqueteSimple(); // implementar tiquete
            	
            }
        });

        validarTiq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaValidacionTiquete validarTiquete= new VentanaValidacionTiquete();//implementar validar tiquete
                
            }
        });     
        consultarTiq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaValidacionTiquete consultarTiquete= new VentanaValidacionTiquete(); //implementar consultar tiquete
                
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
