package com.aeat.portalparejas.persistencia.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.aeat.portalparejas.modelo.entidades.Persona;

public class PersonaDaoHibernateImpl implements PersonaDao {

	private SessionFactory sessionFactory;
	
	@Override
	public long insertar(Persona persona) {
		//Para configuraciones de contexto de session por Thread, 
		//se asocia una operación (transaccion) con una session.
		Session sesion = sessionFactory.getCurrentSession();
		sesion.beginTransaction();
		Long id = (Long) sesion.save(persona);
		sesion.getTransaction().commit();
		return id;
	}

	@Override
	public void borrar(Persona persona) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.getTransaction().begin();
		sesion.delete(persona);
		sesion.getTransaction().commit();
	}

	@Override
	public Collection<Persona> getAll() {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		List<Persona> facturas=session.createQuery("from Persona").list();
		//session.getTransaction().commit();
		return facturas;
	}

	@Override
	public Persona getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Persona persona = (Persona) session.get(Persona.class, id);
		session.getTransaction().commit();
		return persona;
	}

	@Override
	public void borrarById(long id) {
		// TODO Auto-generated method stub

	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
