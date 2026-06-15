package Dominio;

public class FactoryCarta {
	
	public static Carta crearCarta(String[] partes) {
		if(partes[2].equalsIgnoreCase("pokemon")) {
			Carta p = new Pokemon(null, 0, null, 0, 0);
			return p;
			
		}else if(partes[2].equalsIgnoreCase("item")) {
			Carta i = new Item(null, 0, null, 0);
			return i;
			
		}else if(partes[2].equalsIgnoreCase("supporter")) {
			Carta s = new Supporter(null, 0, null, 0);
			return s;
			
		}else {
			Carta e = new Energy(null, 0, null, null);
			return e;
		}
	}

}
