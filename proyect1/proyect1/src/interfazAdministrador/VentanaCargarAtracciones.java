package interfazAdministrador;

	import javax.swing.*;

import parqueDeDiversiones.ParqueDeDiversiones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCargarAtracciones extends JFrame {
	private JPanel panelPrincipal;
    private JTextField campoRutaArchivo;
    private JButton botonCargar;
    private JLabel etiquetaEstado;

    public VentanaCargarAtracciones() {
        setTitle("Cargar Atracciones");
        setSize(500, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoRutaArchivo = new JTextField();
        //me toco consultar para poder hacer esta parte
        campoRutaArchivo.setToolTipText("Ingrese la ruta del archivo");
        
        botonCargar = new JButton("Cargar Atracciones");
        etiquetaEstado = new JLabel(" ");
        etiquetaEstado.setForeground(Color.BLUE);

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ruta = campoRutaArchivo.getText();
                if (ruta.isEmpty()) {
                	//tambien consulte para esta parte
                    JOptionPane.showMessageDialog(null, "ingrese una ruta valida", ruta, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ParqueDeDiversiones.cargarAtracciones(ruta);
                    etiquetaEstado.setText("Atracciones cargadas");
                    JOptionPane.showMessageDialog(null, "Se cargaron las atracciones correctamente", ruta, JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    etiquetaEstado.setText("Error al cargar el archivo.");
                    JOptionPane.showMessageDialog(null, "Hubo un error al cargar el archivo.", ruta, JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout(10, 10));
        panelCentro.add(new JLabel("Ruta del archivo:"), BorderLayout.NORTH);
        panelCentro.add(campoRutaArchivo, BorderLayout.CENTER);
        panelPrincipal.add(new JLabel("Ruta del archivo:"), BorderLayout.NORTH);
        panelPrincipal.add(campoRutaArchivo, BorderLayout.CENTER);
        panelPrincipal.add(botonCargar, BorderLayout.EAST);
        panelPrincipal.add(etiquetaEstado, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }
}
