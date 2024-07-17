package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import sql.Conexion;

public class MenuPrincipal extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JList<String> listLibros;
    private JScrollPane scrollPane;

    private Conexion conexion; // Instancia de Conexion para manejar la base de datos

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Presentacion presentacion = new Presentacion();
                	presentacion.setVisible(true);                
                	} catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 731, 464);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        listLibros = new JList<>();
        scrollPane = new JScrollPane();
        scrollPane.setBounds(104, 149, 493, 148);
        scrollPane.setViewportView(listLibros);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Libreria Wilberto");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblNewLabel.setBounds(228, 11, 286, 69);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Buscador:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(104, 85, 109, 29);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(185, 91, 219, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_6 = new JButton("Buscar");
        btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica de búsqueda
                String textoBusqueda = textField.getText().trim(); // Obtener el texto ingresado y limpiar espacios

                if (textoBusqueda.isEmpty()) {
                    // Si no se ingresa texto, actualizar la lista con todos los libros
                    actualizarListaLibros();
                } else {
                    // Buscar libros por el nombre ingresado
                    List<String> librosFiltrados = conexion.buscarLibrosPorNombre(textoBusqueda);

                    if (librosFiltrados.isEmpty()) {
                        JOptionPane.showMessageDialog(MenuPrincipal.this,
                                "No se encontraron libros con el nombre especificado.", "Sin Resultados",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    // Convertir la lista de libros filtrados a un array para usarlo en JList
                    String[] librosArray = librosFiltrados.toArray(new String[0]);

                    // Configurar el modelo de lista con los libros filtrados
                    listLibros.setListData(librosArray);
                }
            }
        });
        btnNewButton_6.setBounds(414, 91, 89, 23);
        contentPane.add(btnNewButton_6);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\logoss.jpg"));
        lblNewLabel_3.setBounds(525, 0, 227, 141);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\fondo-onda-desenfoque-particulas-abstractas-azul-sobre-fondo-futurista-hermosa-ilustracion-movimiento-que-fluye_36402-1226.jpg"));
        lblNewLabel_2.setBounds(-21, -54, 799, 490);
        contentPane.add(lblNewLabel_2);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú "Opciones"
        JMenu menuOpciones = new JMenu("Menu");
        menuBar.add(menuOpciones);

        // Opción "Registros de Clientes"
        JMenuItem menuItemRegistrosDeClientes = new JMenuItem("Registros de Clientes");
        menuItemRegistrosDeClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de registros de clientes
                RegistrosDeClientes ventanaRegistrosDeClientes = new RegistrosDeClientes();
                ventanaRegistrosDeClientes.setVisible(true);
                // Cerrar la ventana principal
                dispose();
            }
        });
        menuOpciones.add(menuItemRegistrosDeClientes);

        // Opción "Catálogo de libros"
        JMenuItem menuItemCatalogo = new JMenuItem("Catálogo de libros");
        menuItemCatalogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de catálogo de libros
                Catalogo ventanaCatalogo = new Catalogo();
                ventanaCatalogo.setVisible(true);
                // Cerrar la ventana principal
                dispose();
            }
        });
        menuOpciones.add(menuItemCatalogo);

        // Opción "Alquiler de libros"
        JMenuItem menuItemAlquilerLibros = new JMenuItem("Alquiler de libros");
        menuItemAlquilerLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de alquiler de libros
                AlquilarLibros ventanaAlquilerLibros = new AlquilarLibros();
                ventanaAlquilerLibros.setVisible(true);
                // Cerrar la ventana principal
                dispose();
            }
        });
        menuOpciones.add(menuItemAlquilerLibros);

        // Opción "Reserva de libros"
        JMenuItem menuItemReservaLibros = new JMenuItem("Reserva de libros");
        menuItemReservaLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de reserva de libros
                ReservacionDeLibros ventanaReservaLibros = new ReservacionDeLibros();
                ventanaReservaLibros.setVisible(true);
                // Cerrar la ventana principal
                dispose();
            }
        });
        menuOpciones.add(menuItemReservaLibros);

        // Inicializar la instancia de Conexion
        conexion = new Conexion();

        // Llamar al método para actualizar la lista de libros
        actualizarListaLibros();
    }

    // Método para actualizar la lista de libros desde la base de datos
    private void actualizarListaLibros() {
        List<String> libros = conexion.obtenerLibros(); // Llamar al método obtenerLibros() en la instancia

        // Convertir la lista de libros a un array para usarlo en JList
        String[] librosArray = libros.toArray(new String[0]);

        // Configurar el modelo de lista con los libros
        listLibros.setListData(librosArray);
    }
}
