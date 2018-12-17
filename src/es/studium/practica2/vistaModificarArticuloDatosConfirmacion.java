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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class vistaModificarArticuloDatosConfirmacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaModificarArticuloDatosConfirmacion frame;
	static String datos;
	static String desc;
	static String prec;
	static String cant;
	static JLabel lblDescripcin;
	static JLabel lblPrecio;
	static JLabel lblCantidad;
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
					frame = new vistaModificarArticuloDatosConfirmacion();
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
	public vistaModificarArticuloDatosConfirmacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeIntroducirnEstos = new JLabel("Se introducirán estos datos, ¿son correctos?");
		lblSeIntroducirnEstos.setBounds(81, 16, 299, 16);
		contentPane.add(lblSeIntroducirnEstos);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(33, 75, 211, 16);
		contentPane.add(lblDescripcin);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(33, 116, 61, 16);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(33, 162, 61, 16);
		contentPane.add(lblCantidad);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnAceptar)) {
					try {
						updateArticulo();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vistaModificarArticuloDatosResultado.main(null);
				}
			}
		});
		btnAceptar.setBounds(263, 225, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnCancelar)) {
				
					frame.dispose();
					
				}
				
			}
		});
		btnCancelar.setBounds(104, 225, 117, 29);
		contentPane.add(btnCancelar);
	}
	
	public static void Mostrarchoice()
	{

		desc = vistaModificarArticuloDatos.descM;
		prec = vistaModificarArticuloDatos.precM;
		cant = vistaModificarArticuloDatos.cantM;
		lblDescripcin.setText(desc);
		lblPrecio.setText(prec);
		lblCantidad.setText(cant);
	}
	
	public void updateArticulo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Double precioConver = Double.parseDouble(vistaModificarArticulo.desc);
		int stockConver = Integer.parseInt(vistaModificarArticulo.cant);
		int idParseado = Integer.parseInt(vistaModificarArticulo.id);

		Class.forName(driver).newInstance();
		Connection dbcon = DriverManager.getConnection(url, user, pass);
		Statement st = dbcon.createStatement();
		//String sentencia = "UPDATE `DIP2-JARC`.`Articulos` SET (`descripcionArticulo`, `precioArticulo`, `cantidadStockArticulo`) VALUES "
			//	+ "('" + vistaModificarArticulo.desc + "','" + precioConver + "','" + stockConver + "') WHERE idArticulos = ?";
		
		String sentencia = "UPDATE `DIP2-JARC`.`Articulos` SET `descripcionArticulo`= " + vistaModificarArticulo.desc + "," + "`precioArticulo` "+ 11 + "," + "`cantidadStockArticulo`= " + 44 + " WHERE `idArticulos`= " + 1 + ";";

		st.executeUpdate(sentencia);

	}

	
	

}
