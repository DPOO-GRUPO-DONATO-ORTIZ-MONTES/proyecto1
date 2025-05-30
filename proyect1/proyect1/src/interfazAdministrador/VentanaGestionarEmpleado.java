package interfazAdministrador; 

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Empleado.empleado;

public class VentanaGestionarEmpleado extends JFrame {
    private empleado emp;

    public VentanaGestionarEmpleado(empleado emp) {
    	this.emp = emp;
        setTitle("Gestionar Empleado: " + emp.getNombre());
        setSize(400, 300);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton botonTurno = new JButton("Modificar turno");
        JButton botonSalario = new JButton("Cambiar salario");
        JButton botonExtra = new JButton("Agregar horas extra");
        JButton botonLugar = new JButton("Asignar lugar");
        JButton botonCerrar = new JButton("Cerrar");

        botonTurno.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String turno = JOptionPane.showInputDialog("Nuevo turno");
                if (turno != null) {
                    emp.setTurno(turno);
                    //consulte para usar esto que muestra un mensaje al ejecutar la accion
                    JOptionPane.showMessageDialog(null, "Turno cambiado");
                }
            }
        });

        botonSalario.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	//perminte ingresar los datos
                String texto = JOptionPane.showInputDialog("Nuevo salario:");
                if (texto != null) {
                    try {
                        int nuevoSalario = Integer.parseInt(texto);
                        emp.setSalario(nuevoSalario);
                        JOptionPane.showMessageDialog(null, "Salario actualizado");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número");
                    }
                }
            }
        });

        botonExtra.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                emp.setHoraExtra(true);
                JOptionPane.showMessageDialog(null, "Horas extra activadas");
            }
        });

        botonLugar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String lugar = JOptionPane.showInputDialog("Nuevo lugar asignado:");
                if (lugar != null) {
                    emp.cambiarLugarAsignado(lugar);
                    JOptionPane.showMessageDialog(null, "Lugar actualizado");
                }
            }
        });

        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose();
            }
        });
        
        add(botonTurno);
        add(botonSalario);
        add(botonExtra);
        add(botonLugar);
        add(botonCerrar);

        setVisible(true);
    }
}