package tw.dou.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.brad.bean.Member170715;

@WebServlet("/Main170715")
public class Main170715 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if( session.getAttribute("member") == null) {
			response.sendRedirect("Login170715");
			System.out.println("No session");
		}else {
			System.out.println("Yes session");
		System.out.println(((Member170715)session.getAttribute("member")).getRealname());
		//View
		request.getRequestDispatcher("main170715.jsp").forward(request, response);
		}
		
		
	}


}
