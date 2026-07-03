package Dominio;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Pokemon</tt> es una subclase de la clase padre Carta.
 * <p>
 * Esta cumple con ejecutar sus especificaciones segun su tipo de subclase.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see Carta
 */
public class Pokemon extends Carta{
	
	private int daño;
	private int cantidadEnergias;

	/**
	 * Crea una instancia de la clase Pokemon.
	 * <p>
	 * @param nombreCarta Nombre especifico de la carta
	 * @param rareza Escala de rareza
	 * @param tipo Tipo que define la subclase
	 * @param formatoImagen Formato de la imagen correspondiente a la carta
	 * @param daño Daño especifico de la carta 
	 * @param cantidadEnergias Cantidad de energias que posee la carta
	 */
	public Pokemon(String nombreCarta, int rareza, String tipo, String formatoImagen, int daño, int cantidadEnergias) {
		super(nombreCarta, rareza, tipo, formatoImagen);
		this.daño = daño;
		this.cantidadEnergias = cantidadEnergias;
	}

	/**
	 * 
	 * @return El daño de la instancia de la carta
	 */
	public int getDaño() {
		return daño;
	}

	/**
	 * 
	 * @return La cantidad de energias de la instancia de la carta
	 */
	public int getCantidadEnergias() {
		return cantidadEnergias;
	}
	
	/**
	 * Retorna la puntuacion asociada al metodo del visitante {@link VisitanteCartas}
	 * <p>
	 * @param visitante Instancia de la clase visitante implementada por {@link InterfazVisitor}
	 * @return puntuacion de la carta.
	 */
	@Override
	public  int aceptar(InterfazVisitor visitante) {
		return visitante.visitar(this);
	}
	
	
		

}
