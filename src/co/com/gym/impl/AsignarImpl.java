package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.AsignarDao;
import co.com.gym.dao.ServicioDao;
import co.com.gym.model.TbRutinasXTbServicio;
import co.com.gym.model.TbServicio;

public class AsignarImpl {

	AsignarDao asignarDao = new AsignarDao();

	public TbRutinasXTbServicio guardarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		TbRutinasXTbServicio asignar = asignarDao.guardarAsignar(asig);
		return asignar;
	}
	public TbRutinasXTbServicio modificarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		TbRutinasXTbServicio asignar = asignarDao.modificarAsignar(asig);
		return asignar;
	}
	public TbRutinasXTbServicio eliminarAsignar(TbRutinasXTbServicio asig) throws SQLException{
		TbRutinasXTbServicio asignar = asignarDao.eliminarAsignar(asig);
		return asignar;
	}
	
}
