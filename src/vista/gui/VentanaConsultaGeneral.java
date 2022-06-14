package vista.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.operaciones.Persona;

public class VentanaConsultaGeneral extends JFrame {

	private JPanel panelPrincipal;
	private JTextArea areaInformacion;
	private Coordinador miCoordinador;
	
	public VentanaConsultaGeneral() {
		setSize(527, 337);
		setTitle("CALCULO DE PROMEDIO");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		panelPrincipal.setLayout(null);
		setContentPane(panelPrincipal);
		
		JLabel lblTitulo = new JLabel("IMPRIMIR INFORMACION");
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 60, 489, 230);
		panelPrincipal.add(scroll);
		
		areaInformacion = new JTextArea();
		areaInformacion.setWrapStyleWord(true);
		areaInformacion.setLineWrap(true);
		areaInformacion.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		scroll.setViewportView(areaInformacion);
	}

	public void mostrarListaEnArea() {
		ArrayList<Persona> listaPersonas = miCoordinador.getLista();
		String cadena = "INFORMACION PERSONAS\n";
		
		if(!listaPersonas.isEmpty()) {
			for(Persona persona : listaPersonas) {
				cadena += "Documento: "+persona.getDocumento()+"\n";
				cadena += "Nombre: "+persona.getNombre()+"\n";
				cadena += "Nota 1: "+persona.getNota1()+"Nota 2: "+persona.getNota2()+"Nota 3: "+persona.getNota3()+"\n";
				cadena += "Promedio: "+persona.getPromedio()+"\n\n";			
			}
			areaInformacion.setText(cadena);			
		} else {
			areaInformacion.setText("NO SE HAN REGISTRADO ESTUDIANTES");
		}		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}
}