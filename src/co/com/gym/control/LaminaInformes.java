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
	private JButton btnBuscar;
	
	
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
		cbTipoInforme.addItem("Detalles de Usuario");
		add(cbTipoInforme);
		txtBuscar = new JTextField();
		txtBuscar.setBounds(238, 202, 86, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		modelo.addColumn("Campo 1");
		modelo.addColumn("Campo 2");
		modelo.addColumn("Campo 3");
		modelo.addColumn("Campo 4");
		modelo.addColumn("Campo 5");
		modelo.addColumn("Campo 6");
		modelo.addColumn("Campo 7");
		
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear_Table1();
				BuscarCliente(txtBuscar.getText());
				
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(20, 130, 200));
		btnBuscar.setBounds(83, 202, 89, 20);
		add(btnBuscar);
		
		
		
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
			sql = "SELECT TB_SERVICIO_idTB_SERVICIO , COUNT( * ) AS num FROM gym_unisabaneta.tb_rutinas_x_tb_servicio GROUP BY tb_rutinas_x_tb_servicio.TB_SERVICIO_idTB_SERVICIO ORDER BY num DESC";
		}else if (cbTipoInforme.getSelectedItem().equals("Instructores Mas Solicitados")){
			sql="SELECT tb_usuario.FKTIPO_USUARIO ,COUNT( * ) AS num FROM tb_usuario  WHERE tb_usuario.FKTIPO_USUARIO IS NOT NULL GROUP BY tb_usuario.FKTIPO_USUARIO ORDER BY num DESC";
		}else if (cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
			sql="SELECT tb_usuario.DSNOMBRE, tb_rutinas.DSNOMBRERUTINA FROM tb_usuario, tb_rutinas  WHERE tb_rutinas.TB_USUARIO_idTB_USUARIO = tb_usuario.idTB_USUARIO";
		}
		try{
		    
		    
		    
		    if (cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
		    	st2 = conexion.Conexion().createStatement();
		    	rs2 = st2.executeQuery(sql);
		    	while(rs2.next()){
		        modelo.addRow(new Object[] {rs2.getString(1),rs2.getString(2)});
		    	}
			}else{
		    }
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				rs2.close();
				conexion.Conexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
		}
	
	btnBuscar = new JButton("Buscar");
	btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
			Clear_Table1();
			BuscarCliente(txtBuscar.getText());
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "No hay un Cliente asociado a ese Documento o Nombre");
			}
		}
	});

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
		}else if (cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
			sql = "SELECT DSNOMBRE FROM tb_usuario WHERE idTB_USUARIO='"+id+"';";
		}
		String nombre="";
		try{
		    
		    st = conexion.Conexion().createStatement();
		    rs1 = st.executeQuery(sql);
		    while(rs1.next()){
		        nombre = rs1.getString(1);
		    }
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				rs1.close();
		        st.close();
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
	
		sql="SELECT tb_usuario.DSNOMBRE, tb_rutinas.DSNOMBRERUTINA FROM tb_usuario, tb_rutinas  WHERE tb_rutinas.TB_USUARIO_idTB_USUARIO = tb_usuario.idTB_USUARIO and DSNOMBRE like '%"+txtBuscar.getText()+"%'";
	try{
	    conexion = new Conexion();
	    st = conexion.Conexion().createStatement();
	    rs = st.executeQuery(sql);
	    while(rs.next()){
	        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2)});
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
	