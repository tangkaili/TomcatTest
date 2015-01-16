package cn.com.tarena.service.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.tarena.pojo.user;
import cn.com.tarena.service.userService;
import cn.com.tarena.util.DaoFactory;
public class userServiceImpl implements userService{		
	@Override
	public List getuserList() {
		return DaoFactory.getStudentDao().getuserList();
	}

	@Override
	public user getuserByUserNameAndPassword(user paramuser) {
		return DaoFactory.getStudentDao().getuser(paramuser);
	}
}
