package co.com.gym.control;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import co.com.gym.impl.UsuarioImpl;
import co.com.gym.model.TbTipoUsuario;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;

public class LaminaAdmin extends JPanel {
	private JTextField txtNombre,txtPrmApellido,txtSegApellido,txtCorreo,txtDoc,txtTel,txtDireccion;
	private JButton btnGuardar, btnLimpiar, btnBuscar, btnEliminar, btnModificar;
	private Color azul=new Color(20,130,200);
	private JTextField txtOcup;
	private JTextField txtFechReg;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private JTextField txtFechNac;
	private JComboBox cbAutorizado, cbSexo, combo;
	private JLabel lblId;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JTextField txtEstadoC, txtTipoUsuario;
	private JTextField txtEspec;
	private JTextField txtEdad;
	private JTextField txtCel, txtId, txtBuscar;
	UsuarioImpl usuarioImpl = new UsuarioImpl();
	TbTipoUsuario tipoUsuario = new TbTipoUsuario();
	TbUsuario usuario = new TbUsuario();
	private JTextField txtClave;
	private JCalendar calendar;
	
	public LaminaAdmin(){
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ADMINISTRADOR", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		
		calendar = new JCalendar();
		calendar.setBounds(956, 59, 184, 136);
		add(calendar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(330, 28, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();
				if(!Character.isLetter(c) && c!=KeyEvent.VK_SPACE) e.consume();
				
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

					txtEdad.setText(String.valueOf(calcularEdad()));
					txtFechReg.setText(DameFechaRegistro());
					txtFechNac.setText(DameNacimiento());
					tipoUsuario.setIdTipoUsuario(Integer.valueOf(txtTipoUsuario.getText()));
					
					usuario.setTbTipoUsuario(tipoUsuario);
					usuario.setDsnombre(txtNombre.getText());
					usuario.setDsprimerapellido(txtPrmApellido.getText());
					usuario.setDssegundoapellido(txtSegApellido.getText());
					usuario.setNmautorizado(Integer.valueOf((String)cbAutorizado.getSelectedItem()));
					usuario.setDscorreo(txtCorreo.getText());
					usuario.setFefechanacimiento(java.sql.Date.valueOf(txtFechNac.getText()));
					usuario.setNmdocumento(Integer.valueOf(txtDoc.getText()));
					usuario.setDscontrasena(txtClave.getText());
					usuario.setDstelefono(txtTel.getText());
					usuario.setDsdireccion(txtDireccion.getText());
					usuario.setDssexo((String)cbSexo.getSelectedItem());
					usuario.setDsocupacion(txtOcup.getText());
					usuario.setFeregistro(txtFechReg.getText());
					usuario.setDsestadocivil(txtEstadoC.getText());
					usuario.setDeespecialidad(txtEspec.getText());
					usuario.setNmedad(Integer.valueOf(txtEdad.getText()));
					usuario.setNmcelular(Integer.valueOf(txtCel.getText()));
					if (validateEmail(txtCorreo.getText())==true){
					if (calcularEdad()>17){
						usuarioImpl.guardarInstructor(usuario);
						Clear_Table1();
						LlenarTabla(txtTipoUsuario.getText());
						limpiarCampos();
	                }else{
	                    JOptionPane.showMessageDialog(null, "Tiene que ser Mayor de 16 años", "Edad", 0);
	                }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		txtTel.setColumns(10);
		txtTel.setBounds(536, 121, 86, 20);
		add(txtTel);
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(536, 28, 86, 20);
		add(txtDireccion);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(219, 31, 83, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Primer Apellido:");
		lblNewLabel_1.setBounds(219, 62, 125, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido:");
		lblNewLabel_2.setBounds(219, 93, 106, 14);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("Clave:");
		label.setBounds(219, 124, 86, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Correo:");
		label_1.setBounds(424, 62, 67, 14);
		add(label_1);
		
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
		
		txtFechReg = new JTextField();
		txtFechReg.setColumns(10);
		txtFechReg.setBounds(738, 121, 86, 20);
		
		cbSexo = new JComboBox();
		cbSexo.setBounds(738, 59, 86, 20);
		cbSexo.addItem("M");
		cbSexo.addItem("F");
		add(cbSexo);
		
		cbAutorizado = new JComboBox();
		cbAutorizado.setBounds(330, 121, 86, 20);
		cbAutorizado.addItem("1");

		
		txtFechNac = new JTextField();
		txtFechNac.setBounds(536, 90, 86, 20);
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
		modelo.addColumn("Clave");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Sexo");
		modelo.addColumn("Ocupacion");
		modelo.addColumn("Fech Registro");
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
		txtEstadoC.setBounds(538, 90, 86, 20);
		add(txtEstadoC);
		txtEstadoC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(426, 93, 91, 14);
		add(lblEstadoCivil);
		
		JLabel lblEdad = new JLabel("Especialidad:");
		lblEdad.setBounds(834, 31, 112, 14);
		add(lblEdad);
		
		txtEspec = new JTextField();
		txtEspec.setColumns(10);
		txtEspec.setBounds(946, 28, 86, 20);
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
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});

		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(632, 124, 101, 14);
		add(lblCelular);
		
		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(738, 121, 86, 20);
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
					usuarioImpl.eliminarInstructor(usu);
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
				Buscar(txtBuscar.getText());
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
		
		JLabel lblBuscarInstructorX = new JLabel("Buscar Instructor X:");
		lblBuscarInstructorX.setBounds(10, 205, 191, 14);
		add(lblBuscarInstructorX);
		
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
					usuario.setDscontrasena(txtClave.getText());
					usuario.setDstelefono(txtTel.getText());
					usuario.setDsdireccion(txtDireccion.getText());
					usuario.setDssexo((String)cbSexo.getSelectedItem());
					usuario.setDsocupacion(txtOcup.getText());
					usuario.setFeregistro(txtFechReg.getText());
					usuario.setDsestadocivil(txtEstadoC.getText());
					usuario.setDeespecialidad(txtEspec.getText());
					usuario.setNmedad(Integer.valueOf(txtEdad.getText()));
					usuario.setNmcelular(Integer.valueOf(txtCel.getText()));
					if (Integer.valueOf(txtEdad.getText())>17){
						usuarioImpl.modificarInstructor(usuario);
						limpiarCampos();
						Clear_Table1();
						LlenarTabla(txtTipoUsuario.getText());
						btnGuardar.setEnabled(true);
	                }else{
	                    JOptionPane.showMessageDialog(null, "Tiene que ser Mayor de 16 años", "Edad", 0);
	                }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(20, 130, 200));
		btnModificar.setBounds(639, 152, 89, 20);
		btnModificar.setEnabled(false);
		add(btnModificar);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(330, 121, 86, 20);
		add(txtClave);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_3.setBounds(834, 62, 125, 14);
		add(lblNewLabel_3);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setText("1");
		
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
			txtClave.setText(tabla.getValueAt(fila, 8).toString());
			txtTel.setText(tabla.getValueAt(fila, 9).toString());
			txtDireccion.setText(tabla.getValueAt(fila, 10).toString());
			cbSexo.setSelectedItem(tabla.getValueAt(fila, 11));
			txtOcup.setText(tabla.getValueAt(fila, 12).toString());
			txtFechReg.setText(tabla.getValueAt(fila, 13).toString());
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
		txtClave.setText("");
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
	public void Buscar(String valor){
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql="";
		if (combo.getSelectedItem().equals("Nombre"))
		{
			sql="SELECT * FROM tb_usuario WHERE DSNOMBRE='"+valor+"'";
		}else if (combo.getSelectedItem().equals("Cedula")){
			sql="SELECT * FROM tb_usuario WHERE NMDOCUMENTO='"+valor+"'";
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
public int calcularEdad(){
        
        Calendar c2 = new GregorianCalendar();

        int anioNac = calendar.getCalendar().get(Calendar.YEAR);
        int mesNac = calendar.getCalendar().get(Calendar.MONTH);
        int diaNac = calendar.getCalendar().get(Calendar.DATE);
        int dia = c2.get(Calendar.DATE) - diaNac;
        int mes = c2.get(Calendar.MONTH)- mesNac;
        int annio = c2.get(Calendar.YEAR) - anioNac;
        
    
        if (mes < 0 || (mes == 0 && dia < 0)) {
            annio = annio - 1; 
        }
        System.out.println(annio);
        return annio;
    }
public String DameNacimiento(){
	int anioNac = calendar.getCalendar().get(Calendar.YEAR);
    int mesNac = calendar.getCalendar().get(Calendar.MONTH)+1;
    int diaNac = calendar.getCalendar().get(Calendar.DATE);
    
    String Nacimiento = ""+anioNac+""+"-"+""+mesNac+""+"-"+""+diaNac+"";
    return Nacimiento;
}
public String DameFechaRegistro(){
	Calendar c2 = new GregorianCalendar();
	int dia = c2.get(Calendar.DATE);
    int mes = c2.get(Calendar.MONTH)+1;
    int annio = c2.get(Calendar.YEAR);
    String dRegistro="";
    if (mes<10 && dia<10){
    	dRegistro = ""+annio+""+"-"+"0"+mes+""+"-"+"0"+dia+"";
    }
    return dRegistro;
}
public static boolean validateEmail(String email) {

    // Compiles the given regular expression into a pattern.
    Pattern pattern = Pattern.compile(PATTERN_EMAIL);

    // Match the given input against this pattern
    Matcher matcher = pattern.matcher(email);
    Matcher mather = pattern.matcher(email);
    
    if (mather.find() == true) {
        return true;
    } else {
        return false;
    }

}
	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	   }
}

