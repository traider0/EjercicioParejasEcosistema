package com.aeat.portalparejas.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.modelo.servicios.ServicioParejas;

/**
 * Servlet implementation class TestPortalParejasServlet
 */
@WebServlet("/Test")
public class TestPortalParejasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPortalParejasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ServicioParejas servicio = context.getBean(ServicioParejas.class); 
		
		Persona persona = new Persona(0, "Luis", 27, 1.82f, 'H');
		Persona persona2 = new Persona(1, "Marcelo", 45, 1.78f, 'H');
		Persona persona3 = new Persona(2, "Angela", 35, 1.75f, 'M'); // Ideal de Luis
		Persona persona4 = new Persona(3, "Maria", 45, 1.78f, 'M'); // Afin de Luis por altura
		Persona persona5 = new Persona(4, "Carmen", 25, 1.68f, 'M'); // Afin de Luis por edad

		servicio.insert(persona);
		servicio.insert(persona2);
		servicio.insert(persona3);
		servicio.insert(persona4);
		servicio.insert(persona5);

		// Consultamos al servicio

		Persona ideal = servicio.getIdeal(persona);
		System.out.println("El ideal de " + persona.getNombre() + " es "
				+ ideal.getNombre());

		Collection<Persona> afines = servicio.getAfines(persona);
		System.out.println("Los afines de " + persona.getNombre() + " son: ");
		for (Persona afin : afines) {
			System.out.println(afin.getNombre());
		}

		// Limpiamos los datos

		servicio.borrar(persona);
		servicio.borrar(persona2);
		servicio.borrar(persona3);
		servicio.borrar(persona4);
		servicio.borrar(persona5);
	}

}
