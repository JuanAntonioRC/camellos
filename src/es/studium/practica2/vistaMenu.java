package es.studium.practica2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaMenu frame = new vistaMenu();
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
	public vistaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtculo = new JMenu("Artículo");
		menuBar.add(mnArtculo);
		
		JMenuItem mntmCrearArtculo = new JMenuItem("Crear artículo");
		mnArtculo.add(mntmCrearArtculo);
		mntmCrearArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(mntmCrearArtculo)) {
					
					vistaCrearArticulo.main(null);
					
					
				}
			}
		});
		
		
		JMenuItem mntmEliminarArtculo = new JMenuItem("Eliminar artículo");
		mnArtculo.add(mntmEliminarArtculo);
		mntmEliminarArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(mntmEliminarArtculo)) {
					
					vistaEliminarArticulo.main(null);
					
				}
				
			}
			
		});
		
		JMenuItem mntmModificarArtculo = new JMenuItem("Modificar artículo");
		mnArtculo.add(mntmModificarArtculo);
		mntmModificarArtculo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(mntmModificarArtculo)) {
					vistaModificarArticulo.main(null);
				}

			}
			
		});
		
		JMenuItem mntmConsultarArtculo = new JMenuItem("Consultar artículo");
		mnArtculo.add(mntmConsultarArtculo);
		mntmConsultarArtculo.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				
				if(objetoPulsado.equals(mntmConsultarArtculo)) {
					vistaConsultaArticulo.main(null);
				}
			}
			
		});
		
		JMenu mnTickets = new JMenu("Tickets");
		menuBar.add(mnTickets);
		
		JMenuItem mntmCrearTicket = new JMenuItem("Crear ticket");
		mnTickets.add(mntmCrearTicket);
		mntmCrearTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(mntmCrearTicket)) {
					vistaCrearTicket.main(null);
				}
			}
			
		});
		
		JMenuItem mntmConsultarTicket = new JMenuItem("Consultar ticket");
		mnTickets.add(mntmConsultarTicket);
		mntmConsultarTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(mntmConsultarTicket)) {
					vistaConsultaTicket.main(null);
				}
			}
			
		});
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Object objetoPulsado = e.getSource();
				if(objetoPulsado.equals(mnSalir)) {
					System.exit(0);
					
				}
				
			}
			
		});
		
		JLabel lblBi = new JLabel("Bienvenido a su aplicación de gestión");
		lblBi.setBounds(101, 112, 236, 34);
		contentPane.add(lblBi);
	}
}
