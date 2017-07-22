<%--自訂標籤 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="me" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<me:test170716001/>
	<hr>
	<hr>
	
	<me:test170716002 user="Brad"/>
	<hr>
	<hr>
	
	<me:test170716003 x="10" y="3">
		10 + 3 = ${add }<br>
		10 - 3 = ${sub }<br>
		10 * 3 = ${multiply }<br>
		10 / 3 = ${divide }<br>
	</me:test170716003>
	<hr>
	<hr>
	
	<me:test170716004 name="Mouse" id="001" price="100" />
	<hr>
	<hr>
	<me:test170716005 user="" name="AA1" BB="BB1"></me:test170716005>
	<me:test170716005 user="TONY" name="Welcome"></me:test170716005>
	
		
	
	
	
</body>
</html>