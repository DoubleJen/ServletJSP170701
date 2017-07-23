package tw.dou.j2ee;
//非同步
//101=>103 30秒延遲回應
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Dou170723103", asyncSupported=true)
public class Dou170723103 extends HttpServlet {
	private ExecutorService executorService = Executors.newFixedThreadPool(5);
	//本身這個Servlet有5個ThreadPool
	AsyncContext asyncContext;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		asyncContext = request.startAsync();//KEYPOINT=>啟動非同步Context
		executorService.submit(new AsyncRequest());	
		//由executorService來執行執行緒 所以new出執行緒後不用在new XXX.start
		
	}
	
	@Override
	public void destroy() {
		executorService.shutdown();//釋放執行緒
		super.destroy();//真正掛掉的點
	}
	
	//寫成內部類別方便存取request and response
	private class AsyncRequest implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(30*1000);
				
				try {
					PrintWriter out = asyncContext.getResponse().getWriter();
					out.println("OK3: " + (int)(Math.random()*49+1));
					asyncContext.complete();
				} catch (IOException e) {
				}
				
			} catch (InterruptedException e) {
			}
			
			
			
		}
	}


}
