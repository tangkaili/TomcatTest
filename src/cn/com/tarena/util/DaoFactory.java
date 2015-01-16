package cn.com.tarena.util;

import cn.com.tarena.dao.userDao;
import cn.com.tarena.dao.impl.userDaoImpl;

public class DaoFactory {
	private static userDao userDao = new userDaoImpl(); 
	
	public static userDao getStudentDao(){
		return userDao;
	}
}
