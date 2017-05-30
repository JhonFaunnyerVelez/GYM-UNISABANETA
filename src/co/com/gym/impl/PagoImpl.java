package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.PagoDao;
import co.com.gym.model.TbEstadoPago;
import co.com.gym.model.TbServicio;

public class PagoImpl {
	
	PagoDao pagoDao = new PagoDao();

	public TbEstadoPago guardarPago(TbEstadoPago pag) throws SQLException{
		TbEstadoPago pago = pagoDao.guardarPago(pag);
		return pago;
	}
	public TbEstadoPago modificarPago(TbEstadoPago pag) throws SQLException{
		TbEstadoPago pago = pagoDao.modificarPago(pag);
		return pago;
	}
	public TbEstadoPago eliminarPago(TbEstadoPago pag) throws SQLException{
		TbEstadoPago pago = pagoDao.eliminarPago(pag);
		return pago;
	}
}
