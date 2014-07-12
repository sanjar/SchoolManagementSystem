<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
	<head>
		<title>School Management System</title>
		  <script src="http://code.jquery.com/jquery-latest.js"></script>
		      <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
    			<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
	<style type="text/css">
		label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
		p { clear: both; }
		.submit { margin-left: 12em; }
		td { font-weight: bold; padding-right: 1em; vertical-align: top; }
	</style>
    <script>
		 /*  $(document).ready(function(){
			$("#userLoginForm").validate({
				rules: {
					userId:"required",
					password:"required",
					userType:"required"
				},
				messages: {
					userId:"<br>Please specify User Id",
					password:"<br>Please specify Passowrd",
					userType:"<br>Please select User Type to Login"
				}
				
		  });
	}); */
	  </script>
	</head>
	<body>
		<br>
		<hr>
			<a style="padding-left:200px;" href="/project/sms/home">Home</a>
		<hr>
	<h2 align="center">Welcome to School Management System</h2><hr>
	 <%
     
         String errorString = (String)request.getAttribute("error");
         if(errorString != null && errorString.trim().equals("true")){
            out.println("Incorrect login name or password. Please retry using correct login name and password.");
         }
    %>
	<center>
		<form id="userLoginForm" name="userLoginForm" action="<c:url value='j_spring_security_check' />" method="POST">
			<br>
			<table cellspacing="5" cellpadding="5" bgcolor="#F0FFC2">

				<tr>
					<td><b>User ID</b><label style="color: red">*</label></td>
					<td><input name='username' class="required" style="width: 300px;"/></td>
				</tr>
				<tr>
					<td><b>Password</b><label style="color: red">*</label></td>
					<td><input name='password' type="password" style="width: 300px;"/></td>
				</tr>
				<%-- <tr>
					<td><b>Login As</b><label style="color: red">*</label></td>
					<td>
						<form:select path="userType" style="width: 300px;">
							<form:option value="" label="Please Select"/>
							<form:option value="1">Admin</form:option>
							<form:option value="2">Student</form:option>
							<form:option value="3">Vendor</form:option>
							<form:option value="4">Teacher</form:option>
						</form:select>
					</td>
				</tr> --%>
				<tr>
					<td><input type="submit" name="submit" value="Login"/></td>
					<td><a href="forgotPassword">Forgot Password?</a></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form>	
	</center>
	<body>
</html>