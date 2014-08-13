<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Purchase</title>
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-screen.css' />" type="text/css"
	media="screen" />
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-print.css' />" type="text/css"
	media="print" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement'
	rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js">
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script src="<c:url value='/resources/js/multi.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/resources/js/jquery.uniform.min.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
      $(function(){
        $("input:checkbox, input:radio, input:file, select").uniform();
        $( "#dateOfCreation" ).datepicker({
            showOn: "button",
            dateFormat: "dd/mm/yy",
            disabled: false,
            buttonImage: "<c:url value='/resources/images/calendar.png'/>",
            buttonImageOnly: true
        });
      });
      
    </script>
    <script type="text/javascript">
    $(document).ready(function(){
    	/* $('#manageProduct').click(function(event){
			event.preventDefault();
			window.open('manageProduct',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		});
		$('#purchaseReceipt').click(function(event){
			event.preventDefault();
			window.open('purchaseReceipt',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		}); */
    	
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
				| <a href="">Contact</a> | <a id="manageProduct" href="manageProduct">Manage Product</a> |<a id="purchaseReceipt" href="purchaseReceipt">Purchase Receipt</a> | <a id="salesReceipt" href="salesReceipt">Sales Receipt</a> 

			</p>
		</div>
	</div>







	<article>

		<form:form class="mrg-top" id="manageCustomer"
			action="manageCustomer">

			<ul>

				<li class="f">
					<h3 class="back">Customer Creation</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				
				<li class="f"><label for="name" class="fl">Customer Code<span style="color: red">*</span></label> <form:input
					type="text" size="25" id="customerCode" class="fl" path="customerCode" />
					<button class="left" name="action" value="search" style="margin-left: 30px">Search</button>
					<c:if test="${noCustomerFound}">
						<label style="color:red">No Customer Found.</label>
					</c:if>
					<c:if test="${customerSaved}">
						<label style="color: green">Customer Saved!!!</label>
					</c:if> <c:if test="${customerDeleted}">
						<label style="color: green">Customer Deleted!!!</label>
					</c:if> 
				</li>


				<li class="f"><label for="name" class="fl">Customer Type<span style="color: red">*</span></label> 
				<form:select
						path="customerType" class="fl">
						<option value="-1">Please Select Type</option>
						<form:options items="${customerType}"/>
					</form:select>
					
				</li>
					
					
					
				<li class="f"><label for="name" class="fl">Customer Name<span style="color: red">*</span></label> 
				<form:input	type="text" size="25" id="customerName" class="fl" path="customerName" /> 
				</li>

				<li class="f"><label for="name" class="fl">Address<span style="color: red">*</span></label> 
						<form:input type="text" size="25" id="address" class="fl" path="address" /> 
				</li>
				<li class="f"><label for="name" class="fl">PIN<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="pin" class="fl" path="pin" /> 
				</li>
				<li class="f"><label for="name" class="fl">Phone<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" id="phone" class="fl" path="phone" /> 
				</li>
				<li class="f"><label for="name" class="fl">Contact Person</label> 
						<form:input type="text" size="25" id="contactPerson" class="fl" path="contactPerson" /> 
				</li>
				<li class="f"><label for="name" class="fl">Tin No. </label> 
						<form:input type="text" size="25" id="tinNo" class="fl" path="tinNo" /> 
				</li>
				<li class="f"><label for="name" class="fl">Date<span style="color: red">*</span> </label> 
						<form:input type="text" size="25" style="margin-right:10px" id="dateOfCreation" class="fl" path="dateOfCreation" /> 
				</li>
				

				<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="delete">Delete</button>
				 <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button>
				 <button class="left" name="exit" value="exit" onclick="window.close(); return false;">Exit</button>
				</li>
				</ul>
		</form:form>

	</article>
	<div id="footer">
		<hr />
		Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a> All
		rights reserved. <span class="notprinted"> <a href="index.html">Terms
				of Use</a>. <a href="index.html">Privacy Policy</a>.
		</span> <br /> This web site is maintained by <a href="http://www.dsisoftware.net"
			target="_blank">www.dsisoftware.net</a>.

	</div>