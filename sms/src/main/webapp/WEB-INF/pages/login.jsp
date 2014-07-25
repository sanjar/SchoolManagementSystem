<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>SCHOOL ACCOUNTS MANAGEMENT SYSTEM</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- <script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script> -->
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
 <script>
        history.forward();
    </script>
<script type="text/javascript">


$(document).ready(function(){
	$('.link').click(function(event) {
		$('#links li').removeClass("highlight");
		$(this).parent().addClass("highlight");
		
		
	    //$('#userType').val($(this).text().split(" ")[0]);
	    $('#user_type').val($(this).attr("id"));
	    //alert($('#user_type').val());
	  // or use return false;
	});
	
	$	('.noevent').click(function(event) {
		 event.preventDefault();	 
	  // or use return false;
	});
	var x = '${user_type}';
	$('#userType').val(x);
	if("Admin"==x){
		$('#User').parent().removeClass("highlight");
		$('#Admin').parent().addClass("highlight");
	}
	
	$('#username').focus();
	$("#userLoginForm").validate({
		rules: {
			username:"required",
			password:"required"
		},
		messages: {
			username:"<br>Please specify Username",
			password:"<br>Please specify Passowrd"
		}
		
	});
});



</script>

<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css'/>" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/login-box.css'/>" rel="stylesheet" type="text/css" />
</head>

<body>

	<!-- ======== Header ======== -->

	<div id="header">
		<div class="left">
			<p>
				<a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a>
			</p>
		</div>

		

		<div class="subheader">
			<p>
				<span class="hidden">Navigation:</span> <a href="">Home</a> | <a href="">Contact</a> |

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->

	<div id="sidebar1">
		<div>

			<ul id="links">
				<li class="highlight"><a id="User" class="link" href="/sms/user">User Login</a></li>
				<li><a id="Admin" class="link" href="/sms/admin">Admin Login</a></li>
			</ul>
		</div>
		<input type="hidden" name="user_type" id ="user_type" value="" />
	</div>


	<!-- ======== Main Content ======== -->

	<div id="main">

		<div id="navhead">
			<hr />
			 <a class="noevent" href="#">Login</a>
			&raquo; <a class="noevent" href="#">${user_type} Login</a> &raquo;
		</div>


		<h1>Welcome ${user_type}</h1>


		<p>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
	<form id="userLoginForm" name="userLoginForm" action="<c:url value='j_spring_security_check' />" method="post">
			<div id="login-box">
				
				<H2>Login</H2>
				<br /> <br />
				
				<div id="login-box-name" style="margin-top: 20px;"><b>User Name:</b></div>
				<div id="login-box-field" style="margin-top: 20px;">
					<input name="username" id="username" class="form-login" title="Username"
						size="30" maxlength="2048" />
				</div>
				<div id="login-box-name"><b>Password:</b></div>
				<div id="login-box-field">
					<input name="password" id="password" type="password" class="form-login" title="Password"
						 size="30" maxlength="2048" />
				</div>
				
				
				<br /> <span class="login-box-options"><input
					type="checkbox" name="1" value="1"> Remember Me <a href="#"
						style="margin-left: 30px;">Forgot password?</a></span> <br /> <br />
						<center>
						 <input type="image" name="submit" src="<c:url value='/resources/images/login-btn.png'/>" alt="Submit" />
						</center>
						
					






			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				<input type="hidden" name="userType" id ="userType"
				value="${user_type}" />
</form>



			<br id="endmain" />
	</div>


	<!-- ======== Footer ======== -->

	<div id="footer">
		<hr />
		Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a> All
		rights reserved. <span class="notprinted"> <a href="index.html">Terms
				of Use</a>. <a href="index.html">Privacy Policy</a>.
		</span> <br /> This web site is maintained by <a href="www.dsisoftware.net"
			target="_blank">www.dsisoftware.net</a>.

	</div>

</body>
</html>
