package tw.dou.j2ee;
//取得Session
//031建立=>032讀取<=033摧毀

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dou170708032")
public class Dou170708032 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			out.println("No Session");
			return;
		}
		
		Member170708 member = (Member170708)session.getAttribute("who");//此處可能有多重例外產生, 最好try catch
		out.print(member.getName() + ":" + member.getAge());
		
		
		
	}


}
