package cn.com.tarena.user.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.user;
import cn.com.tarena.service.userService;
import cn.com.tarena.service.impl.userServiceImpl;
import cn.com.tarena.util.ServiceFactory;


public class ControllerServlet extends HttpServlet{
	public static String str="0";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		String suffix = "." + path.split("\\.")[1];
		
		getServletContext().setAttribute("suffix", suffix);
		
		path = path.split("\\.")[0];
		
		if("/touserManage".equals(path))
		{
			System.out.println(path+"haha");
			try{
				userService useService = new userServiceImpl();				
				List userList = useService.getuserList();				
				req.setAttribute("userList11", userList);				
				getServletContext().getRequestDispatcher("/userManage").forward(req, resp);
			} catch (Exception e){
				req.setAttribute("message", e.getMessage());			
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}			
		}
		else if("/toLogin".equals(path))
		{
			getServletContext().getRequestDispatcher("/login").forward(req, resp);
			req.getSession().removeAttribute("message");
		}
		else if("/doLogin".equals(path))
		{
			String userName = req.getParameter("userid");
			
			String password = req.getParameter("passwords");
			
			user paramuser = new user();
			
			paramuser.setUserid(userName);
			paramuser.setPassword(password);
			
			req.getSession().setAttribute("paramStudent", paramuser);
			
			userService user1Service = ServiceFactory.getuserService();
			
			user user1 = user1Service.getuserByUserNameAndPassword(paramuser);
			
			if(user1 != null){
				req.getSession().setAttribute("IS_LOGIN", "1");
				
				req.setAttribute("user", user1);
				
				getServletContext().getRequestDispatcher("/welcome").forward(req, resp);
			}else{
				req.getSession().setAttribute("message", "The user was not found!");
				
//				getServletContext().getRequestDispatcher("/login").forward(req, resp);
				resp.sendRedirect(getServletContext().getContextPath() + "/toLogin" + suffix);
			}
			
		}
		else{
			resp.sendError(resp.SC_NOT_FOUND);
		}
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
	

