<!-- scope of Attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.brad.bean.BradUtil170709" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//Scope
		//1.Page
		pageContext.setAttribute("name", "<h3>Brad Big Company</h3>");//only for this page
		//2.request
		request.setAttribute("name", "request");//follow the previous page attribure(跟著前一頁一起過來)
		//3.session
		session.setAttribute("name", "session");//for session
		//4.application
		application.setAttribute("name", "app");
		
	%>
	
	Page: ${pageScope.name }<br>
	Request: ${requestScope.name }<br>
	Session: ${sessionScope.name }<br>
	App: ${applicationScope.name }<br>
	
	1.m1(): <%= BradUtil170709.m1("brad") %><br>
	2.m1(): ${BradUtil170709.m1(param.name) }<br>
								<!-- name手動給參數 -->
	
</body>
</html>