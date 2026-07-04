package Logica;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Dominio.Carta;
import Dominio.DatosAdministrador;
import Dominio.DatosColeccion;
import Dominio.EstrategiaOrdenamiento;
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
		sobrescribirArch();
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
	 * Crea una instancia y la retorna de la clase {@link DatosColeccion}.
	 * <p>
	 * @param owner Ventana principal de la app JFrame
	 * @return una instancia de DatosColeccion
	 */
	@Override
	public DatosColeccion getDatosColeccion(JFrame owner) {
		DatosColeccion d = new DatosColeccion(owner, this);
		return d;
	}
	
	/**
	 * Sobrescribe el archivo relacionado a las cartas Pokemon TCG.
	 * <p>
	 */
	@Override
	public void sobrescribirArch() {
		try {
			String arch = "txts/Sobres.txt";
			FileWriter escritor = new FileWriter(arch);

			for (int i = 0; i < listaCartas.size(); i++) {
				if (i == 0) {
					escritor.write(listaCartas.get(i).lineaTxt());
				} else {
					escritor.write("\n" + listaCartas.get(i).lineaTxt());
				}
			}

			escritor.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR. "+e.getMessage());
		}
	}
	
	/**
	 * Elimina una carta de la lista estatica del sistema implementado del programa.
	 * <p>
	 * @param nombreCarta Nombre de la carta a eliminar
	 * @return Mensaje correspondiente al si se elimino la carta o no.
	 */
    @Override
	public String eliminarCarta(String nombreCarta) {
	for(int i = 0; i < listaCartas.size(); i++) {
		if(listaCartas.get(i).getNombreCarta().equalsIgnoreCase(nombreCarta)) {
			
			listaCartas.remove(i);
			sobrescribirArch();
			return "Se ha eliminado exitosamenta a la carta "+nombreCarta;
			
		}
	}
	
	return "No se ha podido encontrar ninguna carta llamada "+nombreCarta;
	}
    
	/**
	 * Entrega un conteo enumerado de todas las cartas del sistema de cartas Pokemon TCG.
	 * <p>
	 * @return Un string enumerado de las cartas existentes
	 */
    @Override
    public String viewCartas() {
		String list = "<html>";
		int c = 1;

		for (Carta carta : listaCartas) {
			list += c + ". " + carta.getNombreCarta() +" - "+ carta.getTipo()+"<br>";
			c++;
		}
		list += "</html>";

		return list;
    }
    
	/**
	 * Entrega el tamaño de la lista de cartas del sistema como un entero.
	 * <p>
	 * @return El tamaño de la lista de cartas
	 */
    @Override
    public int getTamañoLista() {
    	return listaCartas.size();
    }
    
	/**
	 * Retorna el tipo de la carta pokemon.
	 * <p>
	 * Vease {@link Carta}
	 * @param indice Indice de la carta con respecto a la lista estatica del sistema
	 * @return Tipo de la carta como un string.
	 */
    @Override
    public String getTipoCarta(int indice) {
    	return listaCartas.get(indice).getTipo();
    }
	
	/**
	 * Modifica el atributo de la carta en especifico de tipo Pokemon {@link Pokemon}
	 * <p>
	 * @param indice Indice de la carta segun la lista estatica del sistema implementado
	 * @param atributo Atributo de la carta Pokemon a modificar
	 * @param dato Dato recolectado de la GUI para modificar el atributo
	 */
    @Override
    public void modificarAtributo(int indice, String atributo, String dato) {
    	listaCartas.get(indice).setearAtributo(atributo, dato);
    	sobrescribirArch();
    }
    
	/**
	 * Ordena la lista estatica {@link #listaCartas} sistema implementado con las cartas del programa existentes.
	 * <p>
	 * Esto relacionado con el patron estrategia.
	 * @param estrategia Insatncia de la interfaz y sus clases implementadas.
	 */
    @Override
    public void ordenarCartas(EstrategiaOrdenamiento estrategia) {
		estrategia.ordenamiento(listaCartas);
    	
    }
}
