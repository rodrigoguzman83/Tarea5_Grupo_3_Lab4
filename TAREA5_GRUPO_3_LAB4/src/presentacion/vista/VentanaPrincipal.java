package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 414);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAgregarPersona pnlAgregarPersona = new PanelAgregarPersona();
				contentPane.removeAll();
				contentPane.add(pnlAgregarPersona);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelModificarPersona pnlModificarPersona = new PanelModificarPersona();
				contentPane.removeAll();
				contentPane.add(pnlModificarPersona);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mntmEliminar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnPersona.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
	}
}
