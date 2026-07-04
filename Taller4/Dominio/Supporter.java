package Dominio;

import Logica.InterfazVisitor;
import Logica.VisitanteCartas;

/**
 * <tt>Supporter</tt> es una subclase de la clase padre Carta.
 * <p>
 * Esta cumple con ejecutar sus especificaciones segun su tipo de subclase.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see Carta
 */
public class Supporter extends Carta {

	private int efectosPorTurno;

	/**
	 * Crea una instancia de la clase Supporter.
	 * <p>
	 * @param nombreCarta Nombre especifico de la carta
	 * @param rareza Escala de rareza
	 * @param tipo Tipo que define la subclase
	 * @param formatoImagen Formato de la imagen correspondiente a la carta
	 * @param efectosPorTurno Efectos por turno de la carta
	 */
	public Supporter(String nombreCarta, int rareza, String tipo, String formatoImagen, int efectosPorTurno) {
		super(nombreCarta, rareza, tipo, formatoImagen);
		this.efectosPorTurno = efectosPorTurno;
	}

	/**
	 * 
	 * @return Los efectos por turno de la instancia de la carta
	 */
	public int getEfectosPorTurno() {
		return efectosPorTurno;
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
		return this.nombreCarta+";"+this.rareza+";"+this.tipo+";"+this.efectosPorTurno;
	}
	
	@Override
	public void setearAtributo(String atributo, String dato) {
		if(atributo.equalsIgnoreCase("efecto")) {
			this.efectosPorTurno = Integer.parseInt(dato);
		}
	}

}
