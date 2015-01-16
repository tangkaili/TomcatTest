package cn.com.tarena.dao;

import java.util.List;

import cn.com.tarena.pojo.user;

public interface userDao {
	
	public List getuserList();
	
	public user getuser(user paramuser);
}
