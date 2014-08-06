<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>SCHOOL ACCOUNTS MANAGEMENT SYSTEM</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
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
				<li ><a id="listAdminUsers" class="link" href="/sms/admin/userManagement/listAdminUsers">List Admin Users</a></li>
				<li><a id="listStudents" class="link" href="/sms/admin/userManagement/listStudents">List Students</a></li>
				<li><a id="listStudents" class="link" href="/sms/admin/userManagement/listStudents">List Suppliers/Dealers</a></li>
			</ul>
		</div>
	</div>


	<!-- ======== Main Content ======== -->

	<div id="main" style="height: 400px">

	<h1>User Management</h1>

* <h3><a href="createAdminUser">Create Admin User</a></h3>
* <h3><a href="userManagement/manageStudent">Manage Student</a></h3>
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
