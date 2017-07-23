package tw.dou.j2ee;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
//
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener//務必加上
public class MyServerListener170723002 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		List<AsyncContext> asyncs = new LinkedList<>();//準備一個list結構人家要求送這邊
		servletContext.setAttribute("asyncs", asyncs);

		MyAsyncListener170723 myAsyncListener = new MyAsyncListener170723();
		servletContext.setAttribute("myAsyncListener", myAsyncListener);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	
	
}
