package grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import logica.Libro;
import sql.Conexion;
import java.awt.Color;

public class Catalogo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JList<String> list;
    private Conexion conexion;
    private MostrarDetallesLibro detallesFrame; // Referencia al frame de detalles abierto
    private ButtonGroup radioButtonGroup;

    private JRadioButton rdbtnAutor;
    private JRadioButton rdbtnCodigo;
    private JRadioButton rdbtnAnio;
    private JRadioButton rdbtnIdioma;

    private MenuPrincipal menuPrincipal; // Referencia al frame de MenuPrincipal

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

        JButton btnBuscar_1 = new JButton("Lista Normal");
        btnBuscar_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarLibros(); // Cargar la lista completa de libros nuevamente
            }
        });
        
        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Cerrar la ventana actual
                    dispose();

                    // Abrir la ventana de AgregarLibros
                    AgregarLibros agregarLibros = new AgregarLibros();
                    agregarLibros.setVisible(true);
                }
            });
        btnAgregarLibro.setBackground(Color.WHITE);
        btnAgregarLibro.setBounds(456, 376, 110, 23);
        contentPane.add(btnAgregarLibro);
        btnBuscar_1.setBackground(new Color(255, 255, 255));
        btnBuscar_1.setBounds(456, 146, 110, 23);
        contentPane.add(btnBuscar_1);

        textField = new JTextField();
        textField.setBounds(139, 84, 259, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        rdbtnAutor = new JRadioButton("Por autor");
        rdbtnAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
        rdbtnAutor.setBounds(353, 146, 79, 23);
        contentPane.add(rdbtnAutor);

        rdbtnCodigo = new JRadioButton("Por código");
        rdbtnCodigo.setBounds(32, 146, 89, 23);
        contentPane.add(rdbtnCodigo);

        rdbtnAnio = new JRadioButton("Por año");
        rdbtnAnio.setBounds(257, 146, 73, 23);
        contentPane.add(rdbtnAnio);

        rdbtnIdioma = new JRadioButton("Por idioma");
        rdbtnIdioma.setBounds(139, 146, 89, 23);
        contentPane.add(rdbtnIdioma);

        // Agrupar los radio botones
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(rdbtnAutor);
        radioButtonGroup.add(rdbtnCodigo);
        radioButtonGroup.add(rdbtnAnio);
        radioButtonGroup.add(rdbtnIdioma);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(255, 255, 255));
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
        btnBorrar.setBackground(new Color(255, 255, 255));
        btnBorrar.setBounds(620, 146, 89, 23);
        contentPane.add(btnBorrar);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(22, 376, 89, 23);
        contentPane.add(btnRegresar);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\remix-digital-geografia-vector-fondo-globo-educacion-disruptiva_53876-140586.jpg"));
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

        // Action Listener para el botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado en el campo de búsqueda
                String criterio = textField.getText().trim();

                // Verificar que el campo de búsqueda no esté vacío
                if (criterio.isEmpty()) {
                    // Mostrar mensaje de advertencia
                    JOptionPane.showMessageDialog(contentPane,
                            "Debe ingresar un criterio de búsqueda antes de buscar.",
                            "Campo de Búsqueda Vacío",
                            JOptionPane.WARNING_MESSAGE);

                    return; // Salir del método sin hacer nada más
                }

                // Verificar que se haya seleccionado algún criterio de búsqueda
                if (!radioButtonGroup.isSelected(rdbtnAutor.getModel()) &&
                        !radioButtonGroup.isSelected(rdbtnCodigo.getModel()) &&
                        !radioButtonGroup.isSelected(rdbtnAnio.getModel()) &&
                        !radioButtonGroup.isSelected(rdbtnIdioma.getModel())) {

                    // Mostrar mensaje de advertencia
                    JOptionPane.showMessageDialog(contentPane,
                            "Debe seleccionar un criterio de búsqueda antes de buscar.",
                            "Criterio de Búsqueda No Seleccionado",
                            JOptionPane.WARNING_MESSAGE);

                    return; // Salir del método sin hacer nada más
                }

                filtrarLibros();
            }
        });

        // Action Listener para el botón Regresar
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();

                // Abrir la ventana de MenuPrincipal si está creada
                if (menuPrincipal == null) {
                    menuPrincipal = new MenuPrincipal();
                }
                menuPrincipal.setVisible(true);
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

    // Método para filtrar libros según el criterio seleccionado
    private void filtrarLibros() {
        String criterio = textField.getText().trim();
        List<String> librosFiltrados = null;

        if (criterio.isEmpty()) {
            cargarLibros();
            return;
        }

        if (radioButtonGroup.getSelection() != null) {
            if (radioButtonGroup.isSelected(rdbtnAutor.getModel())) {
                librosFiltrados = conexion.obtenerLibrosPorAutor(criterio);
            } else if (radioButtonGroup.isSelected(rdbtnCodigo.getModel())) {
                librosFiltrados = conexion.obtenerLibrosPorCodigo(criterio); // Assuming 'criterio' is book ID
            } else if (radioButtonGroup.isSelected(rdbtnAnio.getModel())) {
                librosFiltrados = conexion.obtenerLibrosPorAnio(Integer.parseInt(criterio));
            } else if (radioButtonGroup.isSelected(rdbtnIdioma.getModel())) {
                librosFiltrados = conexion.obtenerLibrosPorIdioma(criterio);
            }
        }

        if (librosFiltrados != null && !librosFiltrados.isEmpty()) {
            // Construir lista con el mismo formato "ID: Título"
            String[] librosArray = new String[librosFiltrados.size()];
            for (int i = 0; i < librosFiltrados.size(); i++) {
                String libro = librosFiltrados.get(i);
                // Aquí asumimos que el formato devuelto por la base de datos ya es "ID: Título"
                librosArray[i] = libro;
            }
            list.setListData(librosArray);
        } else {
            list.setListData(new String[]{"No se encontraron resultados"});
        }
    }
}
