package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean agregarPer(Persona personaAgregada);
	public boolean borrarPer(Persona personaEliminada);

	public boolean modificarPer(Persona personaModificada,String dniAux);
	public List<Persona> readAll();

}
