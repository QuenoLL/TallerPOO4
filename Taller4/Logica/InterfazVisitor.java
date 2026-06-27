package Logica;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public interface InterfazVisitor {
	
	int visitar(Supporter suport);
	int visitar(Pokemon pokemon);
	int visitar(Item item);
	int visitar(Energy energia);

}
