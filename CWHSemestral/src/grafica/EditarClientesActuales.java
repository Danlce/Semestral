package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

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
		setBounds(100, 100, 690, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditando = new JLabel("Editar Clientes Actuales");
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(34, 111, 78, 20);
		contentPane.add(lblNewLabel);
		
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(34, 142, 78, 20);
		contentPane.add(lblTelefono);
		
		lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(34, 173, 78, 20);
		contentPane.add(lblDireccion);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(19, 329, 93, 23);
		contentPane.add(btnRegresar);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(544, 329, 120, 23);
		contentPane.add(btnGuardarCambios);
		
		JList list = new JList();
		list.setBounds(262, 91, 387, 219);
		contentPane.add(list);
	}
}
