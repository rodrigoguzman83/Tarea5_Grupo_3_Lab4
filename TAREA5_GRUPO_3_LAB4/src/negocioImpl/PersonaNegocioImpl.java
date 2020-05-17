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
		// TODO Auto-generated method stub
		boolean estado = false;
		if(personaAgregada.getNombre().trim().length()>0 && personaAgregada.getApellido().trim().length()>0 && personaAgregada.getDni().trim().length()>0) {
			estado=pdao.agregarPer(personaAgregada);
		}
		return estado;
	}

	@Override
	public boolean borrarPer(Persona personaEliminada) {
		// TODO Auto-generated method stub
		return false;
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
