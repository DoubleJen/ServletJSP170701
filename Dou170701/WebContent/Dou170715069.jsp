<%--format 自動判斷多國語系 with Google --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--語系 --%>
	<%
		Locale locale = request.getLocale();
	%>
	Locale: <%= locale.getCountry() %><br>			<%--要的 --%>
	Locale: <%= locale.getDisplayCountry() %><br>   <%--呈現的 --%>
	Locale: <%= locale.getLanguage() %><br>
	<hr>
	<fmt:setBundle basename="res"/>					<%--載入 --%>
	<fmt:message key="Hello"/>,<fmt:message key="World"/>
	<hr>
	<fmt:message key="CompanyName"/>
	<hr>
	<hr>
	
	<%--日期 --%>
	<% 
		Date now = new Date();
		out.print(now);
		pageContext.setAttribute("now", now);
	%>
	<hr>
	坎帕拉
	<fmt:setTimeZone value="Africa/Kampala"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="long"/>
	<br>
	亞洲台北
	<fmt:setTimeZone value="Asia/Taipei"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="long"/>
	<hr>
	<hr>
	
	<%--數字 --%>
	Default: <fmt:formatNumber value="${1234567.890123 }" /><br>
	無千分位: <fmt:formatNumber value="${1234567.890123 }" groupingUsed="false" /><br>
	最大四位整數: <fmt:formatNumber value="${1234567.890123 }" maxIntegerDigits="4" /><br>
	最低八位整數&無千分位: <fmt:formatNumber value="${1234567.890123 }" minIntegerDigits="8" groupingUsed="false" /><br>
	小數點最多一位: <fmt:formatNumber value="${1234567.890123 }" maxFractionDigits="1" /><br>
	<hr>
	<hr>
	
	<%--貨幣 --%>
	人民幣: <fmt:formatNumber value="${123 }" type="currency" currencyCode="CNY" />
	
	
</body>
</html>