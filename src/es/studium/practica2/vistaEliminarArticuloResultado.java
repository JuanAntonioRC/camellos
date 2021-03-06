package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaEliminarArticuloResultado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaEliminarArticuloResultado frame;
	vistaEliminarArticuloConfirmacion vistaEliminarArticuloConfirmacion = null;
	vistaEliminarArticulo vistaEliminarArticulo = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaEliminarArticuloResultado();
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
	public vistaEliminarArticuloResultado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtculoEliminadoCon = new JLabel("Artículo eliminado con éxito");
		lblArtculoEliminadoCon.setBounds(120, 85, 237, 16);
		contentPane.add(lblArtculoEliminadoCon);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnVolver)) {
					frame.dispose();
					vistaEliminarArticuloConfirmacion.frame.dispose();
					vistaEliminarArticulo.frame.dispose();
					
					
				}
			}
		});
		btnVolver.setBounds(151, 137, 117, 29);
		contentPane.add(btnVolver);
	}

}
