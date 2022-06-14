package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.vo.EstudianteVO;

public class VentanaConsultaPersonas extends JFrame {

	private JPanel panelPrincipal;
	private JTable tablaEstudiantes;
	private DefaultTableModel model;
	private Coordinador miCoordinador;

	public VentanaConsultaPersonas() {
		setSize(507, 343);
		setTitle("CALCULO DE PROMEDIO");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("MOSTRAR PERSONAS");
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 473, 236);
		panelPrincipal.add(scrollPane);
		
		tablaEstudiantes = new JTable();
		
		scrollPane.setViewportView(tablaEstudiantes);		
	}

	public void llenarTabla() {
		ArrayList<EstudianteVO> listaPersonas = miCoordinador.getLista();
		
		crearModelo();
		
		for(EstudianteVO persona : listaPersonas) {
			Object[] fila = new Object[6];
			fila[0] = persona.getDocumento();
			fila[1] = persona.getNombre();
			fila[2] = persona.getNota1();
			fila[3] = persona.getNota2();
			fila[4] = persona.getNota3();
			fila[5] = persona.getPromedio();
			
			model.addRow(fila);
		}		
	}
	
	private void crearModelo() {
		model = new DefaultTableModel();
		tablaEstudiantes.setModel(model);
		model.addColumn("Documento");
		model.addColumn("Nombre");
		model.addColumn("Nota 1");
		model.addColumn("Nota 2");
		model.addColumn("Nota 3");
		model.addColumn("Promedio");
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}
}