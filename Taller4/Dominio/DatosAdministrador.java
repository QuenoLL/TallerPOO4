package Dominio;

import java.awt.event.WindowAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatosAdministrador extends JDialog{

	private boolean saveClicked = false;
	
	public DatosAdministrador(JFrame owner) {
		super(owner, "Administracion", true);
		initComponents();
	}
	
	private void initComponents() {
		
		JButton agregar = new JButton("Agregar carta");
		JButton eliminar = new JButton("Eliminar carta");
		JButton modificar = new JButton("Modificar carta");
		JButton exitButton = new JButton("Salir.");
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(agregar);
		add(eliminar);
	    add(modificar);
	    add(exitButton);
		
	    agregar.addActionListener(e->{JOptionPane.showInputDialog(null, "Ingrese la carta a agregar: ");});
	    eliminar.addActionListener(e->{});
	    modificar.addActionListener(e->{});
		exitButton.addActionListener(e -> {
			dispose();
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new EscuchadorCierreVentana());
		showDialog();
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
        
        // If the dialog is not already visible, this call will not 
        // return until the dialog is hidden by calling setVisible(false) 
        // or dispose(). 
        setVisible(true);

        return saveClicked;
    }


}
