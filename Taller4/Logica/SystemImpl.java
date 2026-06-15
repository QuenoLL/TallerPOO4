package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.Carta;
import Dominio.FactoryCarta;

public class SystemImpl implements InterfazSystem{
	
	private static InterfazSystem instance;
	private static List<Carta> listaCartas = new ArrayList<Carta>();
	
	private SystemImpl() {
	}

	public static InterfazSystem getSystema() {//Singleton...
		if(instance == null) {
			instance = new SystemImpl();
		}
		
		return instance;
	}

	@Override
	public void crearCarta(String[] partes) {
		listaCartas.add(FactoryCarta.crearCarta(partes));
	}

}
