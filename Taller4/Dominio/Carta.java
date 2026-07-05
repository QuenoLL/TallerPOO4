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
	 * @return Nombre de la instancia de la carta.
	 */
	public String getNombreCarta() {
		return nombreCarta;
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
	 * 
	 * @return El tipo de la carta en especifico.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @return La rareza de la carta en especifico.
	 */
	public int getRareza() {
		return rareza;
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
	 * Entrega el formato de la linea txt relacionada a la carta y a su archivo.txt
	 * @return Linea txt de carta para "Sobres.txt"
	 */
	public abstract String lineaTxt();
	
	/**
	 * Retorna la ruta de la carta pars su posterior puesta en imagen.
	 * <p>
	 * @return Ruta de la imagen
	 */
	public String getRutaCarta() {
		return this.nombreCarta+"."+this.formatoImagen;
	}
	
	/**
	 * Setea el atributo en especifico de las subclases de la clase {@link Carta}
	 * <p>
	 * Cada subclase implementa este atributo a su manera.
	 * @param atributo Atributo a setear
	 * @param dato Dato que sera seteado por el actual en la clase
	 */
	public abstract void setearAtributo(String atributo, String dato);
	
	/**
	 * Entrega una linea de texto, con un formato necesario para la muestra modular de la carta.
	 * <p>
	 * @return Linea de texto con los atributos en especifico de la carta.
	 * @see DetalleCarta
	 */
	public abstract String getEspecifico();
	
}
