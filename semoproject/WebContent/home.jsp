<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

//response.setHeader("Pragma","no-cache");

response.setHeader("Expires", "0"); 
if(session.getAttribute("name")==null)
{
    response.sendRedirect("index.jsp");
}else{
	String mona = (String)session.getAttribute("name");	
}
	
%>

<h1>hello ${name}</h1> 
<form name="action" method="POST" action="actioncontroller">
 <input type="submit" name="action" value="logout"/>
</form>
</body>
</html>