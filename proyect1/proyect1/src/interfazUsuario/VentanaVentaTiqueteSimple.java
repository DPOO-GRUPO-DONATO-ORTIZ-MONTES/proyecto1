package interfazUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cliente.Cliente;
import Tiquete.*;
import java.util.UUID;

public class VentanaVentaTiqueteSimple extends JFrame {
    private JTextField nombreField, correoField, pesoField, alturaField;
    private JComboBox<String> tipoCombo;
    private JCheckBox tieneVertigoCheck, tieneDiscapacidadCheck;
    private JButton generarButton;
    private JTextArea facturaArea;

    public VentanaVentaTiqueteSimple() {
        super("Venta y generación de tiquete");
        setSize(600, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JPanel formPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Nombre completo:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Correo electrónico:"));
        correoField = new JTextField();
        formPanel.add(correoField);

        formPanel.add(new JLabel("Tipo de tiquete:"));
        tipoCombo = new JComboBox<>(new String[] {"Diamante", "Oro", "Familiar", "Basico"});
        formPanel.add(tipoCombo);

        tieneVertigoCheck = new JCheckBox("Tiene vértigo");
        formPanel.add(tieneVertigoCheck);
        formPanel.add(new JLabel(""));

        tieneDiscapacidadCheck = new JCheckBox("Tiene discapacidad");
        formPanel.add(tieneDiscapacidadCheck);
        formPanel.add(new JLabel(""));

        formPanel.add(new JLabel("Peso (kg):"));
        pesoField = new JTextField();
        pesoField.setEnabled(true);
        formPanel.add(pesoField);

        formPanel.add(new JLabel("Altura (cm):"));
        alturaField = new JTextField();
        alturaField.setEnabled(true);
        formPanel.add(alturaField);

        generarButton = new JButton("Generar y Vender Tiquete");
        formPanel.add(generarButton);
        formPanel.add(new JLabel(""));

        add(formPanel, BorderLayout.NORTH);

        facturaArea = new JTextArea();
        facturaArea.setEditable(false);
        facturaArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(facturaArea), BorderLayout.CENTER);

        generarButton.addActionListener(e -> generarTiquete());

        setVisible(true);
    }

    private void generarTiquete() {
        String nombre = nombreField.getText().trim();
        String correo = correoField.getText().trim();
        String tipo = (String) tipoCombo.getSelectedItem();
        boolean tieneVertigo = tieneVertigoCheck.isSelected();
        boolean tieneDiscapacidad = tieneDiscapacidadCheck.isSelected();
        String pesoStr = pesoField.getText().trim();
        String alturaStr = alturaField.getText().trim();

        if(nombre.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y correo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int peso, altura;
        try {
            peso = Integer.parseInt(pesoStr);
            altura = Integer.parseInt(alturaStr);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Peso y altura deben ser números enteros válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = Cliente.listaClientes.get(correo);
        if(cliente == null) {
            cliente = new Cliente(nombre, 0, correo, 1234);
            Cliente.listaClientes.put(correo, cliente);
        }

        Date fechaCompra = new Date();
        String idTiquete = UUID.randomUUID().toString();

        Tiquete nuevoTiquete;
        if(tipo.equalsIgnoreCase("Basico")) {
            nuevoTiquete = new EntradaIndividual(idTiquete, tipo, fechaCompra, false, cliente, "Sin asignación");
        } else {
            List<String> atraccionesAsignadas = new ArrayList<>();
            nuevoTiquete = new TiqueteConRango(idTiquete, tipo, fechaCompra, false, cliente, fechaCompra, atraccionesAsignadas);
        }

        cliente.tiqueteComprado(idTiquete, nuevoTiquete);

        StringBuilder factura = new StringBuilder();
        factura.append("Factura de compra\n");
        factura.append("------------------------\n");
        factura.append("Cliente: ").append(nombre).append("\n");
        factura.append("Correo: ").append(correo).append("\n");
        factura.append("Tipo Tiquete: ").append(tipo).append("\n");
        factura.append("ID Tiquete: ").append(idTiquete).append("\n");
        factura.append("Fecha Compra: ").append(fechaCompra).append("\n");
        factura.append("Vértigo: ").append(tieneVertigo ? "Sí" : "No").append("\n");
        factura.append("Discapacidad: ").append(tieneDiscapacidad ? "Sí" : "No").append("\n");
        factura.append("Peso (kg): ").append(peso).append("\n");
        factura.append("Altura (cm): ").append(altura).append("\n");

        facturaArea.setText(factura.toString());

        JOptionPane.showMessageDialog(this, "Tiquete generado y vendido con éxito");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaVentaTiqueteSimple());
    }
}
