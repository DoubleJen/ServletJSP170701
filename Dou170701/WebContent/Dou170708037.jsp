<!-- . -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int a=10; %> <!-- a此時為區域變數 -->
	<%! int b=10; %><!-- b此時為static變數 活在整個類別 -->
	a = <%= a++ %>
	b = <%= b++ %>
	
</body>
</html>