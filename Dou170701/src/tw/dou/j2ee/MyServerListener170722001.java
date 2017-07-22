package tw.dou.j2ee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
//Servlet傾聽器
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//Server001=>088
//
@WebListener//務必加上
public class MyServerListener170722001 implements ServletContextListener {
	private ServletContext servletContext;
	private Timer timer;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("init");
		
		servletContext = event.getServletContext();
		servletContext.setAttribute("key3", "value3");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/double", "root", "root");
			System.out.println("Connection OK");
			
			servletContext.setAttribute("conn", conn);
			servletContext.setAttribute("isConnection", true);
			
//			PreparedStatement pstmt=
//					conn.prepareStatement("insert into cust2(account, passwd) values(?, ?)");
			
		} catch (Exception e) {
			servletContext.setAttribute("isConnection", false);
			System.out.println("ERROR HAPPEN");
		}
		
		timer = new Timer();
		//timer.schedule(new MyTask(), 5*1000, 1*1000);
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("destroy");

		if((Boolean)(servletContext.getAttribute("isConnection")) &&
			servletContext.getAttribute("conn") != null	){
			Connection conn = (Connection)servletContext.getAttribute("conn");
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("MySQL Close Error!");
			}
		}
		
		if(timer != null) {
			timer.cancel();
			timer.purge();
			timer = null;
		}
		
	}
	
}

class MyTask extends TimerTask{

	@Override
	public void run() {
			System.out.println("TimerTask");
	}
	
}
