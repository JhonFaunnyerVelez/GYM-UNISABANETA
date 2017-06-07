package co.com.gym.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import co.com.gym.model.TbRutinas;
import co.com.gym.model.TbRutinasXTbServicio;
import co.com.gym.model.TbServicio;
import co.com.gym.util.Conexion;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LaminaInformes extends JPanel {
	
	private JButton btnActualizar;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField txtPrec, txtBuscar;
	AsignarImpl asignarImpl = new AsignarImpl();
	TbRutinas rutina = new TbRutinas();
	TbServicio servicio = new TbServicio();
	private JLabel lblRutina;
	private JComboBox cbTipoInforme;
	private JButton btnVer;
	Conexion conexion= null;
	private JButton btnBuscar1;
	
	
	public LaminaInformes(){
	
		conexion = new Conexion();
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "INFORMES", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);;
		

		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		
		lblRutina = new JLabel("Seleccione Informe:");
		lblRutina.setBounds(226, 68, 149, 14);
		add(lblRutina);
		
		cbTipoInforme = new JComboBox();
		
		cbTipoInforme.setBounds(348, 65, 209, 20);
		cbTipoInforme.addItem("Clientes de cada Instructor");
		cbTipoInforme.addItem("Servicios Mas Usados");
		cbTipoInforme.addItem("Instructores Mas Solicitados");
		cbTipoInforme.addItem("Rutina de Usuario");
		cbTipoInforme.addItem("Servicios de Usuario");
		cbTipoInforme.addItem("Detalles de Usuario");
		add(cbTipoInforme);
	
		txtBuscar = new JTextField();
		txtBuscar.setBounds(238, 202, 86, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.setVisible(false);
		
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		modelo.addColumn("");
		
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear_Table1();
				LlenarTabla();
			}
		});
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(new Color(20, 130, 200));
		btnVer.setBounds(620, 65, 89, 20);
		add(btnVer);
		
		btnBuscar1 = new JButton("Buscar");
		btnBuscar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear_Table1();
				BuscarCliente(txtBuscar.getText());
				txtBuscar.setText("");
				
			}
		});
		btnBuscar1.setForeground(Color.WHITE);
		btnBuscar1.setBackground(new Color(20, 130, 200));
		btnBuscar1.setBounds(83, 202, 89, 20);
		btnBuscar1.setVisible(false);
		add(btnBuscar1);
		cbTipoInforme.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbTipoInforme.getSelectedItem().equals("Rutina de Usuario") || cbTipoInforme.getSelectedItem().equals("Servicios de Usuario") || cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
					txtBuscar.setVisible(true);
					btnBuscar1.setVisible(true);
					
				}else
				{
					txtBuscar.setVisible(false);
					btnBuscar1.setVisible(false);
				}
			}
		});
	}


	public void LlenarTabla(){
		
		ResultSet rs2= null;
		ResultSet rs3= null;
		Statement st2 = null; 
		Statement st3 = null; 
		String sql="";
		if (cbTipoInforme.getSelectedItem().equals("Clientes de cada Instructor")){
			sql = "SELECT tb_usuario.FKTIPO_USUARIO, tb_usuario.DSNOMBRE FROM tb_usuario WHERE tb_usuario.TIPO_USUARIO_idTIPO_USUARIO='2';";
		}else if (cbTipoInforme.getSelectedItem().equals("Servicios Mas Usados")){
			sql = "select s.DSNOMBRE, count(TB_SERVICIO_idTB_SERVICIO) 'Cantidad' from tb_rutinas_x_tb_servicio rs , tb_servicio s where s.idTB_SERVICIO = rs.TB_SERVICIO_idTB_SERVICIO group by TB_SERVICIO_idTB_SERVICIO order by count(TB_SERVICIO_idTB_SERVICIO) DESC";
		}else if (cbTipoInforme.getSelectedItem().equals("Instructores Mas Solicitados")){
			sql="select u.DSNOMBRE, u.DSPRIMERAPELLIDO, u.DEESPECIALIDAD , count(idTB_USUARIO) 'Cantidad de solicitudes' from tb_usuario u where u.TIPO_USUARIO_idTIPO_USUARIO = 3 group by idTB_USUARIO order by count(idTB_USUARIO) DESC";
		}else if (cbTipoInforme.getSelectedItem().equals("Rutina de Usuario")){
			sql="SELECT tb_usuario.DSNOMBRE, tb_rutinas.DSNOMBRERUTINA FROM tb_usuario, tb_rutinas  WHERE tb_rutinas.TB_USUARIO_idTB_USUARIO = tb_usuario.idTB_USUARIO";
		}else if (cbTipoInforme.getSelectedItem().equals("Servicios de Usuario")){
			sql="select u.DSNOMBRE 'nombre cliente' ,  s.DSNOMBRE 'Servicio' from tb_rutinas r, tb_usuario u , tb_servicio s , tb_rutinas_x_tb_servicio rs where r.TB_USUARIO_idTB_USUARIO = u.idTB_USUARIO and s.idTB_SERVICIO = rs.TB_SERVICIO_idTB_SERVICIO and rs.TB_RUTINAS_idTB_RUTINAS = r.idTB_RUTINAS and u.TIPO_USUARIO_idTIPO_USUARIO = 2;";
		}else if(cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
			sql="select u.DSNOMBRE 'nombre cliente' , u.DSPRIMERAPELLIDO , u.NMDOCUMENTO ,r.DSNOMBRERUTINA 'Rutina', r.DSDESCRIPCION , r.FEFECHAINICIAL,r.FEFECHAFINAL , s.DSNOMBRE 'Servicio' , s.DSDESCRIPCION from tb_rutinas r, tb_usuario u , tb_servicio s , tb_rutinas_x_tb_servicio rs where r.TB_USUARIO_idTB_USUARIO = u.idTB_USUARIO and s.idTB_SERVICIO = rs.TB_SERVICIO_idTB_SERVICIO and rs.TB_RUTINAS_idTB_RUTINAS = r.idTB_RUTINAS and u.TIPO_USUARIO_idTIPO_USUARIO = 2;";
		}
		try{

		    	st2 = conexion.Conexion().createStatement();
		    	rs2 = st2.executeQuery(sql);
		    	if (cbTipoInforme.getSelectedItem().equals("Clientes de cada Instructor")){
		    	while(rs2.next()){
		    	modelo.setColumnIdentifiers(new Object[] {"Instructor","Cliente"});
		        modelo.addRow(new Object[] {TraerNombre(rs2.getString(1)),rs2.getString(2)});
		    	}

		    	}else if (cbTipoInforme.getSelectedItem().equals("Servicios Mas Usados")){
		    		while(rs2.next()){
				    	modelo.setColumnIdentifiers(new Object[] {"Servicio","Veces Usado"});
				        modelo.addRow(new Object[] {TraerNombre(rs2.getString(1)),rs2.getString(2)});
				    	}

		    	}else if (cbTipoInforme.getSelectedItem().equals("Rutina de Usuario")){
		    		while(rs2.next()){
				    	modelo.setColumnIdentifiers(new Object[] {"Cliente","Rutina"});
				        modelo.addRow(new Object[] {rs2.getString(1),rs2.getString(2)});
				    	}

		    	}else if (cbTipoInforme.getSelectedItem().equals("Instructores Mas Solicitados")){
		    		while(rs2.next()){
				    	modelo.setColumnIdentifiers(new Object[] {"Nombre","Primer Apellido","Especialidad","Numero de Clientes"});
				        modelo.addRow(new Object[] {TraerNombre(rs2.getString(1)),rs2.getString(2),rs2.getString(3),rs2.getString(4)});
				    	}

		    	}else if (cbTipoInforme.getSelectedItem().equals("Servicios de Usuario")){
		    		while(rs2.next()){
				    	modelo.setColumnIdentifiers(new Object[] {"Cliente","Servicio"});
				        modelo.addRow(new Object[] {rs2.getString(1),rs2.getString(2)});
				        
				    	}
		    	}else if (cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
		    		while(rs2.next()){
		    		modelo.setColumnIdentifiers(new Object[] {"Cliente", "PRIMER APELLIDO", "DOCUMENTO", "Rutina", "DESCRIPCION", "FECHA INICIAL", "FECHA FINAL", "Servicio", "DESCRIPCION"});
			        modelo.addRow(new Object[] {rs2.getString(1),rs2.getString(2),rs2.getInt(3),rs2.getString(4),rs2.getString(5),rs2.getDate(6),rs2.getDate(7),rs2.getString(8),rs2.getString(9)});
		    		}
		    	}
				rs2.close();
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				conexion.Conexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
		}
	

}
	
	public String TraerNombre(String id){
		
		Statement st = null; 
		ResultSet rs1 =null;
		String sql="";
		if (cbTipoInforme.getSelectedItem().equals("Clientes de cada Instructor")){
		sql = "SELECT DSNOMBRE FROM tb_usuario WHERE idTB_USUARIO='"+id+"';";
		}else if (cbTipoInforme.getSelectedItem().equals("Servicios Mas Usados")){
			sql = "SELECT DSNOMBRE FROM tb_servicio WHERE idTB_SERVICIO='"+id+"';";
		}else if (cbTipoInforme.getSelectedItem().equals("Instructores Mas Solicitados")){
			sql = "SELECT DSNOMBRE FROM tb_usuario WHERE idTB_USUARIO='"+id+"';";
		}else if (cbTipoInforme.getSelectedItem().equals("Rutina de Usuario")){
			sql = "SELECT DSNOMBRE FROM tb_usuario WHERE idTB_USUARIO='"+id+"';";
		}
		String nombre="";
		try{
		    
		    st = conexion.Conexion().createStatement();
		    rs1 = st.executeQuery(sql);
		    while(rs1.next()){
		        nombre = rs1.getString(1);
		    }
			rs1.close();

		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				conexion.Conexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
		}
		return nombre;
	}
	
	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	       
		
	}
	
