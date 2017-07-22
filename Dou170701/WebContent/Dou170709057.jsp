<!-- XML Tag -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:directive.page import="tw.brad.bean.Member170709"/>
<%  Member170709 member = new Member170709();
	member.setId("008"); member.setName("Daniel");
%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 宣告 -->
	<jsp:declaration>
		int i; String name;
	</jsp:declaration>
	
	<!-- 邏輯 -->
	<jsp:scriptlet>
		i=10; name="Brad";
	</jsp:scriptlet>
	
	<!-- 輸出 -->
	<jsp:expression>
		member
	</jsp:expression>
	<br>
	
	<!-- 普通呈現 -->
	<jsp:text>
		I am Brad!!!
	</jsp:text>
</body>
</html>