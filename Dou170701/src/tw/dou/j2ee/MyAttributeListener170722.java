package tw.dou.j2ee;
//087=>attributelistener=>088
//
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAttributeListener170722 implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributevalue = (String)event.getValue();
		System.out.println("ADD=> " + attributeName);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributevalue = (String)event.getValue();
		System.out.println("REMOVE=> " + attributeName);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributevalue = (String)event.getValue();
		System.out.println("REPLACE=> " + attributeName);
	}
	
}
