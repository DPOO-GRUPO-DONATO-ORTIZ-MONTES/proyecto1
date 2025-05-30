package interfazAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import atraccion.Atraccion;
import atraccion.AtraccionCultural;
import atraccion.AtraccionMecanica;
import parqueDeDiversiones.ParqueDeDiversiones;
import java.util.List;

public class VentanaCatalogoAtracciones extends JFrame {
    private JTextArea areaTexto;

    public VentanaCatalogoAtracciones() {
        setTitle("Catálogo de Atracciones");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Catálogo de Atracciones", JLabel.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);
        JButton botonMostrar = new JButton("Mostrar Atracciones");
        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAtracciones();
            }
        });
        add(botonMostrar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void mostrarAtracciones() {
        List<Atraccion> lista = ParqueDeDiversiones.atracciones;
        areaTexto.setText("");

        if (lista.isEmpty()) {
            areaTexto.setText("No hay atracciones registradas.");
            return;
        }

        for (Atraccion atrac : lista) {
            areaTexto.append("Nombre: " + atrac.getNombreAtraccion() + "\n");
            areaTexto.append("Tipo: " + atrac.getTipoAtraccion() + "\n");
            areaTexto.append("Nivel: " + atrac.getNivelAtraccion() + "\n");

            if (atrac instanceof AtraccionCultural) {
            	//esta es la misma funcion que tengo en parquedediversiones pero adaptada a este caso
                AtraccionCultural ac = (AtraccionCultural) atrac;
                areaTexto.append("Edad mínima: " + ac.getEdadMinima() + "\n");
                areaTexto.append("Es de temporada: " + ac.isEsTemporada() + "\n");
                areaTexto.append("Fecha temporada: " + ac.getFechaTemporada() + "\n");
            } else if (atrac instanceof AtraccionMecanica) {
                AtraccionMecanica am = (AtraccionMecanica) atrac;
                areaTexto.append("Altura mínima: " + am.getAlturaUusario() + "\n");
                areaTexto.append("Peso mínimo: " + am.getPesoUsuario() + "\n");
                areaTexto.append("Apto para discapacitados: " + am.isEsDiscapacitado() + "\n");
                areaTexto.append("Causa vértigo: " + am.isExisteVertigo() + "\n");
                areaTexto.append("Es de temporada: " + am.isEsTemporada() + "\n");
                areaTexto.append("Fecha temporada: " + am.getFechaTemporada() + "\n");
            }
        }
    }
}


