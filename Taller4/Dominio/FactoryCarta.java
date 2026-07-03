package Dominio;

/**
 * <tt>FactoryCarta</tt> es una clase del patron de diseño Factory.
 * <p>
 * Esta se ocupa de instanciar a la clase {@link Carta} y a sus subclases.
 * @author [Eugenio Cortes Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 */ 
public class FactoryCarta {
	
	/**
	 * Retorna una instancia de la clase {@link Carta}.
	 * <p>
	 * Metodo estatico y publico.
	 * @param partes arreglo donde {@code partes[0]} es el nombre,
	 *               {@code partes[1]} contiene el nivel de rareza de la carta,
	 *               {@code partes[2]} el tipo de la carta y las demas partes son especificas de tipo de la carta
	 * @return Una instancia de la clase {@link Carta}
	 */
	public static Carta crearCarta(String[] partes) {
		if(partes[2].equalsIgnoreCase("pokemon")) {
			Carta p = new Pokemon(partes[0], Integer.parseInt(partes[1]), partes[2], "png", Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
			return p;
			
		}else if(partes[2].equalsIgnoreCase("item")) {
			Carta i = new Item(partes[0], Integer.parseInt(partes[1]), partes[2], "png", Integer.parseInt(partes[3]));
			return i;
			
		}else if(partes[2].equalsIgnoreCase("supporter")) {
			Carta s = new Supporter(partes[0], Integer.parseInt(partes[1]), partes[2], "png", Integer.parseInt(partes[3]));
			return s;
			
		}else {
			Carta e = new Energy(partes[0], Integer.parseInt(partes[1]), partes[2], "png", partes[3]);
			return e;
		}
	}

}
