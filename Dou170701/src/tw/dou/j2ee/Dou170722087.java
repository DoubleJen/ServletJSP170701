package tw.dou.j2ee;
//servletContext.setAttribute.
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dou170722087")
public class Dou170722087 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("key1", "value1");
		servletContext.setAttribute("key2", "value2");
		
	
	}


}
