<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<c:set var = "theString" value = "I am a test String"/>
	${fn:contains(theString, 'test')}
	<hr>
	<hr>
	
	<%
		 String str = (String)pageContext.getAttribute("theString");
		 out.print(str.contains("test"));
	%>
	<hr>
	<hr>
	
	 <c:set var = "string1" value = "This is first String."/>
	 <c:set var = "string2" value = "Thisisis first String."/>
     <c:set var = "string3" value = "${fn:substringAfter(string1, 'is')}" />
     <c:set var = "string4" value = "${fn:substringAfter(string2, 'is')}" />
	==>${string3 }<br>
	==>${string4 }
	
</body>
</html>