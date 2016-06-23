package com.aeat.portalparejas.persistencia.dao;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;


import com.aeat.portalparejas.modelo.entidades.Persona;

@Transactional
public interface PersonaDao {

	/**
	 * Inserta en la persistencia una persona y
	 * devuelve el ID asociado a la persona.
	 * @param persona
	 * @return
	 */
	public long insertar(Persona persona);

	public void borrar(Persona persona);

	public void borrarById(long id);

	@Transactional(readOnly=true)
	public Collection<Persona> getAll();

	@Transactional(readOnly=true)
	public Persona getById(long id);

}