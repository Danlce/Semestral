package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Catalogo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JList<String> list;
    private List<Libro> libros;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 555, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(106, 79, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JRadioButton rdbtnAutor = new JRadioButton("Por autor");
        rdbtnAutor.setBounds(43, 117, 109, 23);
        contentPane.add(rdbtnAutor);
        rdbtnAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnAutor.isSelected()) {
                    String autor = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorAutor(autor);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnGenero = new JRadioButton("Por género");
        rdbtnGenero.setBounds(155, 117, 109, 23);
        contentPane.add(rdbtnGenero);
        rdbtnGenero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnGenero.isSelected()) {
                    String genero = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorGenero(genero);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnCodigo = new JRadioButton("Por código");
        rdbtnCodigo.setBounds(266, 117, 109, 23);
        contentPane.add(rdbtnCodigo);
        rdbtnCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnCodigo.isSelected()) {
                    String codigo = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorCodigo(codigo);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnAnio = new JRadioButton("Por año");
        rdbtnAnio.setBounds(377, 117, 109, 23);
        contentPane.add(rdbtnAnio);
        rdbtnAnio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnAnio.isSelected()) {
                    String anio = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorAnio(anio);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnEditorial = new JRadioButton("Por editorial");
        rdbtnEditorial.setBounds(43, 143, 109, 23);
        contentPane.add(rdbtnEditorial);
        rdbtnEditorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnEditorial.isSelected()) {
                    String editorial = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorEditorial(editorial);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnIdioma = new JRadioButton("Por idioma");
        rdbtnIdioma.setBounds(155, 143, 109, 23);
        contentPane.add(rdbtnIdioma);
        rdbtnIdioma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnIdioma.isSelected()) {
                    String idioma = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorIdioma(idioma);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnPrecio = new JRadioButton("Por precio");
        rdbtnPrecio.setBounds(266, 143, 109, 23);
        contentPane.add(rdbtnPrecio);
        rdbtnPrecio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnPrecio.isSelected()) {
                    String precio = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorPrecio(precio);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JRadioButton rdbtnDisponible = new JRadioButton("Por disponibilidad");
        rdbtnDisponible.setBounds(377, 143, 151, 23);
        contentPane.add(rdbtnDisponible);
        rdbtnDisponible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnDisponible.isSelected()) {
                    String disponible = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorDisponible(disponible);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(202, 78, 89, 23);
        contentPane.add(btnBuscar);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Determinar qué radio button está seleccionado y realizar la búsqueda correspondiente
                if (rdbtnAutor.isSelected()) {
                    String autor = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorAutor(autor);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnGenero.isSelected()) {
                    String genero = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorGenero(genero);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnCodigo.isSelected()) {
                    String codigo = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorCodigo(codigo);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnAnio.isSelected()) {
                    String anio = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorAnio(anio);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnEditorial.isSelected()) {
                    String editorial = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorEditorial(editorial);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnIdioma.isSelected()) {
                    String idioma = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorIdioma(idioma);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnPrecio.isSelected()) {
                    String precio = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorPrecio(precio);
                    actualizarLista(librosFiltrados);
                } else if (rdbtnDisponible.isSelected()) {
                    String disponible = textField.getText().trim();
                    List<String> librosFiltrados = filtrarPorDisponible(disponible);
                    actualizarLista(librosFiltrados);
                }
            }
        });

        list = new JList<String>();
        list.setBounds(36, 195, 471, 116);
        contentPane.add(list);

        // Supongamos que tienes una lista de libros predefinida
        libros = new ArrayList<>();
        libros.add(new Libro("Autor1", "Titulo1", "Genero1", "123", "2020"));
        libros.add(new Libro("Autor2", "Titulo2", "Genero2", "456", "2021"));
        // Agregar más libros según sea necesario
    }

    private List<String> filtrarPorAutor(String autor) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorGenero(String genero) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorCodigo(String codigo) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorAnio(String anio) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnio().equalsIgnoreCase(anio)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorEditorial(String editorial) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEditorial().equalsIgnoreCase(editorial)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorIdioma(String idioma) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getIdioma().equalsIgnoreCase(idioma)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorPrecio(String precio) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getPrecio().equalsIgnoreCase(precio)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private List<String> filtrarPorDisponible(String disponible) {
        List<String> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getDisponible().equalsIgnoreCase(disponible)) {
                resultados.add(libro.toString()); // Suponiendo que toString() de Libro retorna algo útil
            }
        }
        return resultados;
    }

    private void actualizarLista(List<String> datos) {
        list.setListData(datos.toArray(new String[0]));
    }

    // Supongamos una clase Libro de ejemplo
    private class Libro {
        private String autor;
        private String titulo;
        private String genero;
        private String codigo;
        private String anio;
        private String editorial;
        private String idioma;
        private String precio;
        private String disponible;

        public Libro(String autor, String titulo, String genero, String codigo, String anio, String editorial, String idioma, String precio, String disponible) {
            this.autor = autor;
            this.titulo = titulo;
            this.genero = genero;
            this.codigo = codigo;
            this.anio = anio;
            this.editorial = editorial;
            this.idioma = idioma;
            this.precio = precio;
            this.disponible = disponible;
        }

        public String getAutor() {
            return autor;
        }

        public String getGenero() {
            return genero;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getAnio() {
            return anio;
        }

        public String getEditorial() {
            return editorial;
        }

        public String getIdioma() {
            return idioma;
        }

        public String getPrecio() {
            return precio;
        }

        public String getDisponible() {
            return disponible;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "autor='" + autor + '\'' +
                    ", titulo='" + titulo + '\'' +
                    ", genero='" + genero + '\'' +
                    ", codigo='" + codigo + '\'' +
                    ", anio='" + anio + '\'' +
                    ", editorial='" + editorial + '\'' +
                    ", idioma='" + idioma + '\'' +
                    ", precio='" + precio + '\'' +
                    ", disponible='" + disponible + '\'' +
                    '}';
        }
    }
}
