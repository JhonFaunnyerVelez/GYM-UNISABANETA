package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.ServicioDao;
import co.com.gym.model.TbServicio;

public class ServicioImpl {
	
	ServicioDao servicioDao = new ServicioDao();

	public TbServicio guardarServicio(TbServicio serv) throws SQLException{
		TbServicio servicio = servicioDao.guardarServicio(serv);
		return servicio;
	}
	public TbServicio modificarServicio(TbServicio serv) throws SQLException{
		TbServicio servicio = servicioDao.modificarServicio(serv);
		return servicio;
	}
	public TbServicio eliminarServicio(TbServicio serv) throws SQLException{
		TbServicio servicio = servicioDao.eliminarServicio(serv);
		return servicio;
	}

}
