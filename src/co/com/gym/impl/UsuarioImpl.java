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
	
	public void guardarUsuario(TbUsuario usuario){
		usuarioDao.guardarUsuario(usuario);
	}	
}
