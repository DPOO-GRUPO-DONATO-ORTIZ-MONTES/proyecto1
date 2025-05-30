package interfazAdministrador;

import javax.swing.*;
import cliente.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCargarUsuarios extends JFrame {

    private JTextField campoRutaArchivo;
    private JButton botonCargar;
    private JLabel etiquetaEstado;

    public VentanaCargarUsuarios() {
        setTitle("Cargar Usuarios");
        setSize(500, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoRutaArchivo = new JTextField();
        campoRutaArchivo.setToolTipText("Ingrese la ruta del archivo");
        botonCargar = new JButton("Cargar Usuarios");
        etiquetaEstado = new JLabel(" ");
        etiquetaEstado.setForeground(Color.BLUE);

        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = campoRutaArchivo.getText();
                if (ruta.isEmpty()) {
                	//esto lo tuve que consultar tambien
                    JOptionPane.showMessageDialog(null, "Ingrese una ruta válida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    Cliente.cargarUsuariosDesdeArchivo(ruta);
                    etiquetaEstado.setText("Usuarios cargados exitosamente");
                    JOptionPane.showMessageDialog(null, "Usuarios cargados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    etiquetaEstado.setText("Error al cargar el archivo.");
                    JOptionPane.showMessageDialog(null, "Hubo un error al cargar el archivo:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        JPanel panelCentro = new JPanel(new BorderLayout(10, 10));
        panelCentro.add(new JLabel("Ruta del archivo:"), BorderLayout.NORTH);
        panelCentro.add(campoRutaArchivo, BorderLayout.CENTER);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(botonCargar, BorderLayout.EAST);
        panelPrincipal.add(etiquetaEstado, BorderLayout.SOUTH);
        add(panelPrincipal);
        setVisible(true);
    }
}