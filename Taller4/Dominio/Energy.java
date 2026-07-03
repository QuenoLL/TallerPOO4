package Dominio;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Energy</tt> es una subclase de la clase padre Carta.
 * <p>
 * Esta cumple con ejecutar sus especificaciones segun su tipo de subclase.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see Carta
 */
public class Energy extends Carta{
	
	private String elemento;

	/**
	 * Crea una instancia de la clase Energy.
	 * <p>
	 * @param nombreCarta Nombre especifico de la carta
	 * @param rareza Escala de rareza 
	 * @param tipo Tipo que define la subclase
	 * @param formatoImagen Formato de la imagen correspondiente a la carta
	 * @param elemento Elemento correspondiente a la energia
	 */
	public Energy(String nombreCarta, int rareza, String tipo, String formatoImagen, String elemento) {
		super(nombreCarta, rareza, tipo, formatoImagen);
		this.elemento = elemento;
	}

	/**
	 * 
	 * @return El tipo de elemento de la energia
	 */
	public String getElemento() {
		return elemento;
	}
	

	/**
	 * Retorna la puntuacion asociada al metodo del visitante {@link VisitanteCartas}
	 * <p>
	 * @param visitante Instancia de la clase visitante implementada por {@link InterfazVisitor}
	 * @return puntuacion de la carta.
	 */
	@Override
	public int aceptar(InterfazVisitor visitante) {
		return visitante.visitar(this);
	}

}
