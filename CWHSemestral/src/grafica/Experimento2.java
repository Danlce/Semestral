package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.Connexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Experimento2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Experimento2 frame = new Experimento2();
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
	public Experimento2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {   
					String bases = "";
				
					Statement sql = Connexion.getConexion().createStatement();
					String consulta = "SELECT name FROM master.dbo.sysdatabases";
					ResultSet resultado = sql.executeQuery(consulta);
					
					while(resultado.next()) {
						
					bases += resultado.getString(1) + "\n";	
				}
					JOptionPane.showMessageDialog(null, bases);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			}		
			
		});
		btnConectar.setBounds(156, 139, 89, 23);
		contentPane.add(btnConectar);
	}
}
