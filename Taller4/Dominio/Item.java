package Dominio;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Item</tt> es una subclase de la clase padre Carta.
 * <p>
 * Esta cumple con ejecutar sus especificaciones segun su tipo de subclase.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see Carta
 */
public class Item extends Carta{
	
	private int bonificacion;

	/**
	 * Crea una instancia de la clase Item.
	 * <p>
	 * @param nombreCarta Nombre especifico de la carta
	 * @param rareza Escala de rareza
	 * @param tipo Tipo que define la subclase
	 * @param formatoImagen Formato de la imagen correspondiente a la carta
	 * @param bonificacion Bonificacion de la carta por turno
	 */
	public Item(String nombreCarta, int rareza, String tipo, String formatoImagen, int bonificacion) {
		super(nombreCarta, rareza, tipo, formatoImagen);
		this.bonificacion = bonificacion;
	}

	/**
	 * 
	 * @return Bonficacion de la instancia de la carta
	 */
	public int getBonificacion() {
		return bonificacion;
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
	
	/**
	 * Entrega el formato de la linea txt relacionada a la carta y a su archivo.txt
	 * @return Linea txt de carta para "Sobres.txt"
	 */
	@Override
	public String lineaTxt() {
		return this.nombreCarta+";"+this.rareza+";"+this.tipo+";"+this.bonificacion;
	}
	
	@Override
	public void setearAtributo(String atributo, String dato) {
		if(atributo.equalsIgnoreCase("bonificacion")) {
			this.bonificacion = Integer.parseInt(dato);
		}
	}
	
	/**
	 * Entrega una linea de texto, con un formato necesario para la muestra modular de la carta.
	 * <p>
	 * @return Linea de texto con los atributos en especifico de la carta.
	 * @see DetalleCarta
	 */
	@Override
	public String getEspecifico() {
		return "Bonificacion: "+this.bonificacion;
	}
	

}
