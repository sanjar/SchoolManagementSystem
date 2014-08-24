<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Manage Admin User</title>
	 	
        <!-- CSS Reset -->
        <link rel="stylesheet" href="<c:url value='/resources/css/form3.css'/>" />
       <link rel="StyleSheet"
	href="<c:url value='/resources/css/main-screen.css' />" type="text/css"
	media="screen" />
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-print.css' />" type="text/css"
	media="print" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement'
	rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js">


<script src="<c:url value='/resources/js/multi.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/resources/js/jquery.uniform.min.js'/>"
	type="text/javascript" charset="utf-8"></script>  
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript">

	 $("#manageAdminUsers").validate({
			rules: {
				/* enrolementNo:"required", */
				userId:"required",
				/* lastName:"required", */
				password:"required", 
				/* dateOfBirth:"required", */
				/* mobileNo:"required", */
				fullName:"required",
				/* motherName:"required",
				dateOfAdmission:"required",
				address:"required", */
				mobileNo:"required",
				emailId:"required"
				/* roll:"required" */
			},
			messages: {
				/* enrolementNo:"Enter Enrolement No.", */
				userId:"Enter User Name",
				/* lastName:"Enter Last Name.", */
				password:"Enter Password.",
				/* dateOfBirth:"Enter Date Of Birth.", */
				/* mobileNo:"Enter Mobile No.", */
				fullName:"Enter Full Name.",
				/* motherName:"Enter mother Name.",
				dateOfAdmission:"Enter Date Of Admission.",
				address:"Enter Address.", */
				mobileNo:"Enter Mobile No",
				emailId:"Enter Email Id"
				/* roll:"Enter Roll" */
			}
			
		});
});

</script>

       
        
		
	</head>
	<body>
	<div id="header">
		<div class="left">
			<p>
				<a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a>
			</p>
		</div>

		<div class="subheader">
			<p>
				<span class="hidden">Navigation:</span> <a href="/sms/home" class="highlight">Home</a>
				| <a href="">Contact</a> |

			</p>
		</div>
	</div>
     <article>	

		<form:form class="mrg-top" id="manageAdminUsers"
			action="manageAdminUsers">

			<ul>

				<li class="f">
					<h3 class="back">Admin User Management</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				<c:if test="${userAlreadyExists}">
						<span style="color: red">User Already Exists with Username : '${command.userId}'.</span>
				</c:if>
				<li class="f"><label for="name" class="fl">Username<span style="color: red">*</span> </label> <form:input
					type="text" size="25" id="userId" class="fl" path="userId" cssStyle="margin-right: 10px;"/>
					<button class="left cancel" name="action" value="search" style="margin-left: 30px">Search</button>
					<c:if test="${noUserFound}">
						<label style="color:red">No User Found.</label>
					</c:if> 
					<c:if test="${userSaved}">
						<label style="color: green">User Saved!!!</label>
					</c:if> <c:if test="${userDeactivated}">
						<label style="color: green">User deactivated!!!</label>
					</c:if> 
				</li>

				<li class="f"><label for="name" class="fl">Password <span style="color: red">*</span> </label> 
						<form:password  size="25" id="password" class="fl" path="password" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Name <span style="color: red">*</span></label> 
						<form:input type="text" size="25" id="fullName" class="fl" path="fullName" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Mobile No. <span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="mobileNo" class="fl" path="mobileNo" cssStyle="margin-right: 10px;"  /> 
				</li>
				<li class="f"><label for="name" class="fl">Email Id <span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="emailId" class="fl" path="emailId" cssStyle="margin-right: 10px;" /> 
				</li>
				<li class="f"><label for="name" class="fl">Enabled</label> 
						<form:input type="text" size="25" id="enabled" class="fl" path="enabled" cssStyle="margin-right: 10px;" readonly="true"/> 
				</li>
				<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="deactivate">Deactivate</button>
				 
				 <button class="left cancel" name="action" value="reset">Reset</button>
				 <button class="left" name="exit" value="exit" onclick="window.close(); return false;">Exit</button>
				 
				</li>
				
				</ul>
		</form:form>

	</article>
        <!-- Footer -->
        <div id="footer">
        	<div class="container_12">
            	<div class="grid_12">
                	
                	
        		</div>
            </div>
            <div style="clear:both;"></div>
        </div> <!-- End #footer -->
	</body>
</html>