<%-- update and last_insert_id() in sql --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://127.0.0.1:3306/double"
user="root" password="root" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:transaction>
		<sql:update var="n" sql="insert into member(account,passwd,realname) values(?,?,?)">
			<sql:param>mark</sql:param>
			<sql:param>123</sql:param>
			<sql:param>Mark</sql:param>
		</sql:update>
		
		<sql:query var="lastid">
			select last_insert_id() as newid
			<%--http://blog.johnsonlu.org/mysqlsql%E8%AA%9E%E6%B3%95-%E5%8F%96%E5%BE%97%E6%9C%80%E5%BE%8C%E4%B8%80%E7%AD%86auto_increment%E5%B1%AC%E6%80%A7%E7%9A%84%E5%80%BClast_insert_id/ --%>
		</sql:query>
		
	</sql:transaction>

	<c:if test="${n >= 1 }">
		Last Id: ${lastid.rows[0].newid }
	</c:if>
	
</body>

</html>