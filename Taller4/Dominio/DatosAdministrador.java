package Dominio;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.InterfazSystem;

/**
 * <tt>DatosAdminstrador</tt> es una clase que implementa el JDialog
 * de manera que me da la posibilidad de establecer un dialogo interactivo con distintos paneles.
 * @author Eugenio Cortés Egaña
 * @author Matias Nuñez Gonzalez
 * 
 */
public class DatosAdministrador extends JDialog{

	private boolean saveClicked = false;
	private JPanel panelCartas;
	private InterfazSystem sistema;
	
	/**
	 * 
	 * @param owner
	 */
	public DatosAdministrador(JFrame owner, InterfazSystem sistema) {
		super(owner, "Administracion", true);
		this.sistema = sistema;
		initComponents();
		showDialog();
	}
	
	private void initComponents() {
		
		JButton agregar = new JButton("Agregar carta");
		JButton eliminar = new JButton("Eliminar carta");
		JButton modificar = new JButton("Modificar carta");
		JButton exitButton = new JButton("Salir.");
		
        panelCartas = new JPanel();
        panelCartas.setLayout(new BoxLayout(panelCartas, BoxLayout.Y_AXIS));
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(agregar);
		add(eliminar);
	    add(modificar);
	    add(exitButton);
	    
	    add(panelCartas);
		
	    agregar.addActionListener(e->{
	    	agregadoCartaComponentes(this);
	    	});
	    
	    eliminar.addActionListener(e->{});
	    modificar.addActionListener(e->{});
		exitButton.addActionListener(e -> {
			dispose();
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new EscuchadorCierreVentana());
	}


	/**
	 * Muestra un panel con una seleccion de tipos de cartas, derivando a abrirFormularioCarta segun la eleccion.
	 * <p>
	 * @param owner La instancia del JDialog.
	 */
	private void agregadoCartaComponentes(DatosAdministrador owner) {
		// Primer diálogo: elegir tipo de carta
	    JDialog dialogoTipo = new JDialog(owner, "Elegir tipo de carta", true);
	    dialogoTipo.setLayout(new BoxLayout(dialogoTipo.getContentPane(), BoxLayout.Y_AXIS));

	    JButton btnPokemon = new JButton("Pokemon");
	    JButton btnItem= new JButton("Item");
	    JButton btnSupporter= new JButton("Supporter");
	    JButton btnEnergy = new JButton("Energy");

	    dialogoTipo.add(btnPokemon);
	    dialogoTipo.add(btnItem);
	    dialogoTipo.add(btnSupporter);
	    dialogoTipo.add(btnEnergy);

	    btnPokemon.addActionListener(e -> {
	        dialogoTipo.dispose();          // cierro el diálogo de selección
	        abrirFormularioCarta(owner, "Pokemon");  // abro el formulario
	    });

	    btnItem.addActionListener(e -> {
	        dialogoTipo.dispose();
	        abrirFormularioCarta(owner, "Item");
	    });

	    btnSupporter.addActionListener(e -> {
	        dialogoTipo.dispose();
	        abrirFormularioCarta(owner, "Supporter");
	    });
	    
	    btnEnergy.addActionListener(e -> {
	        dialogoTipo.dispose();
	        abrirFormularioCarta(owner, "Energy");
	    });

	    dialogoTipo.pack();
	    dialogoTipo.setLocationRelativeTo(owner);
	    dialogoTipo.setVisible(true);
	}

	
	/**
	 * Abre el panel del llenado datos segun el tipo de la carta.
	 * <p>
	 * @param owner La instancia del JDialog.
	 * @param string El tipo de la carta.
	 */
	private void abrirFormularioCarta(DatosAdministrador owner, String string) {
		// Segundo dialogo: llenado del agregado del tipo de carta.
	    JDialog dialogoTipo = new JDialog(owner, "Datos carta", true);
	    dialogoTipo.setLayout(new BoxLayout(dialogoTipo.getContentPane(), BoxLayout.Y_AXIS));
	    
	    JLabel nom = new JLabel("Ingrese el nombre de la carta.");
	    JTextField ingresoNom = new JTextField();
    	dialogoTipo.add(nom);
        dialogoTipo.add(ingresoNom);
	    
	    JLabel rare = new JLabel("Ingrese la rareza de la carta.");
	    JTextField ingresoRare = new JTextField();
	    dialogoTipo.add(rare);
	    dialogoTipo.add(ingresoRare);
	    
	    JLabel especifica = new JLabel();//Para los tipos de carta con ingreso unitario de datos...
	    JTextField ingresoEspecifico = new JTextField();
	    
	    JLabel daño = new JLabel("Ingrese el daño del pokemon.");
    	JTextField ingresoDaño = new JTextField();
    	
    	JLabel cantEnergy = new JLabel("Ingrese la cantidad de energias del pokemon.");
    	JTextField ingresoCant = new JTextField();
	    
	    switch(string) {
	    case "Pokemon":
            dialogoTipo.add(daño);
            dialogoTipo.add(ingresoDaño);
            dialogoTipo.add(cantEnergy);
            dialogoTipo.add(ingresoCant);
	    	break;
	    	
	    case "Item":
	    	especifica.setText("Ingrese la bonificacion.");
	    	dialogoTipo.add(especifica);
            dialogoTipo.add(ingresoEspecifico);
	    	break;
	    	
	    case "Supporter":
	    	especifica.setText("Ingrese los efectos por turnos.");
	    	dialogoTipo.add(especifica);
            dialogoTipo.add(ingresoEspecifico);
	    	break;
	    	
	    case "Energy":
	    	especifica.setText("Ingrese el elemento de la energia.");
	    	dialogoTipo.add(especifica);
            dialogoTipo.add(ingresoEspecifico);
	    	break;
	    }
	    
	    //Botones para guardar la informaciomn y salir exitosamente.
	    JButton save = new JButton("Save");
	    JButton cancel = new JButton("Cancel");
	    
	    //Creo una botonera de manera que los botones tienen su seccion el dialogotipo.
	    JPanel botonera = new JPanel();
	    botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));
	    
