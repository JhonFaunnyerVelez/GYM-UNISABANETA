package co.com.gym.impl;

import java.sql.*;

import co.com.gym.dao.UsuarioDao;
import co.com.gym.model.TbUsuario;


public class UsuarioImpl {
	
	UsuarioDao usuarioDao = new UsuarioDao();

	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		TbUsuario Usuario = usuarioDao.obtenerUsuario(usu);
		return Usuario;
	}
	
	public void guardarUsuario(TbUsuario usuario){
		usuarioDao.guardarUsuario(usuario);
	}	
}
