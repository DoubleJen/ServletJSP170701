package tw.dou.j2ee;
//建立Session
//Session 永遠存在, 除非摧毀它
//031建立=>032讀取<=033摧毀

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dou170708031")
public class Dou170708031 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();//如果沒有存在Session, 就Create a new one!
		//HttpSession session = request.getSession(true);//Same as HttpSession session = request.getSession();
		//HttpSession session = request.getSession(false);//如果沒有session session=null=>redirect出去
		
		Member170708 member = new Member170708("brad", 51);
		session.setAttribute("who", member);
	}


}
