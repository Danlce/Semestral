package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Libro;
import logica.Cliente;
import logica.Alquiler;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BibliotecaGUI extends JFrame {
    private ArrayList<Libro> catalogoLibros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquiler> registros;

    public BibliotecaGUI() {
        catalogoLibros = new ArrayList<>();
        clientes = new ArrayList<>();
        registros = new ArrayList<>();

        // Inicializar la interfaz gráfica
        initComponents();
    }

    private void initComponents() {
        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sistema de Biblioteca");
        setSize(600, 400);

        // Crear componentes como botones, listas, etc.
        // Aquí deberías incluir los componentes que permitan mostrar y gestionar los datos
        // del catálogo de libros, perfiles de clientes y registros de alquiler.

        // Ejemplo: crear una lista de libros
        JList<String> listaLibros = new JList<>();
        DefaultListModel<String> modelLibros = new DefaultListModel<>();
        for (Libro libro : catalogoLibros) {
            modelLibros.addElement(libro.getTitulo());
        }
        getContentPane().setLayout(null);
        listaLibros.setModel(modelLibros);

        // Agregar la lista a un JScrollPane y añadirlo al JFrame
        JScrollPane scrollPane = new JScrollPane(listaLibros);
        scrollPane.setBounds(0, 0, 584, 361);
        getContentPane().add(scrollPane);

        // Otros componentes como botones, campos de texto, etc.

        // Mostrar la interfaz gráfica
        setVisible(true);
    }

    // Métodos para agregar libros, clientes, y registros de alquiler
    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarAlquiler(Alquiler registro) {
        registros.add(registro);
    }

    // Otros métodos según las operaciones que quieras permitir en la interfaz
    // como alquilar libro, devolver libro, etc.
}
