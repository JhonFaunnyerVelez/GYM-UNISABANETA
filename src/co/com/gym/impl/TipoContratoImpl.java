package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.TipoContratoDao;
import co.com.gym.model.TbTipoContrato;

public class TipoContratoImpl {

	TipoContratoDao tipocontratoDao = new TipoContratoDao();

	public TbTipoContrato guardartpcon(TbTipoContrato tbtpcon) throws SQLException{
		TbTipoContrato tpcontrato = tipocontratoDao.guardarTpcon(tbtpcon);
		return tpcontrato;
	}
	public TbTipoContrato modificartpcon(TbTipoContrato tbtpcon) throws SQLException{
		TbTipoContrato tpcontrato = tipocontratoDao.modificarTpcon(tbtpcon);
		return tpcontrato;
	}
	public TbTipoContrato eliminartpcon(TbTipoContrato tbtpcon) throws SQLException{
		TbTipoContrato tpcontrato = tipocontratoDao.eliminarTpcon(tbtpcon);
		return tpcontrato;
	}
	
}
