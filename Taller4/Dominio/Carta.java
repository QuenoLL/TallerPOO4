package Dominio;

import Logica.InterfazVisitor;

public abstract class Carta {
	
	protected String nombreCarta;
	protected int rareza;
	protected String tipo;
	
	public Carta(String nombreCarta, int rareza, String tipo) {
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}

	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public abstract int aceptar(InterfazVisitor visitante);
	
}
