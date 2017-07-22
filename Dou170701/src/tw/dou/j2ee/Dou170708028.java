package tw.dou.j2ee;
//種下Cookie & 設定Cookie期限

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170708028")
public class Dou170708028 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		Cookie cookieRemember = new Cookie("remember", "true");//任何一組Cookie儲存一組key value
		cookieRemember.setMaxAge(1*60);//設定cookie期限以"秒"計, 1*60=>1分鐘
		response.addCookie(cookieRemember);//cookie寫出去
		
		Cookie cookieAccount = new Cookie("account", "brad");//任何一組Cookie儲存一組key value
		cookieAccount.setMaxAge(1*60);//設定cookie期限以"秒"計, 1*60=>1分鐘
		response.addCookie(cookieAccount);//cookie寫出去
		
		Cookie cookiePasswd = new Cookie("passwd", "123456");//任何一組Cookie儲存一組key value
		cookiePasswd.setMaxAge(1*60);//設定cookie期限以"秒"計, 1*60=>1分鐘
		response.addCookie(cookiePasswd);//cookie寫出去
		
		
	}


}
