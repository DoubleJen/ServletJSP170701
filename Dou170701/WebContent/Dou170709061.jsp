<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String method = request.getMethod();
	//pageContext
	HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
	String querystring= req.getQueryString();//抓網址那行 所以post方法會顯示null
	String user = req.getParameter("user");
	String passwd = req.getParameter("passwd");
	String ip = req.getRemoteAddr();
	
%>
Method: <%= method %><br>
Query: <%= querystring %><br>
User: <%= user %><br>
PassWord: <%=passwd %><br>
ip: <%= ip %>
<hr>
Method: ${pageContext.request.method }<br>
Query: ${pageContext.request.queryString }<br>
</body>
</html>