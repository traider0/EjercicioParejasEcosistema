package com.aeat.portalparejas.modelo.servicios;

import java.util.Collection;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.modelo.negocio.Reglas;
import com.aeat.portalparejas.persistencia.dao.PersonaDao;

public interface ServicioParejas {

	public void setDao(PersonaDao dao);
	
	public void setReglas(Reglas reglas);
	
	public long insert(Persona persona);
	
	public void borrar(Persona persona);
	
	public void borrarById(long id);
	
	public Collection<Persona> getAll();
	
	public Persona getById(long id);
	
	public Persona getIdeal(Persona persona);

	public Collection<Persona> getAfines(Persona persona);

}