package grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import logica.Libro;

public class MostrarDetallesLibro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panelDetallesLibro;
    private JLabel lblNewLabel;

    public MostrarDetallesLibro(Libro libro) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambiar a DISPOSE_ON_CLOSE para no cerrar toda la aplicación
        setBounds(100, 100, 719, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel para mostrar detalles del libro seleccionado
        panelDetallesLibro = new JPanel();
        panelDetallesLibro.setBounds(30, 42, 647, 223);
        panelDetallesLibro.setBorder(BorderFactory.createTitledBorder("Detalles del Libro"));
        panelDetallesLibro.setLayout(new GridLayout(0, 2, 10, 10));
        contentPane.add(panelDetallesLibro);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(588, 276, 89, 23);
        contentPane.add(btnCerrar);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\US\\Downloads\\fondo-digital-abstracto-textura-placa-circuito-tecnologia-ilustracion-placa-base-electronica-concepto-comunicacion-e-ingenieria-ilustracion-vectorial_41981-1917.jpg"));
        lblNewLabel.setBounds(-31, -88, 828, 430);
        contentPane.add(lblNewLabel);

        // Agregar ActionListener para el botón Cerrar
        btnCerrar.addActionListener(e -> {
            // Cerrar la ventana al hacer clic en el botón Cerrar
            dispose();
        });

        mostrarDetallesLibro(libro);
    }

    private void mostrarDetallesLibro(Libro libro) {
        // Limpiar el panel de detalles antes de mostrar uno nuevo
        panelDetallesLibro.removeAll();

        // Título
        panelDetallesLibro.add(new JLabel("Título:"));
        panelDetallesLibro.add(new JLabel(libro.getTitulo()));

        // Autor
        panelDetallesLibro.add(new JLabel("Autor:"));
        panelDetallesLibro.add(new JLabel(libro.getAutor()));

        // Género
        panelDetallesLibro.add(new JLabel("Género:"));
        panelDetallesLibro.add(new JLabel(libro.getGenero()));

        // Año
        panelDetallesLibro.add(new JLabel("Año:"));
        panelDetallesLibro.add(new JLabel(String.valueOf(libro.getAnio())));

        // Idioma
        panelDetallesLibro.add(new JLabel("Idioma:"));
        panelDetallesLibro.add(new JLabel(libro.getIdioma()));

        // Precio
        double precio = libro.getPrecio();
        String precioFormateado = String.format("%.2f", precio);
        panelDetallesLibro.add(new JLabel("Precio:"));
        panelDetallesLibro.add(new JLabel("$ " + precioFormateado));

        // Disponible
        panelDetallesLibro.add(new JLabel("Disponible:"));
        panelDetallesLibro.add(new JLabel(libro.isDisponible() ? "Sí" : "No"));

        // Actualizar el panel
        panelDetallesLibro.revalidate();
        panelDetallesLibro.repaint();
    }
}
