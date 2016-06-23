package com.aeat.portalparejas.persistencia.hibernate;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.persistencia.dao.PersonaDaoHibernateTemplateImpl;

public class HibernateDaoTest {

	private static SessionFactory sessionFactory;
	
	private static Persona persona;
	
	private Long idEsperado = Long.parseLong("0");
	
	private static PersonaDaoHibernateTemplateImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sessionFactory = new Configuration().configure("cfg/hibernate.cfg.xml")
				.buildSessionFactory();
		
		dao = new PersonaDaoHibernateTemplateImpl();
		
		dao.setSessionFactory(sessionFactory);
		
		persona = new Persona(0,"Luis",27,1.82f,'H');
	}

	@Test
	public void testInsertar() {
		//sessionFactory.getCurrentSession().beginTransaction();
		Long id = dao.insertar(persona);
		//sessionFactory.getCurrentSession().getTransaction().commit();
		Assert.assertEquals("Ha fallado la insercion de la persona",idEsperado, id);
	}

//	@Test
//	public void testGetAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetById() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testBorrar() {
//		fail("Not yet implemented");
//	}
}
