<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Manage Student</title>
	 	<script>
       	 history.forward();
    	</script>
        <!-- CSS Reset -->
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
$(document).ready(function(){
	 $(".dateField").datepicker({
		 changeMonth: true,
		 changeYear: true,
		 yearRange:'-90:+0',
         showOn: "button",
         dateFormat: "dd/mm/yy",
         disabled: false,
         buttonImage: "<c:url value='/resources/images/calendar.png'/>",
         buttonImageOnly: true
     });
	 
	 $("#manageStudent").validate({
			rules: {
				/* enrolementNo:"required", */
				firstName:"required",
				lastName:"required",
				studentId:"required",
				dateOfBirth:"required",
				/* mobileNo:"required", */
				fathername:"required",
				motherName:"required",
				dateOfAdmission:"required",
				address:"required",
				currentClassBatch:"required",
				roll:"required"
			},
			messages: {
				/* enrolementNo:"Enter Enrolement No.", */
				firstName:"Enter First Name.",
				lastName:"Enter Last Name.",
				studentId:"Enter Student Id.",
				dateOfBirth:"Enter Date Of Birth.",
				/* mobileNo:"Enter Mobile No.", */
				fathername:"Enter Father Name.",
				motherName:"Enter mother Name.",
				dateOfAdmission:"Enter Date Of Admission.",
				address:"Enter Address.",
				currentClassBatch:"Enter Class",
				roll:"Enter Roll"
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

		<form:form class="mrg-top" id="manageStudent"
			action="manageStudent">

			<ul>

				<li class="f">
					<h3 class="back">Student Management</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				
				<li class="f"><label for="name" class="fl">Enrolement No</label> <form:input
					type="text" size="25" id="enrolementNo" class="fl" path="enrolementNo" cssStyle="margin-right: 10px;" readonly="true"/>
					<%-- <button class="left cancel" name="action" value="search" style="margin-left: 30px">Search</button>
					<c:if test="${noStudentFound}">
						<label style="color:red">No Student Found.</label>
					</c:if> --%>
					<c:if test="${studentSaved}">
						<label style="color: green">Student Saved!!!</label>
					</c:if> <c:if test="${studentDeactivated}">
						<label style="color: green">Student deactivated!!!</label>
					</c:if> 
				</li>


				<%-- <li class="f"><label for="name" class="fl">Customer Type<span style="color: red">*</span></label> 
				<form:select
						path="customerType" class="fl">
						<option value="-1">Please Select Type</option>
						<form:options items="${customerType}"/>
					</form:select>
					
				</li> --%>
					
					
					
				<li class="f"><label for="name" class="fl">First Name<span style="color: red">*</span></label> 
				<form:input	type="text" size="25" id="firstName" class="fl" path="firstName" cssStyle="margin-right: 10px;"/> 
				</li>

				<li class="f"><label for="name" class="fl">Middle Name</label> 
						<form:input type="text" size="25" id="middleName" class="fl" path="middleName" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Last Name<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="lastName" class="fl" path="lastName" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Date Of Birth<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="dateOfBirth" class="fl dateField" path="dateOfBirth" readonly='true' style="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Phone No. </label> 
						<form:input type="text" size="25" id="phoneNo" class="fl" path="phoneNo" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Mobile No</label> 
						<form:input type="text" size="25" style="margin-right:10px" id="mobileNo" class="fl" path="mobileNo" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Father Name<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="fathername" class="fl" path="fathername" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Mother Name<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="motherName" class="fl" path="motherName" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Parent Mobile No</label> 
						<form:input type="text" size="25" id="parentMobileNo" class="fl" path="parentMobileNo" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Date Of Addmission<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="dateOfAdmission" class="fl dateField" path="dateOfAdmission" readonly="true" style="margin-right:10px"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Address<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="address" class="fl" path="address" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Current Class<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="currentClassBatch" class="fl" path="currentClassBatch" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Email Id </label> 
						<form:input type="text" size="25" id="emailId" class="fl" path="emailId" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Section </label> 
						<form:input type="text" size="25" id="currentClassSection" class="fl" path="currentClassSection" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Roll </label> 
						<form:input type="text" size="25" id="roll" class="fl" path="roll" cssStyle="margin-right: 10px;"/> 
				</li>
				<form:input type="hidden" path="studentId" id ="studentId"/>

				<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="deactivate">Deactivate</button>
				 <!-- <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button> -->
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