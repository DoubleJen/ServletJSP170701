package tw.dou.j2ee;
//
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter(filterName="BradFilter", urlPatterns= {"/filter/*"})
//urlPatterns= {"/*"}=>全部filter=>原001的Hello, World可見=>filter後Hello, World不可見且不會報錯
//urlPatterns= {"/Filter/*"}=>掛在Filter下的看不到空白, 除非給user(原@WebServlet也要更改=>("/filter/Filter170723"))
public class MyFilter170723 implements Filter {
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter: before");
		
		String user = req.getParameter("user");
		if(user != null && user.equals("brad")){
			chain.doFilter(req, resp);
		}
		
		System.out.println("doFilter: after");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter destroy");
		
	}

	

}
