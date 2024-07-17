package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class Presentacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentacion frame = new Presentacion();
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
	public Presentacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Universidad Tecnológica de Panamá");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(232, 11, 292, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblFacultadDeIngenieria = new JLabel("Facultad de ingenieria de sistema computacional");
		lblFacultadDeIngenieria.setForeground(new Color(255, 255, 255));
		lblFacultadDeIngenieria.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblFacultadDeIngenieria.setBounds(189, 44, 349, 50);
		contentPane.add(lblFacultadDeIngenieria);
		
		JLabel lblLicenciaturaEnIngeniera = new JLabel("Licenciatura en Ingeniería de Software");
		lblLicenciaturaEnIngeniera.setForeground(new Color(255, 255, 255));
		lblLicenciaturaEnIngeniera.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLicenciaturaEnIngeniera.setBounds(226, 72, 349, 50);
		contentPane.add(lblLicenciaturaEnIngeniera);
		
		JLabel lblIntegrantes = new JLabel("Integrantes:");
		lblIntegrantes.setForeground(new Color(255, 255, 255));
		lblIntegrantes.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblIntegrantes.setBounds(159, 117, 108, 50);
		contentPane.add(lblIntegrantes);
		
		JLabel lblEmmanuelHernndez = new JLabel("Emmanuel Hernández 8-1028-609");
		lblEmmanuelHernndez.setForeground(new Color(255, 255, 255));
		lblEmmanuelHernndez.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEmmanuelHernndez.setBounds(232, 160, 349, 50);
		contentPane.add(lblEmmanuelHernndez);
		
		JLabel lblWilsonWang = new JLabel("Wilson Wang 8-1016-822");
		lblWilsonWang.setForeground(new Color(255, 255, 255));
		lblWilsonWang.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblWilsonWang.setBounds(232, 191, 349, 50);
		contentPane.add(lblWilsonWang);
		
		JLabel lblWilliamConcepcion = new JLabel("William concepcion 8-1083-2003");
		lblWilliamConcepcion.setForeground(new Color(255, 255, 255));
		lblWilliamConcepcion.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblWilliamConcepcion.setBounds(232, 221, 349, 50);
		contentPane.add(lblWilliamConcepcion);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setForeground(new Color(255, 255, 255));
		lblProfesor.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblProfesor.setBounds(159, 259, 349, 50);
		contentPane.add(lblProfesor);
		
		JLabel lblRodrigoYngez = new JLabel("Rodrigo Yángüez");
		lblRodrigoYngez.setForeground(new Color(255, 255, 255));
		lblRodrigoYngez.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblRodrigoYngez.setBounds(232, 292, 349, 50);
		contentPane.add(lblRodrigoYngez);
		
		JLabel lblGrupo = new JLabel("Grupo:     1SF-121");
		lblGrupo.setForeground(new Color(255, 255, 255));
		lblGrupo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblGrupo.setBounds(438, 117, 137, 50);
		contentPane.add(lblGrupo);
		
		JLabel lblProfesor_1 = new JLabel("17-7-2024");
		lblProfesor_1.setForeground(new Color(255, 255, 255));
		lblProfesor_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblProfesor_1.setBounds(436, 332, 102, 50);
		contentPane.add(lblProfesor_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\image_2024-07-16_235335253.png"));
		lblNewLabel_1.setBounds(528, 0, 119, 135);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\image_2024-07-16_235514454.png"));
		lblNewLabel_2.setBounds(75, 11, 141, 104);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 43));
		btnNewButton.setBounds(603, 395, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\mysql-connector-j-9.0.0\\diagrama-circuito-tecnologia-azul-lineas-brillantes_1017-25619.jpg"));
		lblNewLabel_3.setBounds(0, 0, 734, 454);
		contentPane.add(lblNewLabel_3);
	}
}
