package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelModificarPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private String dniAux;
	private JButton btnModificar;
	private JList<Persona> JListaModificarUsuario;
	private DefaultListModel<Persona> listModel;

	/**
	 * Create the panel.
	 */

	public PanelModificarPersona() {
		super();
		initialize();
	}

	public String getDniAux() {
		return dniAux;
	}

	public void setDniAux(String dniAux) {
		this.dniAux = dniAux;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String nombre) {
		txtNombre.setText(nombre);
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(String apellido) {
		txtApellido.setText(apellido);
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(String dni) {
		txtDni.setText(dni);
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JList<Persona> getListaModificarUsuario() {
		return JListaModificarUsuario;
	}

	public void setListaModificarUsuario(JList<Persona> listaModificarUsuario) {
		this.JListaModificarUsuario = listaModificarUsuario;
	}

	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
	}

	public void setListModelClear(DefaultListModel<Persona> listModel) {
		listModel.clear();
		this.JListaModificarUsuario.setModel(listModel);
	}

	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 101, 101, 101, 97, 0 };
		gridBagLayout.rowHeights = new int[] { 26, 172, 18, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblSeleccioneLasPersonas = new JLabel("Seleccione las personas que quiere modificar");
		lblSeleccioneLasPersonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSeleccioneLasPersonas = new GridBagConstraints();
		gbc_lblSeleccioneLasPersonas.fill = GridBagConstraints.VERTICAL;
		gbc_lblSeleccioneLasPersonas.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccioneLasPersonas.gridwidth = 4;
		gbc_lblSeleccioneLasPersonas.gridx = 0;
		gbc_lblSeleccioneLasPersonas.gridy = 0;
		add(lblSeleccioneLasPersonas, gbc_lblSeleccioneLasPersonas);

		JListaModificarUsuario = new JList<Persona>();
		/*
		 * JListaModificarUsuario.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { } });
		 */

		GridBagConstraints gbc_listModificar = new GridBagConstraints();
		gbc_listModificar.fill = GridBagConstraints.BOTH;
		gbc_listModificar.insets = new Insets(0, 0, 5, 0);
		gbc_listModificar.gridwidth = 4;
		gbc_listModificar.gridx = 0;
		gbc_listModificar.gridy = 1;
		add(JListaModificarUsuario, gbc_listModificar);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.insets = new Insets(0, 0, 0, 5);
		gbc_txtNombre.gridx = 0;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.BOTH;
		gbc_txtApellido.insets = new Insets(0, 0, 0, 5);
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 2;
		add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.BOTH;
		gbc_txtDni.insets = new Insets(0, 0, 0, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.anchor = GridBagConstraints.WEST;
		gbc_btnModificar.fill = GridBagConstraints.VERTICAL;
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 2;
		add(btnModificar, gbc_btnModificar);
	}

	public JList<Persona> getList() {
		// TODO Auto-generated method stub
		return JListaModificarUsuario;
	}

	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
