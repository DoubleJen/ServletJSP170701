package tw.dou.j2ee;
//097=>098
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MyRequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("request attribute ADD: "+ name + " : " + value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("request attribute REMOVE: "+ name + " : " + value);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		String name = event.getName();
		System.out.println("request replace attribute: " + name);
		
		if(name.equals("x")) {
			String value = (String)event.getValue();
			System.out.println("request attribute REPLACE OLD: "+ name + " : " + value);
			
			ServletRequest req = event.getServletRequest();
			String v2 = (String)req.getAttribute(name);
			System.out.println("NEW request attribute REPLACE: "+ name + " : " + v2);
		}	
	}

}
