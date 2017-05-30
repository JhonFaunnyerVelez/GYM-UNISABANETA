package co.com.gym.control;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import co.com.gym.impl.UsuarioImpl;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.model.TbTipoUsuario;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;

import java.sql.*;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LaminaCliente extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6973662628749754810L;
	private JTextField txtNombre,txtPrmApellido,txtSegApellido,txtCorreo,txtDoc,txtTel,txtDireccion;
	private JButton btnGuardar, btnLimpiar, btnBuscar, btnEliminar, btnModificar;
	private Color azul=new Color(20,130,200);
	private JTextField txtOcup;
	private JTextField txtFechReg;
	private JTextField txtFechNac;
	private JComboBox cbAutorizado, cbSexo, combo;
	private JLabel lblId;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JTextField txtEstadoC, txtTipoUsuario;
	private JTextField txtEspec;
	private JTextField txtEdad;
	private JTextField txtCel, txtId, txtBuscar;
	private JComboBox cbInstructor;
	UsuarioImpl usuarioImpl = new UsuarioImpl();
	TbTipoUsuario tipoUsuario = new TbTipoUsuario();
	TbUsuario usuario = new TbUsuario();

	
	public LaminaCliente(){
		// LAMINA CLIENTE
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CLIENTE", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(true);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(330, 28, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		txtPrmApellido = new JTextField();
		txtPrmApellido.setColumns(10);
		txtPrmApellido.setBounds(330, 59, 86, 20);
		add(txtPrmApellido);
		txtPrmApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		txtSegApellido = new JTextField();
		txtSegApellido.setColumns(10);
		txtSegApellido.setBounds(330, 90, 86, 20);
		add(txtSegApellido);
		txtSegApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(536, 59, 86, 20);
		add(txtCorreo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(434, 152, 89, 20);
		btnGuardar.setForeground(Color.white);
		btnGuardar.setBackground(azul);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					int idInstructor = obtenerCliente();
					TbUsuario usu = new TbUsuario();
					tipoUsuario.setIdTipoUsuario(Integer.valueOf(txtTipoUsuario.getText()));
					usuario.setFktipoUsuario(idInstructor);
					usuario.setTbTipoUsuario(tipoUsuario);
					usuario.setDsnombre(txtNombre.getText());
					usuario.setDsprimerapellido(txtPrmApellido.getText());
					usuario.setDssegundoapellido(txtSegApellido.getText());
					usuario.setNmautorizado(Integer.valueOf((String)cbAutorizado.getSelectedItem()));
					usuario.setDscorreo(txtCorreo.getText());
					usuario.setFefechanacimiento(java.sql.Date.valueOf(txtFechNac.getText()));
					usuario.setNmdocumento(Integer.valueOf(txtDoc.getText()));
					usuario.setDstelefono(txtTel.getText());
					usuario.setDsdireccion(txtDireccion.getText());
					usuario.setDssexo((String)cbSexo.getSelectedItem());
					usuario.setDsocupacion(txtOcup.getText());
					usuario.setFeregistro(txtFechReg.getText());
					usuario.setDsestadocivil(txtEstadoC.getText());
					usuario.setDeespecialidad(txtEspec.getText());
					usuario.setNmedad(Integer.valueOf(txtEdad.getText()));
					usuario.setNmcelular(Integer.valueOf(txtCel.getText()));
					usuarioImpl.guardarUsuario(usuario);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Clear_Table1();
				LlenarTabla(txtTipoUsuario.getText());
				limpiarCampos();
			}
		});
		
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(536, 152, 89, 20);
		btnLimpiar.setBackground(azul);
		btnLimpiar.setForeground(Color.white);
		add(btnLimpiar);
		
		txtDoc = new JTextField();
		txtDoc.setColumns(10);
		txtDoc.setBounds(738, 28, 86, 20);
		add(txtDoc);
		txtDoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		
		txtTel = new JTextField();
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		txtTel.setColumns(10);
		txtTel.setBounds(536, 121, 86, 20);
		add(txtTel);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(536, 28, 86, 20);
		add(txtDireccion);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(206, 34, 114, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Primer Apellido:");
		lblNewLabel_1.setBounds(206, 65, 114, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido:");
		lblNewLabel_2.setBounds(206, 96, 114, 14);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("Autorizado:");
		label.setBounds(206, 127, 114, 14);
		add(label);
		
		JLabel lblNewLabel_3 = new JLabel("Formato Fechas (A\u00D1O-MES-DIA) ejm: 2017-08-21");
		lblNewLabel_3.setBounds(928, 208, 290, 14);
		add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("Correo:");
		label_1.setBounds(424, 62, 67, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Fecha Nacimiento:");
		label_2.setBounds(424, 93, 112, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Documento:");
		label_3.setBounds(632, 31, 96, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Telefono:");
		label_4.setBounds(424, 124, 87, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Direccion:");
		label_5.setBounds(424, 31, 91, 14);
		add(label_5);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(632, 62, 96, 14);
		add(lblSexo);
		
		JLabel lblOcupacion = new JLabel("Ocupacion:");
		lblOcupacion.setBounds(632, 93, 96, 14);
		add(lblOcupacion);
		
		txtOcup = new JTextField();
		txtOcup.setColumns(10);
		txtOcup.setBounds(738, 90, 86, 20);
		add(txtOcup);
		txtOcup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		JLabel lblInstructor = new JLabel("Fecha de Registro:");
		lblInstructor.setBounds(632, 124, 125, 14);
		add(lblInstructor);
		
		txtFechReg = new JTextField();
		txtFechReg.setColumns(10);
		txtFechReg.setBounds(738, 121, 86, 20);
		add(txtFechReg);

		
		cbSexo = new JComboBox();
		cbSexo.setBounds(738, 59, 86, 20);
		cbSexo.addItem("M");
		cbSexo.addItem("F");
		add(cbSexo);
		
		cbAutorizado = new JComboBox();
		cbAutorizado.setBounds(330, 121, 86, 20);
		cbAutorizado.addItem("0");
		cbAutorizado.addItem("1");
		add(cbAutorizado);
		
		txtFechNac = new JTextField();
		txtFechNac.setBounds(536, 90, 86, 20);
		add(txtFechNac);
		txtFechNac.setColumns(10);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Primer Apellido");
		modelo.addColumn("Segundo Apellido");
		modelo.addColumn("Autorizado");
		modelo.addColumn("Correo");
		modelo.addColumn("Fech Nacimiento");
		modelo.addColumn("Cedula");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Sexo");
		modelo.addColumn("Ocupacion");
		modelo.addColumn("Fech Registro");
		modelo.addColumn("Instructor");
		modelo.addColumn("Estado Civil");
		modelo.addColumn("Especialidad");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		tabla = new JTable(modelo);
		JPopupMenu menu = new JPopupMenu();
		tabla.setComponentPopupMenu(menu);
		JMenuItem Modificar;
		menu.add(Modificar = new JMenuItem("Seleccionar"));
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					SeleccionarRegistro();
			}
		});
		scrollPane.setViewportView(tabla);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(569, 532, 106, 23);
		btnActualizar.setForeground(Color.white);
		btnActualizar.setBackground(azul);
		add(btnActualizar);
		
		txtEstadoC = new JTextField();
		txtEstadoC.setColumns(10);
		txtEstadoC.setBounds(946, 28, 86, 20);
		add(txtEstadoC);
		txtEstadoC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(834, 31, 91, 14);
		add(lblEstadoCivil);
		
		JLabel lblEdad = new JLabel("Especialidad:");
		lblEdad.setBounds(834, 62, 91, 14);
		add(lblEdad);
		
		JLabel lblEdad_1 = new JLabel("Edad:");
		lblEdad_1.setBounds(834, 93, 112, 14);
		add(lblEdad_1);
		
		txtEspec = new JTextField();
		txtEspec.setColumns(10);
		txtEspec.setBounds(946, 59, 86, 20);
		add(txtEspec);
		txtEspec.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(946, 90, 86, 20);
		add(txtEdad);
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(835, 124, 106, 14);
		add(lblCelular);
		
		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(946, 121, 86, 20);
		add(txtCel);
		txtCel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		
		lblId = new JLabel("ID");
		lblId.setBounds(57, 79, 24, 14);
		lblId.setVisible(false);;
		add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(91, 76, 86, 20);
		txtId.setVisible(false);
		add(txtId);
		txtId.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TbUsuario usu = new TbUsuario();
				usu.setIdTbUsuario(Integer.valueOf(txtId.getText()));
				try {
					usuarioImpl.eliminarUsuario(usu);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpiarCampos();
				Clear_Table1();
				LlenarTabla(txtTipoUsuario.getText());
				btnGuardar.setEnabled(true);
			
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(20, 130, 200));
		btnEliminar.setBounds(748, 152, 89, 20);
		btnEliminar.setEnabled(false);
		add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Clear_Table1();
				LlenarTabla(txtBuscar.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "No hay un Cliente asociado a ese Documento o Nombre");
				}
			}
		});
		btnBuscar.setEnabled(false);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(20, 130, 200));
		btnBuscar.setBounds(356, 202, 89, 20);
		add(btnBuscar);
		
		JLabel lblBuscarInstructorX = new JLabel("Buscar Cliente X:");
		lblBuscarInstructorX.setBounds(10, 205, 191, 14);
		add(lblBuscarInstructorX);
		
		cbInstructor = new JComboBox();
		cbInstructor.setBounds(1105, 28, 125, 20);
		add(cbInstructor);
		
		combo = new JComboBox();
		combo.setBounds(130, 203, 100, 20);
		combo.addItem("Cedula");
		combo.addItem("Nombre");
		add(combo);
		txtBuscar = new JTextField();
		txtBuscar.setEnabled(false);
		txtBuscar.setBounds(238, 202, 86, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear_Table1();
				LlenarTabla(txtTipoUsuario.getText());
				btnBuscar.setEnabled(true);
				txtBuscar.setEnabled(true);
			
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int idInstructor = obtenerCliente();
					usuario.setFktipoUsuario(idInstructor);
					tipoUsuario.setIdTipoUsuario(Integer.valueOf(txtTipoUsuario.getText()));
					usuario.setIdTbUsuario(Integer.valueOf(txtId.getText()));
					usuario.setTbTipoUsuario(tipoUsuario);
					usuario.setDsnombre(txtNombre.getText());
					usuario.setDsprimerapellido(txtPrmApellido.getText());
					usuario.setDssegundoapellido(txtSegApellido.getText());
					usuario.setNmautorizado(Integer.valueOf((String)cbAutorizado.getSelectedItem()));
					usuario.setDscorreo(txtCorreo.getText());
					usuario.setFefechanacimiento(java.sql.Date.valueOf(txtFechNac.getText()));
					usuario.setNmdocumento(Integer.valueOf(txtDoc.getText()));
					usuario.setDstelefono(txtTel.getText());
					usuario.setDsdireccion(txtDireccion.getText());
					usuario.setDssexo((String)cbSexo.getSelectedItem());
					usuario.setDsocupacion(txtOcup.getText());
					usuario.setFeregistro(txtFechReg.getText());
					usuario.setDsestadocivil(txtEstadoC.getText());
					usuario.setDeespecialidad(txtEspec.getText());
					usuario.setNmedad(Integer.valueOf(txtEdad.getText()));
					usuario.setNmcelular(Integer.valueOf(txtCel.getText()));
					usuarioImpl.modificarUsuario(usuario);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpiarCampos();
				Clear_Table1();
				LlenarTabla(txtTipoUsuario.getText());
				btnGuardar.setEnabled(true);
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(20, 130, 200));
		btnModificar.setBounds(639, 152, 89, 20);
		btnModificar.setEnabled(false);
		add(btnModificar);
		
		JLabel lblInstructor_1 = new JLabel("Instructor: ");
		lblInstructor_1.setBounds(1042, 31, 91, 14);
		add(lblInstructor_1);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    cbInstructor.removeAllItems();
				llenarcombo();
			}
		});
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(new Color(20, 130, 200));
		btnListar.setBounds(1081, 59, 89, 20);
		add(btnListar);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setText("2");
		
	}
	public void SeleccionarRegistro(){
		int fila = tabla.getSelectedRow();
		if(fila>=0){
			txtId.setText(tabla.getValueAt(fila, 0).toString());
			txtNombre.setText(tabla.getValueAt(fila, 1).toString());
			txtPrmApellido.setText(tabla.getValueAt(fila, 2).toString());
			txtSegApellido.setText(tabla.getValueAt(fila, 3).toString());
			cbAutorizado.setSelectedItem(tabla.getValueAt(fila, 4));
			txtCorreo.setText(tabla.getValueAt(fila, 5).toString());
			txtFechNac.setText(tabla.getValueAt(fila, 6).toString());
			txtDoc.setText(tabla.getValueAt(fila, 7).toString());
			txtTel.setText(tabla.getValueAt(fila, 8).toString());
			txtDireccion.setText(tabla.getValueAt(fila, 9).toString());
			cbSexo.setSelectedItem(tabla.getValueAt(fila, 10));
			txtOcup.setText(tabla.getValueAt(fila, 11).toString());
			txtFechReg.setText(tabla.getValueAt(fila, 12).toString());
			txtEstadoC.setText(tabla.getValueAt(fila, 14).toString());
			txtEspec.setText(tabla.getValueAt(fila, 15).toString());
			txtEdad.setText(tabla.getValueAt(fila, 16).toString());
			txtCel.setText(tabla.getValueAt(fila, 17).toString());
			txtId.setVisible(true);
			lblId.setVisible(true);
			btnGuardar.setEnabled(false);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}else{
			JOptionPane.showMessageDialog(null, "no selecciono fila");
		}
	}
	public void limpiarCampos(){
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnGuardar.setEnabled(true);
		txtBuscar.setText("");
		txtId.setText("");
		txtNombre.setText("");
		txtPrmApellido.setText("");
		txtSegApellido.setText("");
		cbAutorizado.setSelectedIndex(0);
		txtCorreo.setText("");
		txtFechNac.setText("");
		txtDoc.setText("");
		txtTel.setText("");
		txtDireccion.setText("");
		cbSexo.setSelectedIndex(0);
		txtOcup.setText("");
		txtFechReg.setText("");
		txtEstadoC.setText("");
		txtEspec.setText("");
		txtEdad.setText("");
		txtCel.setText("");
		txtId.setVisible(false);
		lblId.setVisible(false);
	}
	public void LlenarTabla(String valor){
		
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql="";
		if (valor.equals("")){
			sql = "SELECT * FROM tb_usuario";
		}else{
			sql = "SELECT * FROM tb_usuario WHERE TIPO_USUARIO_idTIPO_USUARIO='"+valor+"'";
		}
		if (combo.getSelectedItem().equals("Nombre"))
		{
			sql="SELECT * FROM tb_usuario WHERE DSNOMBRE='"+valor+"'";
		}
		try{
		    conexion = new Conexion();
		    st = conexion.Conexion().createStatement();
		    rs = st.executeQuery(sql);
		    while(rs.next()){
		        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getDate(14),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20)});
		    }
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				conexion.Conexion().close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
		}
	}
	public void llenarcombo(){
		TbUsuario Usuario=null;
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT DSNOMBRE FROM tb_usuario where TIPO_USUARIO_idTIPO_USUARIO=3";
			st = conexion.Conexion().createStatement();
			rs = st.executeQuery(sql);
			
			
			cbInstructor.addItem("Seleccione un Instructor:");
			
			
			while (rs.next()){
				cbInstructor.addItem(rs.getString(1));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conexion.Conexion().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
	}
	public int obtenerCliente(){
		TbUsuario Usuario = new TbUsuario();
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		int id=0;
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT idTB_USUARIO FROM tb_usuario where DSNOMBRE='"+cbInstructor.getSelectedItem()+"'";
			st = conexion.Conexion().createStatement();
			rs = st.executeQuery(sql);
			
			
			while (rs.next()){
				id = rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conexion.Conexion().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		return id;
		
	}
	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	   }
}




