package co.com.gym.control;

import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.com.gym.impl.InstructorImpl;
import co.com.gym.model.TbInstructor;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class LaminaInstructor extends JPanel{
	

	InstructorImpl instructorImpl = new InstructorImpl();
	TbInstructor instructor1 = new TbInstructor();
	private JTable tabla;
	private JTextField txtBuscar,txtId,txtNombre,txtDireccion,txtCorreo,txtTel,txtPrmApellido,txtSegApellido,txtDoc,txtFechNac,ttxtFechReg;
	private Color azul=new Color(20,130,200);
	private DefaultTableModel modelo;
	private JLabel lblId;
	private JButton btnModificar,btnEliminar,btnGuardar,btnBuscar;
	private JComboBox combo;
	
	public LaminaInstructor(){
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "INSTRUCTOR", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(273, 26, 83, 14);
		add(label);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("\r\n");
		txtNombre.setColumns(10);
		txtNombre.setBounds(402, 26, 86, 20);
		add(txtNombre);
		
		JLabel label_1 = new JLabel("Direccion:");
		label_1.setBounds(496, 29, 91, 14);
		add(label_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(608, 26, 86, 20);
		add(txtDireccion);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(608, 57, 86, 20);
		add(txtCorreo);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(608, 88, 86, 20);
		add(txtTel);
		
		JLabel label_2 = new JLabel("Telefono:");
		label_2.setBounds(496, 91, 87, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Correo:");
		label_3.setBounds(496, 60, 67, 14);
		add(label_3);
		
		txtPrmApellido = new JTextField();
		txtPrmApellido.setColumns(10);
		txtPrmApellido.setBounds(402, 57, 86, 20);
		add(txtPrmApellido);
		
		txtSegApellido = new JTextField();
		txtSegApellido.setColumns(10);
		txtSegApellido.setBounds(402, 88, 86, 20);
		add(txtSegApellido);
		
		JLabel label_4 = new JLabel("Segundo Apellido:");
		label_4.setBounds(273, 88, 119, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Primer Apellido:");
		label_5.setBounds(273, 57, 86, 14);
		add(label_5);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LaminaInstructor lamn = new LaminaInstructor();
				try {

					TbInstructor instructor = new TbInstructor(String.valueOf(txtNombre.getText()), String.valueOf(txtPrmApellido.getText()), String.valueOf(txtSegApellido.getText()), Integer.valueOf(txtTel.getText()), String.valueOf(txtDireccion.getText()), Integer.valueOf(txtDoc.getText()), String.valueOf(txtCorreo.getText()), Date.valueOf(txtFechNac.getText()), Date.valueOf(ttxtFechReg.getText()));
					//CapturarDatos();
					instructorImpl.guardarInstructor(instructor);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Clear_Table1();
				LlenarTabla("");
				limpiarCampos();
				JOptionPane.showMessageDialog(lamn, "Instructor Guardado");
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(20, 130, 200));
		btnGuardar.setBounds(467, 149, 89, 20);
		add(btnGuardar);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LaminaInstructor lamn = new LaminaInstructor();
				try {
					TbInstructor instructor = new TbInstructor(Integer.valueOf(txtId.getText()),String.valueOf(txtNombre.getText()), String.valueOf(txtPrmApellido.getText()), String.valueOf(txtSegApellido.getText()), Integer.valueOf(txtTel.getText()), String.valueOf(txtDireccion.getText()), Integer.valueOf(txtDoc.getText()), String.valueOf(txtCorreo.getText()), Date.valueOf(txtFechNac.getText()), Date.valueOf(ttxtFechReg.getText())); 
					instructorImpl.modificarInstructor(instructor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpiarCampos();
				Clear_Table1();
				LlenarTabla("");
				JOptionPane.showMessageDialog(lamn, "Instructor Modificado");
				btnGuardar.setEnabled(true);
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(20, 130, 200));
		btnModificar.setBounds(668, 149, 89, 20);
		btnModificar.setEnabled(false);
		add(btnModificar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(20, 130, 200));
		btnLimpiar.setBounds(569, 149, 89, 20);
		add(btnLimpiar);
		
		JLabel label_6 = new JLabel("Fecha Registro");
		label_6.setBounds(704, 91, 86, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("Fecha Nacimiento:");
		label_7.setBounds(704, 60, 111, 14);
		add(label_7);
		
		JLabel label_8 = new JLabel("Documento:");
		label_8.setBounds(704, 29, 96, 14);
		add(label_8);
		
		txtDoc = new JTextField();
		txtDoc.setColumns(10);
		txtDoc.setBounds(825, 26, 86, 20);
		add(txtDoc);
		
		txtFechNac = new JTextField();
		txtFechNac.setColumns(10);
		txtFechNac.setBounds(825, 57, 86, 20);
		add(txtFechNac);
		
		ttxtFechReg = new JTextField();
		ttxtFechReg.setColumns(10);
		ttxtFechReg.setBounds(825, 88, 86, 20);
		add(ttxtFechReg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Primer Apellido");
		modelo.addColumn("Segundo Apellido");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Cedula");
		modelo.addColumn("Correo");
		modelo.addColumn("Fech Nacimiento");
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
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(569, 532, 106, 23);
		btnActualizar.setForeground(Color.white);
		btnActualizar.setBackground(azul);
		add(btnActualizar);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(159, 57, 86, 20);
		txtId.setVisible(false);
		add(txtId);
		txtId.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(125, 60, 24, 14);
		lblId.setVisible(false);;
		add(lblId);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LaminaInstructor lamn = new LaminaInstructor();
				try {
					int id = Integer.valueOf(txtId.getText());
					instructor1.setIdTbInstructor(id);
					instructorImpl.eliminarInstructor(instructor1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limpiarCampos();
				Clear_Table1();
				LlenarTabla("");
				JOptionPane.showMessageDialog(lamn, "Instructor Eliminado");
				btnGuardar.setEnabled(true);
			
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(20, 130, 200));
		btnEliminar.setBounds(767, 149, 89, 20);
		btnEliminar.setEnabled(false);
		add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LaminaInstructor lamn = new LaminaInstructor();
				try{
				Clear_Table1();
				LlenarTabla(txtBuscar.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(lamn, "No hay un Instructor asociado a ese Documento");
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
				LlenarTabla("");
				btnBuscar.setEnabled(true);
				txtBuscar.setEnabled(true);
			
			}
		});
	}
	public void SeleccionarRegistro(){
		int fila = tabla.getSelectedRow();
		if(fila>=0){
			txtId.setText(tabla.getValueAt(fila, 0).toString());
			txtNombre.setText(tabla.getValueAt(fila, 1).toString());
			txtPrmApellido.setText(tabla.getValueAt(fila, 2).toString());
			txtSegApellido.setText(tabla.getValueAt(fila, 3).toString());
			txtTel.setText(tabla.getValueAt(fila, 4).toString());
			txtDireccion.setText(tabla.getValueAt(fila, 5).toString());
			txtDoc.setText(tabla.getValueAt(fila, 6).toString());
			txtCorreo.setText(tabla.getValueAt(fila, 7).toString());
			txtFechNac.setText(tabla.getValueAt(fila, 8).toString());
			ttxtFechReg.setText(tabla.getValueAt(fila, 9).toString());
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
		txtTel.setText("");
		txtDireccion.setText("");
		txtDoc.setText("");
		txtCorreo.setText("");
		txtFechNac.setText("");
		ttxtFechReg.setText("");
		txtId.setVisible(false);
		lblId.setVisible(false);
	}
	public void LlenarTabla(String valor){
		
/*		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		TbUsuario tbUsuario = null;
		
		try{
			
			tr = sesion.beginTransaction();
			
			Query q =sesion.createQuery("SELECT i FROM TbInstructor i ");
            List lista = q.list();
            lista.toArray();

            for( int i = 0; i < lista.size(); i++ ){
                TbInstructor usuarioAct = (TbInstructor) lista.get( i );
    		        modelo.addRow(new Object[] {Integer.valueOf(usuarioAct.getIdTbInstructor()),String.valueOf(usuarioAct.getDsnombre()),String.valueOf(usuarioAct.getDsprimerapellido()),String.valueOf(usuarioAct.getDssegundoapellido()),Integer.valueOf(usuarioAct.getNmtelefono()),String.valueOf(usuarioAct.getDsdireccion()),Integer.valueOf(usuarioAct.getNmdocumento()),String.valueOf(usuarioAct.getDscorreo()),usuarioAct.getFefechanacimiento(),usuarioAct.getFeregistro()});

            }

		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
		
		
		*/
		Conexion conexion= null;
		Statement st = null; 
		ResultSet rs =null; 
		String sql="";
		if (valor.equals("")){
			sql = "SELECT * FROM gym_unisabaneta.tb_instructor";
		}else{
			sql="SELECT * FROM gym_unisabaneta.tb_instructor WHERE NMDOCUMENTO='"+valor+"'";
		}
		if (combo.getSelectedItem().equals("Nombre"))
		{
			sql="SELECT * FROM gym_unisabaneta.tb_instructor WHERE DSNOMBRE='"+valor+"'";
		}
		try{
		    conexion = new Conexion();
		    st = conexion.getConnection().createStatement();
		    rs = st.executeQuery(sql);
		    while(rs.next()){
		        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getDate(10)});
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

