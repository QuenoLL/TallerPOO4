package Dominio;

import Logica.InterfazVisitor;

public class Energy extends Carta{
	
	private String elemento;
	
	public Energy(String nombreCarta, int rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}
	
	@Override
	public int aceptar(InterfazVisitor visitante) {
		return visitante.visitar(this);
	}

}
