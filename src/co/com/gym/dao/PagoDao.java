package co.com.gym.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import co.com.gym.model.TbEstadoPago;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;

public class PagoDao {
	public TbEstadoPago guardarPago(TbEstadoPago pago) throws SQLException{
		TbEstadoPago Pago=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		
		try{

			conexion = new Conexion();
			String sql = "INSERT INTO tb_estado_pago (DSTIPOPAGO, NMACTIVO, TB_TIPO_CONTRATO_idTB_TIPO_CONTRATO, TB_USUARIO_idTB_USUARIO) VALUES (?,?,?,?)";
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.setString(1, pago.getDstipopago());
			pst.setInt(2, pago.getNmactivo());
			pst.setInt(3, pago.getTbTipoContrato().getIdTbTipoContrato());
			pst.setInt(4, pago.getTbUsuario().getIdTbUsuario());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", 1);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Guardar el Pago", "Guardar", 0);
			e.printStackTrace();
		}finally{
			conexion.Conexion().close();
			pst.close();
		}
		return pago;
	}
	public TbEstadoPago modificarPago(TbEstadoPago pago) throws SQLException{
		TbEstadoPago Pago=null;
		Conexion conexion= null;
		PreparedStatement pst=null; 
		String sql = "UPDATE tb_estado_pago SET DSTIPOPAGO='"+pago.getDstipopago()+"', NMACTIVO='"+pago.getNmactivo()+"', TB_TIPO_CONTRATO_idTB_TIPO_CONTRATO='"+pago.getTbTipoContrato().getIdTbTipoContrato()+"', TB_USUARIO_idTB_USUARIO='"+pago.getTbUsuario().getIdTbUsuario()+"' WHERE idTB_ESTADO_PAGO='"+pago.getIdTbEstadoPago()+"'";
		
		try{

			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);;
			pst.executeUpdate();			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo Modificar el Pago", "Modificar", 0);
			e.printStackTrace();
		}finally{
			conexion.Conexion().close();
			pst.close();
		}
		JOptionPane.showMessageDialog(null, "Registro Modificado", "Modificar", 1);
		return pago;
	}
	public TbEstadoPago eliminarPago(TbEstadoPago pago) throws SQLException{
	
		TbEstadoPago Pago=null;
		Conexion conexion= null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM tb_estado_pago  WHERE idTB_ESTADO_PAGO='"+pago.getIdTbEstadoPago()+"'";
		try {
			conexion = new Conexion();
			pst = (PreparedStatement) conexion.Conexion().prepareStatement(sql);
			pst.executeUpdate();

			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo Eliminar El registro", "Eliminar", 0);
			e1.printStackTrace();
		} 
		finally{
			conexion.Conexion();
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar", 1);
		return pago;
	}

}
