package co.com.gym.model;

import java.sql.*;


public class GestionUsuario {

	public usuario obtenerUsuario(usuario usu){
		usuario Usuario=null;
		try{
			Conexion conexion = new Conexion();
			String sql = "SELECT * FROM usuario where TBUSUARIO=? and DS= ?";
			PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				Usuario = new usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
			}

		}catch(Exception e){
		
			System.out.println("error en obtener usuario");
		}
		
		
		return Usuario;
	}
	
}
