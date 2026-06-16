package Logica;

import javax.swing.JFrame;

import Dominio.DatosAdministrador;

public interface InterfazSystem {
	
	void crearCarta(String[] partes);
	DatosAdministrador getDatosAdmin(JFrame owner);

}
