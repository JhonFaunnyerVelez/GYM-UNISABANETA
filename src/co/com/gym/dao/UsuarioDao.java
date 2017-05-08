package co.com.gym.dao;

import java.sql.SQLException;
import javax.swing.JButton;
import org.hibernate.*;

import co.com.gym.control.VentanaMenu;
import co.com.gym.model.TbUsuario;

import co.com.gym.util.HibernateUtil;


public class UsuarioDao {


	private int Autorizado =0;
	
	public TbUsuario obtenerUsuario(TbUsuario usu) throws SQLException{
		
		Session sesion =  HibernateUtil.getSessionFactory().openSession();
		Transaction tr = null;
		TbUsuario tbUsuario = null;
		
		try{
			
			tr = sesion.beginTransaction();
			
			tbUsuario = (TbUsuario) sesion.createQuery("SELECT u FROM TbUsuario u where nmdocumento = " + usu.getNmdocumento() + " and dscontrasena = " + usu.getDscontrasena()).uniqueResult();
			tr.commit();
			Autorizado = tbUsuario.getNmautorizado();
			System.out.println(Autorizado);
			VentanaMenu menu = new VentanaMenu();
		    JButton instructor = new JButton(); 
		    JButton cliente = new JButton(); 
		    JButton rutina = new JButton();
		    JButton contrato = new JButton();
		    if (Autorizado==1){
			menu.setVisible(true);
		    }else {
		    	menu.setVisible(true); 
		    	instructor=menu.getBtnInstructor();
		    	instructor.setEnabled(false);
		    	menu.setBtnInstructor(instructor);
		    	cliente=menu.getBtnCliente();
		    	cliente.setEnabled(false);
		    	menu.setBtnCliente(cliente);
		    	rutina=menu.getBtnRutina();
		    	rutina.doClick();
		    	menu.setBtnRutina(rutina);
		    	contrato = menu.getBtnTpContrato();
		    	contrato.setEnabled(false);
		    	menu.setBtnTpContrato(contrato);
		    }

		}catch(Exception e){
			if(tr != null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			sesion.close();	
		}
		return tbUsuario;		

	}
	
	public void guardarUsuario(TbUsuario usuario){
		
		
	}
	}
