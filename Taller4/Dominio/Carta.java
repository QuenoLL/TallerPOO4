package Dominio;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Carta</tt> es una clase abstracta que interactua con el sistema de cartas TCG.
 * <p>
 * Define los atributos y comportamientos comunes a todos los tipos de Cartas
 * del sistema. Las subclases deben implementar la lógica específica
 * correspondiente a su subclase.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 */
public abstract class Carta {
	
	protected String nombreCarta;
	protected int rareza;
	protected String tipo;
	protected String formatoImagen;

	/**
	 * Crea una instancia de la clase {@link Carta}.
	 * <p>
	 * @param nombreCarta Nombre especifico de la carta
	 * @param rareza Escala de rareza
	 * @param tipo Tipo que define su subclase
	 * @param formatoImagen String asociado a la imagen de la carta
	 */
	public Carta(String nombreCarta, int rareza, String tipo, String formatoImagen) {
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
		this.formatoImagen = formatoImagen;
	}

	/**
	 * 
	 * @param nombreCarta Nombre de la carta a setear
	 */
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}

	/**
	 * 
	 * @param rareza Escala de rareza a setear en la carta
	 */
	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	/**
	 * 
	 * @param tipo Tipo a setear de la carta
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna el formato de la imagen (png, jpg, etc.)
	 * @return Tipo del formato de la imagen.
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Retorna la puntuacion asociada al metodo del visitante {@link VisitanteCartas}
	 * <p>
	 * @param visitante Instancia de la clase visitante implementada por {@link InterfazVisitor}
	 * @return puntuacion de la carta.
	 */
	public abstract int aceptar(InterfazVisitor visitante);
	
	/**
	 * Retorna la ruta de la carta pars su posterior puesta en imagen.
	 * <p>
	 * @return Ruta de la imagen
	 */
	public String getRutaCarta() {
		return this.nombreCarta+"."+this.formatoImagen;
	}
	
}
