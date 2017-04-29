package co.com.gym.dao;

import java.sql.*;

import co.com.gym.model.Usuario;
import co.com.gym.util.Conexion;


public class UsuarioDao {

	public Usuario obtenerUsuario(Usuario usu) throws SQLException{
		
		Usuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT * FROM usuario where TBUSUARIO=? and DS= ?";
			pst = conexion.getConnection().prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			
			rs = pst.executeQuery();
			
			while (rs.next()){
				Usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
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
	
	public void guardarUsuario(Usuario usuario){
		// script para guardar un usuario
	}
	
}
