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
	
		
		/*conexion = new Conexion();
		String sql = "INSERT INTO tb_instructor (DSNOMBRE,DSPRIMERAPELLIDO,DSSEGUNDOAPELLIDO,NMTELEFONO,DSDIRECCION,NMDOCUMENTO,DSCORREO,FEFECHANACIMIENTO, FEREGISTRO) VALUES (?,?,?,?,?,?,?,?,?)";
		pst = conexion.getConnection().prepareStatement(sql);
		
		pst.setString(1, intr.getDsnombre());
		pst.setString(2, intr.getDsprimerapellido());
		pst.setString(3, intr.getDssegundoapellido());
		pst.setInt(4, intr.getNmtelefono());
		pst.setString(5, intr.getDsdireccion());
		pst.setInt(6, intr.getNmdocumento());
		pst.setString(7, intr.getDscorreo());
		pst.setDate(8, (Date) intr.getFefechanacimiento());
		pst.setDate(9, (Date) intr.getFeregistro());
		pst.executeUpdate();

		
	}catch(Exception e){
		LaminaInstructor lamn = new LaminaInstructor();
		JOptionPane.showMessageDialog(lamn, "No se Logro Almacenar El Instructor");
		e.printStackTrace();
	}finally{
		conexion.desconectar();
		pst.close();

	}*/

	}

public TbInstructor modificarInstructor(TbInstructor intr) throws SQLException{
	
	TbInstructor Instructor=null;
	Conexion conexion= null;
	PreparedStatement pst = null;
	String sql = "UPDATE gym_unisabaneta.tb_instructor SET "
			+ "DSNOMBRE='"+intr.getDsnombre()+"', DSPRIMERAPELLIDO='"+intr.getDsprimerapellido()+"'"
			+ ", DSSEGUNDOAPELLIDO='"+intr.getDssegundoapellido()+"',NMTELEFONO='"+intr.getNmtelefono()+"'"
			+ ", DSDIRECCION='"+intr.getDsdireccion()+"', NMDOCUMENTO='"+intr.getNmdocumento() +"'"
			+ ", DSCORREO='"+intr.getDscorreo()+"', FEFECHANACIMIENTO='"+intr.getFefechanacimiento()+"'"
			+ ", FEREGISTRO='"+intr.getFeregistro()+"' WHERE idTB_INSTRUCTOR='"+intr.getIdTbInstructor()+"'";
	try {
		conexion = new Conexion();
		pst = conexion.getConnection().prepareStatement(sql);
		pst.executeUpdate();
		
	} catch (SQLException e1) {
		LaminaInstructor lamn = new LaminaInstructor();
		JOptionPane.showMessageDialog(lamn, "No se pudo Modificar El registro", "Modificar", 0);
		e1.printStackTrace();
	} 
	finally{
		conexion.desconectar();
		try {
			pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return Instructor;	

}

public TbInstructor eliminarInstructor(TbInstructor intr) throws SQLException{
	
	TbInstructor Instructor=null;
	Conexion conexion= null;
	PreparedStatement pst = null;
	LaminaInstructor lamn = new LaminaInstructor();
	String sql = "DELETE FROM gym_unisabaneta.tb_instructor WHERE idTB_INSTRUCTOR='"+intr.getIdTbInstructor()+"'";
	try {
		conexion = new Conexion();
		pst = conexion.getConnection().prepareStatement(sql);
		pst.executeUpdate();
		

		
	} catch (SQLException e1) {
		JOptionPane.showMessageDialog(lamn, "No se pudo Eliminar El registro", "Eliminar", 0);
		e1.printStackTrace();
	} 
	finally{
		conexion.desconectar();
		try {
			pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	return Instructor;	

}

}
