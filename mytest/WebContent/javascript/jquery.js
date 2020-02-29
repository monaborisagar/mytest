
function validate() {
		var d=document.myForm.Birthday.value
		var a = document.myForm.name.value;
		if (a == "" || a==null) {
			alert("Name must have !");
			return false;
		}
		
		//alert("s");// Date of birthday 
		if(d=="")
		{
			alert("Date of birthday must have selected");
			return false;
		}
		else
		{
			var a=Birthday.value;
	//		alert("date "+a);
			var year = Number(a.substr(0, 4));
			var year = Number(a.substr(0, 4));
			var month = Number(a.substr(4, 2)) - 1;
			var day = Number(a.substr(6, 2));
			var today = new Date();
			var age = today.getFullYear() - year;
			//alert("year"+age); 
			if(age<15)
			{
				alert("Age must be greter then 15 years");
				return false;
			}
		}
		
		
		t_v=textarea.value;
		if(t_v==""||t_v==null)
		{
			alert("address not null ");
			return false;
		}
		else if (t_v.length>150)
		  {
			  alert("Max limit is 150 characters	 !");
			  return false;
		  }
		
		
		//salary id="sal"
		//alert("salary");
		var s=document.myForm.sal.value
		//alert("salary"+s);
		if(s==""||s==null)
		{
			alert("not null salary");
		
		}
		else if(s < 48 || s > 57)
			{
			alert("number should not exceed range between 48 to 57");
			   event.returnValue = false;
			}

	}
	
	function ValidateNumberOnly()
	{
	if ((event.keyCode < 48 || event.keyCode > 57)) 
	{
		alert("Only Number allowed Max length = 9");
	   event.returnValue = false;
	}
	}
	/* function len(){
	  t_v=textarea.value;
	  if(t_v.length>=150){
		  alert("Max limit is 150 characters	 !")
		  }
	 }
	*/
	
	/* function limitText(limitField, limitCount, limitNum) {
		alert("ok");
		if (limitField.value.length > limitNum) {
			alert("if");
			limitField.value = limitField.value.substring(0, limitNum);
		} else {
			alert("else");
			limitCount.value = limitNum - limitField.value.length;
		}
	} */
	
	/* function calculateAge(birthday) { // birthday is a date
		var a=Birthday.value;
		var year = Number(a.substr(0, 4));
		var year = Number(a.substr(0, 4));
		var month = Number(a.substr(4, 2)) - 1;
		var day = Number(a.substr(6, 2));
		var today = new Date();
		var age = today.getFullYear() - year;
		//alert("year"+age); 
		if(age<15)
		{
			alert("Age must be greter then 15 years");
		}
	} */
	

	
	
