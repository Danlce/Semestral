package grafica;

import logica.Libro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelCatalogoLibros extends JPanel {

    private ArrayList<Libro> catalogoLibros;
    private JList<Libro> listCatalogo;
    private JTextField textFieldBuscar;

    public PanelCatalogoLibros(ArrayList<Libro> catalogoLibros) {
        this.catalogoLibros = catalogoLibros; // Inicializar el atributo con el parámetro recibido
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("Catálogo de Libros");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelFiltros = new JPanel();
        panelFiltros.setBorder(new EmptyBorder(5, 0, 5, 0));
        add(panelFiltros, BorderLayout.NORTH);
        panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblBuscar = new JLabel("Buscar:");
        panelFiltros.add(lblBuscar);

        textFieldBuscar = new JTextField();
        panelFiltros.add(textFieldBuscar);
        textFieldBuscar.setColumns(20);

        JButton btnBuscar = new JButton("Buscar");
        panelFiltros.add(btnBuscar);

        listCatalogo = new JList<>();
        listCatalogo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listCatalogo);
        add(scrollPane, BorderLayout.CENTER);

        actualizarListaCatalogo();

        // Manejador para el botón de buscar
        btnBuscar.addActionListener(e -> buscarLibro());

        // Manejador para el campo de búsqueda (presionar Enter)
        textFieldBuscar.addActionListener(e -> buscarLibro());
    }

    private void actualizarListaCatalogo() {
        if (catalogoLibros != null) {
            listCatalogo.setListData(catalogoLibros.toArray(new Libro[0]));
        }
    }

    private void buscarLibro() {
        String textoBusqueda = textFieldBuscar.getText().trim().toLowerCase();

        if (textoBusqueda.isEmpty()) {
            // Si el campo de búsqueda está vacío, mostrar todos los libros
            actualizarListaCatalogo();
        } else {
            // Filtrar los libros que contienen el texto de búsqueda en el título o autor
            ArrayList<Libro> librosFiltrados = new ArrayList<>();
            for (Libro libro : catalogoLibros) {
                if (libro.getTitulo().toLowerCase().contains(textoBusqueda) ||
                        libro.getAutor().toLowerCase().contains(textoBusqueda)) {
                    librosFiltrados.add(libro);
                }
            }
            listCatalogo.setListData(librosFiltrados.toArray(new Libro[0]));
        }
    }
}
