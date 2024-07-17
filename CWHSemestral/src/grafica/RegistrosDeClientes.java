package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sql.Conexion;

public class RegistrosDeClientes extends JFrame {
    private Conexion conexion;
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnEditar;
    private JButton btnAgregar;
    private JList<String> listClientes;
    private JButton btnBorrar;
    private JLabel lblNewLabel_2;
    private JButton btnActualizar;
    private JLabel lblAmonestacion;
    private JButton btnAlquilar;
    private JButton btnReservar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrosDeClientes frame = new RegistrosDeClientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegistrosDeClientes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 722, 473);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        conexion = new Conexion();

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener todos los alquileres
                DefaultListModel<String> modeloLista = (DefaultListModel<String>) listClientes.getModel();
                int size = modeloLista.getSize();
                
                // Iterar sobre cada alquiler y actualizar
                for (int i = 0; i < size; i++) {
                    String alquilerSeleccionado = modeloLista.getElementAt(i);
                    if (alquilerSeleccionado != null) {
                        String[] parts = alquilerSeleccionado.split(" - Alquiló: ");
                        String nombreCliente = parts[0];
                        String tituloLibro = parts[1].substring(0, parts[1].indexOf(","));

                        // Llamar al método para actualizar la fecha de devolución real
                        conexion.actualizarFechaDevolucionReal(nombreCliente, tituloLibro);

                        // Calcular la nueva amonestación
                        LocalDate fechaDevolucionEsperada = conexion.obtenerFechaDevolucionEsperada(nombreCliente, tituloLibro);
                        LocalDate fechaDevolucionReal = conexion.obtenerFechaDevolucionReal(nombreCliente, tituloLibro);
                        double amonestacion = conexion.calcularAmonestacion(fechaDevolucionEsperada, fechaDevolucionReal);

                        // Aumentar la amonestación si la diferencia es mayor a 7 días
                        if (fechaDevolucionReal != null && fechaDevolucionEsperada != null) {
                            long diasExcedidos = ChronoUnit.DAYS.between(fechaDevolucionEsperada, fechaDevolucionReal);
                            if (diasExcedidos > 7) {
                                amonestacion += 2.50;
                            }
                        }

                        // Mostrar la amonestación en el JLabel correspondiente
                        lblAmonestacion.setText("Amonestación por días excedidos: $" + String.format("%.2f", amonestacion));

                        // Actualizar la amonestación en la base de datos
                        conexion.actualizarAmonestacion(nombreCliente, tituloLibro, amonestacion);

                        // Verificar si alguna reserva puede convertirse en alquiler debido a la disponibilidad del libro
                        verificarReservasActivas();
                    }
                }

                // Actualizar la lista de alquileres mostrada en la interfaz después de procesar todos los alquileres
                actualizarListaAlquileres();
            }
        });
        
        btnReservar = new JButton("Reservar");
        btnReservar.setBounds(388, 383, 89, 23);
        contentPane.add(btnReservar);
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana actual
                ReservacionDeLibros frame = new ReservacionDeLibros(); // Crear nueva instancia de ReservacionDeLibros
                frame.setVisible(true); // Mostrar la ventana de reservación de libros
            }
        });
        
        btnAlquilar = new JButton("Alquilar");
        btnAlquilar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana actual
                AlquilarLibros frame = new AlquilarLibros(); // Crear nueva instancia de AlquilarLibros
                frame.setVisible(true); // Mostrar la ventana de alquiler de libros
            }
        });
        btnAlquilar.setBounds(388, 350, 89, 23);
        contentPane.add(btnAlquilar);

        btnActualizar.setBounds(496, 383, 93, 23);
        contentPane.add(btnActualizar);

        JLabel lblNewLabel = new JLabel("Lista de Clientes Actuales");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblNewLabel.setBounds(35, 11, 337, 43);
        contentPane.add(lblNewLabel);

        listClientes = new JList<>();
        listClientes.setBounds(24, 110, 664, 229);
        contentPane.add(listClientes);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(84, 72, 82, 27);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(142, 77, 306, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(458, 76, 87, 23);
        contentPane.add(btnNewButton);

        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditarClientesActuales frame = new EditarClientesActuales();
                frame.setVisible(true);
            }
        });
        btnEditar.setBounds(599, 350, 89, 23);
        contentPane.add(btnEditar);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                AgregarClientes frame = new AgregarClientes();
                frame.setVisible(true);
            }
        });
        btnAgregar.setBounds(599, 383, 89, 23);
        contentPane.add(btnAgregar);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual (RegistrosDeClientes)
                dispose();

                // Abrir la ventana del menú principal (MenuPrincipal)
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            }
        });
        btnRegresar.setBounds(24, 370, 93, 23);
        contentPane.add(btnRegresar);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(500, 350, 89, 23);
        contentPane.add(btnBorrar);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\aaaaaa.jpg"));
        lblNewLabel_2.setBounds(0, 0, 814, 473);
        contentPane.add(lblNewLabel_2);

        lblAmonestacion = new JLabel("");
        lblAmonestacion.setForeground(Color.RED);
        lblAmonestacion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAmonestacion.setBounds(24, 350, 400, 20);
        contentPane.add(lblAmonestacion);

        // Listener para borrar un alquiler
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alquilerSeleccionado = listClientes.getSelectedValue();
                if (alquilerSeleccionado != null) {
                    String[] parts = alquilerSeleccionado.split(" - Alquiló: ");
                    String nombreCliente = parts[0];
                    String tituloLibro = parts[1].substring(0, parts[1].indexOf(","));

                    // Utilización de la conexión para borrar el alquiler
                    conexion.borrarAlquiler(nombreCliente, tituloLibro);

                    // Recargar la lista de clientes después de borrar el alquiler
                    cargarClientes();
                }
            }
        });

        // Cargar clientes al iniciar la ventana.
        cargarClientes();
    }

    // Método para cargar los clientes y configurar la amonestación
    private void cargarClientes() {
        List<String> clientes = conexion.obtenerClientesConAlquileres();

        // Verificar si la lista de clientes está vacía
        if (!clientes.isEmpty()) {
            DefaultListModel<String> modeloClientes = new DefaultListModel<>();
            for (String cliente : clientes) {
                modeloClientes.addElement(cliente);
            }
            listClientes.setModel(modeloClientes);
        } else {
            listClientes.setModel(new DefaultListModel<>()); // Si está vacía, establecer un modelo vacío
        }
    }

    // Método para actualizar la lista de alquileres en la interfaz
    private void actualizarListaAlquileres() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        List<String> alquileres = conexion.obtenerClientesConAlquileres(); // Obtener los alquileres actualizados

        for (String alquiler : alquileres) {
            modeloLista.addElement(alquiler);
        }

        listClientes.setModel(modeloLista); // Asignar el nuevo modelo a tu JList (listClientes)
    }

    private void verificarReservasActivas() {
        List<String> reservasActivas = conexion.obtenerReservasActivas();

        for (String reserva : reservasActivas) {
            String[] partes = reserva.split("-");
            String cliente = partes[0].trim();
            String libro = partes[1].trim();

            // Verificar disponibilidad del libro
            boolean libroDisponible = conexion.verificarDisponibilidadLibro(libro);

            if (libroDisponible) {
                // Establecer fechas automáticas
                LocalDate fechaAlquiler = LocalDate.now();
                LocalDate fechaDevolucion = fechaAlquiler.plusDays(7);
                LocalDate fechaLimiteDevolucion = fechaAlquiler.plusDays(14);

                // Convertir la reserva en alquiler con las fechas automáticas
                conexion.convertirReservaAAlquiler(cliente, libro, fechaAlquiler, fechaDevolucion, fechaLimiteDevolucion);
            }
        }
    }
}
