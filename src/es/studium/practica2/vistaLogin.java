package es.studium.practica2;

import java.awt.EventQueue;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	static boolean accesoPermitido;
	static vistaLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vistaLogin();
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
	public vistaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 167, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(54, 39, 54, 16);
		contentPane.add(lblUsuario);
		
		user = new JTextField();
		user.setBounds(18, 67, 130, 26);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(43, 106, 77, 16);
		contentPane.add(lblContrasea);
		
		pass = new JTextField();
		pass.setBounds(18, 130, 130, 26);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnAceptarLogin = new JButton("Aceptar");
		btnAceptarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				 if(objetoPulsado.equals(btnAceptarLogin)) {
					 comprobarCredenciales(user.getText().toString(), pass.getText().toString());
					 
					 if(accesoPermitido == true) {
						 vistaMenu.main(null);
						 frame.dispose();
						 
					 } else {
						 vistaLoginError.main(null);
					 }
				 }
			}
		});
		btnAceptarLogin.setBounds(18, 194, 130, 29);
		contentPane.add(btnAceptarLogin);
	}
	public boolean comprobarCredenciales(String usuario,String clave)
	{
		accesoPermitido = false;
		// Conectar a la base de datos para comprobar credenciales
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/AD12_JARC";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT * FROM `DIP2-JARC`.Usuario WHERE nombreUsuario='" + usuario +"' AND claveUsuario='" +(clave) + "'";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs=null;
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url,login,password);
			statement = connection.createStatement();	
			rs=statement.executeQuery(sentencia);
			rs.next();
			if(rs.getRow()==0)
			{
				accesoPermitido=false;
			}
			else
			{
				accesoPermitido=true;
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error 1" +cnfe.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Error 2 Se produjo un error al conectar a la Base de Datos" +e.getMessage());
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
			catch(SQLException ea)
			{
				System.out.println("Error 3" +ea.getMessage());
			}
		}
		return (accesoPermitido);
		
	}
}
