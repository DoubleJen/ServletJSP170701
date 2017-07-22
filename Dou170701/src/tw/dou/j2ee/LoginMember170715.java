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

@WebServlet("/LoginMember170715")
public class LoginMember170715 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//1. Prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		//2. Model
		try {
			Member170715 member = new Member170715();
			member.setAccount(account);
			member.setPasswd(passwd);
			
			if(member.isValidMember()) {
				//Login Success
//				out.print("OK");
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("Main170715");
				
				
			}else {
				//Login Failure
				out.print("XX");
				//response.sendRedirect("Login170715");
			}
		
		}catch(Exception e) {
			out.print("EE");
		}
		
	}


}
