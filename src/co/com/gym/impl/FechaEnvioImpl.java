package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.FechaEnvioDao;
import co.com.gym.model.TbFechaEnvio;

public class FechaEnvioImpl {

FechaEnvioDao fechaDao = new FechaEnvioDao();
	
	public void guardarFecha(TbFechaEnvio fecha) throws SQLException{
		fechaDao.guardarFecha(fecha);
	}
}
