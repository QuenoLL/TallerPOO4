package Dominio;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.InterfazSystem;

/**
 * <tt>DetalleCarta</tt> es una clase correspondiente a una extension de un JDialog.
 * <p>
 * Esta nos da la oportunidad de poder visualizar una instancia de una carta {@link Carta} del sistema de manera modular.
 * @author [Eugenio Cortés Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see JDialog
 */
public class DetalleCarta extends JDialog{
	
	private InterfazSystem sistema;

	public DetalleCarta(JFrame owner, Carta carta,InterfazSystem sistema) {
		super(owner,"Referencia modular carta", true);
		this.sistema = sistema;
		initComponents(carta,owner);
	}

	/**
	 * Completa el JDialog con sus respectivos componentes para la muestra modular
	 * de la carta.
	 * <p>
	 * @param carta Instancia de la carta a mostrar.
	 * @param owner Ventana principal JFrame.
	 */
	private void initComponents(Carta carta,JFrame owner) {
		setSize(320,410);
		//Agregamos un panel en el sur del JDialog que contendra los stats.
		JPanel panelStats = new JPanel();
		panelStats.setLayout(new BorderLayout());
		add(panelStats, BorderLayout.SOUTH);
		
		//Agreamos un panel izquierdo para poder agregar el nombre y la rareza uno sobre el otro.
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
		
		//Agregamos un pael a la derecha dinde iran los atributos especificos de la carta ademas de su poder correspondiente.
		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
		
		
		//Agregamos el icono de la carta en especifico.
		ImageIcon iconoOriginal = new ImageIcon("Images/" + carta.getRutaCarta());
		if (iconoOriginal.getIconWidth() == -1) {
		    iconoOriginal = new ImageIcon("Images/otro.png");
		}

	    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(220, 230, Image.SCALE_SMOOTH);
	    ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
	    
	    JLabel labelImagen = new JLabel(iconoFinal);
	    add(labelImagen, BorderLayout.CENTER); 
	    
	    //Izquierda.
	    JLabel nom = new JLabel("Nombre: "+carta.getNombreCarta());
	    JLabel rare = new JLabel("Rareza: "+carta.getRareza());
	    panelIzquierda.add(nom);
	    panelIzquierda.add(rare);
	    panelStats.add(panelIzquierda, BorderLayout.WEST);
	    
	    //Derecha.
	    JLabel poder = new JLabel("Poder: "+sistema.getPoderCarta(carta));
	    JLabel especifico = new JLabel(carta.getEspecifico());
	    panelDerecha.add(especifico);
	    panelDerecha.add(poder);
	    panelStats.add(panelDerecha, BorderLayout.EAST);
	    
	    //En esta ocasion pack() no podria ir ya que dispone que la ventana se ajuste a sus componentes y nosotros queremos darle un tamaño fijo.
		setLocationRelativeTo(getOwner());
		setVisible(true);
		
	}
	
	

}
