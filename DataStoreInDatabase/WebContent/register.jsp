<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register for chandu app</title>

</script>
</head>
<body>
<fieldset>
<legend>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<b> UserRegister </b>
</legend>
<form action="register" >

firstName/userid<super class="manditary" >*</super>:<input type="text" value="" name="firstname"/><span id="firstname"></span><br/><br/>

lastName:<input type="text" value="" name="lastname"/><br/><br/>

email:<input type="email" value="" name="email"/><br/><br/>
phone:<super class="manditary" >*</super><input type="text" value="" name="phone"/><span id="phone"></span><br/><br/>
password:<super class="manditary" >*</super><input type="password" value="" name="password"/><span id="password"></span><br/><br/>

gender:<super class="manditary" >*</super><input type="radio"" name="gender" value="male">male
		<input type="radio" name="gender" value="female"/>female<span id="gender"></span><br/><br/>
address:<textarea row="10" coloum="10" name="address" value=""></textarea><br/><br/>
qualification:<select name="qualification">
				<option  value="mba">MBA</option>
				<option   value="mca">MCA</option>
				<option  value="btech">Btech</option>
				<option value=0 selected>seclect option</option>
				</select><span id="qualif"></span><br/><br/>	
<input type="submit" value="submit" onclick=" return formvalidation()">	
</form>
</fieldset>
<script>
function formvalidation(){
	  var form=document.forms[0];
	  var firstname =form.firstname;
	  var tem;
	  var idfn1=  document.getElementById("firstname");
	  if((tem=(firstname.value.length==0))){
	    idfn1.style.color="red";
	  	idfn1.innerHTML="plese enter the username";
	  alert("enter username");
	  
	  }
	  
	  else{
	    idfn1.innerHTML=""
	  }
	  var ids2=document.getElementById("phone");
	  var phone=form.phone;
	  var tem2;
	  if((tem2=(phone.value.length==0))){
	    ids2.style.color="red";
	    ids2.innerHTML="plese enter number  in the phone";
	    alert("enter phone");
	  }

	  	  else{
	     ids2.innerHTML="";
	  }
	  var idpw3=document.getElementById("password");
	  var password=form.password;
	  var tem3;
	  if((tem3=(password.value.length==0))){
	    idpw3.style.color="red";
	    idpw3.innerHTML="plese enter password";
	    alert("enter password");
	  }

	  	  else{
	    idpw3.innerHTML="";
	  }
	  var idgd4=document.getElementById("gender");
	  var gender=form.gender;
	  var tem4;
	  if((tem4=(gender.value.length==0))){
	    idgd4.style.color="red";
	    idgd4.innerHTML="plese press gender";
	    alert("enter gender");
	  }

	  	  else{
	    idgd4.innerHTML="";
	  }
	 
	  if(tem||tem2||tem3||tem4){
	    return false
	  }
	  else{
	  return true

	  }
	  

	}
	

</script>
</body>
</html>