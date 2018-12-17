package es.studium.practica2;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaEliminarArticulo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	static String datos;
	static Choice choice;
	static public String ItemPulsado;
	static public String id;
	static public String desc;
	static public String prec;
	static public String cant;
	static vistaEliminarArticulo frame;
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
					frame = new vistaEliminarArticulo();
					frame.setVisible(true);
					Mostrarchoice(choice);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


	public vistaEliminarArticulo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdDelTicket = new JLabel("Seleccione el artículo");
		lblIdDelTicket.setBounds(97, 20, 143, 16);
		contentPane.add(lblIdDelTicket);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();

				if(objetoPulsado.equals(btnEliminar)) {

					ItemPulsado = choice.getSelectedItem();

					String [] parts = ItemPulsado.split("-");
					id = parts[0];
					desc = parts[1];
					prec = parts[2];
					cant = parts[3];
					vistaEliminarArticuloConfirmacion.main(null);

				}

			}
		});
		btnEliminar.setBounds(190, 121, 80, 29);
		contentPane.add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnCancelar)) {
					frame.dispose();
				}
			}
		});
		btnCancelar.setBounds(68, 122, 80, 26);
		contentPane.add(btnCancelar);

		choice= new Choice();
		choice.setBounds(100, 61, 135, 27);
		contentPane.add(choice);
		choice.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				
			}

		});
	}

	public static Choice Mostrarchoice(Choice choice)
	{
		Connection connection = null;
		Statement statement;
		ResultSet rs;
		try
		{
			choice.removeAll();
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


}
