package Dominio;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.InterfazSystem;

/**
 * <tt>DatosColeccin</tt> es una clase que implementa el JDialog
 * de manera que me da la posibilidad de establecer un dialogo interactivo con distintos paneles para la muestra de las cartas.
 * @author [Eugenio Cortés Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see JDialog
 * 
 */
public class DatosColeccion extends JDialog{
	
	private InterfazSystem sistema;
	private JPanel panelCartas;
	
	public DatosColeccion(JFrame owner, InterfazSystem sistema) {
		super(owner, "Coleccion", true);
		this.sistema = sistema;
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		
        // Panel superior con los botones de ordenamiento con respecto a estrategy.
        JPanel panelOrden = new JPanel();
        JButton porRareza = new JButton("Ordenar por Rareza");
        JButton porNombre = new JButton("Ordenar por Nombre");
        JButton porPoder = new JButton("Ordenar por Poder");
        
        panelOrden.add(porRareza);
        panelOrden.add(porNombre);
        panelOrden.add(porPoder);
        add(panelOrden, BorderLayout.NORTH);
	}
	
	

}
