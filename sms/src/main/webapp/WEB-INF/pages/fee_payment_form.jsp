<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Fee Payment Form</title>
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-screen.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-print.css'/>" type="text/css"
	media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/collection.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/form3.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/var.css'/>" />
<link href='http://fonts.googleapis.com/css?family=Engagement'
	rel='stylesheet' type='text/css'>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="<c:url value='/resources/js/multi.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/resources/js/jquery.uniform.min.js'/>"
	type="text/javascript" charset="utf-8"></script>
	<script src="<c:url value='/resources/js/main.js'/>"
	type="text/javascript" charset="utf-8"></script>
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$("input:checkbox, input:radio, input:file, select").uniform();
		
	});
	
	$(document).ready(function(){
		
		function validateGetDetails(){
			var enrolementNo= $('#enrolementNo').val();
			if(enrolementNo==""){
				$('#enrolementNoMissing').show();
				return false;
			}
			return true;
		}
		/* $('#lateFine').change(function(){
			calculateTotalAmount(this.value,true);
		});
		$('#previousDue').change(function(){
			calculateTotalAmount(this.value,true);
		});
		$('#otherFine').change(function(){
			calculateTotalAmount(this.value,true);
		});
		$('#discount').change(function(){
			calculateTotalAmount(this.value,false);
		});
		$('#concession').change(function(){
			calculateTotalAmount(this.value,false);
		});
		
		function calculateTotalAmount(amount,isToBeAdded){
			var totalAmount = $('#totalAmount').val();
			if(isToBeAdded){
				$('#totalAmount').val(totalAmount+amount);
			}
			else{
				$('#totalAmount').val(totalAmount-amount);
			}
		} */
		
		$("#feePayment").validate({
			rules: {
				enrolementNo:"required",
				receiptNo:"required"
			},
			messages: {
				enrolementNo:"<br>Please enter Enrolement No",
				receiptNo:"<br>Please enter Receipt No"
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
		<li class="f" id="c-top">
			<h3 class="back33">Fixed Fee Details</h3>
		</li>
		<div class="main_colle">
		<form:form class="c" action="feePayment" method="POST" id="feePayment">
			<div class="main_coll_cover">
				
					<div class="coll_left">
						<ul class="c1">
						<c:if test="${studentNotfound}">
						<li class="f">
						<label style="color:red">No Student details found</label>
						</li>
						</c:if>
							<li class="f"><label for="name" class="fl">Manual
									Reciept Number:</label> <form:input type="text" size="15" id="receiptNo"
								class="fl numeric" path="receiptNo" /></li>
								<li class="f digit" style="color: Red; display: none">
								<span>* Input digits (0 - 9)</span>
								</li>
							<li class="f"><label for="name" class="fl">Enter
									Enrollment Number:</label> <form:input type="text" size="15" id="enrolementNo"
								class="fl" path="enrolementNo" /></li>
							<li class="f"><label for="name" class="fl">Select Batch </label> 
								<form:select
									path="batch">
									<form:option value="-1">Please Select</form:option>
									<form:options items="${studentClassBatchList}"/>
								</form:select>
								</li>
	
								<li class="f"><label for="name" class="fl">Student Name:</label>
								<span>${command.studentName}</span>
								
								</li>
								<li class="f"><label for="name" class="fl">Student Batch:</label>
								<span>${command.batch}</span>
								
								</li>
								
								<li class="f"><label for="name" class="fl">Student Session:</label>
								<%-- <span>${command.session}</span> --%>
								<form:input type="text" size="15" id="session"
								class="fl" path="session" />
								
								</li>
								
								<li class="f"><label for="name" class="fl">select Month:</label> 
										
									<form:select id="month" path="month">
										<form:options items="${monthList}"/>
								</form:select></li>
								<%-- <li class="f">
								<form:select
									path="studentName" size="6">
									<form:option value="-1">Please Select</form:option>
									<c:forEach items="${studentFatherEnrolemenMap}" var="map">
									
										<c:choose>
										<c:when test="${map.value==command.studentName}">
											<form:option value="${map.value}" selected="selected">${map.key}</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${map.value}">${map.key}</form:option>
										</c:otherwise>
										</c:choose>
			
			
			
			
									</c:forEach>
			
								</form:select>
								</li> --%>

						</ul>
					</div>

				


				<div class="coll_left" id="mtop">
					<div class="part" id="fetchh3" style="width:751px;border-style: double;border-width: thin;">
<table width="750" border="1" >
  <tr>
    <th width="50" scope="col"><u><span class="style2">Month</span></u></th>
    <th width="50" scope="col"><u><span class="style2">Fee</span></u></th>
    <th width="50" scope="col"><u><span class="style2">Dis</span></u></th>
    <th width="50" scope="col"><u><span class="style2">Con </span></u></th>
    <th width="50" scope="col"><u><span class="style2">Fine </span></u></th>
    <th width="50" scope="col"><u><span class="style2">Received </span></u></th>
    <th width="50" scope="col"><u><span class="style2">Pending </span></u></th>
    <th width="50" scope="col"><u><span class="style2">Receipt No</span></u></th>
    
  </tr>
  <c:forEach var="details" items="${studenFeeDetailstList}">
  <tr>
    <td>${details.month}</td>
    <td>${details.totalAmount}</td>
    <td>${details.discount}</td>
    
    <td>${details.concession}</td>
    <td>${details.lateFine+details.otherFine}</td>
    <td>${details.amountReceived}</td>
    <td>${details.previousDue}</td>
    <td>${details.receiptNo}</td>
    
  </tr>
  </c:forEach>
</table>
					
						
					</div>
				</div>
			</div>

			<div id="mtop">
				<div class="main_coll_submit">
					<div style="margin-left: 500px;">
						<button class="left" value="getDetails" name="action" onclick="validateGetDetails();">
							<strong>Get Fee Details</strong>
						</button>
					</div>
				</div>
				<div class="main_coll_blo" id="mtop">
					<div class="main_coll_below">
						<div class="coll_left">
							<div class="part_be" id="fetchh3" style="width:501px;border-style: double;border-width: thin;height:500px">
							
							<table width="500" border="1" >
								  <tr>
								    <th width="10" scope="col"><u><span class="style2">No</span></u></th>
								    <th width="10" scope="col"><u><span class="style2">T/U</span></u></th>
								    <th width="60" scope="col"><u><span class="style2">Fixed Fee Header</span></u></th>
								    <th width="30" scope="col"><u><span class="style2">${command.month}</span></u></th>
								    <th width="20" scope="col"><u><span class="style2">Discount</span></u></th>
								    <th width="30" scope="col"><u><span class="style2">Total </span></u></th>
								    
								  </tr>
								  <c:forEach items="${fixedFeeMap}" varStatus="x" var="map" >
								  <tr>
								    <td>${x.index+1}</td>
								    <td><input type="checkbox" name="includeFee" checked="checked" disabled="disabled"/></td>
								    <td>${map.key}</td>
								    
								    <td>${map.value}</td>
								    <td></td>
								    <td>${map.value}</td>
								    
								  </tr>
								  </c:forEach>
								</table>
							</div>

						</div>
					</div>
					<div class="main_coll_below2">
						<div class="coll_left">
							<ul class="c1">
								
								<li class="f"><label for="name" class="fl">Previous
										Dues:</label> 
										<form:input type="text" size="25" id="previousDue" class="fl" path="previousDue" /></li>
								<li class="f"><label for="name" class="fl">Late
										Fine:</label> 
										<form:input type="text" size="25" id="lateFine" class="fl" path="lateFine"/></li>
								<li class="f"><label for="name" class="fl">Other
										Fine:</label> 
										<form:input type="text" size="25" id="otherFine" class="fl" path="otherFine" /></li>
								<li class="f"><label for="name" class="fl">Discount:</label>
									<form:input type="text" size="25" id="discount" class="fl" path="discount" /></li>
								<li class="f"><label for="name" class="fl">Concession:</label>
									<form:input type="text" size="25" id="concession" class="fl" path="concession" /></li>
								
								<li class="f"><label for="name" class="fl">Total
										Amount:</label> 
										<form:input type="text" size="25" id="totalAmount" class="fl" path="totalAmount" />


								</li>
								<li class="f"><label for="name" class="fl">Mode of
										payment:</label> 
										
									<form:select id="modeOfPayment" path="modeOfPayment">
										<form:options items="${modeOfPaymentList}"/>
								</form:select></li>

								<li class="f"><label for="name" class="fl">Cheque/Draft
										No:</label> 
										<form:input type="text" size="25" id="name" class="fl" path="chequeDraftNo" /></li>
								<li class="f"><label for="name" class="fl">Cheque/Draft
										Date:</label> 
										<form:input type="text" size="25" id="name" class="fl" path="chequeDraftDate" /></li>
								<li class="f"><label for="name" class="fl">Payment
										Date:</label> 
										<form:input type="text" size="25" id="name" class="fl" path="dateOfPayment" /></li>		
								<li class="f"><label for="name" class="fl">Amount
										Recieved:</label> 
										<form:input type="text" size="25" id="name" class="fl" path="amountReceived" />



								</li>
								<li class="f">
									<button class="left" value="save" name="action" onclick="validateSave();"> Save </button>
									<button class="left" value="calculate" name="action"> Calculate </button>
									<button class="left" value="new" name="action"> Create New </button>
									<button class="left" name="print" value="print" onclick="window.print(); return false;">Print</button>
									<button class="left" name="exit" value="exit" onclick="window.close(); return false;">Exit</button>
								</li>
								<li class="f">
									
								</li>
								<li class="f">
									
								</li>
							</ul>
						</div>


					</div>
				</div>





			</div>
			</form:form>
		</div>
	</article>
<div id="footer">
  <hr />
  Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a>  All rights reserved.
  <span class="notprinted">
    <a href="index.html">Terms of Use</a>.
    <a href="index.html">Privacy Policy</a>.
  </span>
  <br />

  This web site is maintained by
 <a href="http://www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div>