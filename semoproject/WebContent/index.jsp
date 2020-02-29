<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form  method="POST" action="actioncontroller">
            <label for="username">Username:</label><input id="username" name="username" type="text"/><br/>
            <label for="password">password:</label><input id="password" name="password" type="text"/><br/>
            <input type="submit"  name="action" value="login"/>
        </form>
<a href="regisatration.jsp" >registration</a>

</body>
</html>