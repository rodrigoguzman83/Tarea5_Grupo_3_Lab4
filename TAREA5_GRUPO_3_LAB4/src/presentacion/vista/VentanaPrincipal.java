package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mntmAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		mntmAgregar = new JMenuItem("Agregar");
		mnPersona.add(mntmAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnPersona.add(mntmModificar);
		
		mntmListar=new JMenuItem("Listar");
		mnPersona.add(mntmListar);
		
		
		
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelEliminarPersona pnlEliminarPersona = new PanelEliminarPersona();
				contentPane.removeAll();
				contentPane.add(pnlEliminarPersona);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mntmEliminar);
		
//		JMenuItem mntmListar = new JMenuItem("Listar");
//		mntmListar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PanelListarPersona pnlListarPersona = new PanelListarPersona();
//				contentPane.removeAll();
//				contentPane.add(pnlListarPersona);
//				contentPane.repaint();
//				contentPane.revalidate();
//			}
//		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

	}
	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}
	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}
	public JMenu getMnPersona() {
		return mnPersona;
	}

	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}

	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}

	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}
	public JMenuItem getMntmListar() {
		return mntmListar;
	}
	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

}
