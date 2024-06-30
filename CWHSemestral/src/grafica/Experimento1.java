package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Experimento1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Experimento1 frame = new Experimento1();
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
	public Experimento1() {
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 414);
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 109, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(46, 112, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Argegar libros");
		lblNewLabel_1.setBackground(new Color(0, 64, 0));
		lblNewLabel_1.setBounds(196, 31, 231, 50);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Volumen");
		lblNewLabel_2.setBounds(46, 143, 67, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Autor");
		lblNewLabel_3.setBounds(46, 182, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(134, 140, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 179, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Año");
		lblNewLabel_3_1.setBounds(46, 216, 46, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Editorial");
		lblNewLabel_3_2.setBounds(46, 250, 46, 14);
		getContentPane().add(lblNewLabel_3_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 213, 86, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(134, 247, 86, 20);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo");
		lblNewLabel_4.setBounds(46, 282, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(134, 278, 86, 20);
		getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("Agregar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(406, 328, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(43, 328, 89, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblNewLabel_5 = new JLabel("Paguinas ");
		lblNewLabel_5.setBounds(284, 112, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Genero");
		lblNewLabel_5_1.setBounds(284, 143, 86, 14);
		getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Idioma");
		lblNewLabel_5_2.setBounds(284, 182, 86, 14);
		getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Precio");
		lblNewLabel_5_3.setBounds(284, 216, 86, 14);
		getContentPane().add(lblNewLabel_5_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(341, 109, 86, 20);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(341, 140, 86, 20);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(341, 179, 86, 20);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(341, 213, 86, 20);
		getContentPane().add(textField_9);
	}
}