public void BuscarCliente(String valor){
	
	Conexion conexion= null;
	Statement st = null; 
	ResultSet rs =null; 
	String sql="";
	if(cbTipoInforme.getSelectedItem().equals("Rutina de Usuario")){
		sql="SELECT tb_usuario.DSNOMBRE, tb_rutinas.DSNOMBRERUTINA FROM tb_usuario, tb_rutinas  WHERE tb_rutinas.TB_USUARIO_idTB_USUARIO = tb_usuario.idTB_USUARIO and DSNOMBRE like '%"+valor+"%'";
	}else if(cbTipoInforme.getSelectedItem().equals("Servicios de Usuario")){
		sql="select u.DSNOMBRE 'nombre cliente' ,  s.DSNOMBRE 'Servicio' from tb_rutinas r, tb_usuario u , tb_servicio s , tb_rutinas_x_tb_servicio rs where r.TB_USUARIO_idTB_USUARIO = u.idTB_USUARIO and s.idTB_SERVICIO = rs.TB_SERVICIO_idTB_SERVICIO and rs.TB_RUTINAS_idTB_RUTINAS = r.idTB_RUTINAS and u.TIPO_USUARIO_idTIPO_USUARIO = 2 and u.DSNOMBRE like '%"+valor+"%'";
	}else if(cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
		sql="select u.DSNOMBRE 'nombre cliente' , u.DSPRIMERAPELLIDO , u.NMDOCUMENTO ,r.DSNOMBRERUTINA 'Rutina', r.DSDESCRIPCION , r.FEFECHAINICIAL,r.FEFECHAFINAL , s.DSNOMBRE 'Servicio' , s.DSDESCRIPCION from tb_rutinas r, tb_usuario u , tb_servicio s , tb_rutinas_x_tb_servicio rs where r.TB_USUARIO_idTB_USUARIO = u.idTB_USUARIO and s.idTB_SERVICIO = rs.TB_SERVICIO_idTB_SERVICIO and rs.TB_RUTINAS_idTB_RUTINAS = r.idTB_RUTINAS and u.TIPO_USUARIO_idTIPO_USUARIO = 2 and u.DSNOMBRE like '%"+valor+"%'";
	}
	try{
	    conexion = new Conexion();
	    st = conexion.Conexion().createStatement();
	    rs = st.executeQuery(sql);
	    if(cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
	    	while(rs.next()){
	        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getString(8),rs.getString(9)});
	    	}
	    }else {
	    while(rs.next()){
	        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2)});
	    }
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
	}}	
}
	