package tw.dou.j2ee;
//摧毀session
//031建立=>032讀取<=033摧毀

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dou170708033")
public class Dou170708033 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			out.println("No Session");
			return;
		}else {
			session.invalidate();
		}
	}


}
