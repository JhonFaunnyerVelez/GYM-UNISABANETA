package co.com.gym.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbServicio;
import co.com.gym.model.TbTipoContrato;
import co.com.gym.util.Conexion;
import co.com.gym.util.HibernateUtil;

public class TipoContratoDao {

public  TbTipoContrato guardarTpcon(TbTipoContrato tpcon) throws SQLException{
		
	TbTipoContrato contrato=null;
	Conexion conexion= null;
	PreparedStatement pst=null; 
	
	try{

		conexion = new Conexion();
		String sql = "INSERT INTO tb_tipo_contrato (DSDESCRIPCION, NMPRECIO, FEREGISTRO) VALUES (?,?,?)";
		pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
		
		pst.setString(1, tpcon.getDsdescripcion());
		pst.setInt(2, tpcon.getNmprecio());
		pst.setDate(3, (java.sql.Date) tpcon.getFeregistro());
		pst.executeUpdate();

		
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "No se pudo Guardar el Tipo de Contrato", "Guardar", 0);
		e.printStackTrace();
	}finally{
		conexion.Conexion().close();
		pst.close();

	}
	JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
	return tpcon;
		}

	public TbTipoContrato modificarTpcon(TbTipoContrato tpcon) throws SQLException{
		
		TbTipoContrato contrato=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "UPDATE tb_tipo_contrato SET DSDESCRIPCION='"+tpcon.getDsdescripcion()+"', NMPRECIO='"+tpcon.getNmprecio()+"', FEREGISTRO='"+tpcon.getFeregistro()+"' WHERE idTB_TIPO_CONTRATO='"+tpcon.getIdTbTipoContrato()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.executeUpdate();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Modificar El registro", "Modificar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.Conexion().close();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro Modificado", "Modificar", 1);

		return tpcon;	
	}

	public TbTipoContrato eliminarTpcon(TbTipoContrato tpcon) throws SQLException{
		
		
		TbTipoContrato contrato=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_tipo_contrato WHERE idTB_TIPO_CONTRATO='"+tpcon.getIdTbTipoContrato()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.executeUpdate();

			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Eliminar El registro", "Eliminar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.Conexion().close();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar", 1);
		return tpcon;
	}
	
}
