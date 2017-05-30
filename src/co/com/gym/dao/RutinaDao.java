package co.com.gym.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbRutinas;
import co.com.gym.model.TbServicio;
import co.com.gym.util.Conexion;

public class RutinaDao {

public  TbRutinas guardarRutina(TbRutinas rut) throws SQLException{
		
	    TbRutinas rutina=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_rutinas (idTB_RUTINAS, DSNOMBRERUTINA, DSDESCRIPCION, FEFECHAINICIAL, FEFECHAFINAL, TB_USUARIO_idTB_USUARIO, FEREGISTRO) VALUES (?,?,?,?,?,?,?)";
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			
			pst.setInt(1, rut.getIdTbRutinas());
			pst.setString(2, rut.getDsnombrerutina());
			pst.setString(3, rut.getDsdescripcion());
			pst.setDate(4, (java.sql.Date) rut.getFefechainicial());
			pst.setDate(5, (java.sql.Date) rut.getFefechafinal());
			pst.setInt(6, rut.getTbUsuario().getIdTbUsuario());
			pst.setDate(7, (java.sql.Date) rut.getFeregistro());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Rutina Guardada", "Guardar", 1);

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar El registro", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.Conexion().close();
			pst.close();
	
		}
		return rutina;	

		}

	public TbRutinas modificarRutina(TbRutinas rut) throws SQLException{
		
		TbRutinas rutina=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "UPDATE tb_rutinas SET DSNOMBRERUTINA='"+rut.getDsnombrerutina()+"', DSDESCRIPCION='"+rut.getDsdescripcion()+"', FEFECHAINICIAL='"+rut.getFefechainicial()+"', FEFECHAFINAL='"+rut.getFefechafinal()+"', TB_USUARIO_idTB_USUARIO='"+rut.getTbUsuario().getIdTbUsuario()+"', FEREGISTRO='"+rut.getFeregistro()+"' WHERE idTB_RUTINAS='"+rut.getIdTbRutinas()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Modificar El registro", "Modificar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.Conexion().close();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro Modificado", "Modificar", 1);

		return rut;	
	}

	public TbRutinas eliminarRutina(TbRutinas rut) throws SQLException{
		
		
		TbRutinas rutina=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_rutinas WHERE idTB_RUTINAS='"+rut.getIdTbRutinas()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "registro Eliminado", "Eliminar", 1);


			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Eliminar El registro", "Eliminar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.Conexion().close();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return rut;
	}
}
