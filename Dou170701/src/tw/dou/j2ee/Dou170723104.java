package tw.dou.j2ee;
//收集要求
//Server002=>104=>105
import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Dou170723104", asyncSupported=true)
public class Dou170723104 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		MyAsyncListener170723 myAsyncListener = (MyAsyncListener170723)servletContext.getAttribute("myAsyncListener");
		
		synchronized (asyncs) {
			AsyncContext async = request.startAsync();
			async.addListener(myAsyncListener);//onStartAsync該事件可能聽不到
			System.out.println(async.getTimeout());//Timeout預設時間為30秒
			async.setTimeout(900000000);//
			asyncs.add(async);
		}
		
		
	
	}


}
