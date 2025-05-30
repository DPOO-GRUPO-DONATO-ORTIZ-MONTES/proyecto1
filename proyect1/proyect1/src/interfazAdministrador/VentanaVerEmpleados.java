package interfazAdministrador;

import javax.swing.*;
import Empleado.empleado;
import java.awt.Font;

public class VentanaVerEmpleados extends JFrame {

    public VentanaVerEmpleados() {
        setTitle("Lista de Empleados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        //esta parte tambien me toco consultarla ya que no sabia bien como poner el codigo para que se mostrara la informacion de forma ordenada.
        StringBuilder sb = new StringBuilder();

        if (empleado.empleadosPorNombre.isEmpty()) {
            sb.append("No hay empleados registrados");
        } else {
            for (empleado emple : empleado.empleadosPorNombre.values()) {
                sb.append("Nombre: ").append(emple.getNombre()).append("\n");
                sb.append("Tipo: ").append(emple.getTipoEmpleado()).append("\n");
                sb.append("ID: ").append(emple.getID()).append("\n");
                sb.append("Salario: ").append(emple.getSalario()).append("\n");
                sb.append("Rango Atracción: ").append(emple.getRangoAtraccion()).append("\n");
                sb.append("Turno: ").append(emple.getTurno()).append("\n");
                sb.append("Hora Extra: ").append(emple.getHoraExtra()).append("\n");
                sb.append("Bonus Hora Extra: ").append(emple.getBonusHoraExtra()).append("\n");
                sb.append("Lugar Asignado: ").append(emple.getLugarAsignado()).append("\n");
            }
        }

        areaTexto.setText(sb.toString());

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);

        setVisible(true);
    }
}

