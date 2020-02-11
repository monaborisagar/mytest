<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date"%>
<%@page import="com.bean.employee"%>
<%@page import="com.dao.employeeDao"%>
<%-- <%@page import ="com.dao.ArrayList"%>--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<%
	employee e = null;
	ArrayList<employee> skillMasterArrayList = null;
%>
<body>
	<h1>my name is abc</h1>

	
	<form name="myForm" action="ActionController" onsubmit="return validate()"
		method="post">
	
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" require />*Required Field</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" id="Birthday" name="birthdate"></td>
			</tr>
			<!-- id="Birthday"
 -->
			<tr>
				<td>ADDRESS:
				<td><textarea id="textarea" maxlength="150" rows="4" cols="20"
						name="address" onkeypress="len();" require></textarea>
			</tr>

			<tr>
				<td>Gender:
				<td><input type="radio" id="male" name="gender" value="1"
					CHECKED>Male <input type="radio" name="gender" id="female"
					value="0">Female
			</tr>
			<tr>
				<td>SALARY: <!-- onkeypress="return ValidateNumberOnly();" -->
				<td><input type="text" name="salary" id="sal"
					title="Please enter exactly 9 digits" maxlength="9"
					onkeypress="return ValidateNumberOnly();">
			</tr>

			Skills:
			<%
				Connection con = utility.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from SkilMaster");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
			%>
			<input type="checkbox" name="lang" value="<%=rs.getInt("skillid")%>">  <%=rs.getString("name")%>

			<%
				}
			%>


			</script>
			<!-- 	onclick="calculateAge();" -->
			<tr>
				<td colspan="2"><input type="submit"  name="action" value="insert" />insert</td>
			</tr>

		</table>
	</form>

	<br />
	<a href="view.jsp">view employees</a>



</body>
<script type="text/javascript" src="javascript/jquery.js"></script>

</html>