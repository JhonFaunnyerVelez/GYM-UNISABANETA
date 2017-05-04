package co.com.gym.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.com.gym.control.LaminaInstructor;
import co.com.gym.control.VentanaMenu;
import co.com.gym.model.TbInstructor;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;

public class InstructorDao {

public  TbInstructor guardarInstructor(TbInstructor intr) throws SQLException{
		
	Session sesion =  HibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;

	
	try{
		
		tr = sesion.beginTransaction();
		sesion.save(intr);
			tr.commit();
		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
	return intr;
	}

public TbInstructor modificarInstructor(TbInstructor intr) throws SQLException{
	
	Session sesion =  HibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;

	
	try{
		
		tr = sesion.beginTransaction();
		sesion.update(intr);
			tr.commit();
		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
	return intr;
}

public TbInstructor eliminarInstructor(TbInstructor intr) throws SQLException{
	
	
	Session sesion =  HibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;

	
	try{
		
		tr = sesion.beginTransaction();
		sesion.delete(intr);
			tr.commit();
		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
	return intr;
}
}
