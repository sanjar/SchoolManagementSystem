<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Discount and Concession</title>
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

		<form:form class="mrg-top" id="new" action="processDiscountsAndConcessions">

			<ul>

				<li class="f">
					<h3 class="back">Variable Fee Details</h3>
				</li>

				<li class="f"><label for="name" class="fl">Session:</label>
				<form:select
						path="session">
						<option value="-1">Please Select</option>
						<c:forEach items="${sessionList}" var="session1" varStatus="loop">
						<c:choose>
							<c:when test="${session1==command.session}">
								<option value="${session1}" selected="selected">${session1}</option>
							</c:when>
							<c:otherwise>
								<option value="${session1}">${session1}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>

					</form:select></li>


				<li class="f"><label for="name" class="fl">Batch:</label> 
				<form:select
						path="batch">
						<option value="-1">Please Select</option>
						<c:forEach items="${batchList}" var="batch" varStatus="loop">
						
							<c:choose>
							<c:when test="${batch==command.batch}">
								<option value="${batch}" selected="selected">${batch}</option>
							</c:when>
							<c:otherwise>
								<option value="${batch}">${batch}</option>
							</c:otherwise>
							</c:choose>




						</c:forEach>

					</form:select></li>


				<li class="f"><label for="name" class="fl">Month:</label> <form:select
						path="month">
						<option value="-1">Please Select</option>
						<c:forEach items="${monthList}" var="month1" varStatus="loop">
						
						<c:choose>
							<c:when test="${month1==command.month}">
								<option value="${month1}" selected="selected">${month1}</option>
							</c:when>
							<c:otherwise>
								<option value="${month1}">${month1}</option>
							</c:otherwise>
							</c:choose>
						
						
							
						</c:forEach>

					</form:select>
					</li>
					<li class="f"><label for="month" class="fl">Student:</label> <form:select
						path="studentNameClassRoll">
						<option value="-1">Please Select</option>
						<c:forEach items="${studentNameClassRollList}" var="student" varStatus="loop">
						
						<c:choose>
							<c:when test="${student==command.studentNameClassRoll}">
								<option value="${student}" selected="selected">${student}</option>
							</c:when>
							<c:otherwise>
								<option value="${student}">${student}</option>
							</c:otherwise>
							</c:choose>
						
						
							
						</c:forEach>

					</form:select>
					
					<button class="left" name="action" value="Search">Search</button>
					<c:if test="${noFeeStructureFound}">
						<label style="color:red">No Fee Structure Found.</label>
					</c:if>
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
							

						</div>

						<div class="main-fees2">
							<div class="main-fees-h1">
								<strong>Fix Fee Header</strong>
							</div>

							<div class="main-fees-h1">Admission Charges Discount</div>

							<div class="main-fees-h1">Activity Fee Discount</div>

							<div class="main-fees-h1">Hostel Charges Discount</div>


							<div class="main-fees-h1">CCE Charges Discount</div>

							<div class="main-fees-h1">Maintainance Fee Discount</div>
							<div class="main-fees-h1">Music Fee Discount</div>
							<div class="main-fees-h1">Misc. Fee Discount</div>
							<div class="main-fees-h1">Examination Fee Discount</div>
							<div class="main-fees-h1">Book Fee Discount</div>
							<div class="main-fees-h1">ICard Fee Discount</div>
							<div class="main-fees-h1">Library Fee Discount</div>
							
							


						</div>

						<div class="main-fees3">
							<div class="main-fees-h2">
								<strong> Amount </strong>
							</div>
							<div>
								<form:input path="discountsConscessionsId" type="hidden" />
							</div>
							<div class="main-fees-h2">
								<form:input path="addmissionChargesDiscount" />

							</div>

							<div class="main-fees-h2">
								<form:input path="activityFeeDiscount" />

							</div>


							<div class="main-fees-h2">
								<form:input path="hostelChargesDiscount" />
							</div>

							<div class="main-fees-h2">
								<form:input path="cceChargesDiscount" />
							</div>


							<div class="main-fees-h2">
								<form:input path="maintainanceFeeDiscount" />
							</div>

							<div class="main-fees-h2">
								<form:input path="musicFeeDiscount" />
							</div>


							<div class="main-fees-h2">
								<form:input path="miscFeeDiscount" />
							</div>
							<div class="main-fees-h2">
								<form:input path="examinationFeeDiscount" />
							</div>
							<div class="main-fees-h2">
								<form:input path="bookFeeDiscount" />
							</div>
							<div class="main-fees-h2">
								<form:input path="icardFeeDiscount" />
							</div>
							<div class="main-fees-h2">
								<form:input path="LibraryFeeDiscount" />
							</div>
							

						</div>
						<div class="main-fees3">
							<div class="main-fees-h2">
								<strong> Percentage </strong>
							</div>
							<div class="main-fees-h2">
								<form:input path="addmissionChargesDiscountPercentage" />

							</div>

							<div class="main-fees-h2">
								<form:input path="activityFeeDiscountPercentage" />

							</div>


							<div class="main-fees-h2">
								<form:input path="hostelChargesDiscountPercentage" />
							</div>

							<div class="main-fees-h2">
								<form:input path="cceChargesDiscountPercentage" />
							</div>


							<div class="main-fees-h2">
								<form:input path="maintainanceFeeDiscountPercentage" />
							</div>

							<div class="main-fees-h2">
								<form:input path="musicFeeDiscountPercentage" />
							</div>


							<div class="main-fees-h2">
								<form:input path="miscFeeDiscountPercentage" />
							</div>
							<div class="main-fees-h2">
								<form:input path="examinationFeeDiscountPercentage" />
							</div>
							<div class="main-fees-h2">
								<form:input path="bookFeeDiscountPercentage" />
							</div>
							<div class="main-fees-h2">
								<form:input path="icardFeeDiscountPercentage" />
							</div>
							<div class="main-fees-h2">
								<form:input path="LibraryFeeDiscountPercentage" />
							</div>
							

						</div>

					</div>
				</li>

				<li class="f">
					<button type="" class="left" name="action" value="save">Save</button>
					<button type="" class="left"name="action" value="delete">Delete</button>
					<button type="" class="left"name="action" value="next">Next</button>
					<button type="" class="left"name="action" value="previous">Previous</button>
					<button type="" class="left"name="action" value="first">First</button>
					<button type="" class="left"name="action" value="last">Last</button>
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