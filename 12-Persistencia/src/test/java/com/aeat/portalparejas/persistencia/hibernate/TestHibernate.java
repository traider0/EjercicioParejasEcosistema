package com.aeat.portalparejas.persistencia.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aeat.portalparejas.modelo.entidades.Persona;

public class TestHibernate {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure("cfg/hibernate.cfg.xml")
				.buildSessionFactory();

		long idPersona1 = addPersona(new Persona(0,"Luis",27,1.82f,'H'));
		long idPersona2 = addPersona(new Persona(1,"Marcelo",45,1.78f,'H'));
		long idPersona3 = addPersona(new Persona(2,"Angela",35,1.75f,'M'));
		long idPersona4 = addPersona(new Persona(3,"Maria",45,1.78f,'M'));
		long idPersona5 = addPersona(new Persona(4,"Carmen",25,1.68f,'M'));
		
		Persona persona1 = getPersona(idPersona1);
		System.out.println(persona1);
		
		Persona persona2 = getPersona(idPersona2);
		System.out.println(persona2);
		
		Persona persona3 = getPersona(idPersona3);
		System.out.println(persona3);
		
		Persona persona4 = getPersona(idPersona4);
		System.out.println(persona4);
		
		Persona persona5 = getPersona(idPersona5);
		System.out.println(persona5);
		
		persona1.setNombre("Marcos");
		updatePersona(persona1);
		
		Persona persona6 = getPersona(idPersona1);
		System.out.println(persona6);
		
		deletePersona(persona1);
		deletePersona(persona2);
		deletePersona(persona3);
		deletePersona(persona4);
		deletePersona(persona5);
		deletePersona(persona6);
	}

	private static void deletePersona(Persona persona) {
		Session sesion = sessionFactory.openSession();
		sesion.getTransaction().begin();
		sesion.delete(persona);
		sesion.getTransaction().commit();
		sesion.close();

	}

	private static void updatePersona(Persona persona) {
		Session sesion = sessionFactory.openSession();
		sesion.getTransaction().begin();
		sesion.update(persona);
		sesion.getTransaction().commit();
		sesion.close();

	}

	private static Persona getPersona(long id) {
		Session sesion = sessionFactory.openSession();
		Persona persona = (Persona) sesion.get(Persona.class, id);
		sesion.close();
		return persona;
	}

	private static long addPersona(Persona persona) {
		Session sesion = sessionFactory.openSession();
		sesion.beginTransaction();
		Long id = (Long) sesion.save(persona);
		System.out.println("Id session save " + id);
		long idSaved = persona.getId();
		System.out.println("Id session idSaved " + idSaved);
		sesion.getTransaction().commit();
		sesion.close();
		return idSaved;
	}
}
