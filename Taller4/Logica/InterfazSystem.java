package Logica;

import java.util.List;

import javax.swing.JFrame;

import Dominio.Carta;
import Dominio.DatosAdministrador;
import Dominio.DatosColeccion;
import Dominio.DetalleCarta;

/**
 * Secuencia de contratos que implementan al programa de cartas TCG.
 * <p>
 * Esta interfaz provee todos los metodos necesarios para el
 * funcionamiento del programa recibiendo solo datos primitivos de la app.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see SystemImpl
 */
public interface InterfazSystem {
	
	/**
	 * Deriva informacion de la app e instancia un Factory para crear {@link Carta}
	 * <p>
	 * @param partes Arreglo proveniente de la app.
	 */
	void leerCarta(String[] partes);
	
	/**
	 * Sobrescribe el archivo relacionado a las cartas Pokemon TCG.
	 * <p>
	 */
	void sobrescribirArch();
	
	/**
	 * Crea una instancia y la retorna de la clase {@link DatosAdministrador}.
	 * <p>
	 * @param owner Ventana principal de la app JFrame
	 * @return Una instancia de DatosAdministrador
	 */
	DatosAdministrador getDatosAdmin(JFrame owner);
	
	/**
	 * Crea una instancia y la retorna de la clase {@link DatosColeccion}.
	 * <p>
	 * @param owner Ventana principal de la app JFrame
	 * @return una instancia de DatosColeccion
	 */
	DatosColeccion getDatosColeccion(JFrame owner);
	
	/**
	 * Elimina una carta de la lista estatica del sistema implementado del programa.
	 * <p>
	 * @param nombreCarta Nombre de la carta a eliminar
	 * @return Mensaje correspondiente al si se elimino la carta o no.
	 */
	String eliminarCarta(String nombreCarta);
	
	/**
	 * Entrega un conteo enumerado de todas las cartas del sistema de cartas Pokemon TCG
	 * <p>
	 * @return Un string enumerado de las cartas existentes
	 */
	String viewCartas();
	
	/**
	 * Entrega el tamaño de la lista de cartas del sistema como un entero.
	 * <p>
	 * @return El tamaño de la lista de cartas
	 */
	int getTamañoLista();
	
	/**
	 * Retorna el tipo de la carta pokemon
	 * <p>
	 * Vease {@link Carta}
	 * @param indice Indice de la carta con respecto a la lista estatica del sistema
	 * @return Tipo de la carta como un string.
	 */
	String getTipoCarta(int indice);
	
	/**
	 * Modifica el atributo de la carta en especifico de tipo Pokemon {@link Pokemon}
	 * <p>
	 * @param indice Indice de la carta segun la lista estatica del sistema implementado
	 * @param atributo Atributo de la carta Pokemon a modificar
	 * @param dato Dato recolectado de la GUI para modificar el atributo
	 */
	void modificarAtributo(int indice, String atributo, String dato);

	/**
	 * Ordena la lista estatica del sistema implementado con las cartas del programa existentes.
	 * <p>
	 * Esto relacionado con el patron estrategia.
	 * @param tipoEstrategia String que contiene el tipo de estrategia a implementar.
	 */
	void ordenarCartas(String tipoEstrategia);
	
	/**
	 * 
	 * @return Lista de las en el sistema de cartas TCG.
	 */
	List<Carta> getListaCartas();
	
	/**
	 * Retorna una instancia del JDialog DetalleCarta
	 * <p>
	 * @param owner Ventana padre JFrame
	 * @return Una instancia del JDialog DetalleCarta {@link DetalleCarta}
	 */
	DetalleCarta getDetalleCarta(JFrame owner,Carta carta);
	
	/**
	 * Retorna el poder de una instancia de una carta.
	 * <p>
	 * Cabe recalcar que esta instancia nunca va provenir de la App o Main, si no de los metodos necesarios del DetalleCarta.
	 * @param carta Instancia de la carta.
	 * @return Poder de una carta.
	 * @see DetalleCarta
	 */
	int getPoderCarta(Carta carta);
}
