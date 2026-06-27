package Logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Dominio.Carta;
import Dominio.DatosAdministrador;
import Dominio.FactoryCarta;

public class SystemImpl implements InterfazSystem{
	
	private static InterfazSystem instance;
	private static List<Carta> listaCartas = new ArrayList<Carta>();
	private static List<Carta> mazo = new ArrayList<Carta>();
	
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
	
	@Override
	public DatosAdministrador getDatosAdmin(JFrame owner) {
		DatosAdministrador d = new DatosAdministrador(owner);
		return d;
	}
	

}
