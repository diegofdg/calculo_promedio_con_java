package procesos;

import java.awt.Color;

public class Procesos {
	public double calcularPromedio(double n1, double n2, double n3) {
		double promedio = (n1+n2+n3)/3;
		return promedio;		
	}

	public String calcularDefinitiva(double promedio) {
		
		if(promedio >= 3.5) {
			return "Aprobado";
			//lblResultado.setText();
			//lblResultado.setForeground(Color.GREEN);
		} else {
			return "No Aprobado";
			//lblResultado.setText("Resultado: No Aprobado");
			//lblResultado.setForeground(Color.RED);
		}
	}
}