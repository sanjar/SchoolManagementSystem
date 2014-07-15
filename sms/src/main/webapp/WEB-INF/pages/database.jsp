<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Database Backup and Restore</title>

<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/login-box.css' />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/style1.css' />"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script>
	$(document).ready(function(){ 
		function checkFileSelection(){
			alert("fff");
			if(""== $('#file').val()){
			$('#fileSelectionError').css("display:inline");
			return;
			}
			document.backuprestore.submit();
		}
	});
</script>
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



	<!-- ======== Main Content ======== -->





	


	<div id="login">

		<h2>Backup/Restore Database</h2>


		<form action="databackupNrestore?backup" name="backuprestore" method="post">

			<fieldset>
				<label>Choose a file where you want to take back up:</label><br />
				<input type="file" name="file" id="file" size="50" /> <br />
				<c:if test="${not empty fileSelectionError}">
				 <label id="fileSelectionError" style="color:red">Please Select a file.</label>
				</c:if>
				
				<p>
					<strong><input type="submit" value="Backup Database"></strong>
				</p>
				<c:if test="${not empty backup_status}">
					<div><b>Data Backup status: ${backup_status}</b></div>
				</c:if>
				
				<p>
					<strong>Restore Database (Passward Required)</strong>
				</p>
				<p>
					<label for="email">Server</label>
				</p>
				<p>
					<input type="email" id="email">
				</p>

				<p>
					<label for="password">Password</label>
				</p>
				<p>
					<input type="password" id="password" value="password">
				</p>

				<p>
					<strong><input type="submit" value="Restore Database"></strong>
				</p>

			</fieldset>

		</form>

	</div>
	<!-- end login -->






	<br id="endmain" />



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
