package es.studium.practica2;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class vistaCrearArticuloConfirmacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaCrearArticuloConfirmacion frame;
	vistaCrearArticulo vistaCrearArticulo = null;
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
					frame = new vistaCrearArticuloConfirmacion();
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
	public vistaCrearArticuloConfirmacion() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLosDatosDel = new JLabel("Los datos del artículo son: ");
		lblLosDatosDel.setBounds(25, 24, 206, 16);
		contentPane.add(lblLosDatosDel);
		
		JLabel lblDescripcin = new JLabel(vistaCrearArticulo.desc);
		lblDescripcin.setBounds(26, 64, 164, 117);
		contentPane.add(lblDescripcin);
		

		JLabel lblPrecio = new JLabel(vistaCrearArticulo.prec);
		lblPrecio.setBounds(25, 189, 61, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidadEnStock = new JLabel(vistaCrearArticulo.stock);
		lblCantidadEnStock.setBounds(25, 217, 128, 16);
		contentPane.add(lblCantidadEnStock);
		
		JLabel lblcrearCliente = new JLabel("¿Crear artículo?");
		lblcrearCliente.setBounds(174, 265, 108, 16);
		contentPane.add(lblcrearCliente);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnNo)) {
					
					frame.dispose();
				}
				
			}
		});
		btnNo.setBounds(153, 288, 66, 29);
		contentPane.add(btnNo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(btnOk)) {
					
					try {
						altaArticulo();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					vistaCrearArticuloResultado.main(null);
				
					
				}
			}
		});
		btnOk.setBounds(217, 288, 75, 29);
		contentPane.add(btnOk);
	}
	
	public void altaArticulo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int precioConver = Integer.parseInt(vistaCrearArticulo.prec);
		int stockConver = Integer.parseInt(vistaCrearArticulo.stock);

		Class.forName(driver).newInstance();
		Connection dbcon = DriverManager.getConnection(url, user, pass);
		Statement st = dbcon.createStatement();
		String sentencia = "INSERT INTO `DIP2-JARC`.`Articulos` (`descripcionArticulo`, `precioArticulo`, `cantidadStockArticulo`) VALUES " + "('" + vistaCrearArticulo.desc + "','" + precioConver + "','" + stockConver + "');";
		
		st.executeUpdate(sentencia);

	}
	

}
