<%--以tablib跑sql資料庫 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error170715.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/double"
	user="root" password="root" />
	
	<%--sql語法1 --%>
	<sql:query sql="select * from member" var="result" />
	<c:forEach items="${result.rows }" var="row">
						<%--rows為屬性 與row無關 --%>
		${row.id } : ${row.account } : ${row.passwd } : ${row.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	<%--sql語法2 --%>
	<sql:query var="result2">select * from member</sql:query>
	<c:forEach items="${result2.rows }" var="row">
						<%--rows為屬性 與row無關 --%>
		${row.id } : ${row.account } : ${row.passwd } : ${row.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	<%--帶參數sql語法 --%>
	<sql:query var="result3">
		select * from member where account=?
		<sql:param>double</sql:param>
	</sql:query>
	<c:forEach items="${result3.rows }" var="row">
						<%--rows為屬性 與row無關 --%>
		${row.id } : ${row.account } : ${row.passwd } : ${row.realname }<br>
	</c:forEach>
	<hr>
	<hr>
	
	${result.rows[0].account}
	<%--rows類似陣列物件 --%>
	
</body>
</html>