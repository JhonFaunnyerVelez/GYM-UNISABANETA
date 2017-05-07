package co.com.gym.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.com.gym.model.TbServicio;
import co.com.gym.util.HibernateUtil;

public class ServicioDao {

	public  TbServicio guardarServicio(TbServicio serv) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.save(serv);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return serv;
		}

	public TbServicio modificarServicio(TbServicio serv) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.update(serv);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return serv;
	}

	public TbServicio eliminarServicio(TbServicio serv) throws SQLException{
		
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;

		
		try{
			
			tr = sesion.beginTransaction();
			sesion.delete(serv);
				tr.commit();
			}catch(Exception e){
				if(tr != null){
					tr.rollback();
				}
				e.printStackTrace();
			}finally{
				sesion.close();	
			}
		return serv;
	}
	
}
