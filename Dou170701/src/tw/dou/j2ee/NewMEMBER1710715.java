package tw.dou.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.bean.Member170715;


@WebServlet("/NewMEMBER1710715")
public class NewMEMBER1710715 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. Prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String realname = request.getParameter("realname");
		
		
		//2. Model
		try {
			Member170715 member = new Member170715();
			member.setAccount(account);
			member.setPasswd(passwd);
			member.setRealname(realname);
			boolean result =member.newInsert();
		
			//View
			request.setAttribute("result", result);
			request.getRequestDispatcher("result170715.jsp").forward(request, response);
					
		}catch(Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("error170715.jsp").forward(request, response);	
		}
		
		}

	

}
