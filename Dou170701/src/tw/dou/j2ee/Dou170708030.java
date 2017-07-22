package tw.dou.j2ee;
//response.sendError 送出錯誤訊息的處理

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170708030")
public class Dou170708030 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		try {
			int a=10, b=0;
			out.print(a / b);
		}catch(Exception ee) {
			response.sendError(HttpServletResponse.SC_BAD_GATEWAY, "Server Busy");
		}
	}


}
