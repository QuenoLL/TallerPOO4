package Dominio;

import java.util.List;

/**
 * <tt>Rareza</tt> Es una clase implementada por la interfaz {@link EstrategiaOrdenamiento}.
 * <p>
 * Esta cumple con un ordenamiento capaz de ordenar una lista de cartas segun su rareza.
 * @author [Eugenio Cortés Egaña, Matías Nuñez Gonzalez]
 * @version 1.0
 */
public class Rareza implements EstrategiaOrdenamiento{
	
	/**
	 * Ordena la lista estatica del sistema del programa segun la rareza de la carta {@link Carta}
	 * <p>
	 * @param listaCartas Lista estatica de cartasd del sistema.
	 */
	@Override
	public void ordenamiento(List<Carta> listaCartas) {
		
		for(int a = 0; a < listaCartas.size() - 1; a++) {
			for(int b = a + 1; b < listaCartas.size(); b++) {
				
				if(listaCartas.get(a).getRareza() < listaCartas.get(b).getRareza()) {
					Carta temp = listaCartas.get(a);
					listaCartas.set(a, listaCartas.get(b));
					listaCartas.set(b, temp);
				}
			}
		}

		
	}
}
