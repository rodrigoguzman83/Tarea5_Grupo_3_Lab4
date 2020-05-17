package presentacion.vista;
import entidad.Persona;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PanelListarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagLayout gridBagLayout;
	private JTable table;
	private DefaultTableModel modelPersona;
	private String[] NomColumnas = {"Nombre", "Apellido","Dni"};

	
	
	public PanelListarPersona() {
		super();
		initialize();
	};
	
	public void initialize() {
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 247, 0};
		gridBagLayout.rowHeights = new int[]{30, 235, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JScrollPane spPersonas = new JScrollPane();
		
		
		modelPersona = new DefaultTableModel(null,NomColumnas);
		table = new JTable(modelPersona);
		spPersonas.setViewportView(table);
		
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelPersona() {
		return modelPersona;
	}

	public void setModelPersona(DefaultTableModel modelPersona) {
		this.modelPersona = modelPersona;
	}
	public String[] getNomColumnas() {
		return NomColumnas;
	}

	public void setNomColumnas(String[] nomColumnas) {
		NomColumnas = nomColumnas;
	}

	
	public void cargarTabla(ArrayList<Persona> Personas) 
	{
		this.getModelPersona().setRowCount(0);
		this.getModelPersona().setColumnCount(0);
		this.getModelPersona().setColumnIdentifiers(this.getNomColumnas());
			
		for(Persona per: Personas) 
		{
			String Nombre=per.getNombre();
			String Apellido=per.getApellido();
			String Dni=per.getDni();
			Object[] Fila = {Nombre, Apellido, Dni};
			this.getModelPersona().addRow(Fila);
			
		}
	
			
	}
		

}
