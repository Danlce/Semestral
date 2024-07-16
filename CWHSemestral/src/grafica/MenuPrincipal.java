package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Libreria Wilberto el mas maricon ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 31));
		lblNewLabel.setBounds(260, 21, 397, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscador:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(141, 77, 109, 29);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(219, 83, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Buscar");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica de búsqueda
			}
		});
		btnNewButton_6.setBounds(442, 82, 89, 23);
		contentPane.add(btnNewButton_6);
		
		List list = new List();
		list.setBounds(229, 112, 530, 237);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\pppppp.jpg"));
		lblNewLabel_2.setBounds(-19, -49, 852, 451);
		contentPane.add(lblNewLabel_2);
		
		// Crear la barra de menú
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Menú "Opciones"
		JMenu menuOpciones = new JMenu("Menu");
		menuBar.add(menuOpciones);
		
		// Opción "Registros de Clientes"
		JMenuItem menuItemRegistrosDeClientes = new JMenuItem("Registros de Clientes");
		menuItemRegistrosDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para abrir la ventana de registros de clientes
				RegistrosDeClientes ventanaRegistrosDeClientes = new RegistrosDeClientes();
				ventanaRegistrosDeClientes.setVisible(true);
				// Cerrar la ventana principal
				dispose();
			}
		});
		menuOpciones.add(menuItemRegistrosDeClientes);
		
		// Opción "Catálogo de libros"
		JMenuItem menuItemCatalogo = new JMenuItem("Catálogo de libros");
		menuItemCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para abrir la ventana de catálogo de libros
				Catalogo ventanaCatalogo = new Catalogo();
				ventanaCatalogo.setVisible(true);
				// Cerrar la ventana principal
				dispose();
			}
		});
		menuOpciones.add(menuItemCatalogo);
	}
}
