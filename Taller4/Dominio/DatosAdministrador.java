package Dominio;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatosAdministrador extends JDialog{

	private boolean saveClicked = false;
	private JPanel panelCartas;
	
	public DatosAdministrador(JFrame owner) {
		super(owner, "Administracion", true);
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


	private void abrirFormularioCarta(DatosAdministrador owner, String string) {
		// Segundo dialogo: llenado del agregado del tipo de carta.
	    JDialog dialogoTipo = new JDialog(owner, "Datos carta", true);
	    dialogoTipo.setLayout(new BoxLayout(dialogoTipo.getContentPane(), BoxLayout.Y_AXIS));
	    
	    JLabel nom = new JLabel("Ingrese el nombre de la carta");
	    JTextField ingresoNom = new JTextField();
	    
	    
	    switch(string) {
	    case "Pokemon":
	    	break;
	    }
	    
	    
	    
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