	    botonera.add(save);
	    botonera.add(cancel);
	    
	    //Agrego la botonera en el jdialog(panel).
	    dialogoTipo.add(botonera, BorderLayout.SOUTH);
	    
	    //Guardado de datos y control de errores.
	    save.addActionListener(e -> {
	    	
	    	String nombreCarta = null;
	    	int rareza = 0;
	    	try {
		    	nombreCarta = ingresoNom.getText();
		    	rareza = Integer.parseInt(ingresoRare.getText());
	    	}catch(Exception a) {
	    		JOptionPane.showMessageDialog(null, "Ingrese datos de acuerdo al campo.");
	    	}
	        
	    	if(nombreCarta.isEmpty() || rareza < 0) {
	    		JOptionPane.showMessageDialog(null, "Complete el nombre y la rareza de la carta como un entero...");
	    		return;
	    	}
	    	
	    	switch(string) {
	    	case "Pokemon":
	    		int dañoValor = 0;
	    		int cantValor = 0;
	    		
	    		try {
	    			dañoValor = Integer.parseInt(ingresoDaño.getText());
	    			cantValor = Integer.parseInt(ingresoCant.getText());
	    		}catch(Exception c) {
	    			JOptionPane.showMessageDialog(null, "Ingrese datos acorde al campo.");
	    			return;
	    		}
	    		
	    		if(dañoValor < 0 || cantValor < 0) {
	    			JOptionPane.showMessageDialog(null, "Daño y Cantidad de energias deben ser mayor que 0.");
	    		}
	    		
	    		//Creo la lista de manera que podamos llamar al metodo del sistema.
	    		String[] partes = {nombreCarta,String.valueOf(rareza),string,String.valueOf(dañoValor),String.valueOf(cantValor)};
	    		sistema.leerCarta(partes);
	    		
	    		dialogoTipo.dispose();
	    		break;
	    		
	    		
	    		
	    	case "Item":
	    	case "Supporter":
	    		int valorEspecifico = 0;
	    		
	    		try {
	    			valorEspecifico = Integer.parseInt(ingresoEspecifico.getText());
	    		}catch(Exception c) {
	    			JOptionPane.showMessageDialog(null, "Ingrese datos acordes al campo.");
	    			return;
	    		}
	    		
	    		if(valorEspecifico < 0) {
	    			JOptionPane.showMessageDialog(null, "El valor especifico de la carta debe ser mayor que 0");
	    		}
	    		
	    		String[] partes2 = {nombreCarta,String.valueOf(rareza),string,String.valueOf(valorEspecifico)};
	    		sistema.leerCarta(partes2);
	    		
	    		dialogoTipo.dispose();
	    		break;
	    		
	    	case "Energy":
	    		String tipoEnergy = ingresoEspecifico.getText();
	    		
	    		if(tipoEnergy.isEmpty()) {
	    			JOptionPane.showMessageDialog(null, "Ingrese el tipo de la energia.");
	    		}
	    		
	    		String[] partes3 = {nombreCarta,String.valueOf(rareza),string,tipoEnergy};
	    		sistema.leerCarta(partes3);
	    		
	    		dialogoTipo.dispose();
	    		break;
	    		
	    	}
	    });
	    cancel.addActionListener(e ->{
	    	dispose();
	    });
	    
	    dialogoTipo.pack();
	    dialogoTipo.setLocationRelativeTo(owner);
	    dialogoTipo.setVisible(true);
	}


	
	private class EscuchadorCierreVentana extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			onCancel();
		}
	}
	
	
	private void onCancel()
    {
        dispose();
    }

    public boolean showDialog()
    {
        pack();
        setLocationRelativeTo(getParent());
        
        setVisible(true);

        return saveClicked;
    }


}
