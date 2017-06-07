package co.com.gym.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import com.mysql.jdbc.PreparedStatement;

import co.com.gym.dao.FechaEnvioDao;
import co.com.gym.impl.FechaEnvioImpl;
import co.com.gym.model.TbFechaEnvio;
import co.com.gym.model.TbUsuario;
import co.com.gym.util.Conexion;

public class Cumpleaños extends JPanel{

	
	private DefaultTableModel modelo;
	private JTable tabla;
	private JButton btnVer;
	private JButton btnEnviar;
	
	
	public Cumpleaños(){
	
		
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cumpleaños", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setBounds(10, 20, 1240, 568);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 1220, 288);
		add(scrollPane);;
		

		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		scrollPane.setViewportView(tabla);
		
		modelo.addColumn("ID");
		modelo.addColumn("Fecha de Envio de Felicitaciones");

		
		
		btnVer = new JButton("Actualizar");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clear_Table1();
				LlenarTabla();
			}
		});
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(new Color(20, 130, 200));
		btnVer.setBounds(579, 537, 119, 20);
		add(btnVer);
		
		btnEnviar = new JButton("Enviar Felicitaciones");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					for (int k=0;k<Correos().size();k++){
						EnviarCorreo((String)Correos().get(k));
					}
					FechaEnvioImpl fechaimpl = new FechaEnvioImpl();
					TbFechaEnvio fecha = new TbFechaEnvio();
					fecha.setFefechaenvio(java.sql.Date.valueOf(DameFechaRegistro()));
					fechaimpl.guardarFecha(fecha);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Clear_Table1();
				LlenarTabla();
			}
		});
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(new Color(20, 130, 200));
		btnEnviar.setBounds(32, 65, 181, 44);
		add(btnEnviar);
	}

public boolean EnviarCorreo(String destinatario) throws MessagingException{
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.setProperty("mail.smtp.starttls.enable", "true");
	props.setProperty("mail.smtp.port", "587");
	props.setProperty("mail.smtp.user", "alex.cadavid@unisabaneta.edu.co");
	props.setProperty("mail.smtp.auth", "true");
	
	Session session = Session.getDefaultInstance(props, null);
	BodyPart texto = new MimeBodyPart();
	texto.setText("Feliz Cumpleaños");
	
	MimeMultipart multiParte = new MimeMultipart();
	multiParte.addBodyPart(texto);
	
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress("alex.cadavid@unisabaneta.edu.co"));
	message.addRecipient(Message.RecipientType.TO, 
			new InternetAddress(destinatario));
	message.setSubject("Feliz Cumpleaños");
	message.setContent(multiParte);
	
	Transport t = session.getTransport("smtp");
	t.connect("alex.cadavid@unisabaneta.edu.co","1035871258");
	t.sendMessage(message, message.getAllRecipients());
	t.close();
	return true;

			
}

public String DameFechaRegistro(){
	Calendar c2 = new GregorianCalendar();
	int dia = c2.get(Calendar.DATE);
    int mes = c2.get(Calendar.MONTH)+1;
    int annio = c2.get(Calendar.YEAR);
    String dRegistro="";
    if (mes<10 && dia<10){
    	dRegistro = ""+annio+""+"-"+"0"+mes+""+"-"+"0"+dia+"";
    }
    return dRegistro;
}
public void LlenarTabla(){
	
	Conexion conexion= null;
	Statement st = null; 
	ResultSet rs =null; 
	String sql="SELECT * FROM gym_unisabaneta.tb_fecha_envio;";
	try{
	    conexion = new Conexion();
	    st = conexion.Conexion().createStatement();
	    rs = st.executeQuery(sql);
	    while(rs.next()){
	        modelo.addRow(new Object[] {rs.getString(1),rs.getDate(2)});
	    }
	    
	}catch(Exception e){
	    System.out.println("error");
	    e.printStackTrace();
	}
	finally{
		try {
			conexion.Conexion().close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; 
	}
}
	public List Correos() throws SQLException{
		
		Conexion conexion2= null;
		Statement st1 = null; 
		ResultSet rs1 =null; 
		List<String> correos = new ArrayList<String>();
		String sql = "SELECT DSCORREO FROM tb_usuario WHERE MONTH(FEFECHANACIMIENTO) = 06 and TIPO_USUARIO_idTIPO_USUARIO=2";
		try{
		    conexion2 = new Conexion();
		    st1 = conexion2.Conexion().createStatement();
		    rs1 = st1.executeQuery(sql);

			while (rs1.next()){
				correos.add(rs1.getString(1));
			}
			rs1.close();	
			st1.close();
			conexion2.Conexion().close();
			
			
		}catch(Exception e){
			System.out.println("error en obtener usuario");
			e.printStackTrace();
		}
		return correos;	
	}
	private void Clear_Table1(){
	       for (int i = 0; i < tabla.getRowCount(); i++) {
	           modelo.removeRow(i);
	           i-=1;
	       }
	   }
}



	