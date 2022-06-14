package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.operaciones.Persona;
import modelo.operaciones.Procesos;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaPersonas;
import vista.gui.VentanaOperaciones;

public class Coordinador {
	private VentanaOperaciones ventanaOperaciones;
	private VentanaConsulta ventanaConsulta;
	private VentanaConsultaGeneral ventanaConsultaGeneral;
	private VentanaConsultaPersonas ventanaConsultaPersonas;
	private Procesos misProcesos;	

	public void setVentanaOperaciones(VentanaOperaciones ventanaOperaciones) {
		this.ventanaOperaciones = ventanaOperaciones;		
	}

	public void setVentanaConsulta(VentanaConsulta ventanaConsulta) {
		this.ventanaConsulta = ventanaConsulta;		
	}

	public void setVentanaGeneral(VentanaConsultaGeneral ventanaConsultaGeneral) {
		this.ventanaConsultaGeneral = ventanaConsultaGeneral;		
	}

	public void setVentanaConsultaPersonas(VentanaConsultaPersonas ventanaConsultaPersonas) {
		this.ventanaConsultaPersonas = ventanaConsultaPersonas;		
	}

	public void setProcesos(Procesos misProcesos) {
		this.misProcesos = misProcesos;		
	}

	public void mostrarVentanaPrincipal() {
		ventanaOperaciones.setVisible(true);
		
	}

	public double calcularPromedio(Persona estudiante) {
		return misProcesos.calcularPromedio(estudiante);		
	}

	public String calcularDefinitiva(double promedio) {		
		return misProcesos.calcularDefinitiva(promedio);
	}

	public void registrarEnBD(Persona estudiante) {
		misProcesos.registrarEnBD(estudiante);		
	}

	public void mostrarVentanaConsultaPersonas() {
		if(misProcesos.getLista().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay información en la lista");
		} else {
			ventanaConsultaPersonas.llenarTabla();
			ventanaConsultaPersonas.setVisible(true);			
		}		
	}

	public ArrayList<Persona> getLista() {
		return misProcesos.getLista();
	}

	public void mostrarVentanaConsulta() {
		ventanaConsulta.setVisible(true);		
	}

	public void mostrarVentanaConsultaGeneral() {
		ventanaConsultaGeneral.mostrarListaEnArea();
		ventanaConsultaGeneral.setVisible(true);		
	}

	public Persona obtenerEstudiante(String documento) {
		return misProcesos.obtenerEstudiante(documento);
	}
}