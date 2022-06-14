package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.operaciones.Persona;

public class VentanaConsulta extends JFrame implements ActionListener {
	
	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JButton btnConsultar;
	private JLabel lblResPromedio;
	private JLabel lblResultado;
	private JLabel lblDoc;
	private JTextField txtDocumento;
	private Coordinador miCoordinador;
	
	public VentanaConsulta() {
		setSize(477, 379);
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
		
		JLabel lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setBackground(Color.BLACK);
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setOpaque(true);		
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConsultar.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblConsultar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 116, 100, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 110, 332, 39);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 165, 100, 23);		
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(95, 159, 63, 39);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(168, 165, 100, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(232, 159, 63, 39);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(300, 165, 100, 23);
		panelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(364, 159, 63, 39);
		txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota3);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPromedio.setBounds(31, 208, 127, 31);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 208, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 249, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(310, 202, 117, 31);
		btnConsultar.addActionListener(this);
		panelPrincipal.add(btnConsultar);
		
		lblDoc = new JLabel("Documento:");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(259, 65, 100, 23);
		panelPrincipal.add(lblDoc);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(364, 60, 63, 39);
		panelPrincipal.add(txtDocumento);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsultar) {			
			Persona miEstudiante = miCoordinador.obtenerEstudiante(txtDocumento.getText());
			if(miEstudiante != null) {
				txtNombre.setText(miEstudiante.getNombre());
				txtNota1.setText(miEstudiante.getNota1()+"");
				txtNota2.setText(miEstudiante.getNota2()+"");
				txtNota3.setText(miEstudiante.getNota3()+"");				
			} else {
				JOptionPane.showMessageDialog(null, "No existe una persona con ese documento");
			}
		}		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}
}