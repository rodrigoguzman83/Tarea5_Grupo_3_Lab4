package presentacion.vista;
import entidad.Persona;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class PanelListarPersona extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelListarPersona(ArrayList<Persona> Personas) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 247, 0};
		gridBagLayout.rowHeights = new int[]{30, 235, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//Creo el iterator y el modelo que recibe el JTable
		Iterator<Persona> ListaPersona = Personas.iterator();
		DefaultTableModel tabla = new DefaultTableModel();

		//Cargo el modelo con el Iterator
		while(ListaPersona.hasNext()) {
			tabla.addRow(ListaPersona.next());
		}
		
		
		JTable table = new JTable(tabla);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);
	}
	
	


}
