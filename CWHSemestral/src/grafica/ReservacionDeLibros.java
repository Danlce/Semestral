package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservacionDeLibros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservacionDeLibros frame = new ReservacionDeLibros();
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
	public ReservacionDeLibros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReservacion = new JLabel("Reservar Libros");
		lblReservacion.setFont(new Font("Vivaldi", Font.PLAIN, 31));
		lblReservacion.setBounds(54, 11, 315, 38);
		contentPane.add(lblReservacion);
		
		JList list = new JList();
		list.setBounds(27, 108, 300, 233);
		contentPane.add(list);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegresar.setBounds(37, 383, 93, 23);
		contentPane.add(btnRegresar);
		
		JButton btnAlquilar = new JButton("Reservar");
		btnAlquilar.setBounds(579, 383, 93, 23);
		contentPane.add(btnAlquilar);
		
		JList<String> listLibros = new JList<String>();
		listLibros.setBounds(357, 62, 337, 298);
		contentPane.add(listLibros);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Catalogo de Libros");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_1.setBounds(357, 31, 206, 20);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Lista de Clientes Actuales");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(27, 77, 206, 20);
		contentPane.add(lblNewLabel_1_1_2_1);
	}
}
