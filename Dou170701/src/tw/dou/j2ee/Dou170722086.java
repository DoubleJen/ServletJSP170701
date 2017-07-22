package tw.dou.j2ee;
//生命週期.
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Dou170722086", //name不要亂改
			urlPatterns= {"/Dou170722086", "/Dou170722086.php", "/Dou170722086.aspx"},	//無預設值
			initParams= {
					@WebInitParam(name="x", value="123"),
					@WebInitParam(name="y", value="456")
			}
			)
			
public class Dou170722086 extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	
	@Override
	public void init() throws ServletException {
//		//System.out.println("init");
//		super.init();
//		System.out.println("init");
		
		super.init();
		servletConfig = getServletConfig();
		servletContext = getServletContext();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		//System.out.println("service");
		super.service(req, resp);	//1.觸發doGet or doPost, 所以先印"doGet"
//		System.out.println("service");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("doGet");
		
		Enumeration<String> params = servletConfig.getInitParameterNames();
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println(param + " = " + servletConfig.getInitParameter(param));
		}
		
		String realPath = servletContext.getRealPath(".");
		System.out.println(realPath);
		String realRoot = servletContext.getRealPath("/");
		System.out.println(realRoot);
		
		Set<String> paths = servletContext.getResourcePaths("/");
		for(String path: paths) {
			System.out.println(path);
		}
		
	}


}
