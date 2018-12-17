package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaCrearTicketConfirmacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaCrearTicketConfirmacion frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaCrearTicketConfirmacion();
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
	public vistaCrearTicketConfirmacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLosDatosDel = new JLabel("Los datos del ticket son:");
		lblLosDatosDel.setBounds(38, 46, 155, 16);
		contentPane.add(lblLosDatosDel);
		
		JLabel lblNmeroDeArtculos = new JLabel("Artículos en el ticket");
		lblNmeroDeArtculos.setBounds(38, 97, 220, 16);
		contentPane.add(lblNmeroDeArtculos);
		
		JLabel lblcrearTicket = new JLabel("¿Crear ticket?");
		lblcrearTicket.setBounds(165, 201, 139, 16);
		contentPane.add(lblcrearTicket);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnNo)) {
					frame.dispose();
				}
			}
		});
		btnNo.setBounds(151, 229, 55, 29);
		contentPane.add(btnNo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnOk)) {
					vistaCrearTicketResultado.main(null);
				}
			}
		});
		btnOk.setBounds(218, 229, 55, 29);
		contentPane.add(btnOk);
	}

}
