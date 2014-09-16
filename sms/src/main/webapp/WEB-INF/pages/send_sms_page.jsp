<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>General Ledger</title>
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
	 if('${disableNext}'){
 		$('#nextButton').attr('disabled','disabled');
 	}
 	if('${disablePrevious}'){
 		$('#previousButton').attr('disabled','disabled');
 	}
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
				| <a href="">Contact</a> 

			</p>
		</div>
	</div>
     <article>

		<form:form class="mrg-top" id="send"
			action="generateReport/send" method="POST">
			<div style="float:left;margin-right: 10px">
				<span><b>Employee List</b></span>
				<table border="">
					<tr>
					<th width="96" scope="col"><u>
					<span class="style2">Name </span></u></th>
					<th width="96" scope="col"><u>
					<span class="style2">Employee Id </span></u></th>
					<th scope="col"><u>
					<span class="style2"></span></u></th>
					</tr>
				<c:forEach var="employee" items="${employeeList}" varStatus="i">
				<tr>
					<td id="employeeName_${i.index}">${employee.employeeName}</td>
					<td id="employeeId_${i.index}">${employee.employeeId}</td>
					<td><input type="checkbox" size="25" id="employee_${i.index}" value="${employee.phoneNo }" name="extra" class="fl" style="margin-right: 10px; ">
					</input> </td>
					
				</tr>
			</c:forEach>
				</table>
				<br />
				<button class="left" name="action" value="send">Send</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
			</div>
			
			<div style="float:left">
			<span><b>Extra List</b></span>
				<table border="">
					<tr>
					<th width="96" scope="col"><u>
					<span class="style2">Name </span></u></th>
					<th width="96" scope="col"><u>
					<span class="style2">Phone No </span></u></th>
					<th scope="col"><u>
					<span class="style2"></span></u></th>
					</tr>
				<c:forEach var="extra" items="${extraList}" varStatus="i">
				<tr>
					<td>${extra.name}</td>	
					<td>${extra.phoneNo}</td>
					<td><input type="checkbox" size="25" name="extra" value="${extra.phoneNo }" id="extra_${i.index}" class="fl" style="margin-right: 10px;" /> </td>
					
				</tr>
			</c:forEach>
				</table>
				
			</div>
			
		</form:form>
<br/>
	</article>
	<div>
	<br/>
	</div>
        <!-- Footer -->
        <div id="footer">
		<hr />
		Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a> All
		rights reserved. <span class="notprinted"> <a href="index.html">Terms
				of Use</a>. <a href="index.html">Privacy Policy</a>.
		</span> <br /> This web site is maintained by <a href="http://www.dsisoftware.net"
			target="_blank">www.dsisoftware.net</a>.

	</div>
	</body>
</html>