package Dominio;

public class Pokemon extends Carta{
	
	private int daño;
	private int cantidadEnergias;
	
	public Pokemon(String nombreCarta, int rareza, String tipo,int daño, int cantidadEnergias) {
		super(nombreCarta, rareza, tipo);
		this.daño = daño;
		this.cantidadEnergias = cantidadEnergias;
	}

	public int getDaño() {
		return daño;
	}

	public int getCantidadEnergias() {
		return cantidadEnergias;
	}
		

}
