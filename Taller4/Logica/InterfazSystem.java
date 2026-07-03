package Logica;

import javax.swing.JFrame;

import Dominio.DatosAdministrador;

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
	 * Retorna un String para sobrescribir el archivo "Sobres.txt" en la app.
	 * <p>
	 * @return Un String para sobrescribir el archivo.
	 */
	String sobrescribirArch();
	
	/**
	 * Crea una instancia y la retorna de la clase {@link DatosAdministrador}.
	 * <p>
	 * @param owner Ventana principal de la app JFrame
	 * @return Una instancia de DatosAdministrador
	 */
	DatosAdministrador getDatosAdmin(JFrame owner);

}
