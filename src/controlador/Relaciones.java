package controlador;

import modelo.dao.EstudianteDAO;
import modelo.operaciones.Procesos;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaPersonas;
import vista.gui.VentanaOperaciones;

public class Relaciones {
	
	public void iniciar() {
		
		// Se instancian las clases
		VentanaOperaciones ventanaOperaciones = new VentanaOperaciones();
		VentanaConsulta ventanaConsulta = new VentanaConsulta();
		VentanaConsultaGeneral ventanaConsultaGeneral = new VentanaConsultaGeneral();
		VentanaConsultaPersonas ventanaConsultaPersonas = new VentanaConsultaPersonas();
		Procesos misProcesos = new Procesos();
		EstudianteDAO miEstudianteDAO = new EstudianteDAO();
		Coordinador miCoordinador = new Coordinador();
		
		// Se establecen las relaciones entre clases
		ventanaOperaciones.setCoordinador(miCoordinador);
		ventanaConsulta.setCoordinador(miCoordinador);
		ventanaConsultaGeneral.setCoordinador(miCoordinador);
		ventanaConsultaPersonas.setCoordinador(miCoordinador);		
		misProcesos.setCoordinador(miCoordinador);
		miEstudianteDAO.setCoordinador(miCoordinador);
		
		// Se establecen relaciones con la clase Coordinador
		miCoordinador.setVentanaOperaciones(ventanaOperaciones);
		miCoordinador.setVentanaConsulta(ventanaConsulta);
		miCoordinador.setVentanaGeneral(ventanaConsultaGeneral);
		miCoordinador.setVentanaConsultaPersonas(ventanaConsultaPersonas);
		miCoordinador.setProcesos(misProcesos);
		miCoordinador.setEstudianteDAO(miEstudianteDAO);
		
		miCoordinador.mostrarVentanaPrincipal();
	}
}
