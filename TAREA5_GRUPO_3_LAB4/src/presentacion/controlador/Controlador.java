package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListarPersona;
import presentacion.vista.PanelModificarPersona;


public class Controlador implements ActionListener{
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresarPersona;
	private PanelModificarPersona pnlModificarPersona;
	private PanelListarPersona pnlListarPersona;
	private PanelEliminarPersona pnlEliminarPersona;
	private PersonaNegocio perNeg;
	private ArrayList<Persona> listaPersona;
	private DefaultListModel<Persona> listModel;
	
	
	//Constructor
	public Controlador(VentanaPrincipal vista,PersonaNegocio perNeg) 
	{
		
		//Instancias
		this.ventanaPrincipal=vista;
		this.perNeg=perNeg;
		
		
		//Instancias Paneles
		this.pnlIngresarPersona=new PanelAgregarPersona();
		this.pnlModificarPersona = new PanelModificarPersona();
		this.pnlListarPersona=new PanelListarPersona();
		this.pnlEliminarPersona = new PanelEliminarPersona();
		
		//llamado de la ventana
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a-> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		//this.ventanaPrincipal.getMntmModificar().addActionListener(m-> EventoClickMenu_AbrirPanel_ModificarPersona(m));
		this.ventanaPrincipal.getMntmListar().addActionListener(l->EventoClickMenu_AbrirPanel_Listar(l));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(e-> EventoClickMenu_AbrirPanel_ElmininarPersona(e));
		
		//llamado a la accion de los botones  
		this.pnlIngresarPersona.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPersona_PanelAgregarPersona(a));
		this.pnlEliminarPersona.getBtnEliminarUsuario().addActionListener(e->EventoClickBoton_EliminarPersona_PanelEliminarPersona(e));
		
		//this.pnlModificarPersona.getBtnModificar().addActionListener(m->EventoClickBoton_ModificarPersona_PanelModificarPersona(m));
		//
	}

	
	public void EventoClickBoton_EliminarPersona_PanelEliminarPersona(ActionEvent e) {
		
	}


	public void EventoClickMenu_AbrirPanel_ElmininarPersona(ActionEvent e) {
		// TODO Auto-generated method stub
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		pnlEliminarPersona.setListModelClear(listModel);
		 refrescarListaEliminar();
	}

	public void EventoClickMenu_AbrirPanel_Listar(ActionEvent l) {
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		listaPersona=(ArrayList<Persona>)perNeg.readAll();
		pnlListarPersona.cargarTabla(listaPersona);
	}


	public void EventoClickBoton_AgregarPersona_PanelAgregarPersona(ActionEvent a) {
		// TODO Auto-generated method stub
		String dni = this.pnlIngresarPersona.getTxtDni().getText();
		String nombre = this.pnlIngresarPersona.getTxtNombre().getText();
		String apellido = this.pnlIngresarPersona.getTxtApellido().getText();
		
		Persona nuevaPersona = new Persona(dni,nombre,apellido);
		boolean estado = perNeg.agregarPer(nuevaPersona);
		
		String mensaje ;
		
		if(estado == true) {
			mensaje = "Persona agregada con exito";
			this.pnlIngresarPersona.getTxtNombre().setText("");
			this.pnlIngresarPersona.getTxtDni().setText("");
			this.pnlIngresarPersona.getTxtApellido().setText("");
		}
		else {
			mensaje = "Persona no agregada, complete los campos";
		}
		
		this.pnlIngresarPersona.mostrarMensaje(mensaje);
	}

	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		
		 ventanaPrincipal.getContentPane().removeAll();
		 ventanaPrincipal.getContentPane().add(pnlIngresarPersona);
		 ventanaPrincipal.getContentPane().repaint();
		 ventanaPrincipal.getContentPane().revalidate();
	} 
	
 	//BOTON MODIFICAR PERSONA
	public void eventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent e) {
		String dni = this.pnlModificarPersona.getTxtDni().getText();
		String nombre = this.pnlModificarPersona.getTxtNombre().getText();
		String apellido = this.pnlModificarPersona.getTxtApellido().getText();
		
	}
	
	public void refrescarListaEliminar() {
		listaPersona=(ArrayList<Persona>) perNeg.readAll();
		for(Persona item:listaPersona) {
			listModel.addElement(item);
			pnlEliminarPersona.setListModel(listModel);
		}
	}
	//PARA EJECUTAR LA VENTANA DE AGREGAR

	//PARA INICIALIZAR LA VENTANA PRINCIPAL
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
