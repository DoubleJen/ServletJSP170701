package tw.dou.j2ee;
//094=>095=>096
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttribute170723 implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//event.getSession();
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("ADD: " + name + " : " + value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("REMOVE: " + name + " : " + value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		//before replace
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("REPLACE OLD: " + name + " : " + value);
		
		//after replace
		HttpSession session = event.getSession();
		String v2 = (String)session.getAttribute(name);
		System.out.println("NEW REPLACE : " + name + " : " + v2);
	}

}
