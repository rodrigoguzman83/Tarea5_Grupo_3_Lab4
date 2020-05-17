package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersona;


public class Controlador implements ActionListener{
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresarPersona;
	private PersonaNegocio perNeg;
	
	//Constructor
	public Controlador(VentanaPrincipal vista,PersonaNegocio perNeg) 
	{
		
		//Instancias
		this.ventanaPrincipal=vista;
		this.perNeg=perNeg;
		
		//Instancias Paneles
		this.pnlIngresarPersona=new PanelAgregarPersona();
		
		//llamado de la ventana
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a-> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		
		//llamado a la accion del boton AGREGAR de Panel Agregar Persona
		this.pnlIngresarPersona.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPersona_PanelAgregarPersona(a));
		
		//
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
