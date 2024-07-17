package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sql.Conexion;

public class ReservacionDeLibros extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> listClientes;
    private JList<String> listLibrosNoDisponibles;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservacionDeLibros frame = new ReservacionDeLibros();
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
    public ReservacionDeLibros() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 738, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnRegistroDeClientes = new JButton("Registro de Clientes");
        btnRegistroDeClientes.setBounds(407, 383, 153, 23);
        contentPane.add(btnRegistroDeClientes);
        btnRegistroDeClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrosDeClientes registrosDeClientes = new RegistrosDeClientes();
                registrosDeClientes.setVisible(true);
                dispose(); // Cierra la ventana actual (ReservacionDeLibros)
            }
        });
        
        listLibrosNoDisponibles = new JList<>();
        listLibrosNoDisponibles.setBounds(362, 62, 310, 298);
        contentPane.add(listLibrosNoDisponibles);

        JLabel lblReservacion = new JLabel("Reservar Libros");
        lblReservacion.setForeground(new Color(255, 255, 255));
        lblReservacion.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblReservacion.setBounds(54, 11, 250, 55);
        contentPane.add(lblReservacion);

        listClientes = new JList<>();
        listClientes.setBounds(27, 108, 300, 233);
        contentPane.add(listClientes);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
                dispose(); // Cierra la ventana actual (ReservacionDeLibros)
            }
        });
        btnRegresar.setBounds(37, 383, 93, 23);
        contentPane.add(btnRegresar);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el cliente seleccionado
                String clienteSeleccionado = listClientes.getSelectedValue();
                if (clienteSeleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Selecciona un cliente para reservar.");
                    return;
                }

                // Obtener el libro no disponible seleccionado
                String libroSeleccionado = listLibrosNoDisponibles.getSelectedValue();
                if (libroSeleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Selecciona un libro no disponible para reservar.");
                    return;
                }

                // Llamar a la función para realizar la reserva en la base de datos
                Conexion conexion = new Conexion();
                conexion.realizarReserva(clienteSeleccionado, libroSeleccionado);

                // Actualizar la lista de libros no disponibles después de la reserva
                cargarLibrosNoDisponibles();
            }
        });

        btnReservar.setBounds(579, 383, 93, 23);
        contentPane.add(btnReservar);

        JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Catálogo de Libros");
        lblNewLabel_1_1_2_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1_1.setBounds(357, 31, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1_1);

        JLabel lblNewLabel_1_1_2_1 = new JLabel("Lista de Clientes Actuales");
        lblNewLabel_1_1_2_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1.setBounds(27, 77, 206, 20);
        contentPane.add(lblNewLabel_1_1_2_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\fondo-digital-abstracto-textura-placa-circuito-tecnologia-ilustracion-placa-base-electronica-concepto-comunicacion-e-ingenieria-ilustracion-vectorial_41981-1986.jpg"));
        lblNewLabel.setBounds(0, 0, 944, 456);
        contentPane.add(lblNewLabel);

        cargarLibrosNoDisponibles();
        // Cargar clientes al iniciar la ventana
        cargarClientes();
    }

    private void cargarClientes() {
        Conexion conexion = new Conexion(); // Crear instancia de la clase de conexión
        List<String> clientes = conexion.obtenerClientes(); // Obtener lista de clientes desde la base de datos

        // Crear un modelo de lista con capacidad de selección única
        DefaultComboBoxModel<String> modeloClientes = new DefaultComboBoxModel<>();
        for (String cliente : clientes) {
            modeloClientes.addElement(cliente); // Agregar cada cliente al modelo
        }

        // Asignar el modelo de lista al JList de clientes
        listClientes.setModel(modeloClientes);
    }

    private void cargarLibrosNoDisponibles() {
        Conexion conexion = new Conexion(); // Asegúrate de tener una clase de conexión implementada
        List<String> librosNoDisponibles = conexion.obtenerLibrosNoDisponibles(); // Obtener lista de libros no disponibles

        // Crear un modelo de lista y añadir los libros obtenidos
        DefaultListModel<String> modeloLibros = new DefaultListModel<>();
        for (String libro : librosNoDisponibles) {
            modeloLibros.addElement(libro);
        }

        // Asignar el modelo de lista al JList de libros no disponibles
        listLibrosNoDisponibles.setModel(modeloLibros);
    }
}
