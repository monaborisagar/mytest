<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name="myForm " method="POST" action="actioncontroller"
		onsubmit=" return validate();">
		<label for="username">Username:</label><input id="username"
			name="username" type="text" required="required" /><br />
			 <label
			for="password">password:</label><input id="password" name="password"
			type="text" required="required" /><br /> 
			<label for="email">email:</label><input
			id="email" name="email" type="email" required="required" /><br />
			 <label
			for="email">date:</label><input id="date" name="date" type="text"
			required="required" on /><br /> 
			<label for="phnenumber">phnenumber:</label><input
			id="phnenumber" name="phnenumber" type="text"
			onkeypress="return ValidateNumberOnly();" required="required" /><br />
			
		<input type="submit" name="action" value="register" />
	</form>


</body>
<script type="text/javascript">
	function validate() {
		var username1 = document.getElementById("username").value;

		if (username1 == "" || username1 == null) {
			alert("Please enter username");
			return false;
		}

		var phnenumber = document.getElementById("phnenumber").value;

		alert(phnenumber.length);
		var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		if (!(phoneno).test(phnenumber)) {
			
		
			alert("phnenumber pattern is not matched ");
			return false;
		}
		
		 
		    var dob =document.getElementById("date").value;
		    alert("fdbdfb");
		    var pattern = /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
		    alert(dob);
		    
		    if ( !pattern.test(dob)) {
		    	
		        alert("Invalid date of birth\n");
		        return false;
		    }
		
		   
	}
	
</script>
</html>