package Dominio;

import java.util.List;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Poder</tt> es una clase implementada por la interfaz {@link EstrategiaOrdenamiento}.
 * <p>
 * Esta cumple con un ordenamiento capaz de ordenar una lista de cartas segun el poder de estas.
 * @author [Eugenio Cortés Egaña, Matías Nuñez Gonzalez]
 * @version 1.0
 */
public class Poder implements EstrategiaOrdenamiento{

	/**
	 * Ordena la lista estatica del sistema del programa segun el poder de las cartas {@link Carta}.
	 * <p>
	 * @param listaCartas Lista estatica de cartasd del sistema.
	 */
	@Override
	public void ordenamiento(List<Carta> listaCartas) {
		InterfazVisitor visitante = new VisitanteCartas();
		for(int a = 0; a < listaCartas.size()-1;a++) {
			for(int b = a + 1; b < listaCartas.size(); b++) {
				if(listaCartas.get(a).aceptar(visitante) < listaCartas.get(b).aceptar(visitante)) {
					
					//Intercambiamos las posiciones de las cartas en funcion a su puntuacion.
					Carta temp = listaCartas.get(a);
	                listaCartas.set(a, listaCartas.get(b));
	                listaCartas.set(b, temp);
				}
			}
		}
	}
}
