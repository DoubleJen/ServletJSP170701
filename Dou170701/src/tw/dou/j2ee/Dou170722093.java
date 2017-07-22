package tw.dou.j2ee;
//092登入=>093登出
//
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dou170722093")
public class Dou170722093 extends HttpServlet {
	private ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		context = getServletContext();
		try {
			Connection conn1 = (Connection)context.getAttribute("conn");
			Statement stmt = conn1.createStatement();
			
			HttpSession session = request.getSession(false);
			if(session != null) {
				String dbid = (String)session.getAttribute("dbid");
				stmt.executeUpdate("update member set islogin=0 where id="+ dbid);
				session.invalidate();
			}
			
			
			
			
			System.out.println("insert OK!!!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


}
