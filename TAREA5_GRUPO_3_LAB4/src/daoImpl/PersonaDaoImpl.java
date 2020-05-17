package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao
{
 private static final String agregarPer="INSERT INTO Personas(Dni,Nombre,Apellido)values(?,?,?)";
 //private static final String borrarPer="DELETE FROM Personas WHERE Dni=?";
 //private static final String modificarPer="UPDATE Personas set Nombre=?, Apellido=? WHERE Dni=?";
 private static final String readAll="SELECT * FROM Personas";

 public boolean agregarPer(Persona persona) 
 {
 	PreparedStatement statement;
 	Connection conexion=Conexion.getConexion().getSQLConexion();
 	boolean isInsertExitoso=false;
 	try 
 	{
 		statement=conexion.prepareStatement(agregarPer);
 		statement.setString(1, persona.getDni());
 		statement.setString(2,persona.getNombre());
 		statement.setString(3, persona.getApellido());
 		if(statement.executeUpdate()> 0) 
 		{
 			conexion.commit();
 			isInsertExitoso=true;
 		}
 		
 	}catch(Exception ex) 
 	{
 		ex.printStackTrace();
 		try {
 			conexion.rollback();
 		}catch (Exception ex1) {
 			ex1.printStackTrace();
 		}
 	}
 	return isInsertExitoso;
 	
 }
 /*public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}*/

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
	PreparedStatement statement;
	ResultSet resultSet;
	ArrayList<Persona> Personas = new ArrayList<Persona>();
 	Conexion conexion = Conexion.getConexion();
 	try 
 	{
 		statement=conexion.getSQLConexion().prepareStatement(readAll);
 		resultSet = statement.executeQuery();
 		while(resultSet.next()) {
 			Personas.add(getPersona(resultSet));
 		}
 	}
 	catch(SQLException ex) 
 	{
 		ex.printStackTrace();
 	}
 	return Personas;
}
private Persona getPersona(ResultSet resultSet) throws SQLException {
	String DNI = resultSet.getString("Dni");
	String Nombre = resultSet.getString("Nombre");
	String Apellido = resultSet.getString("Apellido");
	
	return new Persona(DNI, Nombre, Apellido);
}

 
 
 
}


