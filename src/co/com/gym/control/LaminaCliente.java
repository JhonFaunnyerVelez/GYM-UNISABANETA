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

import co.com.gym.util.Conexion;

import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LaminaCliente extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6973662628749754810L;
	private JTextField txtNombre,txtPrmApellido,txtSegApellido,txtAutorizado,txtCorreo,txtNacimiento,txtDoc,txtTel,txtDireccion;
	private JButton btnGuardar, btnCancelar;
	private Color azul=new Color(20,130,200);
	private JTextField txtSexo;
	private JTextField txtOcup;
	private JTextField txtInstructor;

	
	public LaminaCliente(){
		// LAMINA CLIENTE
				setBounds(24, 20, 629, 180);
				setLayout(null);
				setBackground(Color.WHITE);
				setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
				//getContentPane().add(laminaCliente);
				setLayout(null);
				
				txtNombre = new JTextField();
				txtNombre.setBounds(121, 26, 86, 20);
				add(txtNombre);
				txtNombre.setColumns(10);
				
				txtPrmApellido = new JTextField();
				txtPrmApellido.setColumns(10);
				txtPrmApellido.setBounds(121, 57, 86, 20);
				add(txtPrmApellido);
				
				txtSegApellido = new JTextField();
				txtSegApellido.setColumns(10);
				txtSegApellido.setBounds(121, 88, 86, 20);
				add(txtSegApellido);
				
				txtAutorizado = new JTextField();
				txtAutorizado.setColumns(10);
				txtAutorizado.setBounds(121, 119, 86, 20);
				add(txtAutorizado);
				
				txtCorreo = new JTextField();
				txtCorreo.setColumns(10);
				txtCorreo.setBounds(327, 57, 86, 20);
				add(txtCorreo);
				
				txtNacimiento = new JTextField();
				txtNacimiento.setColumns(10);
				txtNacimiento.setBounds(327, 88, 86, 20);
				add(txtNacimiento);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(222, 149, 89, 20);
				btnGuardar.setForeground(Color.white);
				btnGuardar.setBackground(azul);
				add(btnGuardar);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(337, 149, 89, 20);
				btnCancelar.setBackground(azul);
				btnCancelar.setForeground(Color.white);
				add(btnCancelar);
				
				txtDoc = new JTextField();
				txtDoc.setColumns(10);
				txtDoc.setBounds(529, 26, 86, 20);
				add(txtDoc);
				
				txtTel = new JTextField();
				txtTel.setColumns(10);
				txtTel.setBounds(327, 119, 86, 20);
				add(txtTel);
				
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(327, 26, 86, 20);
				add(txtDireccion);
				
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 29, 83, 14);
				add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Primer Apellido:");
				lblNewLabel_1.setBounds(10, 60, 86, 14);
				add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Segundo Apellido:");
				lblNewLabel_2.setBounds(10, 91, 106, 14);
				add(lblNewLabel_2);
				
				JLabel label = new JLabel("Autorizado:");
				label.setBounds(10, 122, 86, 14);
				add(label);
				
				JLabel label_1 = new JLabel("Correo:");
				label_1.setBounds(215, 60, 67, 14);
				add(label_1);
				
				JLabel label_2 = new JLabel("Fecha Nacimiento:");
				label_2.setBounds(215, 91, 112, 14);
				add(label_2);
				
				JLabel label_3 = new JLabel("Documento:");
				label_3.setBounds(423, 29, 96, 14);
				add(label_3);
				
				JLabel label_4 = new JLabel("Telefono:");
				label_4.setBounds(215, 122, 87, 14);
				add(label_4);
				
				JLabel label_5 = new JLabel("Direccion:");
				label_5.setBounds(215, 29, 91, 14);
				add(label_5);
				
				JLabel lblSexo = new JLabel("Sexo:");
				lblSexo.setBounds(423, 60, 96, 14);
				add(lblSexo);
				
				txtSexo = new JTextField();
				txtSexo.setColumns(10);
				txtSexo.setBounds(529, 57, 86, 20);
				add(txtSexo);
				
				JLabel lblOcupacion = new JLabel("Ocupacion:");
				lblOcupacion.setBounds(423, 91, 96, 14);
				add(lblOcupacion);
				
				txtOcup = new JTextField();
				txtOcup.setColumns(10);
				txtOcup.setBounds(529, 88, 86, 20);
				add(txtOcup);
				
				JLabel lblTipoUsuario = new JLabel("Tipo Usuario:");
				lblTipoUsuario.setBounds(489, 152, 65, 14);
				add(lblTipoUsuario);
				
				JLabel lblInstructor = new JLabel("Instructor:");
				lblInstructor.setBounds(423, 122, 96, 14);
				add(lblInstructor);
				
				JComboBox cbTipo = new JComboBox();
				cbTipo.setBounds(564, 149, 41, 20);
				add(cbTipo);
				
				txtInstructor = new JTextField();
				txtInstructor.setColumns(10);
				txtInstructor.setBounds(529, 119, 86, 20);
				add(txtInstructor);
				
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
modelo.addColumn("Nombre");
modelo.addColumn("Pr Apellido");
modelo.addColumn("Seg Apellido");
modelo.addColumn("Autorizado");
modelo.addColumn("Correo");
modelo.addColumn("nacimiento");
modelo.addColumn("Documento");
modelo.addColumn("Telefono");
modelo.addColumn("Direccion");
modelo.addColumn("Sexo");
modelo.addColumn("Ocupacion");
modelo.addColumn("registro");
modelo.addColumn("Tipo Usuario");
modelo.addColumn("Instructor");
JTable tabla = new JTable(modelo);
JScrollPane scrollCliente = new JScrollPane(tabla);
scrollCliente.setBounds(10, 11, 1220, 352);
add(scrollCliente);

Conexion conexion= null;
Statement st = null; 
ResultSet rs =null; 

try{
    conexion = new Conexion();
    st = conexion.getConnection().createStatement();
    rs = st.executeQuery("SELECT * FROM gym_unisabaneta.tb_usuario");
    while(rs.next()){
        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)});
    }
    
}catch(Exception e){
    System.out.println("error");
}

    }
	}

//--------------------------------------------------------
