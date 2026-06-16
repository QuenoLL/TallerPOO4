// Nombre: Eugenio Cortés Egaña; Rut: 22.405.687-7
// Nombre: Matías Núñez González; Rut: 22.256.666-5
package Logica;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
	
	private static InterfazSystem system = SystemImpl.getSystema();
	//private static Scanner entrada = new Scanner(System.in);
	
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
		
		ventana.getContentPane().add(createGUI(ventana));
		ventana.setVisible(true);
	}

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
	

	private JButton pestaña1(JFrame ventana) {
		JButton b = new JButton("Administracion");
		b.addActionListener(e ->{system.getDatosAdmin(ventana);
		});
		
		return b;
	}

	private JButton pestaña2() {
		JButton b = new JButton("Ver Coleccion");
		b.addActionListener(e ->{});
		
		return b;
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
