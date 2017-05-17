package co.com.gym.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.com.gym.model.TbTipoContrato;
import co.com.gym.util.HibernateUtil;

public class TipoContratoDao {

public  TbTipoContrato guardarTpcon(TbTipoContrato tpcon) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.save(tpcon);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return tpcon;
		}

	public TbTipoContrato modificarTpcon(TbTipoContrato tpcon) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.update(tpcon);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return tpcon;
	}

	public TbTipoContrato eliminarTpcon(TbTipoContrato tpcon) throws SQLException{
		
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.delete(tpcon);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return tpcon;
	}
	
}