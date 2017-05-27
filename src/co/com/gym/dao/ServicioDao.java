package co.com.gym.dao;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbServicio;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;

public class ServicioDao {

	public  TbServicio guardarServicio(TbServicio serv) throws SQLException{
		
		TbServicio servicio=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_servicio (DSNOMBRE,DSDESCRIPCION,NMCUPOLIMITE,FEREGISTRO) VALUES (?,?,?,?)";
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			
			pst.setString(1, serv.getDsnombre());
			pst.setString(2, serv.getDsdescripcion());
			pst.setString(3, serv.getNmcupolimite());
			pst.setDate(4, (java.sql.Date) serv.getFeregistro());
			pst.executeUpdate();

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar El registro", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
	
		}
		JOptionPane.showMessageDialog(null, "Servicio Guardado", "Guardar", 1);
		return servicio;	

		}

	public TbServicio modificarServicio(TbServicio serv) throws SQLException{
		
		TbServicio servicio=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "UPDATE tb_servicio SET DSNOMBRE='"+serv.getDsnombre()+"', DSDESCRIPCION='"+serv.getDsdescripcion()+"', NMCUPOLIMITE="+serv.getNmcupolimite()+", FEREGISTRO='"+serv.getFeregistro()+"'WHERE idTB_SERVICIO='"+serv.getIdTbServicio()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Modificar El registro", "Modificar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.desconectar();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro Modificado", "Modificar", 1);

		return serv;	
	}

	public TbServicio eliminarServicio(TbServicio serv) throws SQLException{
		
		
		TbServicio servicio=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM gym_unisabaneta.tb_servicio WHERE idTB_SERVICIO='"+serv.getIdTbServicio()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			pst.executeUpdate();
			

			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Eliminar El registro", "Eliminar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.desconectar();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return serv;
	}
	
}
