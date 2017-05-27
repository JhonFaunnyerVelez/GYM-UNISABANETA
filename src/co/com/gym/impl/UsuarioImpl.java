package co.com.gym.impl;

import java.sql.*;

import co.com.gym.dao.UsuarioDao;
import co.com.gym.model.TbUsuario;


public class UsuarioImpl {
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	String TIPO_USUARIO_ADMINISTRADOR = "Administrador";

	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		TbUsuario Usuario = usuarioDao.obtenerUsuario(usu);
//		if(Usuario.getTbTipoUsuario().getDsdescripcion().equalsIgnoreCase(TIPO_USUARIO_ADMINISTRADOR)){
//			
//		}
		return Usuario;
	}
	
	public void guardarUsuario(TbUsuario usuario) throws SQLException{
		usuarioDao.guardarUsuario(usuario);
	}
	public void modificarUsuario(TbUsuario usuario) throws SQLException{
		usuarioDao.modificarUsuario(usuario);
	}
	public void eliminarUsuario(TbUsuario usuario) throws SQLException{
		usuarioDao.eliminarUsuario(usuario);
	}
	public void guardarInstructor(TbUsuario usuario) throws SQLException{
		usuarioDao.guardarInstructor(usuario);
	}
	public void modificarInstructor(TbUsuario usuario) throws SQLException{
		usuarioDao.modificarInstructor(usuario);
	}
	public void eliminarInstructor(TbUsuario usuario) throws SQLException{
		usuarioDao.eliminarInstructor(usuario);
	}
}
