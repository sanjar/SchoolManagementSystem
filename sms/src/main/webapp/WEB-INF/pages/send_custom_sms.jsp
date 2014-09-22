<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Send Custom SMS</title>
	 	
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
	 
	 $("#otherPayments").validate({
			rules: {
				/* enrolementNo:"required", */
				name:"required",
				mobileNo:"required",
				address:"required",
				purpose:"required",
				paymentAmount:"required",
				paymentDate:"required"
				
			},
			messages: {
				/* enrolementNo:"Enter Enrolement No.", */
				name:"Enter Name.",
				mobileNo:"Enter Mobile No.",
				address:"Enter Address.",
				purpose:"Enter Purpose of Payment.",
				paymentAmount:"Enter Amount Paid.",
				paymentDate:"Enter Payment Date."
				
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

		<form:form class="mrg-top" id="sendCustomSMS" name="sendCustomSMS"
			action="sendCustomSMS">

			<ul>

				<li class="f">
					<h3 class="back">Send Custom SMS</h3>
				</li>
				<%-- <c:if test="${noOtherPaymentFound}">
						<span style="color: red">Atleast Receipt, Mobile No or Name is required for Search.</span>
				</c:if> --%>
				<c:if test="${smsSent}">
						<label style="color: green">SMS Sent!!!</label>
					</c:if> 
				<li class="f"><label for="name" class="fl">Mobile No</label> 
				<form:input	type="text" size="25" id="mobileNo" class="fl" path="mobileNo" cssStyle="margin-right: 10px;"/> 
				</li>

				
				<li class="f"><label for="name" class="fl">Date<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="date" class="fl dateField" path="date" readonly="true" style="margin-right:10px"/> 
				</li>
				<li class="f" style="min-height:100px"><label for="name" class="fl">SMS Content <span style="color: red">*</span> </label> 
						<form:textarea type="text"  id="smsContent"  class="fl" path="smsContent" cssStyle="margin-right: 10px;height:87px;width:280px" /> 
				</li>
				

				<li  class="f">
				 <button class="left" name="action" value="send">Send SMS</button>
				 <button class="left cancel" name="action" value="reset">Reset</button>
				  <!-- <button class="left cancel" name="action" value="search">Search</button> -->
				  <!-- <button class="left" name="print" value="print" onclick="window.print(); return false;">Print</button> -->
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