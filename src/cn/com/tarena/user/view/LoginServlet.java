package cn.com.tarena.user.view;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.user;

public class LoginServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = "";
		
		user paramStudent = (user)req.getSession().getAttribute("paramuser");
		
		if(paramStudent != null){
			userName = paramStudent.getUserid();
		}
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Login</h2>");
		out.println("	<hr>");

		if(req.getSession().getAttribute("message") != null){
			out.println("	" + req.getSession().getAttribute("message") + "");
		}
		out.println("	<form action=\"doLogin.action\" method=\"post\">");
		out.println("		Username:<input name=\"userName\" type=\"text\" value=\"" + userName + "\"><br>");
		out.println("		Password:<input name=\"password\" type=\"password\"><br>");
		out.println("		<input type=\"submit\" value=\"login\">");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}

