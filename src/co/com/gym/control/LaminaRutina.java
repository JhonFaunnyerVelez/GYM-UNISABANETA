package co.com.gym.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.impl.PagoImpl;
import co.com.gym.impl.RutinaImpl;
import co.com.gym.impl.TipoContratoImpl;
import co.com.gym.model.TbRutinas;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.model.TbTipoUsuario;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import javax.swing.JComboBox;

public class LaminaRutina extends JPanel {
	
	/**
	 * 
	 */
	private JButton btnGuardar,btnLimpiar,btnModificar,btnEliminar,btnActualizar;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField txtDescripcion,txtNombre,txtFechReg, txtId;
	private JLabel lblId;
	RutinaImpl rutinaImpl = new RutinaImpl();
	TbTipoContrato tipocontrato1 = new TbTipoContrato();
	private JTextField txtFin;
	private JLabel lblFechaInicial;
	private JTextField txtInicio;
	private JLabel lblCliente;
	private JComboBox cbCliente;
	
	public LaminaRutina(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "RUTINA", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		
		JLabel label = new JLabel("Descripcion:");
		label.setBounds(402, 62, 83, 14);
		add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(402, 31, 86, 14);
		add(lblNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(537, 59, 86, 20);
		add(txtDescripcion);

		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(537, 28, 86, 20);
		add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'a' || c>'z') e.consume();
				
			}
		});
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro:");
		lblFechaDeRegistro.setBounds(402, 90, 125, 14);
		add(lblFechaDeRegistro);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(20, 130, 200));
		btnGuardar.setBounds(439, 149, 89, 20);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idcliente = obtenerCliente();
					TbUsuario usu = new TbUsuario();
					usu.setIdTbUsuario(idcliente);
					TbRutinas rutina = new TbRutinas(Integer.valueOf(txtId.getText()),usu, txtNombre.getText(), txtDescripcion.getText(), Date.valueOf(txtInicio.getText()), Date.valueOf(txtFin.getText()), Date.valueOf(txtFechReg.getText()));
					rutinaImpl.guardarRutina(rutina);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Clear_Table1();
				LlenarTabla();
				limpiarCampos();
			}
		});


		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(20, 130, 200));
		btnLimpiar.setBounds(538, 149, 89, 20);
		add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		
		txtFechReg = new JTextField();
		txtFechReg.setColumns(10);
		txtFechReg.setBounds(537, 90, 86, 20);
		add(txtFechReg);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(new Color(20, 130, 200));
		btnEliminar.setBounds(738, 149, 89, 20);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			try {
				TbRutinas rutina = new TbRutinas();
				int id = Integer.valueOf(txtId.getText());
			    rutina.setIdTbRutinas(id);
				rutinaImpl.eliminarRutina(rutina);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			limpiarCampos();
			Clear_Table1();
			LlenarTabla();
			btnGuardar.setEnabled(true);
		}
	});

		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setEnabled(false);
		btnModificar.setBackground(new Color(20, 130, 200));
		btnModificar.setBounds(639, 149, 89, 20);
		add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idcliente = obtenerCliente();
				TbUsuario usu = new TbUsuario();
				usu.setIdTbUsuario(idcliente);
				TbRutinas rutina = new TbRutinas(Integer.valueOf(txtId.getText()),usu, txtNombre.getText(), txtDescripcion.getText(), Date.valueOf(txtInicio.getText()), Date.valueOf(txtFin.getText()), Date.valueOf(txtFechReg.getText()));
				try {
					rutinaImpl.modificarRutina(rutina);
					txtId.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Clear_Table1();
				LlenarTabla();
				limpiarCampos();
			}
			
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Formato Fechas (A\u00D1O-MES-DIA) ejm: 2017-08-21");
		lblNewLabel_3.setBounds(928, 208, 290, 14);
		add(lblNewLabel_3);

		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(new Color(20, 130, 200));
		btnActualizar.setBounds(569, 540, 106, 23);
		add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear_Table1();
				LlenarTabla();
			}
		});

		
		txtId = new JTextField();
		txtId.setBounds(279, 38, 86, 20);
		add(txtId);
		txtId.setColumns(10);
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				
			}
		});
		
		lblId = new JLabel("ID");
		lblId.setBounds(245, 41, 24, 14);
		add(lblId);
		

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Fecha Inicial");
		modelo.addColumn("Fecha Final");
		modelo.addColumn("Cliente");
		modelo.addColumn("Fech Registro");
		tabla = new JTable(modelo);
		JPopupMenu menu = new JPopupMenu();
		tabla.setComponentPopupMenu(menu);
		JMenuItem Modificar;
		menu.add(Modificar = new JMenuItem("Seleccionar"));
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					SeleccionarRegistro();
					txtId.setEnabled(false);
			}
		});
		scrollPane.setViewportView(tabla);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final:");
		lblFechaFinal.setBounds(633, 62, 125, 14);
		add(lblFechaFinal);
		
		txtFin = new JTextField();
		txtFin.setColumns(10);
		txtFin.setBounds(768, 59, 86, 20);
		add(txtFin);
		
		lblFechaInicial = new JLabel("Fecha Inicial:");
		lblFechaInicial.setBounds(633, 34, 125, 14);
		add(lblFechaInicial);
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		txtInicio.setBounds(768, 31, 86, 20);
		add(txtInicio);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(633, 93, 125, 14);
		add(lblCliente);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(768, 87, 213, 20);
		add(cbCliente);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbCliente.removeAllItems();
				llenarcombo();
			}
		});
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(new Color(20, 130, 200));
		btnListar.setBounds(1028, 87, 86, 20);
		add(btnListar);
		
		
		
	}
	public void SeleccionarRegistro(){
		int fila = tabla.getSelectedRow();
		if(fila>=0){
			txtId.setText(tabla.getValueAt(fila, 0).toString());
			txtNombre.setText(tabla.getValueAt(fila, 1).toString());
			txtDescripcion.setText(tabla.getValueAt(fila, 2).toString());
			txtInicio.setText(tabla.getValueAt(fila, 3).toString());
			txtFin.setText(tabla.getValueAt(fila, 4).toString());
			cbCliente.setSelectedItem(tabla.getValueAt(fila, 5).toString());
			txtFechReg.setText(tabla.getValueAt(fila, 6).toString());

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
		txtDescripcion.setText("");
		txtNombre.setText("");
		txtFechReg.setText("");
		txtInicio.setText("");
		txtFin.setText("");
	}
	public void LlenarTabla(){
		
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql = "SELECT * FROM tb_rutinas";
		try{
		    conexion = new Conexion();
		    st = conexion.Conexion().createStatement();
		    rs = st.executeQuery(sql);
		    while(rs.next()){
		        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getDate(7)});
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
			String sql = "SELECT DSNOMBRE FROM tb_usuario where TIPO_USUARIO_idTIPO_USUARIO=2";
			st = conexion.Conexion().createStatement();
			rs = st.executeQuery(sql);
			
			cbCliente.addItem("Seleccione un cliente:");
			
			
			while (rs.next()){
				cbCliente.addItem(rs.getString(1));
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
			String sql = "SELECT idTB_USUARIO FROM tb_usuario where DSNOMBRE='"+cbCliente.getSelectedItem()+"'";
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