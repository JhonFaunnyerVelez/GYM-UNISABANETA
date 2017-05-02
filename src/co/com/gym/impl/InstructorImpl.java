package co.com.gym.impl;

import java.sql.SQLException;

import co.com.gym.dao.InstructorDao;
import co.com.gym.model.TbInstructor;


public class InstructorImpl {

	InstructorDao instructotDao = new InstructorDao();

	public TbInstructor guardarInstructor(TbInstructor intr) throws SQLException{
		TbInstructor Instructor = instructotDao.guardarInstructor(intr);
		return Instructor;
	}
	public TbInstructor modificarInstructor(TbInstructor intr) throws SQLException{
		TbInstructor Instructor = instructotDao.modificarInstructor(intr);
		return Instructor;
	}
	public TbInstructor eliminarInstructor(TbInstructor intr) throws SQLException{
		TbInstructor Instructor = instructotDao.eliminarInstructor(intr);
		return Instructor;
	}
	
}
