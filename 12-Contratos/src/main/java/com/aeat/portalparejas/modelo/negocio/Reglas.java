package com.aeat.portalparejas.modelo.negocio;

import com.aeat.portalparejas.modelo.entidades.Persona;

public interface Reglas {

	boolean esIdeal(Persona candidato, Persona usuario);

	boolean esAfin(Persona candidato, Persona usuario);

}