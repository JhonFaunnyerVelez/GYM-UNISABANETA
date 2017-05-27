package co.com.gym.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import co.com.gym.impl.ServicioImpl;
import co.com.gym.impl.TipoContratoImpl;
import co.com.gym.model.TbServicio;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.util.Conexion;

public class LaminaTpContrato extends JPanel{
	
	private JButton btnGuardar,btnLimpiar,btnModificar,btnEliminar,btnActualizar;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField txtDescripcion,txtPrecio,txtFechReg, txtId;
	private JLabel lblId;
	private JTextField txtPrec;
	TipoContratoImpl tipocontratoImpl = new TipoContratoImpl();
	TbTipoContrato tipocontrato1 = new TbTipoContrato();
	
	public LaminaTpContrato(){
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TIPO DE CONTRATO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		
		JLabel label = new JLabel("Descripcion:");
		label.setBounds(408, 28, 83, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Precio:");
		label_1.setBounds(408, 59, 86, 14);
		add(label_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(537, 28, 86, 20);
		add(txtDescripcion);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(537, 59, 86, 20);
		add(txtPrecio);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro:");
		lblFechaDeRegistro.setBounds(633, 28, 125, 14);
		add(lblFechaDeRegistro);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(20, 130, 200));
		btnGuardar.setBounds(439, 149, 89, 20);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					TbTipoContrato tipocontrato = new TbTipoContrato(String.valueOf(txtDescripcion.getText()), Integer.valueOf(txtPrecio.getText()), Date.valueOf(txtFechReg.getText()));
					//CapturarDatos();
					tipocontratoImpl.guardartpcon(tipocontrato);
					
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
		txtFechReg.setBounds(768, 28, 86, 20);
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
				int id = Integer.valueOf(txtId.getText());
			    tipocontrato1.setIdTbTipoContrato(id);
				tipocontratoImpl.eliminartpcon(tipocontrato1);
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
					
					TbTipoContrato tbTipoContrato = new TbTipoContrato();
					tbTipoContrato.setIdTbTipoContrato(Integer.valueOf(txtId.getText()));
					tbTipoContrato.setDsdescripcion(txtDescripcion.getText());
					tbTipoContrato.setNmprecio(Integer.valueOf(txtPrecio.getText()));
					tbTipoContrato.setFeregistro(Date.valueOf(txtFechReg.getText()));
					tipocontratoImpl.modificartpcon(tbTipoContrato);
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
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio");
		modelo.addColumn("Fech Registro");
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
		
		
		
	}
	public void SeleccionarRegistro(){
		int fila = tabla.getSelectedRow();
		if(fila>=0){
			txtId.setText(tabla.getValueAt(fila, 0).toString());
			txtDescripcion.setText(tabla.getValueAt(fila, 1).toString());
			txtPrecio.setText(tabla.getValueAt(fila, 2).toString());
			txtFechReg.setText(tabla.getValueAt(fila, 3).toString());
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
		txtPrecio.setText("");
		txtFechReg.setText("");
		txtId.setVisible(false);
		lblId.setVisible(false);
	}
	public void LlenarTabla(){
		
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql = "SELECT * FROM gym_unisabaneta.tb_tipo_contrato";
		try{
		    conexion = new Conexion();
		    st = conexion.getConnection().createStatement();
		    rs = st.executeQuery(sql);
		    while(rs.next()){
		        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4)});
		    }
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			conexion.desconectar();
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

	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	   }
}
