package co.com.gym.util;

import java.sql.*;

public class Conexion {

	static String bd = "gym_unisabaneta?verifyServerCertificate=false&useSSL=true";
	   static String login = "b0431bfa507395";
	   static String password = "799363b9";
	   static String url = "jdbc:mysql://br-cdbr-azure-south-b.cloudapp.net:3306/"+bd;
	 
	   Connection conn = null;
	 
	   /** Constructor de DbConnection */
	   public Conexion() {
	      try{
	         //obtenemos el driver de para mysql
	         Class.forName("com.mysql.jdbc.Driver");
	         //obtenemos la conexi�n
	         conn = DriverManager.getConnection(url,login,password);
	 
	         if (conn!=null){
	            //System.out.println("Conecci�n a base de datos "+bd+" OK");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }
	   /**Permite retornar la conexi�n*/
	   public Connection getConnection(){
	      return conn;
	   }
	 
	   public void desconectar(){
		      conn=null;
	}
}
	

