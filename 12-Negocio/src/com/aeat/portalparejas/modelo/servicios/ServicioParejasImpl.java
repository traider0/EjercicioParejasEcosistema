package com.aeat.portalparejas.modelo.servicios;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.modelo.negocio.Reglas;
import com.aeat.portalparejas.persistencia.dao.PersonaDao;

@Service
@Transactional
public class ServicioParejasImpl implements ServicioParejas {

	public ServicioParejasImpl(PersonaDao dao, Reglas reglas) {
		this.dao = dao;
		this.reglas = reglas;
	}

	public ServicioParejasImpl() {
	}

	@Autowired
	private PersonaDao dao;

	@Autowired
	private Reglas reglas;

	public PersonaDao getDao() {
		return dao;
	}

	public void setDao(PersonaDao dao) {
		this.dao = dao;
	}

	public Reglas getReglas() {
		return reglas;
	}

	public void setReglas(Reglas reglas) {
		this.reglas = reglas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aeat.portalparejas.modelo.servicios.ServicioParejas#getIdeal(com.
	 * aeat.portalparejas.modelo.entidades.Persona)
	 */
	@Override
	public Persona getIdeal(Persona persona) {
		Persona ideal = null;
		Collection<Persona> todas = dao.getAll();
		for (Persona candidato : todas) {
			if (reglas.esIdeal(candidato, persona)) {
				ideal = candidato;
				break;
			}
		}

		return ideal;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aeat.portalparejas.modelo.servicios.ServicioParejas#getAfines(com
	 * .aeat.portalparejas.modelo.entidades.Persona)
	 */
	@Override
	public Collection<Persona> getAfines(Persona persona) {
		Collection<Persona> afines = new ArrayList<Persona>();

		Collection<Persona> candidatos = dao.getAll();;

		for (Persona candidato : candidatos) {
			if (reglas.esAfin(candidato, persona)) {
				afines.add(candidato);
			}
		}

		return afines;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public long insert(Persona persona) {
		//long resultado = dao.insertar(persona);
		return 0;
	}

	@Override
	public void borrar(Persona persona) {
		dao.borrar(persona);
	}

	@Override
	public void borrarById(long id) {
		dao.borrarById(id);
	}

	@Override
	public Collection<Persona> getAll() {
		return dao.getAll();
	}

	@Override
	public Persona getById(long id) {
		return dao.getById(id);
	}

}
