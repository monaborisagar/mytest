<%@page import="com.dao.employeeDao"%>
<%@page import="com.bean.employee"%>
<%@page import="java.util.List"%>
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
		List<employee> list = employeeDao.getAllEmployees();

		List<employee> list1 = employeeDao.getAllEmployeeSkill();
	%>

	<form name="myForm" action="ActionController"
		onsubmit="return validate()" method="post">

		<table border='1' width='100%'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Salary</th>
				<th>BirthDate</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<!-- <tr><td>"+e.getEmployeeId()+"</td><td>"+e.getName()+"</td><td>"+e.getAddress()+"</td>  <td>"+e.getGender()+"</td><td>"+e.getSalary()+"</td><td>"+e.getBirthdate()+"</td><td><a href='EditServlet?id="+e.getEmployeeId()+"'>edit</a></td>   <td><a href='DeleteServlet?id="+e.getEmployeeId()+"'>delete</a></td></tr> -->
			<%
				for (employee e : list) {
			%>
			<tr>
				<td><%=e.getEmployeeId() %></td>
				<td><%=e.getName()%></td>
				<td><%=e.getAddress()%></td>
				<td><%=e.getGender()%></td>
				<td><%=e.getSalary()%></td>
				<td><%=e.getBirthdate()%></td>

				<td>
					<form name="edit" method="post" action="ActionController">
						<input type="hidden" name="id" value="<%=e.getEmployeeId() %>"> <input
							type="submit" name="action" value="edit">
					</form>
				</td>
				
				<td>
					<form name="delete" method="post" action="ActionController">
						<input type="hidden" name="id" value="<%=e.getEmployeeId() %>"> <input
							type="submit" name="action" value="delete">
					</form>
				</td>

			</tr>
			<%
				}
			%>
			<tr>
				<th>Skill Employeeid</th>
				<th>EmployeeSkillid</th>
			</tr>

			<%
				for (employee e : list1) {
			%>

			<tr>
				<td><%=e.getEmployeeSkillid()%></td>
				<td><%=e.getSkillemployeeid()%></td>
			</tr>
			<%
				}
			%>

		</table>

	</form>




</body>
</html>




<%-- <td><a href='EditServlet?id=<%=e.getEmployeeId() %>>edit</a></td>
				<td><a href='DeleteServlet?id=<%=e.getEmployeeId()%>>delete</a></td> --%>

