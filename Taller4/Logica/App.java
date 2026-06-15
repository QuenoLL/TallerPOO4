// Nombre: Eugenio Cortés Egaña; Rut: 22.405.687-7
// Nombre: Matías Núñez González; Rut: 22.256.666-5
package Logica;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
	
	private static InterfazSystem system = SystemImpl.getSystema();
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		
		App m = new App();
		m.ejecutar();
		
	}

	private void ejecutar() throws IOException{
		leerArch();
		panel();
	}

	private void panel() {
		JFrame ventana = new JFrame("Universo TCG");
		ventana.setSize(300,400);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.getContentPane().add(createGUI());
		ventana.setVisible(true);
	}

	private JPanel createGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel pestañas = new JPanel();
		pestañas.setLayout(new BoxLayout(pestañas, BoxLayout.LINE_AXIS));
		
		return mainPanel;
	}

	private void leerArch() throws IOException{
		File file = new File("txts/Sobres.txt");
		Scanner lector = new Scanner(file);
		
		while(lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			
			system.crearCarta(partes);
		}
		
		lector.close();
	}
	

}
