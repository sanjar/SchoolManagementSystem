<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Other Payments</title>
	 	
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

		<form:form class="mrg-top" id="otherPayments" name="otherPayments"
			action="otherPayments">

			<ul>

				<li class="f">
					<h3 class="back">Other Payments</h3>
				</li>
				<c:if test="${noOtherPaymentFound}">
						<span style="color: red">Atleast Receipt, Mobile No or Name is required for Search.</span>
				</c:if>
				<c:if test="${otherPaymentProcessed}">
						<label style="color: green">Payment Processed!!!</label>
					</c:if> 
				<li class="f"><label for="name" class="fl">Receipt No</label> 
				<form:input	type="text" size="25" id="receiptNo" class="fl" path="receiptNo" cssStyle="margin-right: 10px;"/> 
				</li>

				<li class="f"><label for="name" class="fl">Name<span style="color: red">*</span></label> 
						<form:input type="text" size="25" id="name" class="fl" path="name" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Mobile No<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="mobileNo" class="fl" path="mobileNo" cssStyle="margin-right: 10px;"/> 
				</li>
				
				
				<li class="f" style="min-height:100px"><label for="name" class="fl">Address <span style="color: red">*</span> </label> 
						<form:textarea type="text"  id="address"  class="fl" path="address" cssStyle="margin-right: 10px;height:87px;width:280px" /> 
				</li>
				
				
				<li class="f"><label for="name" class="fl">Purpose<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="purpose" class="fl" path="purpose" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Payment Amount<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="paymentAmount" class="fl" path="paymentAmount" cssStyle="margin-right: 10px;"/> 
				</li>
				<li class="f"><label for="name" class="fl">Comments</label> 
						<form:input type="text" size="25" id="comments" class="fl" path="comments" cssStyle="margin-right: 10px;"/> 
				</li>
				
				<li class="f"><label for="name" class="fl">Date Of Payment<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="paymentDate" class="fl dateField" path="paymentDate" readonly="true" style="margin-right:10px"/> 
				</li>
				
				

				<li  class="f">
				 <button class="left" name="action" value="process">Process Payment</button>
				 <button class="left cancel" name="action" value="reset">Reset</button>
				  <button class="left cancel" name="action" value="search">Search</button>
				  <button class="left" name="print" value="print" onclick="window.print(); return false;">Print</button>
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