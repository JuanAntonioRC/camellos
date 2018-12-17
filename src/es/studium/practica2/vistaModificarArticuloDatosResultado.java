package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaModificarArticuloDatosResultado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaModificarArticuloDatosResultado frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaModificarArticuloDatosResultado();
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
	public vistaModificarArticuloDatosResultado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeHaModificado = new JLabel("Se ha modificado con exito");
		lblSeHaModificado.setBounds(127, 77, 195, 16);
		contentPane.add(lblSeHaModificado);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnVolver)) {
					
					frame.dispose();
					vistaModificarArticuloDatosConfirmacion.frame.dispose();
					vistaModificarArticuloDatos.frame.dispose();
					vistaModificarArticulo.frame.dispose();
				}
			}
		});
		btnVolver.setBounds(169, 167, 117, 29);
		contentPane.add(btnVolver);
	}

}
