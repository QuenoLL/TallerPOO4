package Logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Dominio.Carta;
import Dominio.DatosAdministrador;
import Dominio.FactoryCarta;

/**
 * <tt>SystemImpl</tt> es una implementacion del sistema de cartas TCG.
 * <p>
 * Este administra las lista estatica de la clase {@link Carta} proveendo distintos metodos necesarios
 * para el funcionamiento del programa, como consultas, creaciones, etc.
 * 
 * @author [Eugenio Cortés Egaña, Matías Nuñez Gonzalez]
 * @version 1.0
 * @see InterfazSystem
 */
public class SystemImpl implements InterfazSystem{
	
	private static InterfazSystem instance;
	
	/** Lista estatica de todas las cartas registradas en el sistema  */
	private static List<Carta> listaCartas = new ArrayList<Carta>();
	
	/**
	 * Crea una instancia de la clase de forma privada
	 * <p>
	 * Este respetando el patron de diseño Singleton.
	 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
	 */
	private SystemImpl() {
	}

	
	/**
	 * Retorna una unica instancia del Sistema Implementado.
	 * <p>
	 * Esto respetando el patron de diseño visitor.
	 * @return Una unica instanica del sistema implementado.
	 */
	public static InterfazSystem getSystema() {//Singleton...
		if(instance == null) {
			instance = new SystemImpl();
		}
		
		return instance;
	}

	/**
	 * Deriva a un Factory de la clase {@link Carta} {@link FactoryCarta}
	 * <p>
	 * Añadiendo esta instancia creada a la lista estatica {@link #listaCartas}
	 */
	@Override
	public void leerCarta(String[] partes) {
		listaCartas.add(FactoryCarta.crearCarta(partes));
	}
	
	/**
	 * Crea una instancia y la retorna de la clase {@link DatosAdministrador}.
	 * <p>
	 * @param owner Ventana principal de la app JFrame
	 * @return Una instancia de DatosAdministrador
	 */
	@Override
	public DatosAdministrador getDatosAdmin(JFrame owner) {
		DatosAdministrador d = new DatosAdministrador(owner,this);
		return d;
	}
	
	/**
	 * Retorna un String para sobrescribir el archivo "Sobres.txt" en la app.
	 * <p>
	 * @return Un String para sobrescribir el archivo.
	 */
	@Override
	public String sobrescribirArch() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
