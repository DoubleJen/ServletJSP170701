package tw.dou.j2ee;
//Servlet傾聽器
//
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener//務必加上
public class MyServerListener170722002 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("init1");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("destroy1");
		
	}

	
	
}
