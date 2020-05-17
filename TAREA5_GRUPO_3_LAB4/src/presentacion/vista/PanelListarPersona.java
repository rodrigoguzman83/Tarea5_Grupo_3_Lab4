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
	private JTable table;
	private DefaultTableModel modelPersona;
	private String[] NomColumnas = {"Nombre", "Apellido","Dni"};
	
	
	public PanelListarPersona() {
		super();
		initialize();
	};
	
	public void initialize() {
		
<<<<<<< HEAD
		modelPersona = new DefaultTableModel(null,NomColumnas); 		
		setLayout(new BorderLayout(0, 0)); 		
		table = new JTable(modelPersona); 		
		table.setBounds(40, 31, 348, 235); 		 		 		
		JPanel panel = new JPanel(); 		
		panel.setBounds(10, 11, 348, 235); 		
		add(panel, BorderLayout.CENTER); 		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 		 		
		JScrollPane spPersonas = new JScrollPane(); 		
		panel.add(spPersonas); 		 		
		spPersonas.setViewportView(table); 
=======
								
		modelPersona = new DefaultTableModel(null,NomColumnas);
		setLayout(new BorderLayout(0, 0));
		table = new JTable(modelPersona);
		table.setBounds(40, 31, 348, 235);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 348, 235);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane spPersonas = new JScrollPane();
		panel.add(spPersonas);
		
		spPersonas.setViewportView(table);
		
>>>>>>> branch 'master' of https://github.com/rodrigoguzman83/Tarea5_Grupo_3_Lab4.git
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
