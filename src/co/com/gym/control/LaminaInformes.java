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
	private JTextField txtPrec;
	AsignarImpl asignarImpl = new AsignarImpl();
	TbRutinas rutina = new TbRutinas();
	TbServicio servicio = new TbServicio();
	private JLabel lblRutina;
	private JComboBox cbTipoInforme;
	private JButton btnVer;
	Conexion conexion= null;
	
	
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
			sql="SELECT tb_usuario.DSNOMBRE, tb_usuario.FKTIPO_USUARIO, tb_rutinas.DSNOMBRERUTINA,tb_servicio.DSNOMBRE, tb_estado_pago.DSTIPOPAGO, tb_tipo_contrato.DSDESCRIPCION, tb_tipo_contrato.NMPRECIO FROM tb_usuario, tb_rutinas, tb_estado_pago, tb_tipo_contrato, tb_servicio, tb_rutinas_x_tb_servicio  WHERE tb_rutinas.TB_USUARIO_idTB_USUARIO = tb_usuario.idTB_USUARIO and tb_estado_pago.TB_USUARIO_idTB_USUARIO= tb_usuario.idTB_USUARIO and tb_estado_pago.TB_TIPO_CONTRATO_idTB_TIPO_CONTRATO= tb_tipo_contrato.idTB_TIPO_CONTRATO and  tb_rutinas_x_tb_servicio.TB_SERVICIO_idTB_SERVICIO = tb_servicio.idTB_SERVICIO";
		}
		try{
		    
		    
		    
		    if (cbTipoInforme.getSelectedItem().equals("Detalles de Usuario")){
		    	st2 = conexion.Conexion().createStatement();
		    	rs2 = st2.executeQuery(sql);
		    	while(rs2.next()){
		        modelo.addRow(new Object[] {rs2.getString(1),TraerNombre(rs2.getString(2)),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6),rs2.getString(7)});
		    	}
			}else{
				st3 = conexion.Conexion().createStatement();
				rs3 = st3.executeQuery(sql);
		    while(rs3.next()){
		        modelo.addRow(new Object[] {TraerNombre(rs3.getString(1)),rs3.getString(2)});
		    }
		    }
		    
		}catch(Exception e){
		    System.out.println("error");
		    e.printStackTrace();
		}
		finally{
			try {
				rs2.close();
				rs3.close();
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
	}
	