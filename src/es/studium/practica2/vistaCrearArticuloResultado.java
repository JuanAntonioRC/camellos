package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaCrearArticuloResultado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaCrearArticuloResultado frame;
	static vistaCrearArticulo vistaCrearArticulo = null;
	static vistaCrearArticuloConfirmacion vistaCrearArticuloConfirmacion = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaCrearArticuloResultado();
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
	public vistaCrearArticuloResultado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtculoCreadoCon = new JLabel("Artículo creado con exito");
		lblArtculoCreadoCon.setBounds(70, 41, 168, 16);
		contentPane.add(lblArtculoCreadoCon);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnVolver)) {
					
					frame.dispose();
					vistaCrearArticulo.frame.dispose();
					vistaCrearArticuloConfirmacion.frame.dispose();
					
					
				}
			}
		});
		btnVolver.setBounds(90, 69, 117, 29);
		contentPane.add(btnVolver);
	}

}
