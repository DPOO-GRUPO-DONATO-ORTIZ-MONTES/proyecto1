package interfazAdministrador;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Empleado.*;
import java.util.*;

public class VentanaRegistrarEmpleado extends JFrame  {
	//aqui me base mucho en el taller de swing ya que uso textField que a mi parecer hace mas elegante la interfaz
	private JComboBox<String> tipoEmpleado;
    private JTextField nombre;
    private JTextField turno;
    private JTextField id;
    private JTextField salario;
    private JTextField rangoAtraccion;
    private JTextField bonusHoraExtra;
    private JTextField lugarAsignado;
    private JTextField extra;
    private JCheckBox horaExtra;
    private JLabel extraLabel;
    private JButton registrarBoton;

    public VentanaRegistrarEmpleado(){
        setTitle("Registrar Empleado");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2, 5, 5));

        add(new JLabel("Tipo de Empleado:"));
        tipoEmpleado = new JComboBox<>(new String[]{"cajero", "cocinero", "operadorMecanica"});
        add(tipoEmpleado);

        add(new JLabel("Nombre:"));
        nombre = new JTextField();
        add(nombre);

        add(new JLabel("Turno:"));
        turno = new JTextField();
        add(turno);

        add(new JLabel("¿Hora Extra?:"));
        horaExtra = new JCheckBox();
        add(horaExtra);

        add(new JLabel("ID:"));
        id = new JTextField();
        add(id);

        add(new JLabel("Salario:"));
        salario = new JTextField();
        add(salario);

        add(new JLabel("Rango Atracción (si aplica):"));
        rangoAtraccion = new JTextField();
        add(rangoAtraccion);

        add(new JLabel("Bonus Hora Extra:"));
        bonusHoraExtra = new JTextField();
        add(bonusHoraExtra);

        add(new JLabel("Lugar Asignado:"));
        lugarAsignado = new JTextField();
        add(lugarAsignado);

        extraLabel = new JLabel("Punto Asignado / Certificado / Atracciones Habilitadas:");
        add(extraLabel);
        extra = new JTextField();
        add(extra);

        registrarBoton = new JButton("Registrar");
        add(registrarBoton);

        registrarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        setVisible(true);
    }

    private void registrarEmpleado() {
        try {
            String tipo = (String) tipoEmpleado.getSelectedItem();
            String nombre1 = nombre.getText();
            String turno1 = turno.getText();
            boolean horaExtra1 = horaExtra.isSelected();
            int id1 = Integer.parseInt(id.getText());
            int salario1 = Integer.parseInt(salario.getText());
            String rango1 = rangoAtraccion.getText();
            int bonus1 = Integer.parseInt(bonusHoraExtra.getText());
            String lugar1 = lugarAsignado.getText();
            String extra1 = extra.getText();

            empleado nuevoEmpleado;

            switch (tipo) {
                case "cajero":
                    nuevoEmpleado = new cajero(tipo, nombre1, turno1, horaExtra1, id1, salario1, rango1, bonus1, lugar1, extra1);
                    break;
                case "cocinero":
                    nuevoEmpleado = new cocinero(tipo, nombre1, turno1, horaExtra1, id1, salario1, rango1, bonus1, lugar1, extra1);
                    break;
                case "operadorMecanica":
                    List<String> atracciones = Arrays.asList(extra1.split(","));
                    nuevoEmpleado = new operadorMecanica(tipo, nombre1, turno1, horaExtra1, id1, salario1, rango1, bonus1, lugar1, atracciones, atracciones);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Tipo de empleado invalido");
                    return;
            }

            empleado.empleadosPorNombre.put(nombre1, nuevoEmpleado);
            JOptionPane.showMessageDialog(this, "Empleado registrado");
            dispose();

        } catch (Exception ex) {
        	//aqui me pregunte como puedo decirle al usuario donde esta el error al ejecutar y pues usando get message se puede esot lo consulte.
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
