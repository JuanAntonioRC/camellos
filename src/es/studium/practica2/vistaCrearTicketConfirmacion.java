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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class vistaCrearTicketConfirmacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaCrearTicketConfirmacion frame;
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
					frame = new vistaCrearTicketConfirmacion();
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
	public vistaCrearTicketConfirmacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLosDatosDel = new JLabel("Los datos del ticket son:");
		lblLosDatosDel.setBounds(38, 46, 155, 16);
		contentPane.add(lblLosDatosDel);

		JLabel lblNmeroDeArtculos = new JLabel("Artículos en el ticket");
		lblNmeroDeArtculos.setBounds(38, 97, 220, 16);
		contentPane.add(lblNmeroDeArtculos);

		JLabel lblcrearTicket = new JLabel("¿Crear ticket?");
		lblcrearTicket.setBounds(165, 201, 139, 16);
		contentPane.add(lblcrearTicket);

		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnNo)) {
					frame.dispose();
				}
			}
		});
		btnNo.setBounds(151, 229, 55, 29);
		contentPane.add(btnNo);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnOk)) {
					insertTicket();
					vistaCrearTicketResultado.main(null);
				}
			}
		});
		btnOk.setBounds(218, 229, 55, 29);
		contentPane.add(btnOk);
	}

	public static void insertTicket()
	{
		Connection connection = null;
		Statement statement;
		ResultSet rs;
		try
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now));  


			String sentenciaInsert = "INSERT INTO `DIP2-JARC`.`Tickets` (`fechaTicket`, `totalTicket`)  VALUES " + "('" + dtf.format(now) + "','" + vistaCrearTicket.totalTicket + "');";

			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, user, pass);
			//Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			statement.executeUpdate(sentenciaInsert);

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
	}
}
