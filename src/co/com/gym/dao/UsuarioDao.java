package co.com.gym.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.hibernate.*;

import com.mysql.jdbc.*;

import co.com.gym.control.VentanaMenu;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;


public class UsuarioDao {

	
	
	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		ResultSet rs =null; 
		
		try{
			
			conexion = new Conexion();
			String sql = "SELECT * FROM tb_usuario where NMDOCUMENTO=? and DSCONTRASENA= ?";
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			
			pst.setInt(1, usu.getNmdocumento());
			pst.setString(2, usu.getDscontrasena());
			
			rs = pst.executeQuery();
			
			
			while (rs.next()){
				Usuario = new TbUsuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20));
			}
			
		}catch(Exception e){
			System.out.println("error en obtener usuario");
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
			rs.close();		
		}
		return Usuario;	

	}
	
	public TbUsuario guardarUsuario(TbUsuario usuario) throws SQLException{
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_usuario (DSNOMBRE, DSPRIMERAPELLIDO, DSSEGUNDOAPELLIDO, NMAUTORIZADO, DSCORREO, FEFECHANACIMIENTO, NMDOCUMENTO, DSTELEFONO, DSDIRECCION, DSSEXO, DSOCUPACION, FEREGISTRO, TIPO_USUARIO_idTIPO_USUARIO, DSESTADOCIVIL, DEESPECIALIDAD, NMEDAD, NMCELULAR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			pst.setString(1, usuario.getDsnombre());
			pst.setString(2, usuario.getDsprimerapellido());
			pst.setString(3, usuario.getDssegundoapellido());
			pst.setInt(4, usuario.getNmautorizado());
			pst.setString(5, usuario.getDscorreo());
			pst.setDate(6, (java.sql.Date) usuario.getFefechanacimiento());
			pst.setInt(7, usuario.getNmdocumento());
			pst.setString(8, usuario.getDstelefono());
			pst.setString(9, usuario.getDsdireccion());
			pst.setString(10, usuario.getDssexo());
			pst.setString(11, usuario.getDsocupacion());
			pst.setString(12,usuario.getFeregistro());
			pst.setInt(13, usuario.getTbTipoUsuario().getIdTipoUsuario());
			pst.setString(14, usuario.getDsestadocivil());
			pst.setString(15, usuario.getDeespecialidad());
			pst.setInt(16, usuario.getNmedad());
			pst.setInt(17, usuario.getNmcelular());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar el Cliente", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
		}
		return usuario;
	}
	public TbUsuario modificarUsuario(TbUsuario usuario) throws SQLException{
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		String sql = "UPDATE tb_usuario SET DSNOMBRE='"+usuario.getDsnombre()+"', DSPRIMERAPELLIDO='"+usuario.getDsprimerapellido()+"', "
				+ "DSSEGUNDOAPELLIDO='"+usuario.getDssegundoapellido()+"', NMAUTORIZADO='"+usuario.getNmautorizado()+"', DSCORREO='"+usuario.getDscorreo()+"',"
				+ " FEFECHANACIMIENTO='"+(java.sql.Date) usuario.getFefechanacimiento()+"', NMDOCUMENTO='"+usuario.getNmdocumento()+"', "
				+ "DSTELEFONO='"+usuario.getDstelefono()+"', DSDIRECCION='"+usuario.getDsdireccion()+"', DSSEXO='"+usuario.getDssexo()+"', "
			    + "DSOCUPACION='"+usuario.getDsocupacion()+"', FEREGISTRO='"+usuario.getFeregistro()+"', TIPO_USUARIO_idTIPO_USUARIO='"+usuario.getTbTipoUsuario().getIdTipoUsuario()+"', "
			    + "DSESTADOCIVIL='"+usuario.getDsestadocivil()+"', DEESPECIALIDAD='"+usuario.getDeespecialidad()+"',"
			    + " NMEDAD='"+usuario.getNmedad()+"', NMCELULAR='"+usuario.getNmcelular()+"' WHERE idTB_USUARIO='"+usuario.getIdTbUsuario()+"'";
		
		try{

			conexion = new Conexion();
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);;
			pst.executeUpdate();			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar el Cliente", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
		}
		JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
		return usuario;
	}
	public TbUsuario eliminarUsuario(TbUsuario usuario) throws SQLException{
	
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_usuario  WHERE idTB_USUARIO='"+usuario.getIdTbUsuario()+"'";
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
		JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar", 1);
		return usuario;
	}
	public TbUsuario guardarInstructor(TbUsuario usuario) throws SQLException{
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_usuario (DSNOMBRE, DSPRIMERAPELLIDO, DSSEGUNDOAPELLIDO, NMAUTORIZADO, DSCORREO, FEFECHANACIMIENTO, NMDOCUMENTO, DSCONTRASENA, DSTELEFONO, DSDIRECCION, DSSEXO, DSOCUPACION, FEREGISTRO, TIPO_USUARIO_idTIPO_USUARIO, DSESTADOCIVIL, DEESPECIALIDAD, NMEDAD, NMCELULAR) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);
			pst.setString(1, usuario.getDsnombre());
			pst.setString(2, usuario.getDsprimerapellido());
			pst.setString(3, usuario.getDssegundoapellido());
			pst.setInt(4, usuario.getNmautorizado());
			pst.setString(5, usuario.getDscorreo());
			pst.setDate(6, (java.sql.Date) usuario.getFefechanacimiento());
			pst.setInt(7, usuario.getNmdocumento());
			pst.setString(8, usuario.getDscontrasena());
			pst.setString(9, usuario.getDstelefono());
			pst.setString(10, usuario.getDsdireccion());
			pst.setString(11, usuario.getDssexo());
			pst.setString(12, usuario.getDsocupacion());
			pst.setString(13,usuario.getFeregistro());
			pst.setInt(14, usuario.getTbTipoUsuario().getIdTipoUsuario());
			pst.setString(15, usuario.getDsestadocivil());
			pst.setString(16, usuario.getDeespecialidad());
			pst.setInt(17, usuario.getNmedad());
			pst.setInt(18, usuario.getNmcelular());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar el Instructor", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
		}
		return usuario;
	}
	public TbUsuario modificarInstructor(TbUsuario usuario) throws SQLException{
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		String sql = "UPDATE tb_usuario SET DSNOMBRE='"+usuario.getDsnombre()+"', DSPRIMERAPELLIDO='"+usuario.getDsprimerapellido()+"', "
				+ "DSSEGUNDOAPELLIDO='"+usuario.getDssegundoapellido()+"', NMAUTORIZADO='"+usuario.getNmautorizado()+"', DSCORREO='"+usuario.getDscorreo()+"',"
				+ " FEFECHANACIMIENTO='"+(java.sql.Date) usuario.getFefechanacimiento()+"', NMDOCUMENTO='"+usuario.getNmdocumento()+"', DSCONTRASENA='"+usuario.getDscontrasena()+"', "
				+ "DSTELEFONO='"+usuario.getDstelefono()+"', DSDIRECCION='"+usuario.getDsdireccion()+"', DSSEXO='"+usuario.getDssexo()+"', "
			    + "DSOCUPACION='"+usuario.getDsocupacion()+"', FEREGISTRO='"+usuario.getFeregistro()+"', TIPO_USUARIO_idTIPO_USUARIO='"+usuario.getTbTipoUsuario().getIdTipoUsuario()+"', "
			    + "DSESTADOCIVIL='"+usuario.getDsestadocivil()+"', DEESPECIALIDAD='"+usuario.getDeespecialidad()+"',"
			    + " NMEDAD='"+usuario.getNmedad()+"', NMCELULAR='"+usuario.getNmcelular()+"' WHERE idTB_USUARIO='"+usuario.getIdTbUsuario()+"'";
		
		try{

			conexion = new Conexion();
			pst = (PreparedStatement) conexion.getConnection().prepareStatement(sql);;
			pst.executeUpdate();			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo modificar el Instructor", "Modificar", 0);
			e.printStackTrace();
		}finally{
			conexion.desconectar();
			pst.close();
		}
		JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
		return usuario;
	}
	public TbUsuario eliminarInstructor(TbUsuario usuario) throws SQLException{
	
		TbUsuario Usuario=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_usuario  WHERE idTB_USUARIO='"+usuario.getIdTbUsuario()+"'";
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
		JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar", 1);
		return usuario;
	}
}
