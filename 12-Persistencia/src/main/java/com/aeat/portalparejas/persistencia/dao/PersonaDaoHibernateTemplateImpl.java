package com.aeat.portalparejas.persistencia.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.aeat.portalparejas.modelo.entidades.Persona;

public class PersonaDaoHibernateTemplateImpl extends HibernateTemplate implements PersonaDao {

	@Override
	public long insertar(Persona persona) {
		return (Long)getSessionFactory().getCurrentSession().save(persona);
	}

	@Override
	public void borrar(Persona persona) {
		getSessionFactory().getCurrentSession().delete(persona);

	}

	@Override
	public void borrarById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Persona> getAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Persona").list();
	}

	@Override
	public Persona getById(long id) {
		return (Persona) getSessionFactory().getCurrentSession().get(Persona.class, id);
	}

}
