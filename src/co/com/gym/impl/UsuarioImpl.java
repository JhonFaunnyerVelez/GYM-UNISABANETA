package co.com.gym.impl;

import java.sql.*;

import co.com.gym.dao.UsuarioDao;
import co.com.gym.model.Usuario;


public class UsuarioImpl {
	
	UsuarioDao usuarioDao = new UsuarioDao();

	public Usuario obtenerUsuario(Usuario usu) throws SQLException{
		Usuario Usuario = usuarioDao.obtenerUsuario(usu);
		return Usuario;
	}
	
	
	/**
	 * Metodo que guarda la informacion de un usuario
	 * @param usu
	 * @return
	 */
	
	public void guardarUsuario(Usuario usuario){
		usuarioDao.guardarUsuario(usuario);
	}
		
}
