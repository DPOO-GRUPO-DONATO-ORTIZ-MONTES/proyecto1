package interfazUsuario;

import javax.swing.*;

import cliente.Cliente;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class registroUsuarioInterfaz extends JFrame {

    private JTextField campoNombre;
    private JTextField campoID;
    private JTextField campoCorreo;
    private JTextField campoPassword;
    private JButton botonRegistrar;
    private Map<String, Cliente> listaClientes;

    public registroUsuarioInterfaz(Map<String, Cliente> listaClientes) {
        this.listaClientes = listaClientes;

        setTitle("Registro de Usuario");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        add(campoNombre);

        add(new JLabel("ID:"));
        campoID = new JTextField();
        add(campoID);

        add(new JLabel("Correo:"));
        campoCorreo = new JTextField();
        add(campoCorreo);

        add(new JLabel("Contraseña (número):"));
        campoPassword = new JTextField();
        add(campoPassword);

        botonRegistrar = new JButton("Registrar");
        add(new JLabel()); 
        add(botonRegistrar);

        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                String idTexto = campoID.getText().trim();
                String correo = campoCorreo.getText().trim();
                String passwordTexto = campoPassword.getText().trim();

                if (nombre.isEmpty() || idTexto.isEmpty() || correo.isEmpty() || passwordTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene la informacion correctamente");
                    return;
                }

                int ID;
                int password;
                try {
                    ID = Integer.parseInt(idTexto);
                    password = Integer.parseInt(passwordTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID y contraseña deben ser numeros");
                    return;
                }

                if (listaClientes.containsKey(correo)) {
                    JOptionPane.showMessageDialog(null, "El correo ya está registrado ");
                    return;
                }

                Cliente nuevoCliente = new Cliente(nombre, ID, correo, password);
                listaClientes.put(correo, nuevoCliente);

                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                dispose();

                interfazUsuario ventanaUsuario = new interfazUsuario();
                ventanaUsuario.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Map<String, Cliente> listaClientes1 = new java.util.HashMap<>();
        SwingUtilities.invokeLater(() -> {
            new registroUsuarioInterfaz(listaClientes1).setVisible(true);
        });
    }
}
