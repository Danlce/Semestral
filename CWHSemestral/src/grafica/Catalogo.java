package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.SystemColor;

public class Catalogo extends JFrame {

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
		contentPane.setForeground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Por autor");
		rdbtnNewRadioButton.setBounds(43, 117, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(43, 82, 65, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(106, 79, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnGenero = new JRadioButton("Genero");
		rdbtnGenero.setBounds(155, 117, 109, 23);
		contentPane.add(rdbtnGenero);
		
		JRadioButton rdbtnCodigo = new JRadioButton("Codigo");
		rdbtnCodigo.setBounds(266, 117, 109, 23);
		contentPane.add(rdbtnCodigo);
		
		JRadioButton rdbtnAo = new JRadioButton("Año");
		rdbtnAo.setBounds(377, 117, 109, 23);
		contentPane.add(rdbtnAo);
		
		JRadioButton rdbtnEditoria = new JRadioButton("Editoria");
		rdbtnEditoria.setBounds(43, 143, 109, 23);
		contentPane.add(rdbtnEditoria);
		
		JRadioButton rdbtnIdioma = new JRadioButton("Idioma");
		rdbtnIdioma.setBounds(155, 143, 109, 23);
		contentPane.add(rdbtnIdioma);
		
		JRadioButton rdbtnPrecio = new JRadioButton("Precio");
		rdbtnPrecio.setBounds(266, 143, 109, 23);
		contentPane.add(rdbtnPrecio);
		
		JRadioButton rdbtnPaguinas = new JRadioButton("Disponible");
		rdbtnPaguinas.setBounds(377, 143, 109, 23);
		contentPane.add(rdbtnPaguinas);
		
		JList list = new JList();
		list.setBounds(36, 195, 471, 116);
		contentPane.add(list);
	}
}
