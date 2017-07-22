<%@tag import="java.util.HashMap"%>
<%@ tag dynamic-attributes="mail" %>
<%@ tag import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ tag import = "javax.mail.internet.*,javax.activation.*"%>
<%@ tag import = "javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ attribute name="from" required="true" %>
<%@ attribute name="to" required="true" %>
<%@ attribute name="subject" required="true" %>
<%@ attribute name="content" required="true" %>


<%
final String username = "tonytest1985@gmail.com";
final String password = "19856315";

Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");

Session session2 = Session.getInstance(props,
  new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
  });

try {

	Message message = new MimeMessage(session2);
	message.setFrom(new InternetAddress("tonytest1985@gmail.com"));
	message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("tonytest1985@gmail.com"));
	message.setSubject("Testing Subject170716gmail");
	message.setText("Dear Mail Crawler,"
		+ "\n\n No spam to my email, please!");

	Transport.send(message);

	out.println("Done");

} catch (MessagingException e) {
	//throw new RuntimeException(e);
	System.out.println(e);
}

%>