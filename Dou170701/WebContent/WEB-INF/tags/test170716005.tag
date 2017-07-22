<%@tag import="java.util.HashMap"%>
<%@ tag dynamic-attributes="product" %>
<%@ attribute name="user" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%
	out.print("<h1>Brad Big Company</h1>" + "<br>");

	HashMap<String, String> ps = (HashMap<String, String>)jspContext.getAttribute("product");
	if(ps.containsKey("name")){
		out.print(ps.get("name"));
	}
	
%>


<table border="1" width="100%">
	<tr>
		<th>ITEM</th>
		<th>VALUE</th>
	</tr>
	

</table>
