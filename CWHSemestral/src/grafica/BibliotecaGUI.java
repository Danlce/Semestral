package grafica;

import logica.Alquiler;
import logica.Cliente;
import logica.Libro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class BibliotecaGUI extends JFrame {

    private JPanel contentPane;
    private JList<Libro> listCatalogo;
    private JList<Cliente> listClientes;
    private JList<Alquiler> listAlquileres;

    private ArrayList<Libro> catalogoLibros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquiler> alquileres;
    private JPanel panelClientesInfo;
    private JTextArea textAreaClienteInfo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BibliotecaGUI frame = new BibliotecaGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BibliotecaGUI() {
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
     // En la clase BibliotecaGUI


        JPanel panelCatalogo = new JPanel();
        panelCatalogo.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panelCatalogo, BorderLayout.WEST);
        panelCatalogo.setLayout(new BorderLayout(0, 0));

        JLabel lblCatalogo = new JLabel("Catálogo de Libros");
        lblCatalogo.setHorizontalAlignment(SwingConstants.CENTER);
        panelCatalogo.add(lblCatalogo, BorderLayout.NORTH);

        listCatalogo = new JList<>();
        listCatalogo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneCatalogo = new JScrollPane(listCatalogo);
        panelCatalogo.add(scrollPaneCatalogo, BorderLayout.CENTER);

        JPanel panelClientes = new JPanel();
        panelClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panelClientes, BorderLayout.CENTER);
        panelClientes.setLayout(new BorderLayout(0, 0));

        JLabel lblClientes = new JLabel("Clientes");
        lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
        panelClientes.add(lblClientes, BorderLayout.NORTH);

        listClientes = new JList<>();
        listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneClientes = new JScrollPane(listClientes);
        panelClientes.add(scrollPaneClientes, BorderLayout.CENTER);

        // Panel para mostrar información del cliente seleccionado
        panelClientesInfo = new JPanel();
        panelClientesInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelClientesInfo.setLayout(new BorderLayout(0, 0));
        panelClientes.add(panelClientesInfo, BorderLayout.SOUTH);

        JLabel lblInfoCliente = new JLabel("Información del Cliente");
        lblInfoCliente.setHorizontalAlignment(SwingConstants.CENTER);
        panelClientesInfo.add(lblInfoCliente, BorderLayout.NORTH);

        textAreaClienteInfo = new JTextArea();
        textAreaClienteInfo.setEditable(false);
        JScrollPane scrollPaneClienteInfo = new JScrollPane(textAreaClienteInfo);
        panelClientesInfo.add(scrollPaneClienteInfo, BorderLayout.CENTER);

        JPanel panelAlquileres = new JPanel();
        panelAlquileres.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panelAlquileres, BorderLayout.EAST);
        panelAlquileres.setLayout(new BorderLayout(0, 0));

        JLabel lblAlquileres = new JLabel("Libros Alquilados");
        lblAlquileres.setHorizontalAlignment(SwingConstants.CENTER);
        panelAlquileres.add(lblAlquileres, BorderLayout.NORTH);

        listAlquileres = new JList<>();
        listAlquileres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneAlquileres = new JScrollPane(listAlquileres);
        panelAlquileres.add(scrollPaneAlquileres, BorderLayout.CENTER);
        
        // Inicialización de listas
        catalogoLibros = new ArrayList<>();
        clientes = new ArrayList<>();
        alquileres = new ArrayList<>();

        // Ejemplo de datos iniciales
       

      
        // Actualización de listas en la GUI
        actualizarListas();

        // Manejador de selección de cliente
        listClientes.addListSelectionListener(e -> {
            Cliente clienteSeleccionado = listClientes.getSelectedValue();
            if (clienteSeleccionado != null) {
                mostrarInfoCliente(clienteSeleccionado);
            }
        });
    }

    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarAlquiler(Alquiler alquiler) {
        alquileres.add(alquiler);
    }

    private void actualizarListas() {
        listCatalogo.setListData(catalogoLibros.toArray(new Libro[0]));
        listClientes.setListData(clientes.toArray(new Cliente[0]));
        listAlquileres.setListData(alquileres.toArray(new Alquiler[0]));
    }

    private void mostrarInfoCliente(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(cliente.getNombre()).append("\n");
        sb.append("Código: ").append(cliente.getCodigo()).append("\n");

        // Aquí puedes agregar más información según sea necesario

        textAreaClienteInfo.setText(sb.toString());
    }
}
