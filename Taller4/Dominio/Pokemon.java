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
	
	/**
	 * Entrega el formato de la linea txt relacionada a la carta y a su archivo.txt
	 * @return Linea txt de carta para "Sobres.txt"
	 */
	@Override
	public String lineaTxt() {
		return this.nombreCarta+";"+this.rareza+";"+this.tipo+";"+this.daño+";"+this.cantidadEnergias;
	}
	
	/**
	 * Setea el atributo en especifico de las subclases de la clase {@link Carta}
	 * <p>
	 * Setea segun la opcion del usuario el daño o la cantidad de energias de la clase pokemon
	 * @param atributo Atributo a setear, ya sea daño o cantidad de energias.
	 * @param dato Dato que sera seteado por el actual en la clase
	 */
	@Override
	public void setearAtributo(String atributo, String dato) {
		switch(atributo) {
		case "Daño":
			this.daño = Integer.parseInt(dato);
			break;
			
		case "Cantidad":
			this.cantidadEnergias = Integer.parseInt(dato);
			break;
		}
	}
	
	/**
	 * Entrega una linea de texto, con un formato necesario para la muestra modular de la carta.
	 * <p>
	 * @return Linea de texto con los atributos daño y cantidad de energia en especifico de la carta.
	 * @see DetalleCarta
	 */
	@Override
	public String getEspecifico() {
		return "<html>Daño: "+this.daño+"<br>"
				+"Cantidad Energia: "+this.cantidadEnergias+"</html>";
	}
	
	
		

}
