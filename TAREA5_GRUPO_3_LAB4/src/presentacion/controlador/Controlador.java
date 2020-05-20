package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresarPersona;
	private PanelModificarPersona pnlModificarPersona;
	private PanelListarPersona pnlListarPersona;
	private PanelEliminarPersona pnlEliminarPersona;
	private MouseListener Click;
	private PersonaNegocio perNeg;
	private JList<Persona> listadoPersona;
	private ArrayList<Persona> listaPersona;
	private DefaultListModel<Persona> listModel;

	// Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio perNeg) {

		// Instancias
		this.ventanaPrincipal = vista;
		this.perNeg = perNeg;
		listModel = new DefaultListModel<Persona>();

		// Instancias Paneles
		this.pnlIngresarPersona = new PanelAgregarPersona();
		this.pnlModificarPersona = new PanelModificarPersona();
		this.pnlListarPersona = new PanelListarPersona();
		this.pnlEliminarPersona = new PanelEliminarPersona();

		// llamado de la ventana
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(m -> EventoClickMenu_AbrirPanel_ModificarPersona(m));
		this.ventanaPrincipal.getMntmListar().addActionListener(l -> EventoClickMenu_AbrirPanel_Listar(l));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(e -> EventoClickMenu_AbrirPanel_ElmininarPersona(e));

		// llamado a la accion de los botones
		this.pnlIngresarPersona.getBtnAceptar()
				.addActionListener(a -> EventoClickBoton_AgregarPersona_PanelAgregarPersona(a));
		this.pnlEliminarPersona.getBtnEliminarUsuario()
				.addActionListener(e -> EventoClickBoton_EliminarPersona_PanelEliminarPersona(e));
		this.pnlModificarPersona.getBtnModificar()
				.addActionListener(m -> EventoClickBoton_ModificarPersona_PanelModificarPersona(m));
		eventList();
		// llamado a la accion mouseclick

	}

	public void EventoClickBoton_EliminarPersona_PanelEliminarPersona(ActionEvent e) {
		boolean estado = false;
		Persona person = this.pnlEliminarPersona.getJlistEliminarUsuarios().getSelectedValue();

		estado = perNeg.borrarPer(person);
		String mensaje;
		if (estado == true) {
			mensaje = "Persona eliminada con exito ";
		} else {
			mensaje = "No se pudo eliminar la persona";
		}

		this.pnlEliminarPersona.mostrarMensaje(mensaje);
		refrescarListaEliminar();
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
		listaPersona = (ArrayList<Persona>) perNeg.readAll();
		pnlListarPersona.cargarTabla(listaPersona);
	}

	public void EventoClickBoton_AgregarPersona_PanelAgregarPersona(ActionEvent a) {
		// TODO Auto-generated method stub
		String dni = this.pnlIngresarPersona.getTxtDni().getText();
		String nombre = this.pnlIngresarPersona.getTxtNombre().getText();
		String apellido = this.pnlIngresarPersona.getTxtApellido().getText();

		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		boolean estado = perNeg.agregarPer(nuevaPersona);

		String mensaje;

		if (estado == true) {
			mensaje = "Persona agregada con exito";
			this.pnlIngresarPersona.getTxtNombre().setText("");
			this.pnlIngresarPersona.getTxtDni().setText("");
			this.pnlIngresarPersona.getTxtApellido().setText("");
		} else {
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

	// BOTON DEL PANEL MODIFICAR PERSONA
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent e) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		pnlModificarPersona.setListModelClear(listModel);
		refrescarListaModificar();
	}

	public void EventoClickLista_SeleccionarPersona_PanelModificarPersona() {
		Persona persona = new Persona();
		if (pnlModificarPersona.getList().getSelectedValue() != null) {
			persona = this.pnlModificarPersona.getList().getSelectedValue();
			pnlModificarPersona.setTxtNombre(persona.getNombre());
		}

	}

	public void EventoClickBoton_ModificarPersona_PanelModificarPersona(ActionEvent m) {
		String dni = this.pnlModificarPersona.getTxtDni().getText();
		String nombre = this.pnlModificarPersona.getTxtNombre().getText();
		String apellido = this.pnlModificarPersona.getTxtApellido().getText();
		String dniAux = this.pnlModificarPersona.getDniAux();

		Persona modPersona = new Persona(dni, nombre, apellido);
		boolean estado = perNeg.modificarPer(modPersona,dniAux);

		String mensaje;

		if (estado == true) {
			mensaje = "Persona modificada con exito";
			this.pnlModificarPersona.getTxtNombre().setText("");
			this.pnlModificarPersona.getTxtDni().setText("");
			this.pnlModificarPersona.getTxtApellido().setText("");
		} else {
			mensaje = "Persona no modificada, complete los campos";
		}

		this.pnlModificarPersona.mostrarMensaje(mensaje);
		refrescarListaModificar();
	}

	public void refrescarListaModificar() {
		listaPersona = (ArrayList<Persona>) perNeg.readAll();
		listModel.clear();
		for (Persona item : listaPersona) {
			listModel.addElement(item);
		}
		pnlModificarPersona.setListModel(listModel);
	}

	public void refrescarListaEliminar() {
		listaPersona = (ArrayList<Persona>) perNeg.readAll();
		listModel.clear();
		for (Persona item : listaPersona) {
			listModel.addElement(item);
		}
		pnlEliminarPersona.setListModel(listModel);
	}
	// PARA EJECUTAR LA VENTANA DE AGREGAR

	// PARA INICIALIZAR LA VENTANA PRINCIPAL
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public MouseListener getClick() {
		return Click;
	}

	public void setClick(MouseListener click) {
		Click = click;
	}

	// @override
	// probar con el MouseListener
	public void Click(MouseEvent e) {
		Persona per = new Persona();
		per = listadoPersona.getSelectedValue();
		pnlModificarPersona.setTxtNombre(per.getNombre());
	}

	public void eventList() {

		this.pnlModificarPersona.getListaModificarUsuario().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				Persona per = new Persona();
				JList<Persona> list = pnlModificarPersona.getListaModificarUsuario();
				per = list.getSelectedValue();
				pnlModificarPersona.setTxtNombre(per.getNombre());
				pnlModificarPersona.setTxtApellido(per.getApellido());
				pnlModificarPersona.setTxtDni(per.getDni());
				pnlModificarPersona.setDniAux(per.getDni());

			}
		});

	}
}
