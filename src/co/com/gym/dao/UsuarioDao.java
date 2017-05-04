package co.com.gym.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;

import org.hibernate.*;

import co.com.gym.control.LaminaCliente;
import co.com.gym.control.LaminaInstructor;
import co.com.gym.control.VentanaMenu;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;


public class UsuarioDao {

//	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
//		
//		TbUsuario Usuario=null;
//		Conexion conexion= null;
//		PreparedStatement pst=null; 
//		ResultSet rs =null; 
//		
//		Session sesion =  HibernateUtil.getSessionFactory().openSession();
//		
//		try{
//			
//			conexion = new Conexion();
//			String sql = "SELECT * FROM tb_usuario where NMDOCUMENTO=? and DSCONTRASENA= ?";
//			pst = conexion.getConnection().prepareStatement(sql);
//			
//			pst.setInt(1, usu.getNmdocumento());
//			pst.setString(2, usu.getDscontrasena());
//			
//			rs = pst.executeQuery();
//			
//			
//			while (rs.next()){
//				Usuario = new TbUsuario(rs.getInt(8),rs.getString(9));
//			}
//
//		}catch(Exception e){
//			System.out.println("error en obtener usuario");
//		}finally{
//			conexion.desconectar();
//			pst.close();
//			rs.close();		
//		}
//		return Usuario;	
//
//	}
	private int Autorizado =0;
	
	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		TbUsuario tbUsuario = null;
		
		try{
			
			tr = sesion.beginTransaction();
			
			tbUsuario = (TbUsuario) sesion.createQuery("SELECT u FROM TbUsuario u where nmdocumento = " + usu.getNmdocumento() + " and dscontrasena = " + usu.getDscontrasena()).uniqueResult();
			tr.commit();
			Autorizado = tbUsuario.getNmautorizado();
			System.out.println(Autorizado);
			VentanaMenu menu = new VentanaMenu();
		    JButton instructor = new JButton(); 
		    JButton cliente = new JButton(); 
		    JButton rutina = new JButton();
		    if (Autorizado==1){
			menu.setVisible(true);
		    }else {
		    	menu.setVisible(true); 
		    	instructor=menu.getBtnInstructor();
		    	instructor.setEnabled(false);
		    	menu.setBtnInstructor(instructor);
		    	cliente=menu.getBtnCliente();
		    	cliente.setEnabled(false);
		    	menu.setBtnCliente(cliente);
		    	rutina=menu.getBtnRutina();
		    	rutina.doClick();
		    	menu.setBtnRutina(rutina);
		    }

		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
		return tbUsuario;		

	}
	
	public void guardarUsuario(TbUsuario usuario){
		
		
	}

	public int permisoUsuario() throws SQLException{
		return Autorizado;
	}
	}
