package co.com.gym.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbRutinasXTbServicio;
import co.com.gym.util.Conexion;

public class AsignarDao extends JPanel{

public  TbRutinasXTbServicio guardarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		
	    TbRutinasXTbServicio asignar=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_rutinas_x_tb_servicio (TB_RUTINAS_idTB_RUTINAS, TB_SERVICIO_idTB_SERVICIO, FEREGISTRO) VALUES (?,?,?)";
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			
			pst.setInt(1, asig.getTbRutinas().getIdTbRutinas());
			pst.setInt(2, asig.getTbServicio().getIdTbServicio());
			pst.setDate(3, (java.sql.Date) asig.getFeregistro());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Asignacion Guardada", "Guardar", 1);

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar El registro", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.Conexion().close();
			pst.close();
	
		}
		return asignar;	

		}

	public TbRutinasXTbServicio modificarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		
		TbRutinasXTbServicio asignar=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "UPDATE tb_rutinas_x_tb_servicio SET TB_RUTINAS_idTB_RUTINAS='"+asig.getTbRutinas().getIdTbRutinas()+"', TB_SERVICIO_idTB_SERVICIO='"+asig.getTbServicio().getIdTbServicio()+"', FEREGISTRO='"+asig.getFeregistro()+"',  WHERE CDCODIGO='"+asig.getCdcodigo()+"'";
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

		return asignar;	
	}

	public TbRutinasXTbServicio eliminarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		
		
		TbRutinasXTbServicio asignar=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_rutinas_x_tb_servicio WHERE CDCODIGO='"+asig.getCdcodigo()+"'";
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
		
		return asignar;
	}
	
}
