package cn.com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.tarena.dao.userDao;
import cn.com.tarena.pojo.user;
//import cn.com.tarena.util.ConnectionFactory;
import cn.com.tarena.util.ConnectionFactory;

public class userDaoImpl implements userDao {	
	@Override
	public List getuserList() {
		List userList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				user user1 = new user();
				user1.setUserid(rs.getString("userid"));
				user1.setPassword(rs.getString("passwords"));				
				userList.add(user1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users ", e);
			}
		}
		return userList;
	}
	@Override
	public user getuser(user paramuser) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users where userid ='"
					+ paramuser.getUserid() + "' and passwords = '"
					+ paramuser.getPassword() + "'");
			if (rs.next()) {
				user user1 = new user();
				user1.setUserid(rs.getString("userid"));
				user1.setPassword(rs.getString("passwords"));			
				return user1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying users ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("error when querying users ", e);
			}
		}	
		return null;
	}
}
