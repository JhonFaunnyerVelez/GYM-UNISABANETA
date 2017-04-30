package co.com.gym.control;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LaminaRutina extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2700611048525707511L;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	private JButton btnGuardar,btnCancelar;
	private Color azul=new Color(20,130,200);
	
	public LaminaRutina(){
		
		setBounds(24, 20, 629, 180);

		//getContentPane().setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rutina", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 26, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 57, 86, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 88, 86, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(313, 26, 86, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(313, 57, 86, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(313, 88, 86, 20);
		add(textField_5);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(222, 130, 89, 23);
		btnGuardar.setForeground(Color.white);
		btnGuardar.setBackground(azul);
		add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(337, 130, 89, 23);
		btnCancelar.setBackground(azul);
		btnCancelar.setForeground(Color.white);
		add(btnCancelar);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(506, 26, 86, 20);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(506, 57, 86, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(506, 88, 86, 20);
		add(textField_8);
		
		JLabel lblLbel = new JLabel("New label");
		lblLbel.setBounds(30, 29, 46, 14);
		add(lblLbel);
		
		JLabel lblLbel_1 = new JLabel("New label");
		lblLbel_1.setBounds(30, 60, 46, 14);
		add(lblLbel_1);
		
		JLabel lblLbel_2 = new JLabel("New label");
		lblLbel_2.setBounds(30, 91, 46, 14);
		add(lblLbel_2);
		
		JLabel lbe3 = new JLabel("New label");
		lbe3.setBounds(240, 29, 46, 14);
		add(lbe3);
		
		JLabel lbe_1 = new JLabel("New label");
		lbe_1.setBounds(240, 60, 46, 14);
		add(lbe_1);
		
		JLabel lbe_2 = new JLabel("New label");
		lbe_2.setBounds(240, 91, 46, 14);
		add(lbe_2);
		
		JLabel lbe_3 = new JLabel("New label");
		lbe_3.setBounds(437, 32, 46, 14);
		add(lbe_3);
		
		JLabel lbe_4 = new JLabel("New label");
		lbe_4.setBounds(437, 63, 46, 14);
		add(lbe_4);
		
		JLabel lbe_5 = new JLabel("New label");
		lbe_5.setBounds(437, 94, 46, 14);
		add(lbe_5);
	}
}

class LaminaTbRutina extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2320744253522303813L;

	LaminaTbRutina(){

		setBackground(Color.WHITE);
		setBounds(10, 211, 657, 374);
		setLayout(null);
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("idRut");
		modelo.addColumn("nombre");
		modelo.addColumn("nacimiento");
		JTable tabla = new JTable(modelo);
		JScrollPane scrollCliente = new JScrollPane(tabla);
		scrollCliente.setBounds(10, 11, 1220, 352);
		add(scrollCliente);
		
		
	}
}
