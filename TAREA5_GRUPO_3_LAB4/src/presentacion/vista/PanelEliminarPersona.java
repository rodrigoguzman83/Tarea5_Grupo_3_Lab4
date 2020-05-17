package presentacion.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;

public class PanelEliminarPersona extends JPanel {
	private JButton btnEliminarUsuario;
	private JList<Persona> JlistEliminarUsuarios;
	private DefaultListModel<Persona> listModel;
	private static final long serialVersionUID = 1L;

	public PanelEliminarPersona() { 
		super();
		initialize();
	}
	
	public JButton getBtnEliminarUsuario() {
		return btnEliminarUsuario;
	}

	public void setBtnEliminarUsuario(JButton btnEliminarUsuario) {
		this.btnEliminarUsuario = btnEliminarUsuario;
	}

	public JList<Persona> getJlistEliminarUsuarios() {
		return JlistEliminarUsuarios;
	}

	public void setJlistEliminarUsuarios(JList<Persona> jlistEliminarUsuarios) {
		JlistEliminarUsuarios = jlistEliminarUsuarios;
	}
	
	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
	}
	
	public void setListModelClear(DefaultListModel<Persona> listModel) {	
		listModel.clear();
		this.JlistEliminarUsuarios.setModel(listModel);
	}

	private void initialize() {
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
		
		JlistEliminarUsuarios = new JList<Persona>();
		GridBagConstraints gbc_JlistEliminarUsuarios = new GridBagConstraints();
		gbc_JlistEliminarUsuarios.gridwidth = 3;
		gbc_JlistEliminarUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_JlistEliminarUsuarios.fill = GridBagConstraints.BOTH;
		gbc_JlistEliminarUsuarios.gridx = 1;
		gbc_JlistEliminarUsuarios.gridy = 1;
		add(JlistEliminarUsuarios, gbc_JlistEliminarUsuarios);
		
		btnEliminarUsuario = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminarUsuario = new GridBagConstraints();
		gbc_btnEliminarUsuario.gridwidth = 3;
		gbc_btnEliminarUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminarUsuario.gridx = 1;
		gbc_btnEliminarUsuario.gridy = 2;
		add(btnEliminarUsuario, gbc_btnEliminarUsuario);
		
	}
	
	
	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
