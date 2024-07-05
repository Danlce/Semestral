package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrosDeClientes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnEditar;
    private JButton btnAgregar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrosDeClientes frame = new RegistrosDeClientes();
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
    public RegistrosDeClientes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 467);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Lista de Clientes Actuales");
        lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 31));
        lblNewLabel.setBounds(35, 11, 337, 43);
        contentPane.add(lblNewLabel);
        
        JList list = new JList();
        list.setBounds(24, 110, 641, 229);
        contentPane.add(list);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(84, 72, 82, 27);
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(142, 77, 306, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(458, 76, 87, 23);
        contentPane.add(btnNewButton);
        
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditarClientesActuales frame = new EditarClientesActuales();
                frame.setVisible(true);
            }
        });
        btnEditar.setBounds(576, 350, 89, 23);
        contentPane.add(btnEditar);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                AgregarClientes frame = new AgregarClientes();
                frame.setVisible(true);
            }
        });
        btnAgregar.setBounds(576, 384, 89, 23);
        contentPane.add(btnAgregar);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual (RegistrosDeClientes)
                dispose();
                
                // Abrir la ventana del menú principal (MenuPrincipal)
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            }
        });
        btnRegresar.setBounds(24, 370, 93, 23);
        contentPane.add(btnRegresar);
    }
}
