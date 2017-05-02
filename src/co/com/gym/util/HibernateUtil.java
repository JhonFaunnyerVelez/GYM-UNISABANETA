   package co.com.gym.util; 
   import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 
   
   public class HibernateUtil { 
	   
	   private static final SessionFactory sessionFactory = buildSessionFactory(); 
	   
	   private static SessionFactory buildSessionFactory() { 
		   
		   try { 
			   
			   return  new Configuration().configure().buildSessionFactory();
			   // Create the SessionFactory from hibernate.cfg.xml
		   
		   } catch (Throwable ex) { 
			   // Make sure you log the exception, as it might be swallowed 
			   System.err.println("Initial SessionFactory creation failed." + ex); 
			   throw new ExceptionInInitializerError(ex); 
		   }
	   } 
	   
	   public static SessionFactory getSessionFactory() { 
		   return sessionFactory; 
	   } 
	   
	   public static void shutdown(){
		   getSessionFactory().close();
	   }
	   
	   
   }	   
   
