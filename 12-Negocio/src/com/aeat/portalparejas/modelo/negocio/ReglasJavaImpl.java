package com.aeat.portalparejas.modelo.negocio;

import static java.lang.Math.abs;

import org.springframework.stereotype.Component;

import com.aeat.portalparejas.modelo.entidades.Persona;

@Component
public class ReglasJavaImpl implements Reglas {

	/**
	 * Para ser Ideales,
	 * 	-Han de tener distinto genero, 
	 * 	-Tener menos de 10 años de diferencia y
	 * 	-Tener menos de 10 cm de diferencia en la altura
	 */
	
	public boolean esIdeal(Persona candidato, Persona usuario) {
		return candidato.getGenero() != usuario.getGenero() 
				&& abs(candidato.getEdad()-usuario.getEdad())<10
				&& abs(candidato.getAltura()-usuario.getAltura())<.10f;
	}
	
	/**
	 * Para ser Afines,
	 * 	-Han de tener distinto genero y
	 * 	-Tener menos de 10 años de diferencia o
	 * 	-Tener menos de 10 cm de diferencia en la altura
	 */
	
	public boolean esAfin(Persona candidato, Persona usuario) {
		return candidato.getGenero() != usuario.getGenero() 
				&&	(abs(candidato.getEdad()-usuario.getEdad())<10
				|| abs(candidato.getAltura()-usuario.getAltura())<.10f);
	}

}
