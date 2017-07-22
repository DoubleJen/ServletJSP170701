<!-- . -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String op = request.getParameter("op");
	int intx, inty;
	String result = "";

	if(x != null && y != null){
	 	intx = Integer.parseInt(x);
		inty = Integer.parseInt(y);
		switch(op){
			case "1": result = (intx + inty) +""; break;
			case "2": result = (intx - inty) +""; break;
			case "3": result = (intx * inty) +""; break;
			case "4":
				int temp1 = intx / inty; 
				int temp2 = intx % inty;
				result = temp1 + " ...... " + temp2;
				break;
		}
	}else{
		op="";
		intx = inty = 0;
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	
		<input type='text' name='x' value='<%= intx %>' />
		<select name='op'>
			<option value='1' <%= op.equals("1")?"selected":"" %>>+</option>
			<option value='2' <%= op.equals("2")?"selected":"" %>>-</option>
			<option value='3' <%= op.equals("3")?"selected":"" %>>*</option>
			<option value='4' <%= op.equals("4")?"selected":"" %>>/</option>
		</select>
		<input type='text' name='y' value='<%= inty %>'/>
		<input type='submit' value='='  />
		<%= result %>
		
	</form>
</body>
</html>