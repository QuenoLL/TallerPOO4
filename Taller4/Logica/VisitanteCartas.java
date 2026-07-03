package Logica;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

/**
 * <tt>VisitanteCartas</tt> es una clase implementada por el sistema de visitantes.
 * <p>
 * Esta clase visita las demas de manera que cumple con funcionalidades necesarias para el programa.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see InterfazVisitor
 */
public class VisitanteCartas implements InterfazVisitor {

	/**
	 * Retorna la puntuacion de la carta de tipo Energia {@link Energy}
	 * <p>
	 * @param energia Instancia de la clase Energy
	 * @return puntuacion de la carta Energy
	 */
	@Override
	public int visitar(Energy energia) {
		return 1;
	}
	
	/**
	 * Retorna la puntuacion de la carta de tipo Item{@link Item}
	 * <p>
	 * @param item Instancia de la calse Item
	 * @return puntuacion de la carta Item
	 */
	@Override
	public int visitar(Item item) {
		return item.getBonificacion() * 20;
	}
	
	/**
	 * Retorna la puntuacion de la carta de tipo Pokemon {@link Pokemon}
	 * <p>
	 * @param pokemon Instancia de la clase Pokemon
	 * @return puntuacion de la carta int
	 */
	@Override
	public int visitar(Pokemon pokemon) {
		return (pokemon.getDaño() / pokemon.getCantidadEnergias()) * 100;
	}
	
	/**
	 * Retorna la puntuacion de la carta de tipo soporte {@link Supporter}
	 * <p>
	 * @param suport Instancia de la clase supporter
	 * @return puntuacion de la carta int
	 */
	@Override
	public int visitar(Supporter suport) {
		return suport.getEfectosPorTurno() * 50;
	}
	
}
