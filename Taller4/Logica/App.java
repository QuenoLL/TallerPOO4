// Nombre: Eugenio Cortés Egaña; Rut: 22.405.687-7
// Nombre: Matías Núñez González; Rut: 22.256.666-5
package Logica;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Inicio de la aplicación.
 * <p>
 * Carga los datos desde archivos de texto al iniciar, y presenta al usuario
 * un menú principal con acceso al menú de administración y al menú de coleccion.
 *
 * @author [Eugenio Cortés Egaña, Matías Núñez González]
 * @version 1.0
 */

public class App {
	
	/**  Instancia unica del sistema implementado */
	private static InterfazSystem system = SystemImpl.getSystema();
	
	/**
     * Main de la aplicación.
     * <p>
     * Carga cartas desde el archivo, luego muestra el menú principal.
     *
     * @throws IOException si ocurre un error al leer los archivos de datos
     */
	public static void main(String[] args) throws IOException{
		
		App m = new App();
		m.ejecutar();
		
	}

	/**
	 * Ejecuta los metodos asociados a la App.
	 * @throws IOException
	 */
	private void ejecutar() throws IOException{
		leerArch();
		panel();
	}

	/**
	 * Inicializa el JFrame que contiene todas las interacciones con el usario.
	 */
	private void panel() {
		JFrame ventana = new JFrame("Universo TCG");
		ventana.setSize(300,400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
	    ImageIcon iconoOriginal = new ImageIcon("Images/Portada.png");
	    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 310, Image.SCALE_SMOOTH);
	    ImageIcon iconoFinal = new ImageIcon(imagenEscalada);

	    JLabel labelPortada = new JLabel(iconoFinal);
	    ventana.add(labelPortada, BorderLayout.CENTER);   // <- imagen arriba

	    ventana.add(createGUI(ventana), BorderLayout.NORTH);
		ventana.setVisible(true);
	}

	/**
	 * Crea el contenido dentro del JFrame, ventana principal.
	 * <p>
	 * @param ventana Ventana principal JFrame
	 * @return El JPanel que contiene las interacciones
	 */
	private JPanel createGUI(JFrame ventana) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel pestañas = new JPanel();
		pestañas.setLayout(new BoxLayout(pestañas, BoxLayout.LINE_AXIS));
		
		JButton pestaña1 = pestaña1(ventana);
		JButton pestaña2 = pestaña2();
		
		pestañas.add(pestaña1);
		pestañas.add(pestaña2);
		
		mainPanel.add(pestañas, BorderLayout.NORTH);
		
		return mainPanel;
	}
	

	/**
	 * Inicializa el boton que lleva al Dialogo de Administrador.
	 * @param ventana Ventana principal JFrame
	 * @return un boton interactivo JButton
	 */
	private JButton pestaña1(JFrame ventana) {
		JButton b = new JButton("Administracion");
		b.addActionListener(e ->{system.getDatosAdmin(ventana);
		});
		
		return b;
	}

	/**
	 * Inicializa el boton que lleva al Dialogo de Coleccion.
	 * @return un boton interactivo JButton
	 */
	private JButton pestaña2() {
		JButton b = new JButton("Ver Coleccion");
		b.addActionListener(e ->{});
		
		return b;
	}

	/**
	 * Lee el archivo "Sobres.txt" con la informacion pertinente.
	 * @throws IOException
	 */
	private void leerArch() throws IOException{
		File file = new File("txts/Sobres.txt");
		Scanner lector = new Scanner(file);
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			
			system.leerCarta(partes);
		}
		
		lector.close();
	}
	

}
