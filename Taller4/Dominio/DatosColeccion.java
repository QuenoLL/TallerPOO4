package Dominio;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	
	/**
	 * Crea una instancia de la clase {@link DatosColeccion}.
	 * <p>
	 * @param owner Ventana principal JFrame
	 * @param sistema Instancia del sistema implmentado
	 */
	public DatosColeccion(JFrame owner, InterfazSystem sistema) {
		super(owner, "Coleccion", true);
		this.sistema = sistema;
		initComponents(owner);
	}

	/**
	 * Carga los datos contenidos dentro del JDialog.
	 * <p>
	 */
	private void initComponents(JFrame owner) {
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
        
        //Panel central para las cartas junto al Scroll...
        panelCartas = new JPanel();
        panelCartas.setLayout(new BoxLayout(panelCartas, BoxLayout.Y_AXIS));
        
        //Agrego un JScroll ya que al ser demasiadas cartas
        JScrollPane scroll = new JScrollPane(panelCartas);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);//Añado el scroll al JDialog
        
        porRareza.addActionListener(e->{
        	sistema.ordenarCartas("rareza");
        });
        
        porNombre.addActionListener(e->{
        	sistema.ordenarCartas("nombre");
        });
        
        porPoder.addActionListener(e->{
        	sistema.ordenarCartas("poder");
        });
        
        //Metodo para actualizar como se nos muestran las cartas en la pantalla
        actualizarPantalla(owner);
        
        setSize(700, 500); // con scroll, ya podemos fijar un tamaño razonable
        setLocationRelativeTo(getOwner());
        setVisible(true);
	}

	/**
	 * Actualiza el JDialog de manera que las cartas se adecuen a la estrategia actual.
	 */
	private void actualizarPantalla(JFrame owner) {
		panelCartas.removeAll();//Removemos todos los componentes de la ventana.
		
		for(Carta carta : sistema.getListaCartas()) {
			JButton btnCarta = new JButton(carta.getNombreCarta());
			btnCarta.setAlignmentX(Component.LEFT_ALIGNMENT);
			btnCarta.addActionListener(e->{
				mostrarDetalleCarta(carta,owner);
			});
			panelCartas.add(btnCarta);
		}
		
		panelCartas.revalidate();
        panelCartas.repaint();
		
	}

	/**
	 * Muestra la carta y su imagen de manera modular
	 * @param carta
	 */
	private void mostrarDetalleCarta(Carta carta, JFrame owner) {
		sistema.getDetalleCarta(owner, carta);
	}
	
	

}
