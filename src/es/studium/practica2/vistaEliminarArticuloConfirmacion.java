package es.studium.practica2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaEliminarArticuloConfirmacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaEliminarArticuloConfirmacion frame;
	static vistaEliminarArticulo vistaEliminarArticulo = null;
	int idParseado = Integer.parseInt(vistaEliminarArticulo.id);
	private final static String user = "root";
	private final static String pass = "Studium2018;";

	private static final String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/AD12_JARC";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaEliminarArticuloConfirmacion();
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
	public vistaEliminarArticuloConfirmacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeVaA = new JLabel("Se va a eliminar el siguiente artículo:");
		lblSeVaA.setBounds(23, 23, 261, 16);
		contentPane.add(lblSeVaA);
		
		JLabel lblNombreArticulo = new JLabel(vistaEliminarArticulo.id + "\n" + 
				vistaEliminarArticulo.desc + "\n" + vistaEliminarArticulo.prec +
				"\n" + vistaEliminarArticulo.cant);
		lblNombreArticulo.setBounds(96, 101, 114, 16);
		contentPane.add(lblNombreArticulo);
		
		JLabel lblNewLabel = new JLabel("¿Eliminar artículo?");
		lblNewLabel.setBounds(92, 207, 125, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnOk)) {
					
					try {
						Class.forName(driver).newInstance();
						Connection dbcon = DriverManager.getConnection(url, user, pass);
						Statement st = dbcon.createStatement();
						String sentencia = "DELETE FROM `DIP2-JARC`.`Articulos` WHERE idArticulos = ?";
						PreparedStatement PreparedStatement = dbcon.prepareStatement(sentencia);
						PreparedStatement.setInt(1, idParseado);
						PreparedStatement.executeUpdate();
						
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					vistaEliminarArticuloResultado.main(null);
				}
			}
		});
		btnOk.setBounds(151, 243, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnCancelar)) {
					frame.dispose();
				}
			}
		});
		btnCancelar.setBounds(32, 243, 117, 29);
		contentPane.add(btnCancelar);
	}
	
	public static void mostrarSelecionado() {
		String datos = vistaEliminarArticulo.ItemPulsado.getBytes().toString();
		
	}
}
