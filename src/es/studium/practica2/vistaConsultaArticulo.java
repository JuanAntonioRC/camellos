package es.studium.practica2;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;





public class vistaConsultaArticulo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static vistaConsultaArticulo frame;
	static Statement statement = null;
	static Connection connection = null;
	static ResultSet rs = null;
	static Document documento = new Document();
	static File path = new File ("fichero.pdf"); 
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
					frame = new vistaConsultaArticulo();
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
	public vistaConsultaArticulo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblgenerarPdf = new JLabel("¿Generar PDF?");
		lblgenerarPdf.setBounds(170, 54, 116, 16);
		contentPane.add(lblgenerarPdf);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(btnAceptar)) {
					try {
						generarPDF();
					} catch (SQLException | DocumentException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
				}
				
			}
		});
		btnAceptar.setBounds(158, 150, 117, 29);
		contentPane.add(btnAceptar);
	}
	
	public void generarPDF () throws SQLException, DocumentException, IOException
	{
		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");
		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
		String l=null;		
		Connection con = DriverManager.getConnection(url, user, pass);
		statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs= statement.executeQuery("SELECT * FROM `DIP2-JARC`.Articulos;");
		while(rs.next())
		{
			l= Integer.toString(rs.getInt("idArticulos"));
			l= l + "-" + rs.getString("descripcionArticulo");
			l= l + "-" + rs.getString("precioArticulo");
			l= l + "-" + rs.getString("cantidadStockArticulo");

			documento.open();
			documento.add(new Paragraph(l));
		}
	
		documento.close();
		// Y ahora abrimos el fichero para mostrarlo
		Desktop.getDesktop().open(path);
	}

}
