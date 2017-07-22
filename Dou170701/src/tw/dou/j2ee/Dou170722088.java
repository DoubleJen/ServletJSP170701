package tw.dou.j2ee;
//
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170722088")
public class Dou170722088 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		//087 => 088
		if(servletContext.getAttribute("key1") != null) {
			servletContext.removeAttribute("key1");
		}		
		System.out.println(servletContext.getAttribute("key1"));
		
//		//Server001=>088
//		System.out.println(servletContext.getAttribute("key3"));
	}


}
