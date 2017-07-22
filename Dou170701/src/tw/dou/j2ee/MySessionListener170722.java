package tw.dou.j2ee;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener170722 implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session start: " + new Date().toString());
		//同一頁面重整停在同一session
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session destroy: " + new Date().toString());
		//關掉瀏覽器不會馬上摧毀
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/double", "root", "root");
			Statement stmt = conn.createStatement();
			
			HttpSession session = event.getSession();
			String dbid = (String)session.getAttribute("dbid");
			stmt.executeUpdate("update member set islogin=0 where id=" + dbid );
		
	}catch(Exception ee) {
		System.out.println(ee);
	}

	}
}
