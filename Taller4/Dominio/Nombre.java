package Dominio;

import java.util.List;

/**
 * <tt>Rareza</tt> Es una clase implementada por la interfaz {@link EstrategiaOrdenamiento}.
 * <p>
 * Esta cumple con un ordenamiento capaz de ordenar una lista de cartas segun sus nombres.
 * @author [Eugenio Cortés Egaña, Matías Nuñez Gonzalez]
 * @version 1.0
 */
public class Nombre implements EstrategiaOrdenamiento{
	

	/**
	 * Ordena la lista estatica del sistema del programa segun el nombre de la carta {@link Carta}
	 * <p>
	 * @param listaCartas Lista estatica de cartasd del sistema.
	 */
	@Override
	public void ordenamiento(List<Carta> listaCartas) {
		for (int a = 0; a < listaCartas.size() - 1; a++) {
	        for (int b = a + 1; b < listaCartas.size(); b++) {
	        	//Uso compare to para poder comparar los nombres de las cartas alfabeticamente modo sigma lookmaxing.
	            if (listaCartas.get(a).getNombreCarta().compareTo(listaCartas.get(b).getNombreCarta()) > 0) {
	                // Intercambio de posiciones
	                Carta temp = listaCartas.get(a);
	                listaCartas.set(a, listaCartas.get(b));
	                listaCartas.set(b, temp);
	            }
	        }
	    }
	}

}
