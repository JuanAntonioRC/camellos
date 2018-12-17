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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class vistaCrearTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField numeroAnadir;
	static vistaCrearTicket frame;
	static String datos;
	static Choice choice;
	static public String ItemPulsado;
	static public String id;
	static public String desc;
	static public String prec;
	static public String cant;
	static JTextArea textArea;
	static public int numerAnadirParseado;
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
					frame = new vistaCrearTicket();
					frame.setVisible(true);
					Mostrarchoice(choice);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vistaCrearTicket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 321, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(44, 189, 117, 29);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnCancelar)) {
					frame.dispose();
				}
			}
			
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(158, 189, 117, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnAceptar)) {
					vistaCrearTicketConfirmacion.main(null);
				}
			}
			
		});
		
		
		JLabel lblArtculo = new JLabel("Artículo");
		lblArtculo.setBounds(23, 40, 61, 16);
		contentPane.add(lblArtculo);
		
		choice = new Choice();
		choice.setBounds(77, 29, 129, 39);
		contentPane.add(choice);
		
		numeroAnadir = new JTextField();
		numeroAnadir.setBounds(212, 35, 39, 26);
		contentPane.add(numeroAnadir);
		numeroAnadir.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnNewButton)) {
					parsear();
					ItemPulsado = choice.getSelectedItem();	
					for (int i = 0; i < numerAnadirParseado; i ++)
					textArea.append(ItemPulsado + "\n");
					
				}
			}
		});
		btnNewButton.setBounds(258, 35, 39, 29);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(33, 95, 247, 82);
		contentPane.add(textArea);
	}
	
	public static Choice Mostrarchoice(Choice choice)
	{
		Connection connection = null;
		Statement statement;
		ResultSet rs;
		try
		{
			String sentencia = "SELECT * FROM `DIP2-JARC`.Articulos;";
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, user, pass);
			//Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			//executeQuery para los select
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				datos= Integer.toString(rs.getInt("idArticulos"));
				datos= datos + "-" + rs.getString("descripcionArticulo");
				datos= datos + "-" + rs.getString("precioArticulo");
				datos= datos + "-" + rs.getString("cantidadStockArticulo");
				choice.add(datos);
				
				ItemPulsado = choice.getSelectedItem();

				String [] parts = ItemPulsado.split("-");
				id = parts[0];
				desc = parts[1];
				prec = parts[2];
				cant = parts[3];

			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3-"+e.getMessage());
			}
		}
		return choice;
	}
	
	public static void parsear() {
		
		String numeroAnadirDatos = numeroAnadir.getText().toString();
		numerAnadirParseado = Integer.parseInt(numeroAnadirDatos);
		
	}

}
