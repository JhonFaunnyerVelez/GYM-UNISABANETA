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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.com.gym.impl.PagoImpl;
import co.com.gym.impl.TipoContratoImpl;
import co.com.gym.model.TbEstadoPago;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import javax.swing.JComboBox;

public class LaminaPago extends JPanel {
	private JButton btnGuardar,btnLimpiar,btnModificar,btnEliminar,btnActualizar;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField txtTipoPago, txtId;
	private JLabel lblId;
	private JTextField txtPrec;
	PagoImpl pagoImpl = new PagoImpl();
	TbEstadoPago Tbestadopago = new TbEstadoPago();
	TbUsuario usuario = new TbUsuario();
	TbTipoContrato contrato = new TbTipoContrato();
	private JComboBox cbCliente;
	private JLabel lblCliente;
	private JLabel label_3;
	private JComboBox cbTipoContrato;
	private JButton btnListarContrato;
	private JButton btnListarCliente;
	private JLabel lblActivo;
	private JComboBox cbActivo;
	
	public LaminaPago(){
		
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PAGO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

			setBounds(10, 20, 1240, 568);
			setLayout(null);
			setBackground(Color.WHITE);
			setVisible(false);
			
			JLabel lblTipoDeContrato = new JLabel("Tipo de Pago:");
			lblTipoDeContrato.setBounds(408, 28, 119, 14);
			add(lblTipoDeContrato);
			
			txtTipoPago = new JTextField();
			txtTipoPago.setColumns(10);
			txtTipoPago.setBounds(537, 28, 86, 20);
			add(txtTipoPago);
			txtTipoPago.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c<'a' || c>'z') e.consume();
					
				}
			});
			

			btnGuardar = new JButton("Guardar");
			btnGuardar.setForeground(Color.WHITE);
			btnGuardar.setBackground(new Color(20, 130, 200));
			btnGuardar.setBounds(439, 149, 89, 20);
			add(btnGuardar);
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {

						int idcliente = obtenerCliente();
						usuario.setIdTbUsuario(idcliente);
						int idContrato = obtenerContrato();
						contrato.setIdTbTipoContrato(idContrato);
						TbEstadoPago pago = new TbEstadoPago();
						pago.setDstipopago(txtTipoPago.getText());
						pago.setNmactivo(Integer.valueOf((String)cbActivo.getSelectedItem()));
						pago.setTbTipoContrato(contrato);
						pago.setTbUsuario(usuario);
						pagoImpl.guardarPago(pago);
						
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
					TbEstadoPago pago = new TbEstadoPago();
					pago.setIdTbEstadoPago(id);
					pagoImpl.eliminarPago(pago);
					
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
						
						int idcliente = obtenerCliente();
						usuario.setIdTbUsuario(idcliente);
						int idContrato = obtenerContrato();
						contrato.setIdTbTipoContrato(idContrato);
						TbEstadoPago pago = new TbEstadoPago();
						pago.setIdTbEstadoPago(Integer.valueOf(txtId.getText()));
						pago.setDstipopago(txtTipoPago.getText());
						pago.setNmactivo(Integer.valueOf((String)cbActivo.getSelectedItem()));
						pago.setTbTipoContrato(contrato);
						pago.setTbUsuario(usuario);
						pagoImpl.modificarPago(pago);
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
			txtId.setColumns(10);
			
			lblId = new JLabel("ID");
			lblId.setBounds(245, 41, 24, 14);
			lblId.setVisible(false);;
			add(lblId);
			

			modelo = new DefaultTableModel();
			modelo.addColumn("ID");
			modelo.addColumn("Tipo de Pago");
			modelo.addColumn("Activo");
			modelo.addColumn("Tipo de Contrato");
			modelo.addColumn("Cliente");
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
			
			cbCliente = new JComboBox();
			cbCliente.setBounds(750, 65, 236, 20);
			add(cbCliente);
			
			lblCliente = new JLabel("Cliente:");
			lblCliente.setBounds(633, 71, 91, 14);
			add(lblCliente);
			
			label_3 = new JLabel("Tipo de Contrato:");
			label_3.setBounds(633, 34, 124, 14);
			add(label_3);
			
			cbTipoContrato = new JComboBox();
			cbTipoContrato.setBounds(750, 28, 236, 20);
			add(cbTipoContrato);
			
			btnListarContrato = new JButton("Listar");
			btnListarContrato.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbTipoContrato.removeAllItems();
					llenarcomboContrato();
				}
			});
			btnListarContrato.setForeground(Color.WHITE);
			btnListarContrato.setBackground(new Color(20, 130, 200));
			btnListarContrato.setBounds(996, 28, 89, 20);
			add(btnListarContrato);
			
			btnListarCliente = new JButton("Listar");
			btnListarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbCliente.removeAllItems();
					llenarcomboCliente();
				}
			});
			btnListarCliente.setForeground(Color.WHITE);
			btnListarCliente.setBackground(new Color(20, 130, 200));
			btnListarCliente.setBounds(996, 62, 89, 20);
			add(btnListarCliente);
			
			lblActivo = new JLabel("Activo:");
			lblActivo.setBounds(408, 68, 86, 14);
			add(lblActivo);
			
			cbActivo = new JComboBox();
			cbActivo.setBounds(537, 65, 86, 20);
			cbActivo.addItem("0");
			cbActivo.addItem("1");
			add(cbActivo);
			
			
			
		}
		public void SeleccionarRegistro(){
			int fila = tabla.getSelectedRow();
			if(fila>=0){
				txtId.setText(tabla.getValueAt(fila, 0).toString());
				txtTipoPago.setText(tabla.getValueAt(fila, 1).toString());
				cbActivo.setSelectedItem(tabla.getValueAt(fila, 2));
				cbTipoContrato.setSelectedItem(tabla.getValueAt(fila, 3));
				cbCliente.setSelectedItem(tabla.getValueAt(fila, 4));
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
			txtTipoPago.setText("");
			cbActivo.setSelectedIndex(0);
			cbTipoContrato.setSelectedIndex(0);
			cbCliente.setSelectedIndex(0);
			txtId.setVisible(false);
			lblId.setVisible(false);
		}
		public void LlenarTabla(){
			
			Conexion conexion= null;
			Statement st = null; 
			ResultSet rs =null; 
			String sql = "SELECT * FROM gym_unisabaneta.tb_estado_pago";
			try{
			    conexion = new Conexion();
			    st = conexion.Conexion().createStatement();
			    rs = st.executeQuery(sql);
			    while(rs.next()){
			        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)});
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
		
		public void llenarcomboCliente(){
			Conexion conexion= null;
			Statement st=null; 
			ResultSet rs =null; 
			
			try{
				
				conexion = new Conexion();
				String sql = "SELECT DSNOMBRE FROM tb_usuario where TIPO_USUARIO_idTIPO_USUARIO=2";
				st = conexion.Conexion().createStatement();
				rs = st.executeQuery(sql);
				
				
				cbCliente.addItem("Seleccione un Cliente:");
				
				
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
		
		public void llenarcomboContrato(){
			Conexion conexion= null;
			Statement st=null; 
			ResultSet rs =null; 
			
			try{
				
				conexion = new Conexion();
				String sql = "SELECT DSDESCRIPCION FROM tb_tipo_contrato";
				st = conexion.Conexion().createStatement();
				rs = st.executeQuery(sql);
				
				
				cbTipoContrato.addItem("Seleccione un Contrato:");
				
				
				while (rs.next()){
					cbTipoContrato.addItem(rs.getString(1));
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
		
		public int obtenerContrato(){
			Conexion conexion= null;
			Statement st=null; 
			ResultSet rs =null; 
			int id=0;
			
			try{
				
				conexion = new Conexion();
				String sql = "SELECT idTB_TIPO_CONTRATO FROM tb_tipo_contrato where DSDESCRIPCION='"+cbTipoContrato.getSelectedItem()+"'";
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
		public int obtenerCliente(){
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
