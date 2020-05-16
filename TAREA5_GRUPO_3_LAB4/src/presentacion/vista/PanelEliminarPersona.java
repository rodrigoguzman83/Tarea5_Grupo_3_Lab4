package presentacion.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import entidad.Persona;

public class PanelEliminarPersona extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelEliminarPersona() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 101, 0, 101, 97, 0};
		gridBagLayout.rowHeights = new int[]{26, 172, 18, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		GridBagConstraints gbc_lblEliminarUsuarios = new GridBagConstraints();
		gbc_lblEliminarUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblEliminarUsuarios.gridx = 1;
		gbc_lblEliminarUsuarios.gridy = 0;
		add(lblEliminarUsuarios, gbc_lblEliminarUsuarios);
		
		JList<Persona> JlistEliminarUsuarios = new JList<Persona>();
		GridBagConstraints gbc_JlistEliminarUsuarios = new GridBagConstraints();
		gbc_JlistEliminarUsuarios.gridwidth = 3;
		gbc_JlistEliminarUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_JlistEliminarUsuarios.fill = GridBagConstraints.BOTH;
		gbc_JlistEliminarUsuarios.gridx = 1;
		gbc_JlistEliminarUsuarios.gridy = 1;
		add(JlistEliminarUsuarios, gbc_JlistEliminarUsuarios);
		
		JButton btnEliminarUsuario = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminarUsuario = new GridBagConstraints();
		gbc_btnEliminarUsuario.gridwidth = 3;
		gbc_btnEliminarUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminarUsuario.gridx = 1;
		gbc_btnEliminarUsuario.gridy = 2;
		add(btnEliminarUsuario, gbc_btnEliminarUsuario);
	}

}
