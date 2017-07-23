package tw.dou.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170723108")
public class Dou170723108 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String mesg = request.getParameter("mesg");
//		StringBuffer sb = new StringBuffer();
//		sb.append(mesg);
//		String sbs = sb.toString();
		
		//更新資料庫訊息
		try {
		Connection conn = (Connection)getServletContext().getAttribute("conn");
		if(conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into message(mesg) values('"+ mesg +"')");
		}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		//發送
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		
		synchronized (asyncs) {
			for(AsyncContext async: asyncs) {
				System.out.println("send");
				
				HttpServletResponse resp = (HttpServletResponse)async.getResponse();
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
//				for(int i=0; i<4; i++) {
//					out.println(sbs +"<br>");
//					async.complete();
//				}
				out.println(mesg);
				async.complete();
			}
			asyncs.clear();
		};
		
		response.sendRedirect("Dou170723107.html");
				
	}
	


}
