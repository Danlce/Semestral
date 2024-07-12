package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import logica.Libro;
import sql.Conexion;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

public class Catalogo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JList<String> list;
    private Conexion conexion;
    private MostrarDetallesLibro detallesFrame; // Referencia al frame de detalles abierto

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Catalogo frame = new Catalogo();
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
    public Catalogo() {
        conexion = new Conexion(); // Instancia de la clase Conexion
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 752, 461);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(139, 84, 259, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JRadioButton rdbtnAutor = new JRadioButton("Por autor");
        rdbtnAutor.setBounds(32, 146, 73, 23);
        contentPane.add(rdbtnAutor);

        JRadioButton rdbtnGenero = new JRadioButton("Por género");
        rdbtnGenero.setBounds(258, 146, 80, 23);
        contentPane.add(rdbtnGenero);

        JRadioButton rdbtnCodigo = new JRadioButton("Por código");
        rdbtnCodigo.setBounds(107, 146, 80, 23);
        contentPane.add(rdbtnCodigo);

        JRadioButton rdbtnAnio = new JRadioButton("Por año");
        rdbtnAnio.setBounds(189, 146, 63, 23);
        contentPane.add(rdbtnAnio);

        JRadioButton rdbtnIdioma = new JRadioButton("Por idioma");
        rdbtnIdioma.setBounds(344, 146, 80, 23);
        contentPane.add(rdbtnIdioma);

        JRadioButton rdbtnPrecio = new JRadioButton("Por precio");
        rdbtnPrecio.setBounds(426, 146, 73, 23);
        contentPane.add(rdbtnPrecio);

        JRadioButton rdbtnDisponible = new JRadioButton("Por disponibilidad");
        rdbtnDisponible.setBackground(new Color(70, 130, 180));
        rdbtnDisponible.setForeground(new Color(255, 255, 255));
        rdbtnDisponible.setBounds(501, 146, 109, 23);
        contentPane.add(rdbtnDisponible);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(51, 51, 255));
        btnBuscar.setBounds(408, 83, 89, 23);
        contentPane.add(btnBuscar);

        list = new JList<String>();
        list.setBounds(22, 176, 687, 189);
        contentPane.add(list);

        JLabel lblNewLabel = new JLabel("Buscador:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(67, 85, 73, 14);
        contentPane.add(lblNewLabel);

        JLabel lblCatalogoDeLibros = new JLabel("Catalogo de Libros");
        lblCatalogoDeLibros.setForeground(new Color(255, 255, 255));
        lblCatalogoDeLibros.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblCatalogoDeLibros.setBounds(32, 30, 315, 38);
        contentPane.add(lblCatalogoDeLibros);

        JButton btnMostrar = new JButton("Mostrar Detalles");
        btnMostrar.setBackground(new Color(102, 153, 255));
        btnMostrar.setBounds(589, 376, 120, 23);
        contentPane.add(btnMostrar);
        
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnBorrar.setBackground(new Color(153, 102, 255));
        btnBorrar.setBounds(620, 146, 89, 23);
        contentPane.add(btnBorrar);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(22, 376, 89, 23);
        contentPane.add(btnRegresar);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\US\\Downloads\\remix-digital-geografia-vector-fondo-globo-educacion-disruptiva_53876-140586.jpg"));
        lblNewLabel_1.setBounds(0, -21, 864, 475);
        contentPane.add(lblNewLabel_1);

        // Action Listener para el botón Mostrar Detalles
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si ya hay una instancia abierta y cerrarla
                if (detallesFrame != null && detallesFrame.isVisible()) {
                    detallesFrame.dispose();
                }
                mostrarDetallesLibro();
            }
        });

        // Cargar libros al inicio
        cargarLibros();
    }

    // Método para cargar los libros desde la base de datos y actualizar la lista
    private void cargarLibros() {
        List<String> libros = conexion.obtenerLibros();
        list.setListData(libros.toArray(new String[0]));
    }

    // Método para mostrar los detalles del libro seleccionado
    private void mostrarDetallesLibro() {
        String selectedBook = list.getSelectedValue();
        if (selectedBook != null && !selectedBook.isEmpty()) {
            // Obtener el ID del libro seleccionado (asumiendo que está al inicio del string)
            int idLibro = Integer.parseInt(selectedBook.split(":")[0].trim());
            // Obtener los detalles del libro desde la base de datos
            Libro libro = conexion.obtenerLibroPorId(idLibro);
            // Mostrar detalles en un nuevo frame de MostrarDetallesLibro
            detallesFrame = new MostrarDetallesLibro(libro);
            detallesFrame.setVisible(true);
        }
    }
}
