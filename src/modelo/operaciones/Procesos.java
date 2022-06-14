package modelo.operaciones;

import java.util.ArrayList;

import controlador.Coordinador;
import modelo.vo.EstudianteVO;

public class Procesos {
	
	ArrayList<EstudianteVO> listaPersonas;
	private Coordinador miCoordinador;
	
	public Procesos() {
		listaPersonas = new ArrayList<EstudianteVO>();
	}
	public double calcularPromedio(double n1, double n2, double n3) {
		double promedio = (n1+n2+n3)/3;
		return promedio;		
	}

	public String calcularDefinitiva(double promedio) {
		
		if(promedio >= 3.5) {
			return "Aprobado";
		} else {
			return "No Aprobado";
		}
	}

	public double calcularPromedio(EstudianteVO estudiante) {
		double promedio = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3()) / 3;
		return promedio;
	}

	public void registrarEnBD(EstudianteVO estudiante) {
		System.out.println("Se registra en la BD");
		listaPersonas.add(estudiante);
		
	}
	public void imprimirListaEstudiantes() {
		for(EstudianteVO persona : listaPersonas) {
			System.out.println(persona);
		}		
	}
	
	public ArrayList<EstudianteVO> getLista() {
		return listaPersonas;		
	}
	
	public EstudianteVO obtenerEstudiante(String documento) {
		EstudianteVO p = null;
		for(EstudianteVO persona : listaPersonas) {
			if(persona.getDocumento().equals(documento)) {
				p = persona;
			}	
		}
		return p;
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}
}