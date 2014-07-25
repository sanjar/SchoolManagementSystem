<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Transport Management</title>
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-screen.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-print.css'/>" type="text/css"
	media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/form3.css'/>" />
<link href='http://fonts.googleapis.com/css?family=Engagement'
	rel='stylesheet' type='text/css'>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script src="<c:url value='/resources/js/multi.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/resources/js/jquery.uniform.min.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$("input:checkbox, input:radio, input:file, select").uniform();
	});
	
	$(document).ready(function(){
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
			<a href="">Contact</a> |

			</p>
		</div>
	</div>







	<article>

		<form:form class="mrg-top" id="new" action="manageTransportFee">

			<ul>
				
				<li class="f">
					<h3 class="back">Transport Management</h3>
				</li>

				<c:if test="${transportRoutePickUpSaved}">
					<li class="f">
						<span style="color: green">Transport Route PickUp Saved!!!</span>
						</li>
					</c:if> <c:if test="${transportRoutePickUpDeleted}">
					<li class="f">
						<span style="color: green">Transport Route PickUp Deleted!!!</span>
						</li>
					</c:if>
					<c:if test="${isFormIncomplete}">
					  <li class="f">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
						</li>
				</c:if>
				<c:if test="${noTransportRoutePickUpFound}">
				<li class="f">
						<span style="color:red">No Transport PickUp  Found.</span>
						</li>
					</c:if>
				<li class="f"><label for="name" class="fl">Route Code<span style="color: red">*</span> </label>
				<form:select
						path="routeCode">
						<option value="-1">Please Select</option>
						<form:options items="${routeCodeList}" itemLabel="routeCode" itemValue="routeCode"/>
					</form:select></li>

				<li  class="f">
					<label for="name" class="fl">PickUp Point Id<span style="color: red">*</span> </label> 
								<form:input path="pickUpId" />
							
				
				</li>
				<li  class="f">
					<label for="name" class="fl">PickUp Point Name </label> 
								<form:input path="pickUpName" />
							
				
				</li>

				<li class="f"><label for="name" class="fl">Vehicle Id<span style="color: red">*</span> </label> 
				<form:select
						path="vehicleId">
						<option value="-1">Please Select</option>
						<form:options items="${vehicleList}" itemLabel="vehicleId" itemValue="vehicleId"/>
					</form:select>
					
					
					</li>

					<li  class="f">
					<label for="name" class="fl">PickUp Time </label> 
								<form:input path="pickUpTime" />
								
					<button  name="action" value="Search">Search</button>
					
				
				</li>
				
					
					
				<li class="f">
					<div class="main-fees">
						<div class="main-fees1">

							<div class="main-fees-h">
								<strong>No.</strong>
							</div>

							<div class="main-fees-h">1</div>

							<div class="main-fees-h">2</div>


							<div class="main-fees-h">3</div>


							<div class="main-fees-h">4</div>

							<div class="main-fees-h">5</div>

							<div class="main-fees-h">6</div>
							<div class="main-fees-h">7</div>
							<div class="main-fees-h">8</div>
							<div class="main-fees-h">9</div>
							<div class="main-fees-h">10</div>
							<div class="main-fees-h">11</div>
							<div class="main-fees-h">12</div>
							

						</div>

						<div class="main-fees2">
							<div class="main-fees-h1">
								<strong>Month</strong>
							</div>

							<div class="main-fees-h1">January</div>

							<div class="main-fees-h1">February</div>

							<div class="main-fees-h1">March</div>


							<div class="main-fees-h1">April</div>

							<div class="main-fees-h1">May</div>
							<div class="main-fees-h1">June</div>

							<div class="main-fees-h1">July</div>
							<div class="main-fees-h1">August</div>
							<div class="main-fees-h1">September</div>
							<div class="main-fees-h1">October</div>
							<div class="main-fees-h1">November</div>
							<div class="main-fees-h1">December</div>
							


						</div>

						<div class="main-fees3">
							<div class="main-fees-h2">
								<strong> Amount </strong>
							</div>
							<div>
								<form:input path="pickUpMasterId" type="hidden" />
							</div>
							<div class="main-fees-h2">
								<form:input path="transportCostJan" />

							</div>

							<div class="main-fees-h2">
								<form:input path="transportCostFeb" />

							</div>


							<div class="main-fees-h2">
								<form:input path="transportCostMar" />
							</div>

							<div class="main-fees-h2">
								<form:input path="transportCostApr" />
							</div>


							<div class="main-fees-h2">
								<form:input path="transportCostMay" />
							</div>

							<div class="main-fees-h2">
								<form:input path="transportCostJun" />
							</div>


							<div class="main-fees-h2">
								<form:input path="transportCostJul" />
							</div>
							
							<div class="main-fees-h2">
								<form:input path="transportCostAug" />
							</div>
							
							<div class="main-fees-h2">
								<form:input path="transportCostSep" />
							</div>
							
							<div class="main-fees-h2">
								<form:input path="transportCostOct" />
							</div>
							
							<div class="main-fees-h2">
								<form:input path="transportCostNov" />
							</div>
							
							<div class="main-fees-h2">
								<form:input path="transportCostDec" />
							</div>


						</div>

					</div>
				</li>

				<li class="f">
					<button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="delete">Delete</button>
				 <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button>
				<button class="left" name="action" value="new">New</button>	
				<button class="left" name="exit" value="exit" onclick="window.close(); return false;">Exit</button>
				</li>
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