package tw.dou.j2ee;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170722089")
public class Dou170722089 extends HttpServlet {
	private ServletContext servletContext;
	private Connection conn1, conn2;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		servletContext = getServletContext();
		try {
			conn1 = (Connection)servletContext.getAttribute("conn");
			Statement stmt = conn1.createStatement();
			stmt.executeUpdate("insert into member(account, passwd, realname) values('AA1','BB1','CC1')");
			System.out.println("insert OK!!!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//////////////////////////////////////////////////////
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK2");
			
			Connection conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/double", "root", "root");
			System.out.println("Connection OK2");
		} catch (Exception ee) {
			System.out.println(ee.toString());
		}
		
		System.out.println((conn1 == conn2));
	}


}
