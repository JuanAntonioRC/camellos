package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaCrearTicketResultado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaCrearTicketResultado frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaCrearTicketResultado();
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
	public vistaCrearTicketResultado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 241, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTicketCreadoCon = new JLabel("Ticket creado con exito");
		lblTicketCreadoCon.setBounds(43, 55, 154, 16);
		contentPane.add(lblTicketCreadoCon);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnVolver)) {
					frame.dispose();
				}
			}
		});
		btnVolver.setBounds(63, 83, 117, 29);
		contentPane.add(btnVolver);
	}

}
