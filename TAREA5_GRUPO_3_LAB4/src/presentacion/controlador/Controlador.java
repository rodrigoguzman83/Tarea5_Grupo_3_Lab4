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
		
		//
	}

	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		
		 ventanaPrincipal.getContentPane().removeAll();
		 ventanaPrincipal.getContentPane().add(pnlIngresarPersona);
		 ventanaPrincipal.getContentPane().repaint();
		 ventanaPrincipal.getContentPane().revalidate();
	} 
	

}
