package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelModificarPersona extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;

	/**
	 * Create the panel.
	 */
	public PanelModificarPersona() {
		setLayout(null);
		
		JLabel lblSeleccioneLasPersonas = new JLabel("Seleccione las personas que quiere modificar");
		lblSeleccioneLasPersonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccioneLasPersonas.setBounds(74, 21, 329, 26);
		add(lblSeleccioneLasPersonas);
		
		JList listModificar = new JList();
		listModificar.setBounds(10, 54, 433, 172);
		add(listModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 247, 101, 18);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(117, 247, 101, 18);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(224, 247, 101, 18);
		add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(346, 247, 97, 18);
		add(btnModificar);

	}
}
