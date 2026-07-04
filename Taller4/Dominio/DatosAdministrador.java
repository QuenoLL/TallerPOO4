package Dominio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
 * @author [Eugenio Cortés Egaña, Matias Nuñez Gonzalez]
 * @version 1.0
 * @see JDialog
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
	
	/**
	 * Carga los componentes del JDialog principal
	 * <p>
	 * Menu interactivo con distintas funcionalidades que  derivan a distintos metodos administrativos del mundo TCG Pokemon.
	 */
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
	    
	    eliminar.addActionListener(e->{
	    	elimarCarta(this);
	    });
	    
	    modificar.addActionListener(e->{
	    	modificarCarta(this);
	    });
		exitButton.addActionListener(e -> {
			dispose();
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new EscuchadorCierreVentana());
	}


	/**
	 * Modifica una carta existente a eleccion del usuario
	 * <p>
	 * @param datosAdministrador JDialog padre
	 */
	private void modificarCarta(DatosAdministrador owner) {
		//Dialogo de la modificacion de cartas.
		JDialog dialogoModificacion = new JDialog(owner,"Modificacion de carta",true);
		dialogoModificacion.setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Cartas en el Sistema.");
		JPanel panelTitulo = new JPanel();
		panelTitulo.add(titulo);
		dialogoModificacion.add(panelTitulo, BorderLayout.NORTH);//Añado el panel para que se centre en el medio el titulo (esa es la idea).
		
		JPanel panelCentral =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		
		JLabel printeo = new JLabel(sistema.viewCartas());
		panelCentral.add(printeo);
		dialogoModificacion.add(panelCentral, BorderLayout.CENTER);
		
		JPanel datos = new JPanel();
		datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
		
		JLabel ingreso = new JLabel("Ingrese el numero de la carta a modificar.");
		JTextField ingresoNum = new JTextField();
		JButton save = new JButton("Save");
		
		datos.add(ingreso);
		datos.add(ingresoNum);
		datos.add(save);
		dialogoModificacion.add(datos,BorderLayout.SOUTH);
		
		
		save.addActionListener(e ->{
			int indiceCarta = 0;
			
			try {
				indiceCarta = Integer.parseInt(ingresoNum.getText());
			}catch(Exception c) {
				JOptionPane.showMessageDialog(null, "ERROR. "+c.getMessage());
			}
			
			if(indiceCarta < 1 || indiceCarta > sistema.getTamañoLista()) {
				JOptionPane.showMessageDialog(null, "Ingrese un indice de acuerdo a los entregados.");
				return;
			}
			
			indiceCarta--; //Para ajustarlo al indice correspondiente de la lista estatica
			
			dialogoModificacion.dispose();
			formularioModificacion(owner, sistema.getTipoCarta(indiceCarta), indiceCarta);
			
		});
		
		dialogoModificacion.pack();
		dialogoModificacion.setLocationRelativeTo(owner);
		dialogoModificacion.setVisible(true);
		
		
	}
	
	/**
	 * Abre un formulario correspondiente al tipo de la carta para su posterior modificacion.
	 * <p>
	 * @param owner JDialog padre
	 * @param tipo Tipo de la clase a modificar.
	 */
	private void formularioModificacion(DatosAdministrador owner, String tipo, int indiceCarta) {
		//JDialog para poder modificar la carta.
		JDialog formularioModificacion = new JDialog(owner, "Formulario Modificacion", true);
		formularioModificacion.setLayout(new BoxLayout(formularioModificacion.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel titulo = new JLabel("Seleccione el atributo a modificar.");
		JPanel panelNorte = new JPanel();
		panelNorte.add(titulo);
		
		switch(tipo) {
		case "Pokemon":
			//Pokemon al tener dos datos debe de 
			formularioModificacion.add(panelNorte, BorderLayout.NORTH);
			
			JButton daño = new JButton("Daño");
			JButton cantidadEnergy = new JButton("Cantidad de Energias");
			JPanel panelCentral = new JPanel();
			panelCentral.add(daño);
			panelCentral.add(cantidadEnergy);
			
			formularioModificacion.add(panelCentral, BorderLayout.CENTER);
			
			daño.addActionListener(e -> {
				formularioModificacion.dispose();
				pedirNuevoValor(owner, indiceCarta, tipo, "Daño");
			});
			
			cantidadEnergy.addActionListener(e->{
				formularioModificacion.dispose();
				pedirNuevoValor(owner, indiceCarta, tipo, "Cantidad");
			});
			break;
			
		case "Energy":
			JLabel etiqueta = new JLabel("Ingrese el elemento de la energia.");
			JTextField ingresoElemento = new JTextField();
			
			
			formularioModificacion.add(etiqueta);
			formularioModificacion.add(ingresoElemento);
			
			JButton saveEnergy = new JButton("Save");
			formularioModificacion.add(saveEnergy);
			
			saveEnergy.addActionListener(e ->{
				String elemento = null;
				
				try {
					elemento = ingresoElemento.getText().trim();
				}catch(Exception c) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor de acuerdo al campo.");
				}
				
		    	if(elemento.isEmpty()) {
		    		JOptionPane.showMessageDialog(null, "Complete el nombre del elemento");
		    		return;
		    	}
		    	
		    	sistema.modificarAtributo(indiceCarta, "elemento", elemento);
		    	formularioModificacion.dispose();
				
			});
			
			break;
			
		case "Supporter":
			JLabel etiqueta2 = new JLabel("Ingrese los efectos por turno");
			JTextField ingresoEfectos = new JTextField();
			
			formularioModificacion.add(etiqueta2);
			formularioModificacion.add(ingresoEfectos);
			
			JButton saveSupo = new JButton("Save");
			formularioModificacion.add(saveSupo);
			
			saveSupo.addActionListener(e ->{
				int  efectos = 0;
				
				try {
					efectos = Integer.parseInt(ingresoEfectos.getText());
				}catch(Exception c) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor de acuerdo al campo.");
				}
				
		    	if(efectos < 0) {
		    		JOptionPane.showMessageDialog(null, "Ingrese un valor apto a lo solicitado");
		    		return;
		    	}
		    	
		    	sistema.modificarAtributo(indiceCarta, "efecto", String.valueOf(efectos));
		    	formularioModificacion.dispose();
		    	});
		    	
			
			break;
			
		case "Item":
			JLabel etiqueta3 = new JLabel("Ingrese la bonifiacion por turno");
			JTextField ingresoBoni= new JTextField();
			
			
			formularioModificacion.add(etiqueta3);
			formularioModificacion.add(ingresoBoni);
			
			JButton saveBoni = new JButton("Save");
			formularioModificacion.add(saveBoni);
			
			saveBoni.addActionListener(e ->{
				int bonificacion = 0;
				
				try {
					bonificacion = Integer.parseInt(ingresoBoni.getText());
				}catch(Exception c) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor de acuerdo al campo.");
				}
				
		    	if(bonificacion < 0) {
		    		JOptionPane.showMessageDialog(null, "Ingrese un valor apto a lo solicitado");
		    		return;
		    	}
		    	
		    	sistema.modificarAtributo(indiceCarta, "bonificacion", String.valueOf(bonificacion));
		    	formularioModificacion.dispose();
			});
			
			
			break;
		}
		
		
		
		formularioModificacion.pack();
		formularioModificacion.setLocationRelativeTo(owner);
		formularioModificacion.setVisible(true);
		
	}

	/**
	 * Pide un nuevo valor especificamente para la sub clase pokemon.
	 * <p>
	 * Debido a que cuenta con dos atributos especificos, se pide los datos para diferenciar en este metodo
	 * @param owner JDialog padre
	 * @param indiceCarta indice de la carta segun la lista estatica del sistema implementado
	 * @param tipo Tipo de la carta en especifico
	 * @param obj Tipo de atributo del pokemon a cambiar
	 */
	private void pedirNuevoValor(DatosAdministrador owner, int indiceCarta, String tipo, String obj) {
		JDialog dialogoNuevo = new JDialog(owner, "Pedir nuevo Valor variable", true);
		
	    dialogoNuevo.setLayout(new BoxLayout(dialogoNuevo.getContentPane(), BoxLayout.Y_AXIS));

	    JLabel etiqueta = new JLabel("Ingrese el nuevo valor para " + obj + ":");
	    JTextField campo = new JTextField();
	    JButton guardar = new JButton("Guardar");

	    dialogoNuevo.add(etiqueta);
	    dialogoNuevo.add(campo);
	    dialogoNuevo.add(guardar);

	    guardar.addActionListener(e -> {
	        try {
	            sistema.modificarAtributo(indiceCarta, obj, campo.getText());
	            dialogoNuevo.dispose();
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(dialogoNuevo, "ERROR. "+ex.getMessage());
	        }
	    });
	    
		dialogoNuevo.pack();
		dialogoNuevo.setLocationRelativeTo(owner);
		dialogoNuevo.setVisible(true);
		
	}

	/**
	 * Elimina una carta a travez de una JDialog interactivo con el usuario
	 * <p>
	 * @param owner JDialog padre
	 */
	private void elimarCarta(DatosAdministrador owner) {
		//Dialogo de eliminacion de la carta.
		JDialog dialogoEliminacion = new JDialog(owner,"Eliminar carta", true);
		dialogoEliminacion.setLayout(new BoxLayout(dialogoEliminacion.getContentPane(), BoxLayout.Y_AXIS));
		
		//Etiquetas y textfields.
		JLabel etiquetaNombre = new JLabel("Ingrese el nombre de la carta a eliminar.");
		JTextField ingresoCarta = new JTextField();
		
		JButton save = new JButton("Save");
		JButton cancel = new JButton("Cancel");
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));
		
		botonera.add(save);
		botonera.add(cancel);
		
		//Agregado de componentes al JDialog
		dialogoEliminacion.add(etiquetaNombre);
		dialogoEliminacion.add(ingresoCarta);
		dialogoEliminacion.add(botonera, BorderLayout.SOUTH);
		
		save.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, sistema.eliminarCarta(ingresoCarta.getText()));
			dialogoEliminacion.dispose();
		});
		
		cancel.addActionListener(e ->{
			dialogoEliminacion.dispose();
		});
		
		
		//Funcionalidades basicas del JDialog
	    dialogoEliminacion.pack();
	    dialogoEliminacion.setLocationRelativeTo(owner);
	    dialogoEliminacion.setVisible(true);
		
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
	    	dialogoTipo.dispose();
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
