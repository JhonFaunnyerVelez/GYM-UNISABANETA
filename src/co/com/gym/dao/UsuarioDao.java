package co.com.gym.dao;

import java.sql.*;

import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;


public class UsuarioDao {

	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT * FROM tb_usuario where NMDOCUMENTO=? and DSCONTRASENA= ?";
			pst = conexion.getConnection().prepareStatement(sql);
			
			pst.setInt(1, usu.getNmdocumento());
			pst.setString(2, usu.getDscontrasena());
			
			rs = pst.executeQuery();
			
			
			while (rs.next()){
				Usuario = new TbUsuario(rs.getInt(8),rs.getString(9));
			}

		}catch(Exception e){
			System.out.println("error en obtener usuario");
		}finally{
			conexion.desconectar();
			pst.close();
			rs.close();		
		}
		return Usuario;	

	}
	
	public void guardarUsuario(TbUsuario usuario){
		// script para guardar un usuario
	}
	
}
