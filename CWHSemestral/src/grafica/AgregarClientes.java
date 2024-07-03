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
import sql.Conexion;

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
        textFieldNombre.setBounds(107, 111, 120, 20);
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
        textFieldTelefono.setBounds(107, 140, 120, 20);
        contentPane.add(textFieldTelefono);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setColumns(10);
        textFieldDireccion.setBounds(107, 171, 120, 20);
        contentPane.add(textFieldDireccion);

        JButton btnAgregar = new JButton("Agregar Cliente");
        btnAgregar.setBounds(558, 329, 150, 23);
        contentPane.add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String telefono = textFieldTelefono.getText();
                String direccion = textFieldDireccion.getText();

                Conexion conexion = new Conexion();
                conexion.insertarCliente(nombre, telefono, direccion);

                // Limpiar los campos de texto después de insertar el cliente
                textFieldNombre.setText("");
                textFieldTelefono.setText("");
                textFieldDireccion.setText("");
            }
        });
    }
}

