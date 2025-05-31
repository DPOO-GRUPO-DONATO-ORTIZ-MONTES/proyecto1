package interfazUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import cliente.Cliente;

public class VentanaValidacionTiquete extends JFrame {
    private JTextField idTiqueteField;
    private JTextArea resultadoArea;
    private JButton validarButton;

    public VentanaValidacionTiquete() {
        super("Validación de Tiquete");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSuperior.add(new JLabel("Ingrese el ID del tiquete:"));
        idTiqueteField = new JTextField();
        panelSuperior.add(idTiqueteField);

        validarButton = new JButton("Validar Tiquete");
        panelSuperior.add(validarButton);
        panelSuperior.add(new JLabel(""));

        add(panelSuperior, BorderLayout.NORTH);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        validarButton.addActionListener(e -> validarTiquete());

        setVisible(true);
    }

    private void validarTiquete() {
        String idBuscado = idTiqueteField.getText().trim();
        if (idBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID de tiquete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Cliente cliente : Cliente.listaClientes.values()) {
            Map<String, Map<String, String>> tiquetes = cliente.getTiquetesComprados();
            if (tiquetes.containsKey(idBuscado)) {
                Map<String, String> t = tiquetes.get(idBuscado);
                StringBuilder sb = new StringBuilder();
                sb.append("Tiquete encontrado\n");
                sb.append("------------------------\n");
                sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
                sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
                sb.append("Tipo: ").append(t.get("tipo")).append("\n");
                sb.append("ID: ").append(t.get("id")).append("\n");
                sb.append("Fecha de compra: ").append(t.get("fechaCompra")).append("\n");
                resultadoArea.setText(sb.toString());
                return;
            }
        }

        resultadoArea.setText("Tiquete NO encontrado. Verifique el ID ingresado.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaValidacionTiquete());
    }
}
