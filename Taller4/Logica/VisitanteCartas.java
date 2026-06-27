package Logica;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class VisitanteCartas implements InterfazVisitor {

	@Override
	public int visitar(Energy energia) {
		return 1;
	}
	
	@Override
	public int visitar(Item item) {
		return item.getBonificacion() * 20;
	}
	
	@Override
	public int visitar(Pokemon pokemon) {
		return (pokemon.getDaño() / pokemon.getCantidadEnergias()) * 100;
	}
	
	@Override
	public int visitar(Supporter suport) {
		return suport.getEfectosPorTurno() * 50;
	}
	
}
