<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<jsp:useBean id="member" class="tw.brad.bean.Member170709"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("x", "123");
	%>
	<c:out value="${'Hello World'}"/><br>
	<c:out value="${x }" default="no value"></c:out><br>
	<c:out value="${y }" default="no value"></c:out><br>
	<hr>
	
	<c:set var="var1" value="456" scope="page"	/>
	${var1 }<br>
	<hr>
	
	<c:set var="var2">
		${var1 +100 }
		<% out.print("Math OK!!!"); %>
	</c:set>
	${var2 }<br>
	<hr>
	
	<c:set target="${member }" property="id">
		009
	</c:set>
	<c:set target="${member }" property="name">
		John
	</c:set>
	${member }
	<hr>
	
	<c:remove var="var1"/>
	<c:out value="${var1 }" default="NO var1 value"></c:out>
	
	
	
	
</body>
</html>