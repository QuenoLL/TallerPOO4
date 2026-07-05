package Dominio;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class DetalleCarta extends JDialog{

	public DetalleCarta(JFrame owner, Carta carta) {
		super(owner,"Referencia modular carta", true);
		initComponents(carta,owner);
	}

	private void initComponents(Carta carta,JFrame owner) {
		//Agregamos un panel en el sur del JDialog que contendra los stats.
		JPanel panelStats = new JPanel();
		panelStats.setLayout(new BorderLayout());
		add(panelStats, BorderLayout.SOUTH);
		
		//Agregamos el icono de la carta en especifico.
		ImageIcon iconoOriginal = new ImageIcon("Images/" + carta.getRutaCarta());
		if (iconoOriginal.getIconWidth() == -1) {
		    iconoOriginal = new ImageIcon("Images/otro.png");
		}

	    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 310, Image.SCALE_SMOOTH);
	    ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
	    

	    JLabel labelImagen = new JLabel(iconoFinal);
	    add(labelImagen, BorderLayout.CENTER); 
	    
	    pack();
		setLocationRelativeTo(getOwner());
		setVisible(true);
		
	}
	
	

}
