package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaCrearArticulo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static public JTextField txDescripcion;
	static public JTextField txPrecio;
	static public JTextField txStock;
	static vistaCrearArticulo frame;
	static public String desc;
	static public String prec;
	static public String stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaCrearArticulo();
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
	public vistaCrearArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Precio ");
		lblNewLabel.setBounds(30, 95, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcinArtculo = new JLabel("Descripción");
		lblDescripcinArtculo.setBounds(30, 67, 90, 16);
		contentPane.add(lblDescripcinArtculo);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(30, 123, 61, 16);
		contentPane.add(lblStock);
		
		txDescripcion = new JTextField();
		txDescripcion.setBounds(132, 62, 130, 26);
		contentPane.add(txDescripcion);
		txDescripcion.setColumns(10);
		
		txPrecio = new JTextField();
		txPrecio.setBounds(132, 90, 130, 26);
		contentPane.add(txPrecio);
		txPrecio.setColumns(10);
		
		txStock = new JTextField();
		txStock.setBounds(132, 118, 130, 26);
		contentPane.add(txStock);
		txStock.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnCancelar)) {
					
					frame.dispose();
				}
				
			}
		});
		btnCancelar.setBounds(30, 196, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnAceptar)) {
					
					desc = txDescripcion.getText().toString();
					prec = txPrecio.getText().toString();
					stock = txStock.getText().toString();
					System.out.println(desc + prec+ stock);
					vistaCrearArticuloConfirmacion.main(null);
					
				}
			}
		});
		btnAceptar.setBounds(145, 196, 117, 29);
		contentPane.add(btnAceptar);
	}
	
	public void ponerVariables() {
		
		
		
	}
}
