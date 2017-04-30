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

public class LaminaCliente extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6973662628749754810L;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	private JButton btnGuardar, btnCancelar;
	private Color azul=new Color(20,130,200);

	
	public LaminaCliente(){
		// LAMINA CLIENTE
				setBounds(24, 20, 629, 180);
				
				setLayout(null);
				setBackground(Color.WHITE);
				setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
				//getContentPane().add(laminaCliente);
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
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(30, 29, 46, 14);
				add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(30, 60, 46, 14);
				add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setBounds(30, 91, 46, 14);
				add(lblNewLabel_2);
				
				JLabel label = new JLabel("New label");
				label.setBounds(240, 29, 46, 14);
				add(label);
				
				JLabel label_1 = new JLabel("New label");
				label_1.setBounds(240, 60, 46, 14);
				add(label_1);
				
				JLabel label_2 = new JLabel("New label");
				label_2.setBounds(240, 91, 46, 14);
				add(label_2);
				
				JLabel label_3 = new JLabel("New label");
				label_3.setBounds(437, 32, 46, 14);
				add(label_3);
				
				JLabel label_4 = new JLabel("New label");
				label_4.setBounds(437, 63, 46, 14);
				add(label_4);
				
				JLabel label_5 = new JLabel("New label");
				label_5.setBounds(437, 94, 46, 14);
				add(label_5);
				
				//----------------------------------------------------
				
				
	}
}

//LAMINA DE LA TABLA CLIENTES

class LaminaTblClient extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5613816124067094195L;

	public LaminaTblClient(){
setBackground(Color.WHITE);
setBounds(10, 211, 657, 374);
//getContentPane().add(laminaTblClient);
setLayout(null);
DefaultTableModel modelo = new DefaultTableModel();
modelo.addColumn("idClt");
modelo.addColumn("nombre");
modelo.addColumn("nacimiento");
JTable tabla = new JTable(modelo);
JScrollPane scrollCliente = new JScrollPane(tabla);
scrollCliente.setBounds(10, 11, 637, 352);
add(scrollCliente);
	}
}
//--------------------------------------------------------
