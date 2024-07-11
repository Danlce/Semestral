package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sql.Conexion;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class AgregarClientes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldTelefono;
    private JTextField textFieldDireccion;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgregarClientes frame = new AgregarClientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AgregarClientes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 691, 418);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.textHighlightText);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Agregar Cliente Nuevo");
        lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblNewLabel.setBounds(76, 22, 315, 59);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(35, 109, 78, 20);
        contentPane.add(lblNewLabel_1);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(107, 111, 284, 20);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Teléfono:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(35, 140, 78, 20);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Dirección:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(35, 171, 78, 20);
        contentPane.add(lblNewLabel_1_2);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setColumns(10);
        textFieldTelefono.setBounds(107, 140, 284, 20);
        contentPane.add(textFieldTelefono);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setColumns(10);
        textFieldDireccion.setBounds(107, 171, 284, 20);
        contentPane.add(textFieldDireccion);

        JButton btnAgregar = new JButton("Agregar Cliente");
        btnAgregar.setBounds(526, 327, 107, 23);
        contentPane.add(btnAgregar);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();
                // Abrir la ventana de RegistroDeClientes
                RegistrosDeClientes frame = new RegistrosDeClientes();
                frame.setVisible(true);
            }
        });
        btnRegresar.setBounds(35, 327, 84, 23);
        contentPane.add(btnRegresar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText().trim();
                String telefono = textFieldTelefono.getText().trim();
                String direccion = textFieldDireccion.getText().trim();

                if (nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!nombre.matches("[a-zA-Z\\s]+")) {
                    JOptionPane.showMessageDialog(contentPane, "El nombre no debe contener números ni caracteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!telefono.matches("[0-9-]+")) {
                    JOptionPane.showMessageDialog(contentPane, "El teléfono solo debe contener números y el carácter especial '-'", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Conexion conexion = new Conexion();
                    conexion.insertarCliente(nombre, telefono, direccion);

                    // Limpiar los campos de texto después de insertar el cliente
                    textFieldNombre.setText("");
                    textFieldTelefono.setText("");
                    textFieldDireccion.setText("");
                    
                    JOptionPane.showMessageDialog(contentPane, "Cliente agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
