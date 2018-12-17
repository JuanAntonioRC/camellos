package es.studium.practica2;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class vistaModificarArticuloDatos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txDescricpion;
	private static JTextField txPrecio;
	private static JTextField txStock;
	static String datos;
	static String desc;
	static String prec;
	static String cant;
	static String descM;
	static String precM;
	static String cantM;
	static vistaModificarArticuloDatos frame;
	static vistaModificarArticulo vistaModificarArticulo = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaModificarArticuloDatos();
					frame.setVisible(true);
					Mostrarchoice();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vistaModificarArticuloDatos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescriocin = new JLabel("Descripción");
		lblDescriocin.setBounds(47, 56, 75, 16);
		contentPane.add(lblDescriocin);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(47, 108, 61, 16);
		contentPane.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(47, 163, 61, 16);
		contentPane.add(lblCantidad);

		txDescricpion = new JTextField();
		txDescricpion.setBounds(162, 103, 130, 26);
		contentPane.add(txDescricpion);
		txDescricpion.setColumns(10);

		txPrecio = new JTextField();
		txPrecio.setBounds(162, 158, 130, 26);
		contentPane.add(txPrecio);
		txPrecio.setColumns(10);

		txStock = new JTextField();
		txStock.setBounds(162, 51, 130, 26);
		contentPane.add(txStock);
		txStock.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(175, 243, 117, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();

				if(objetoPulsado.equals(btnAceptar)) {
					
					conseguirValores();
					vistaModificarArticuloDatosConfirmacion.main(null);
				}
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(46, 243, 117, 29);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();

				if(objetoPulsado.equals(btnCancelar)) {
					frame.dispose();
				}

			}

		});
	}
	public static void Mostrarchoice()
	{

		desc = vistaModificarArticulo.desc;
		txDescricpion.setText(desc);

		prec = vistaModificarArticulo.prec;
		txPrecio.setText(prec);

		cant = vistaModificarArticulo.cant;
		txStock.setText(cant);

	}
	
	public static void conseguirValores() {
		
		descM = txDescricpion.getText().toString();
		precM = txPrecio.getText().toString();
		cantM = txStock.getText().toString();
		
	}




}
