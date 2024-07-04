package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import sql.Conexion;

public class AlquilarLibros extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JList<String> listClientes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlquilarLibros frame = new AlquilarLibros();
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
    public AlquilarLibros() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 463);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAlquilarLibros = new JLabel("Alquiler de Libros");
        lblAlquilarLibros.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblAlquilarLibros.setBounds(71, 21, 214, 59);
        contentPane.add(lblAlquilarLibros);

        JLabel lblNewLabel_1_1_2 = new JLabel("Fecha de alquiler:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(53, 300, 130, 20);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("Fecha de devolución:");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_3.setBounds(53, 331, 150, 20);
        contentPane.add(lblNewLabel_1_1_3);

        listClientes = new JList<>();
        listClientes.setBounds(38, 124, 328, 165);
        contentPane.add(listClientes);

        JList<String> listLibros = new JList<>();
        listLibros.setBounds(386, 47, 263, 275);
        contentPane.add(listLibros);

        JLabel lblNewLabel_1_1_2_1 = new JLabel("Lista de Clientes Actuales");
        lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1.setBounds(28, 93, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1);

        JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Lista de Libros Disponibles");
        lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1_1.setBounds(376, 21, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(196, 302, 99, 20);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(196, 333, 99, 20);
        contentPane.add(textField_1);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(28, 378, 93, 23);
        contentPane.add(btnRegresar);

        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.setBounds(546, 378, 93, 23);
        contentPane.add(btnAlquilar);
        
        JButton btnRegistroDeClientes = new JButton("Registro de Clientes");
        btnRegistroDeClientes.setBounds(376, 332, 130, 23);
        contentPane.add(btnRegistroDeClientes);

        // Cargar datos de clientes
        cargarClientes();
    }

    private void cargarClientes() {
        Conexion conexion = new Conexion();
        DefaultListModel<String> modelo = new DefaultListModel<>();

        for (String cliente : conexion.obtenerClientes()) {
            modelo.addElement(cliente);
        }

        listClientes.setModel(modelo);
    }
}
