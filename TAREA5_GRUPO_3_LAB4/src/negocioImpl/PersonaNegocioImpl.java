package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDao pdao = new PersonaDaoImpl();

	@Override
	public boolean agregarPer(Persona personaAgregada) {
		boolean estado = false;
		if(personaAgregada.getNombre().trim().length()>0 && personaAgregada.getApellido().trim().length()>0 && personaAgregada.getDni().trim().length()>0) {
			estado=pdao.agregarPer(personaAgregada);
		}
		return estado;
	}

	@Override
	public boolean borrarPer(Persona personaEliminada) {
		boolean estado= false;
		if(personaEliminada.getDni().trim().length()>0) {
			estado=pdao.borrarPer(personaEliminada); 
		}
		return estado; 
	}

	@Override
	public boolean modificarPer(Persona personaModificada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

}
