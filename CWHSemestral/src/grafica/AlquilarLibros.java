package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CustomDateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import sql.Conexion;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AlquilarLibros extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> listClientes;
    private JList<String> listLibros;
    private CustomDateChooser dateChooser;

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
        setBounds(100, 100, 732, 490);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAlquilarLibros = new JLabel("Alquiler de Libros");
        lblAlquilarLibros.setForeground(new Color(255, 255, 255));
        lblAlquilarLibros.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblAlquilarLibros.setBounds(71, 21, 214, 59);
        contentPane.add(lblAlquilarLibros);

        JLabel lblNewLabel_1_1_3 = new JLabel("Fecha de devolución:");
        lblNewLabel_1_1_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_3.setBounds(49, 314, 150, 20);
        contentPane.add(lblNewLabel_1_1_3);

        // Configuración del CustomDateChooser en lugar de JDateChooser
        dateChooser = new CustomDateChooser();
        dateChooser.setBounds(196, 316, 150, 20);
        contentPane.add(dateChooser);

        listClientes = new JList<>();
        listClientes.setBounds(38, 124, 328, 165);
        contentPane.add(listClientes);

        listLibros = new JList<>();
        listLibros.setBounds(386, 77, 291, 275);
        contentPane.add(listLibros);

        JLabel lblNewLabel_1_1_2_1 = new JLabel("Lista de Clientes Actuales");
        lblNewLabel_1_1_2_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1.setBounds(28, 93, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1);

        JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Lista de Libros Disponibles");
        lblNewLabel_1_1_2_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1_1.setBounds(368, 43, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1_1);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRegresar.setBounds(38, 396, 93, 23);
        contentPane.add(btnRegresar);

        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.setBounds(584, 396, 93, 23);
        contentPane.add(btnAlquilar);

        JButton btnRegistroDeClientes = new JButton("Registro de Clientes");
        btnRegistroDeClientes.setBounds(547, 362, 130, 23);
        contentPane.add(btnRegistroDeClientes);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\mysql-connector-j-9.0.0\\remix-digital-geografia-vector-fondo-globo-educacion-disruptiva_53876-140586.jpg"));
        lblNewLabel.setBounds(0, -40, 756, 505);
        contentPane.add(lblNewLabel);

        // Cargar datos de clientes
        cargarClientes();

        // Cargar datos de libros disponibles
        cargarLibrosDisponibles();

        // Acción del botón Alquilar
        btnAlquilar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alquilarLibro();
            }
        });
    }

    private void cargarClientes() {
        Conexion conexion = new Conexion();
        DefaultListModel<String> modeloClientes = new DefaultListModel<>();

        for (String cliente : conexion.obtenerClientes()) {
            modeloClientes.addElement(cliente);
        }

        listClientes.setModel(modeloClientes);
    }

    private void cargarLibrosDisponibles() {
        Conexion conexion = new Conexion();
        DefaultListModel<String> modeloLibros = new DefaultListModel<>();

        for (String libro : conexion.obtenerLibrosDisponibles()) {
            modeloLibros.addElement(libro);
        }

        listLibros.setModel(modeloLibros);
    }

    private void alquilarLibro() {
        String clienteSeleccionado = listClientes.getSelectedValue();
        String libroSeleccionado = listLibros.getSelectedValue();
        Date fechaDevolucion = dateChooser.getDate();
        Date fechaDevolucionReal = new java.sql.Date(System.currentTimeMillis()); // Aquí obtienes la fecha actual, ajusta según necesites

        if (clienteSeleccionado == null || libroSeleccionado == null || fechaDevolucion == null) {
            System.out.println("Debe seleccionar un cliente, un libro y una fecha de devolución.");
            return;
        }

        String clienteNombre = clienteSeleccionado.split(" ")[0];
        String libroTitulo = libroSeleccionado.split(" - ")[0];

        Conexion conexion = new Conexion();
        conexion.alquilarLibro(clienteNombre, libroTitulo, new java.sql.Date(fechaDevolucion.getTime()), fechaDevolucionReal);


        // Recargar listas
        cargarLibrosDisponibles();
    }
}
