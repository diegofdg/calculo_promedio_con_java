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
import modelo.vo.EstudianteVO;

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
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblResActualizacion;
	
	public VentanaConsulta() {
		setSize(491, 426);
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
		lblPromedio.setBounds(31, 209, 127, 31);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(156, 209, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 250, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(333, 60, 94, 31);
		btnConsultar.addActionListener(this);
		panelPrincipal.add(btnConsultar);
		
		lblDoc = new JLabel("Documento:");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(175, 65, 100, 23);
		panelPrincipal.add(lblDoc);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(260, 60, 63, 31);
		panelPrincipal.add(txtDocumento);
		
		btnActualizar = new JButton();
		btnActualizar.setText("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(31, 298, 184, 31);
		btnActualizar.addActionListener(this);
		panelPrincipal.add(btnActualizar);
		
		btnEliminar = new JButton();
		btnEliminar.setText("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(243, 298, 184, 31);
		btnEliminar.addActionListener(this);
		panelPrincipal.add(btnEliminar);
		
		lblResActualizacion = new JLabel("");
		lblResActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResActualizacion.setBounds(31, 345, 396, 31);
		panelPrincipal.add(lblResActualizacion);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsultar) {		
			EstudianteVO miEstudiante = miCoordinador.obtenerEstudiante(txtDocumento.getText());
			lblResActualizacion.setText("");
			
			if(miEstudiante != null) {
				txtNombre.setText(miEstudiante.getNombre());
				txtNota1.setText(miEstudiante.getNota1()+"");
				txtNota2.setText(miEstudiante.getNota2()+"");
				txtNota3.setText(miEstudiante.getNota3()+"");
				lblResPromedio.setText(miEstudiante.getPromedio()+"");
				
				if(miEstudiante.getPromedio() >= 3.5) {
					lblResultado.setText("Resultado: Aprobado");					
					lblResultado.setForeground(Color.GREEN);
				} else {
					lblResultado.setText("Resultado: No Aprobado");					
					lblResultado.setForeground(Color.RED);
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "El estudiante no existe");
			}
			
		} else if (e.getSource()==btnActualizar) {
			EstudianteVO miEstudiante = new EstudianteVO();
			
			miEstudiante.setDocumento(txtDocumento.getText());
			miEstudiante.setNombre(txtNombre.getText());
			miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
			miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
			miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));
			miEstudiante.setPromedio(miCoordinador.calcularPromedio(miEstudiante));
			
			String resultado = miCoordinador.actualizarEstudiante(miEstudiante);
			
			if (resultado.equals("ok")) {
				lblResActualizacion.setText("Se ha actualizado correctamente");
				lblResPromedio.setText(miEstudiante.getPromedio()+"");
				lblResultado.setText("");
			} else {
				lblResActualizacion.setText("No se pudo actualizar");
			}
			
		} else if (e.getSource() == btnEliminar) { 
			String documento = txtDocumento.getText();
			String resultado = miCoordinador.eliminarEstudiante(documento);
			
			if (resultado.equals("ok")) {
				limpiarCampos();
				lblResActualizacion.setText("Se ha eliminado correctamente");
			} else {
				lblResActualizacion.setText("No se pudo eliminar");
			}
		}
	}
	
	public void limpiarCampos() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		lblResPromedio.setText("");
		lblResultado.setText("");
		lblResActualizacion.setText("");
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}
}