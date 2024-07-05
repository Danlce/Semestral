package grafica;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sql.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AgregarLibros extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTitulo;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;

    // Lista de checkboxes para los géneros
    private List<JCheckBox> generoCheckboxes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgregarLibros frame = new AgregarLibros();
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
    public AgregarLibros() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCatalogoDeLibros = new JLabel("Agregar Libros");
        lblCatalogoDeLibros.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblCatalogoDeLibros.setBounds(109, 34, 315, 38);
        contentPane.add(lblCatalogoDeLibros);

        JLabel lblNewLabel_1 = new JLabel("Título:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(51, 116, 78, 20);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Autor:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(51, 147, 78, 20);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Año:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(51, 178, 65, 20);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Género:");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(289, 116, 78, 20);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Idioma:");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(51, 209, 78, 20);
        contentPane.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Precio:");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(51, 240, 78, 20);
        contentPane.add(lblNewLabel_1_5);

        txtTitulo = new JTextField();
        txtTitulo.setColumns(10);
        txtTitulo.setBounds(117, 116, 120, 20);
        contentPane.add(txtTitulo);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(117, 147, 120, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(117, 178, 120, 20);
        contentPane.add(textField_2);

        // Crear checkboxes para géneros
        generoCheckboxes = new ArrayList<>();
        JCheckBox checkBoxFiccion = new JCheckBox("Ficción");
        checkBoxFiccion.setBounds(356, 117, 80, 23);
        contentPane.add(checkBoxFiccion);
        generoCheckboxes.add(checkBoxFiccion);

        JCheckBox checkBoxNoFiccion = new JCheckBox("No ficción");
        checkBoxNoFiccion.setBounds(479, 117, 100, 23);
        contentPane.add(checkBoxNoFiccion);
        generoCheckboxes.add(checkBoxNoFiccion);

        JCheckBox checkBoxCienciaFiccion = new JCheckBox("Ciencia ficción");
        checkBoxCienciaFiccion.setBounds(356, 148, 120, 23);
        contentPane.add(checkBoxCienciaFiccion);
        generoCheckboxes.add(checkBoxCienciaFiccion);

        JCheckBox checkBoxRomance = new JCheckBox("Romance");
        checkBoxRomance.setBounds(356, 179, 80, 23);
        contentPane.add(checkBoxRomance);
        generoCheckboxes.add(checkBoxRomance);

        JCheckBox checkBoxSuspenso = new JCheckBox("Suspenso");
        checkBoxSuspenso.setBounds(479, 148, 100, 23);
        contentPane.add(checkBoxSuspenso);
        generoCheckboxes.add(checkBoxSuspenso);

        JCheckBox checkBoxTerror = new JCheckBox("Terror");
        checkBoxTerror.setBounds(479, 179, 80, 23);
        contentPane.add(checkBoxTerror);
        generoCheckboxes.add(checkBoxTerror);

        // Nuevos checkboxes para más géneros
        JCheckBox checkBoxAventura = new JCheckBox("Aventura");
        checkBoxAventura.setBounds(356, 209, 100, 23);
        contentPane.add(checkBoxAventura);
        generoCheckboxes.add(checkBoxAventura);

        JCheckBox checkBoxHistoria = new JCheckBox("Historia");
        checkBoxHistoria.setBounds(356, 240, 80, 23);
        contentPane.add(checkBoxHistoria);
        generoCheckboxes.add(checkBoxHistoria);

        JCheckBox checkBoxFantasia = new JCheckBox("Fantasía");
        checkBoxFantasia.setBounds(479, 210, 100, 23);
        contentPane.add(checkBoxFantasia);
        generoCheckboxes.add(checkBoxFantasia);

        JCheckBox checkBoxPoesia = new JCheckBox("Poesía");
        checkBoxPoesia.setBounds(479, 241, 80, 23);
        contentPane.add(checkBoxPoesia);
        generoCheckboxes.add(checkBoxPoesia);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(117, 211, 120, 20);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(117, 242, 120, 20);
        contentPane.add(textField_5);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(36, 330, 93, 23);
        contentPane.add(btnRegresar);

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText().trim();
                String autor = textField_1.getText().trim();
                String año = textField_2.getText().trim();
                String idioma = textField_4.getText().trim();
                String precio = textField_5.getText().trim();

                // Validación mínima de campos no vacíos
                if (titulo.isEmpty() || autor.isEmpty() || año.isEmpty() || idioma.isEmpty() || precio.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación del Autor
                if (!autor.matches("[a-zA-Z\\s.]+")) {
                    JOptionPane.showMessageDialog(contentPane, "El autor debe contener solo letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación del Año
                if (!año.matches("\\d+")) {
                    JOptionPane.showMessageDialog(contentPane, "El año debe contener solo números", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener los géneros seleccionados
                List<String> selectedGenres = new ArrayList<>();
                int checkedCount = 0;
                for (JCheckBox checkBox : generoCheckboxes) {
                    if (checkBox.isSelected()) {
                        selectedGenres.add(checkBox.getText());
                        checkedCount++;
                    }
                }

                // Validación de cantidad de géneros seleccionados
                if (checkedCount < 1 || checkedCount > 3) {
                    JOptionPane.showMessageDialog(contentPane, "Debe seleccionar entre 1 y 3 géneros", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación del Idioma
                if (!idioma.matches("[a-zA-Zñ]+")) {
                    JOptionPane.showMessageDialog(contentPane, "El idioma debe contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación del Precio
                if (!precio.matches("[0-9.]+")) {
                    JOptionPane.showMessageDialog(contentPane, "El precio debe contener solo números y puntos decimales", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

             // Guardar en la base de datos
                Conexion conexion = new Conexion();
                // Iterar sobre los géneros seleccionados para agregarlos uno por uno
                for (String genero : selectedGenres) {
                    conexion.insertarLibro(titulo, autor, año, genero, idioma, precio);
                    break; // Detener la iteración después de la primera inserción
                }

                // Limpiar campos después de agregar
                txtTitulo.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_4.setText("");
                textField_5.setText("");

                // Limpiar checkboxes de género
                for (JCheckBox checkBox : generoCheckboxes) {
                    checkBox.setSelected(false);
                }

                JOptionPane.showMessageDialog(contentPane, "Libro(s) agregado(s) exitosamente", "Agregado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnAgregarLibro.setBounds(539, 330, 120, 23);
        contentPane.add(btnAgregarLibro);
    }
}
