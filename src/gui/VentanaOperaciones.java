package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import procesos.Persona;
import procesos.Procesos;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnCalcular;
	private JLabel lblResPromedio;
	private JLabel lblResultado;
	Procesos misProcesos;	
	private JButton btnImprimirTotal;
	private JLabel lblDoc;
	private JTextField txtDocumento;
	private JButton btnConsultarEstudiante;
	private AbstractButton btnConsultarLista;
	

	public VentanaOperaciones() {
		misProcesos = new Procesos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(486, 531);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CALCULO DE PROMEDIO");
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(null);
		setContentPane(panelPrincipal);
		
		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setOpaque(true);		
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 86, 100, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 80, 200, 39);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 135, 100, 23);		
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 129, 63, 39);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 135, 100, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 129, 63, 39);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 135, 100, 23);
		panelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 129, 63, 39);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota3);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 245, 127, 31);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 245, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 286, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalcular.setBounds(310, 190, 117, 31);
		btnCalcular.addActionListener(this);
		panelPrincipal.add(btnCalcular);
		
		btnImprimirTotal = new JButton("Imprimir total");
		btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimirTotal.setBounds(28, 365, 136, 31);
		btnImprimirTotal.addActionListener(this);
		panelPrincipal.add(btnImprimirTotal);
		
		lblDoc = new JLabel("Doc:");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(312, 86, 42, 23);
		panelPrincipal.add(lblDoc);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(364, 78, 63, 39);
		panelPrincipal.add(txtDocumento);
		
		btnConsultarEstudiante = new JButton("Consultar");
		btnConsultarEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarEstudiante.setBounds(327, 365, 100, 31);
		btnConsultarEstudiante.addActionListener(this);
		panelPrincipal.add(btnConsultarEstudiante);
		
		btnConsultarLista = new JButton();
		btnConsultarLista.setText("Consulta Total");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(181, 365, 136, 31);
		btnConsultarLista.addActionListener(this);
		panelPrincipal.add(btnConsultarLista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCalcular) {			
			calcularPromedio();
			
		} else if(e.getSource() == btnImprimirTotal) {			
			misProcesos.imprimirListaEstudiantes();
			VentanaConsultaGeneral miConsultaGeneral = new VentanaConsultaGeneral();
			miConsultaGeneral.setProcesos(misProcesos);
			miConsultaGeneral.mostrarListaEnArea();
			miConsultaGeneral.setVisible(true);
			
		} else if(e.getSource() == btnConsultarEstudiante) {
			VentanaConsulta miVentanaConsulta = new VentanaConsulta();
			miVentanaConsulta.asignarProcesos(misProcesos);
			miVentanaConsulta.setVisible(true);
			
		} else if (e.getSource()==btnConsultarLista) {
			VentanaConsultaPersonas miVentanaConsultaPersonas = new VentanaConsultaPersonas();
			miVentanaConsultaPersonas.setProcesos(misProcesos);
			miVentanaConsultaPersonas.llenarTabla();
			miVentanaConsultaPersonas.setVisible(true);			
		}
	}

	private void calcularPromedio() {
		Persona estudiante = new Persona();
		estudiante.setNombre(txtNombre.getText());
		estudiante.setDocumento(txtDocumento.getText());
		
		try {
			estudiante.setNota1(Double.parseDouble(txtNota1.getText()));
			estudiante.setNota2(Double.parseDouble(txtNota2.getText()));
			estudiante.setNota3(Double.parseDouble(txtNota3.getText()));			
			estudiante.setPromedio(misProcesos.calcularPromedio(estudiante));
			
			lblResPromedio.setText(estudiante.getPromedio()+" ");
			
			String resultado = misProcesos.calcularDefinitiva(estudiante.getPromedio());
			
			misProcesos.registrarEnBD(estudiante);
			
			if(resultado.equals("Aprobado")) {
				lblResultado.setText("Resultado: "+resultado);
				lblResultado.setForeground(Color.GREEN);				
			} else {
				lblResultado.setText("Resultado: "+resultado);
				lblResultado.setForeground(Color.RED);
			}			
					
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error de ingreso de texto", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurre un error, verifique los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}				
	}
}