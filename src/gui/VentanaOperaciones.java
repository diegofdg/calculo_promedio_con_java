package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import procesos.Procesos;

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
	

	public VentanaOperaciones() {
		misProcesos = new Procesos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 625, 372);
		setSize(491, 382);
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
		txtNombre.setBounds(95, 80, 332, 39);
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCalcular) {			
			calcularPromedio();
		}		
	}

	private void calcularPromedio() {
		String nombreString = txtNombre.getText();
		
		try {
			double n1 = Double.parseDouble(txtNota1.getText());
			double n2 = Double.parseDouble(txtNota2.getText());
			double n3 = Double.parseDouble(txtNota3.getText());			
			double promedio = misProcesos.calcularPromedio(n1, n2, n3);	
			
			lblResPromedio.setText(promedio+"");
			
			String resultado = misProcesos.calcularDefinitiva(promedio);
			
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