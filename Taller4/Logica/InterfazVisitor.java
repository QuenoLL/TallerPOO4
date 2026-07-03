package Logica;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

/**
 * <tt>InterfazVisitor</tt> es una interfaz diseñada para cumplir el patron de diseño Visitor, implementando con sus metodos 
 * a los distintos visitantes por haber en el programa.
 * <p>
 * @author [Eugenio Cortés Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 */
public interface InterfazVisitor {
	
	/**
	 * Retorna la puntuacion de la carta de tipo soporte {@link Supporter}
	 * <p>
	 * @param suport Instancia de la clase supporter
	 * @return puntuacion de la carta int
	 */
	int visitar(Supporter suport);
	
	/**
	 * Retorna la puntuacion de la carta de tipo Pokemon {@link Pokemon}
	 * <p>
	 * @param pokemon Instancia de la clase Pokemon
	 * @return puntuacion de la carta int
	 */
	int visitar(Pokemon pokemon);
	
	/**
	 * Retorna la puntuacion de la carta de tipo Item{@link Item}
	 * <p>
	 * @param item Instancia de la calse Item
	 * @return puntuacion de la carta Item
	 */
	int visitar(Item item);
	
	/**
	 * Retorna la puntuacion de la carta de tipo Energia {@link Energy}
	 * <p>
	 * @param energia Instancia de la clase Energy
	 * @return puntuacion de la carta Energy
	 */
	int visitar(Energy energia);

}
