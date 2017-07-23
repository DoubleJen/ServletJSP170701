package tw.dou.j2ee;
//101=>100 30秒回來 102馬上回來
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170723100")
public class Dou170723100 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		
		try {
			Thread.sleep(1*30*1000);//30秒
		} catch (InterruptedException e) {
			
		}//30秒後印出out.print
		out.println("OK: " + (int)(Math.random()*49+1));
		
		
	}


}
