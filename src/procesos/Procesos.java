package procesos;

import java.util.ArrayList;
import java.util.Iterator;

public class Procesos {
	
	ArrayList<Persona> listaPersonas;
	
	public Procesos() {
		listaPersonas = new ArrayList<Persona>();
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

	public double calcularPromedio(Persona estudiante) {
		double promedio = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3()) / 3;
		return promedio;
	}

	public void registrarEnBD(Persona estudiante) {
		System.out.println("Se registra en la BD");
		listaPersonas.add(estudiante);
		
	}
	public void imprimirListaEstudiantes() {
		for(Persona persona : listaPersonas) {
			System.out.println(persona);
		}		
	}
	
	public ArrayList<Persona> getLista() {
		return listaPersonas;		
	}
	
	public Persona obtenerEstudiante(String documento) {
		Persona p = null;
		for(Persona persona : listaPersonas) {
			if(persona.getDocumento().equals(documento)) {
				p = persona;
				//System.out.println(persona);
			}	
		}
		return p;
	}
}