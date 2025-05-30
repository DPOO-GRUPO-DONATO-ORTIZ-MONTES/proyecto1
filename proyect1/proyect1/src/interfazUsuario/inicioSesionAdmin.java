package interfazUsuario;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import interfazAdministrador.ventanaAdministrador;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class inicioSesionAdmin extends JFrame {
	public inicioSesionAdmin() {		
		super("inicio Sesion Admin");
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	     setSize(400, 400);
	     setLocationRelativeTo(null);  
	     setVisible(true);
	     JLabel nombreAdmin;
	     JTextField userAdmin;
	     JLabel passwordAdmin;
	     JPasswordField contrasenaAdmin;
	     JPanel showInicioSesion;
	     JButton ingresar;
	     nombreAdmin= new JLabel("Nombre Administrador");
	     userAdmin= new JTextField(15);
	     passwordAdmin= new JLabel("Ingrese Contraseña");
	     contrasenaAdmin= new JPasswordField(15);
	     ingresar= new JButton("Ingresar");
	     showInicioSesion= new JPanel();
	     showInicioSesion.setLayout(new GridLayout(5, 5, 10, 10));
	     showInicioSesion.add(nombreAdmin);
	     showInicioSesion.add(userAdmin);
	     showInicioSesion.add(passwordAdmin);
	     showInicioSesion.add(contrasenaAdmin);
	     showInicioSesion.add(ingresar);
	     add(showInicioSesion); 
   
	     ingresar.addActionListener(e -> {
	    	    String usuario = userAdmin.getText();
	    	    String contrasenia = new String(contrasenaAdmin.getPassword());
	    	    if (usuario.equals("admin") && contrasenia.equals("admin123")) {
	    	        ventanaAdministrador ventana = new ventanaAdministrador();
	    	        dispose();
	    	    } else {
	    	        javax.swing.JOptionPane.showMessageDialog( inicioSesionAdmin.this, "Usuario o contraseña incorrectos","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
	    	    }
	    	});     
	     setVisible(true);	     
	}
	
	 
	   public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new inicioSesionAdmin();
	            }
	        });
	    }
}
