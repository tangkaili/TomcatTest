package cn.com.tarena.util;

import cn.com.tarena.service.userService;
import cn.com.tarena.service.impl.userServiceImpl;

public class ServiceFactory {
	private static userService useService = new userServiceImpl(); 
	
	public static userService getuserService(){
		return useService;
	}
}
