package cn.com.tarena.user.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.user;

public class WelcomeServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		user user1 = (user)req.getAttribute("userList11");
		
		String userName = "";
		
		if(user1 != null){
			userName = user1.getUserid();
		}
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h2 align=\"center\">Welcome</h2>");
		out.println("	<hr>");
		out.println("Welcome back," + userName + "!<br>");
		out.println("<a href=\"toStudentList" + getServletContext().getAttribute("suffix") + "\">toStudentList</a>");
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