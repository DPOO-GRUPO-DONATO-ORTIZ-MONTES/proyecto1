package interfazUsuario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class inicioSesionEmp extends JFrame {
	public inicioSesionEmp() {super("inicio Sesion Empleado");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    setSize(400, 400);
    setLocationRelativeTo(null);  
    setVisible(true);
    JLabel nombreEmp;
    JTextField userEmp;
    JLabel passwordEmp;
    JPasswordField contrasenaEmp;
    JPanel showInicioSesionEmp;
    JButton ingresarEmp;
    nombreEmp= new JLabel("Nombre Empleado");
    userEmp= new JTextField(15);
    passwordEmp= new JLabel("Ingrese Contraseña");
    contrasenaEmp= new JPasswordField(15);
    ingresarEmp= new JButton("Ingresar");
    showInicioSesionEmp= new JPanel();
    showInicioSesionEmp.setLayout(new GridLayout(5, 5, 10, 10));
    showInicioSesionEmp.add(nombreEmp);
    showInicioSesionEmp.add(userEmp);
    showInicioSesionEmp.add(passwordEmp);
    showInicioSesionEmp.add(contrasenaEmp);
    showInicioSesionEmp.add(ingresarEmp);
    add(showInicioSesionEmp);
    ingresarEmp.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		validarIngreso();
    	}

		private void validarIngreso() {
			String usuario = userEmp.getText();
	        String contrasenia = new String(contrasenaEmp.getPassword());	        
	        if (usuario.equals(usuario) && contrasenia.equals("123456789")) {	            
	            JOptionPane.showMessageDialog(inicioSesionEmp.this, "Ingreso exitoso, Continuar", "Información", JOptionPane.INFORMATION_MESSAGE);
	            dispose(); 
	            InterfazEmpleado abrirEmpleado= new InterfazEmpleado();
	        } 
	        else {	            
	            JOptionPane.showMessageDialog(inicioSesionEmp.this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
	        }
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

		
	

