package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sql.Conexion;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EditarClientesActuales extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblNewLabel;
    private JLabel lblTelefono;
    private JLabel lblDireccion;
    private JButton btnRegresar;
    private JButton btnGuardarCambios;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditarClientesActuales frame = new EditarClientesActuales();
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
    public EditarClientesActuales() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 736, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEditando = new JLabel("Editar Clientes Actuales");
        lblEditando.setForeground(new Color(255, 255, 255));
        lblEditando.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblEditando.setBounds(76, 21, 315, 59);
        contentPane.add(lblEditando);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(107, 111, 120, 20);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(107, 142, 120, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(107, 173, 120, 20);
        contentPane.add(textField_2);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(34, 111, 78, 20);
        contentPane.add(lblNewLabel);

        lblTelefono = new JLabel("Teléfono");
        lblTelefono.setForeground(new Color(255, 255, 255));
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTelefono.setBounds(34, 142, 78, 20);
        contentPane.add(lblTelefono);

        lblDireccion = new JLabel("Dirección");
        lblDireccion.setForeground(new Color(255, 255, 255));
        lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDireccion.setBounds(34, 173, 78, 20);
        contentPane.add(lblDireccion);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(34, 368, 93, 23);
        contentPane.add(btnRegresar);

        btnGuardarCambios = new JButton("Guardar Cambios");
        btnGuardarCambios.setBounds(566, 368, 120, 23);
        contentPane.add(btnGuardarCambios);

        // Crear el modelo para la lista
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(262, 111, 424, 234);
        contentPane.add(list);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(262, 368, 93, 23);
        contentPane.add(btnBorrar);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\diagrama-circuito-tecnologia-azul-lineas-brillantes_1017-25619.jpg"));
        lblNewLabel_1.setBounds(-15, -51, 895, 493);
        contentPane.add(lblNewLabel_1);

        // Obtener los datos de los clientes y agregarlos al modelo de la lista
        Conexion conexion = new Conexion();
        List<String> clientes = conexion.obtenerClientes();
        for (String cliente : clientes) {
            listModel.addElement(cliente);
        }

        // Agregar ActionListener para el botón Borrar
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedValue = listModel.getElementAt(selectedIndex);
                    String nombre = selectedValue.split("\\s+")[0];

                    int confirm = JOptionPane.showConfirmDialog(contentPane, "¿Estás seguro de que deseas borrar al cliente " + nombre + "?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        conexion.borrarCliente(nombre);
                        listModel.removeElementAt(selectedIndex);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, seleccione un cliente de la lista para borrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar ActionListener para el botón Guardar Cambios
        btnGuardarCambios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedValue = listModel.getElementAt(selectedIndex);
                    String nombreOriginal = selectedValue.split("\\s+")[0];
                    String telefonoOriginal = selectedValue.split("\\s+")[1];
                    String direccionOriginal = selectedValue.split("\\s+")[2];

                    String nuevoNombre = textField.getText().trim();
                    String nuevoTelefono = textField_1.getText().trim();
                    String nuevaDireccion = textField_2.getText().trim();

                    if (!nuevoNombre.isEmpty() && !nuevoNombre.matches("[a-zA-Z\\s]+")) {
                        JOptionPane.showMessageDialog(contentPane, "El nombre no debe contener números ni caracteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!nuevoTelefono.isEmpty() && !nuevoTelefono.matches("[0-9-]+")) {
                        JOptionPane.showMessageDialog(contentPane, "El teléfono solo debe contener números y el carácter especial '-'", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!nuevoNombre.isEmpty() || !nuevoTelefono.isEmpty() || !nuevaDireccion.isEmpty()) {
                        if (nuevoNombre.isEmpty()) nuevoNombre = nombreOriginal;
                        if (nuevoTelefono.isEmpty()) nuevoTelefono = telefonoOriginal;
                        if (nuevaDireccion.isEmpty()) nuevaDireccion = direccionOriginal;

                        conexion.actualizarCliente(nombreOriginal, nuevoNombre, nuevoTelefono, nuevaDireccion);

                        listModel.setElementAt(nuevoNombre + " " + nuevoTelefono + " " + nuevaDireccion, selectedIndex);

                        textField.setText("");
                        textField_1.setText("");
                        textField_2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese al menos un dato a actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, seleccione un cliente de la lista", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar ActionListener para el botón Regresar
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Volver a la ventana de RegistrosDeClientes
                RegistrosDeClientes frame = new RegistrosDeClientes();
                frame.setVisible(true);
            }
        });
    }
}
