package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.RutinaDao;
import co.com.gym.dao.ServicioDao;
import co.com.gym.model.TbRutinas;
import co.com.gym.model.TbServicio;

public class RutinaImpl {

	RutinaDao rutinaDao = new RutinaDao();

	public TbRutinas guardarRutina(TbRutinas rut) throws SQLException{
		TbRutinas rutina = rutinaDao.guardarRutina(rut);
		return rutina;
	}
	public TbRutinas modificarRutina(TbRutinas rut) throws SQLException{
		TbRutinas rutina = rutinaDao.modificarRutina(rut);
		return rutina;
	}
	public TbRutinas eliminarRutina(TbRutinas rut) throws SQLException{
		TbRutinas rutina = rutinaDao.eliminarRutina(rut);
		return rutina;
	}

	
}
