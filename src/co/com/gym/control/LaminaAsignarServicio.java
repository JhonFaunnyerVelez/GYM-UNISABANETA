package co.com.gym.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

import co.com.gym.impl.AsignarImpl;
import co.com.gym.impl.PagoImpl;
import co.com.gym.model.TbEstadoPago;
import co.com.gym.model.TbRutinas;
import co.com.gym.model.TbRutinasXTbServicio;
import co.com.gym.model.TbServicio;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;

public class LaminaAsignarServicio extends JPanel {
	
	private JButton btnGuardar,btnLimpiar,btnModificar,btnEliminar,btnActualizar;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField txtFechReg, txtId;
	private JLabel lblId;
	private JTextField txtPrec;
	AsignarImpl asignarImpl = new AsignarImpl();
	TbRutinas rutina = new TbRutinas();
	TbServicio servicio = new TbServicio();
	private JComboBox cbServicio;
	private JLabel lblCliente;
	private JLabel lblRutina;
	private JComboBox cbRutina;
	private JButton btnListarRutina;
	private JButton btnListarServicio;
	
	public LaminaAsignarServicio(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ASIGNAR SERVICIOS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		
		txtFechReg = new JTextField();
		txtFechReg.setColumns(10);
		txtFechReg.setBounds(498, 28, 86, 20);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(20, 130, 200));
		btnGuardar.setBounds(439, 149, 89, 20);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					txtFechReg.setText(DameFechaRegistro());
					int idRutina = obtenerRutina();
					rutina.setIdTbRutinas(idRutina);
					int idServicio = obtenerServicio();
					servicio.setIdTbServicio(idServicio);
					TbRutinasXTbServicio asignar = new TbRutinasXTbServicio();
					asignar.setTbRutinas(rutina);
					asignar.setTbServicio(servicio);
					asignar.setFeregistro(Date.valueOf(txtFechReg.getText()));
					asignarImpl.guardarAsignar(asignar);
					
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(new Color(20, 130, 200));
		btnEliminar.setBounds(738, 149, 89, 20);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				int id = Integer.valueOf(txtId.getText());
				TbRutinasXTbServicio asignar = new TbRutinasXTbServicio();
				asignar.setCdcodigo(id);
				asignarImpl.eliminarAsignar(asignar);
				
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
				try {
					txtFechReg.setText(DameFechaRegistro());
					TbRutinasXTbServicio asignar = new TbRutinasXTbServicio();
					asignar.setFeregistro(Date.valueOf(txtFechReg.getText()));
					asignar.setCdcodigo(Integer.valueOf(txtId.getText()));
					asignarImpl.modificarAsignar(asignar);
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);

		
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
		txtId.setEditable(false);
		txtId.setBounds(279, 38, 86, 20);
		txtId.setVisible(false);
		add(txtId);
		
		lblId = new JLabel("ID");
		lblId.setBounds(245, 41, 24, 14);
		lblId.setVisible(false);;
		add(lblId);
		

		modelo = new DefaultTableModel();
		modelo.addColumn("Rutina");
		modelo.addColumn("Servicio");
		modelo.addColumn("Fecha de registro");
		modelo.addColumn("Codigo");
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
		
		cbServicio = new JComboBox();
		cbServicio.setBounds(892, 65, 230, 20);
		add(cbServicio);
		
		lblCliente = new JLabel("Servicio:");
		lblCliente.setBounds(775, 71, 91, 14);
		add(lblCliente);
		
		lblRutina = new JLabel("Rutina:");
		lblRutina.setBounds(381, 71, 91, 14);
		add(lblRutina);
		
		cbRutina = new JComboBox();
		cbRutina.setBounds(498, 65, 230, 20);
		add(cbRutina);
		
		btnListarRutina = new JButton("Listar");
		btnListarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbRutina.removeAllItems();
				llenarcomboRutina();
			}
		});
		btnListarRutina.setForeground(Color.WHITE);
		btnListarRutina.setBackground(new Color(20, 130, 200));
		btnListarRutina.setBounds(498, 96, 89, 20);
		add(btnListarRutina);
		
		btnListarServicio = new JButton("Listar");
		btnListarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbServicio.removeAllItems();
				llenarcomboServicio();
			}
		});
		btnListarServicio.setForeground(Color.WHITE);
		btnListarServicio.setBackground(new Color(20, 130, 200));
		btnListarServicio.setBounds(892, 96, 89, 20);
		add(btnListarServicio);
		
		
		
	}
	public void SeleccionarRegistro(){
		int fila = tabla.getSelectedRow();
		if(fila>=0){
			txtId.setText(tabla.getValueAt(fila, 3).toString());
			txtFechReg.setText(tabla.getValueAt(fila, 2).toString());
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
		txtFechReg.setText("");
		cbRutina.setSelectedIndex(0);
		cbServicio.setSelectedIndex(0);
		txtId.setVisible(false);
		lblId.setVisible(false);
	}
	public void LlenarTabla(){
		
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql = "SELECT * FROM tb_rutinas_x_tb_servicio";
		try{
		    conexion = new Conexion();
		    st = conexion.Conexion().createStatement();
		    rs = st.executeQuery(sql);
		    while(rs.next()){
		        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4)});
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
	
	public void llenarcomboRutina(){
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT DSNOMBRERUTINA FROM tb_rutinas";
			st = conexion.Conexion().createStatement();
			rs = st.executeQuery(sql);
			
			
			cbRutina.addItem("Seleccione Rutina:");
			
			
			while (rs.next()){
				cbRutina.addItem(rs.getString(1));
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
	
	public void llenarcomboServicio(){
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT DSNOMBRE FROM tb_servicio";
			st = conexion.Conexion().createStatement();
			rs = st.executeQuery(sql);
			
			
			cbServicio.addItem("Seleccione Servicio:");
			
			
			while (rs.next()){
				cbServicio.addItem(rs.getString(1));
				
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
	
	public int obtenerRutina(){
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		int id=0;
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT idTB_RUTINAS FROM tb_rutinas where DSNOMBRERUTINA='"+cbRutina.getSelectedItem()+"'";
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
	public int obtenerServicio(){
		Conexion conexion= null;
		Statement st=null; 
		ResultSet rs =null; 
		int id=0;
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT idTB_SERVICIO FROM tb_servicio where DSNOMBRE='"+cbServicio.getSelectedItem()+"'";
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
	
	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
		
	}

}
