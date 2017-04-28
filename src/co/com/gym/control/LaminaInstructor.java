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

public class LaminaInstructor extends JPanel {
	
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	private JButton btnGuardar, btnCancelar;
	private Color azul=new Color(20,130,200);

	public LaminaInstructor(){
		
		setBounds(24, 20, 629, 180);
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Instructor", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JLabel lblLabel = new JLabel("New label");
		lblLabel.setBounds(30, 29, 46, 14);
		add(lblLabel);
		
		JLabel lblLabel_1 = new JLabel("New label");
		lblLabel_1.setBounds(30, 60, 46, 14);
		add(lblLabel_1);
		
		JLabel lblLabel_2 = new JLabel("New label");
		lblLabel_2.setBounds(30, 91, 46, 14);
		add(lblLabel_2);
		
		JLabel labe3 = new JLabel("New label");
		labe3.setBounds(240, 29, 46, 14);
		add(labe3);
		
		JLabel labe_1 = new JLabel("New label");
		labe_1.setBounds(240, 60, 46, 14);
		add(labe_1);
		
		JLabel labe_2 = new JLabel("New label");
		labe_2.setBounds(240, 91, 46, 14);
		add(labe_2);
		
		JLabel labe_3 = new JLabel("New label");
		labe_3.setBounds(437, 32, 46, 14);
		add(labe_3);
		
		JLabel labe_4 = new JLabel("New label");
		labe_4.setBounds(437, 63, 46, 14);
		add(labe_4);
		
		JLabel labe_5 = new JLabel("New label");
		labe_5.setBounds(437, 94, 46, 14);
		add(labe_5);
		
		//LAMINA DE LA TABLA INSTRUCTOR
		
	
		//--------------------------------------------------------
		
	}
}

class laminaTbInstruct extends JPanel{
	public laminaTbInstruct(){
	setBackground(Color.WHITE);
	setBounds(10, 211, 657, 374);
	//getContentPane().add(laminaTbIntruct);
	setLayout(null);
	DefaultTableModel modelo = new DefaultTableModel();
	modelo.addColumn("id");
	modelo.addColumn("nombre");
	modelo.addColumn("nacimiento");
	JTable tabla = new JTable(modelo);
	JScrollPane scrollCliente = new JScrollPane(tabla);
	scrollCliente.setBounds(10, 11, 637, 352);
	add(scrollCliente);
	}
}
