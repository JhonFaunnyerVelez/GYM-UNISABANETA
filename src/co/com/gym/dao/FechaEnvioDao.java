package co.com.gym.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbFechaEnvio;
import co.com.gym.util.Conexion;

public class FechaEnvioDao {
	
	public TbFechaEnvio guardarFecha(TbFechaEnvio fecha) throws SQLException{
	TbFechaEnvio Fecha=null;
	Conexion conexion= null;
	PreparedStatement pst=null; 
	
	try{

		conexion = new Conexion();
		String sql = "INSERT INTO tb_fecha_envio (FEFECHAENVIO) VALUES (?)";
		pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
		pst.setDate(1, (java.sql.Date)fecha.getFefechaenvio());
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Emails Enviados", "Guardar", 1);
		
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "No se pudo Enviar", "Guardar", 0);
		e.printStackTrace();
	}finally{
		conexion.Conexion().close();
		pst.close();
	}
	return fecha;
}
}
