package Dominio;

import Logica.InterfazVisitor;

public class Item extends Carta{
	
	private int bonificacion;
	
	public Item(String nombreCarta, int rareza, String tipo,int bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion =bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}
	
	@Override
	public int aceptar(InterfazVisitor visitante) {
		return visitante.visitar(this);
	}
	

}
