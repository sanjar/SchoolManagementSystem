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
				| <a href="">Contact</a> |

			</p>
		</div>
	</div>
     <article>

		<form:form class="mrg-top" id="generalLedger"
			action="generalLedger" method="POST">

			<ul>

				<li class="f">
					<h3 class="back">General Ledger Entry</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				
				<li class="f">
					<c:if test="${generalLedgerSaved}">
						<label style="color: green">General Ledger Saved!!!</label>
					</c:if> <c:if test="${generalLedgerDeleted}">
						<label style="color: green">General Ledger Delelted!!!</label>
					</c:if> 
					<c:if test="${noGeneralLedgerFound}">
						<span style="color:red">No General Ledger Found.</span>
					</c:if>
				</li>
	
				<li class="f"><label for="name" class="fl">GL Code<span style="color: red">*</span></label> 
				<form:input	type="text" size="25" id="glCode" class="fl" path="glCode" cssStyle="margin-right: 10px;"/> 
				</li>

				<li class="f"><label for="name" class="fl">Name<span style="color: red">*</span></label> 
						<form:input type="text" size="25" id="name" class="fl" path="name" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Sub Ledger Code Required<span style="color: red">*</span> </label> 
						<form:checkbox size="25" id="subLedgerCodeRequired" class="fl" path="subLedgerCodeRequired" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Personal Code Required</label> 
						<form:checkbox size="25" id="personalCodeRequired" class="fl" path="personalCodeRequired" style="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Order Code Required </label> 
						<form:checkbox size="25" id="orderCodeRequired" class="fl" path="orderCodeRequired" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Telephone Required</label> 
						<form:checkbox size="25" style="margin-right:10px" id="telephoneRequired" class="fl" path="telephoneRequired" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">B&L,B/s Code</label> 
						<form:input type="text" size="25" id="PLBSCode" class="fl" path="PLBSCode" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Average Balance Code</label> 
						<form:input type="text" size="25" id="averageBalanceCode" class="fl" path="averageBalanceCode" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">TDS Percentage</label> 
						<form:input type="text" size="25" id="TDSPercentage" class="fl" path="TDSPercentage" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">STX Percentage</label> 
						<form:input type="text" size="25" id="STXPercentage" class="fl" path="STXPercentage" style="margin-right:10px"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">investment </label> 
						<form:checkbox size="25" id="investment" class="fl" path="investment" cssStyle="margin-right: 10px;"/> 
				</li>
				

				<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="delete">Delete</button>
				 <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button>
				<button class="left" name="action" value="new">New</button>	
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