<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.employeeDao"%>
<%@page import="com.bean.employee"%>
<%@page import="com.util.utility"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		employee e = (employee) request.getAttribute("emp");
		out.println("value of address is :" + e.getAddress());
		out.println("value of address is :" + e.getGender());
	%>



	<form name="update" action="ActionController" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="employeeid"
					value="<%=e.getEmployeeId()%>" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=e.getName()%>"
					require />*Required Field</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" id="Birthday" name="birthdate"
					value="<%=e.getBirthdate()%>"></td>
			</tr>

			<tr>
				<td>ADDRESS:
				<td><textarea id="textarea" maxlength="150" rows="4" cols="20"
						name="address" onkeypress="len();" require><%=e.getAddress()%></textarea>
			</tr>

			<tr>
			<tr>
				<td>Gender: <%
					if (e.getGender() == 1) {
				%> <%
 	out.println("this is inside male option");
 %>
				<td><input type="radio" id="male" name="gender" value="1"
					checked />male <input type="radio" name="gender" id="female"
					value="0">female <%
					} else if (e.getGender() == 0) {
				%>
					<%
						out.println("this is inside female option");
					%>
				<td><input type="radio" id="male" name="gender" value="1">male
					<input type="radio" name="gender" id="female" value="0" checked />female
					<%
					}
				%>
			</tr>




			<tr>
				<td>SALARY:
				<td><input type="text" name="salary" id="sal"
					title="Please enter exactly 9 digits" maxlength="9"
					onkeypress="return ValidateNumberOnly();"
					value="<%=e.getSalary()%>">
			</tr>
			
			Skills:
			<%
				Connection con = utility.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select  SkilMaster.skillid,name,EmployeeSkill15.skillid as eskillid from SkilMaster left join EmployeeSkill15 on (SkilMaster.skillId=EmployeeSkill15.skillId and EmployeeSkill15.employeeId=?)");
				ps.setInt(1, e.getEmployeeId());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
			%>
			<input type="checkbox" name="lang" value="<%=rs.getInt("skillid")%>"
				<%=((rs.getInt("eskillid") != 0) ? "CHECKED" : "")%>><%=rs.getString("name")%>
			<%
				}
				con.close();
			%>

			

			
			
			<tr>
				<td colspan="2"><input type="submit" value="update" name="action" /></td>
			</tr>

		</table>
	</form>

</body>
</html>