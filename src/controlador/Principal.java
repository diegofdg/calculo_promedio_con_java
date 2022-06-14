package controlador;

import modelo.conexion.Conexion;

public class Principal {
	
	public static void main(String[] args) {
		
		new Relaciones().iniciar();
		Conexion miConexion = new Conexion();
		String respuesta = miConexion.conectar();
		System.out.println(respuesta);
	}
}