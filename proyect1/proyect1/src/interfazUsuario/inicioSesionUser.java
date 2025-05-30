package interfazUsuario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cliente.Cliente;
import cliente.GestorClientes;

@SuppressWarnings("serial")
public class inicioSesionUser extends JFrame {
    private JTextField userUser;
    private JPasswordField contrasenaUser;
    private JButton ingresarUser;

    public inicioSesionUser() {
        super("inicio Sesion User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        JLabel nombreUser = new JLabel("Correo usuario"); 
        userUser = new JTextField(15);
        JLabel passwordUser = new JLabel("Ingrese Contraseña");
        contrasenaUser = new JPasswordField(15);
        ingresarUser = new JButton("Ingresar");

        JPanel showInicioSesionUser = new JPanel();
        showInicioSesionUser.setLayout(new GridLayout(5, 5, 10, 10));
        showInicioSesionUser.add(nombreUser);
        showInicioSesionUser.add(userUser);
        showInicioSesionUser.add(passwordUser);
        showInicioSesionUser.add(contrasenaUser);
        showInicioSesionUser.add(ingresarUser);

        add(showInicioSesionUser);

        ingresarUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correoIngresado = userUser.getText();
                String contrasenaTexto = new String(contrasenaUser.getPassword()).trim();

                if (correoIngresado.isEmpty() || contrasenaTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(inicioSesionUser.this, "Por favor ingrese correo y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int contrasenaIngresada = Integer.parseInt(contrasenaTexto);

                    Cliente cliente = GestorClientes.listaClientes.get(correoIngresado);

                    if (cliente != null && cliente.getPassword() == contrasenaIngresada) {
                        JOptionPane.showMessageDialog(inicioSesionUser.this,"Ingreso exitoso", "Info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                        interfazUsuario ventanaUsuario = new interfazUsuario();
                        ventanaUsuario.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(inicioSesionUser.this,"Correo o contraseña incorrectos. Ejecutando registro.","Error", JOptionPane.ERROR_MESSAGE);
                        dispose();
                        registroUsuarioInterfaz ventanaRegistro = new registroUsuarioInterfaz(GestorClientes.listaClientes);
                        ventanaRegistro.setVisible(true);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inicioSesionUser.this,"La contraseña debe ser un número","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        GestorClientes.cargarUsuariosDesdeArchivo("datosDeCarga/DatosUsuarios");

        SwingUtilities.invokeLater(() -> new inicioSesionUser());
    }
}
