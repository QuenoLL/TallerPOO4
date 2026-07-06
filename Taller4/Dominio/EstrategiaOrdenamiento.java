package Dominio;

import java.util.List;


/**
 * <tt>EstrategiaOrdenamiento</tt> Es una interfaz que implementa multiples clases respetando el patron de diseño Estrategy.
 * <p>
 * Esta nos da la posibilidad de cambiar el comportamientoo de la lista estatica de cartas en el sistema.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 */
public interface EstrategiaOrdenamiento {
	
	/**
	 * Ordena la lista estatica del sistema del programa segun el criterio de la clase que implemente la interfaz.
	 * <p>
	 * @param listaCartas Lista estatica de cartasd del sistema.
	 */
	void ordenamiento(List<Carta> listaCartas);
}
