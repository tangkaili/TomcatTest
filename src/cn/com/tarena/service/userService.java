package cn.com.tarena.service;

import java.util.List;

import cn.com.tarena.pojo.user;

public interface userService {

	public List getuserList();
	public user getuserByUserNameAndPassword(user paramuser);
}
