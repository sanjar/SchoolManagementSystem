<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Fee Management</title>

<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/login-box.css' />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/style1.css' />"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script>
	$(document).ready(function(){ 
		function checkFileSelection(){
			alert("fff");
			if(""== $('#file').val()){
			$('#fileSelectionError').css("display:inline");
			return;
			}
			document.backuprestore.submit();
		}
		
		/* $('#manageFixedFee').click(function(event){
			event.preventDefault();
			window.open('manageFixedFee',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		});
		$('#manageVariableFee').click(function(event){
			event.preventDefault();
			window.open('manageVariableFee',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		});
		$('#manageDiscountsAndConcessions').click(function(event){
			event.preventDefault();
			window.open('manageDiscountsAndConcessions',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		});
		
		$('#feePayment').click(function(event){
			event.preventDefault();
			window.open('feePayment',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		}); */
	});
</script>
<style type="text/css">
	.style2{color:#0080FF}
</style>
</head>

<body>

	<!-- ======== Header ======== -->

	<div id="header">
		<div class="left">
			<p>
				<a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a>
			</p>
		</div>

		

		<div class="subheader">
			<p>
				<span class="hidden">Navigation:</span> <a id="manageFixedFee"
					href="manageFixedFee">Manage Fixed Fee</a> | <a id="manageVariableFee" href="manageVariableFee">Manage
					Variable Fee</a> | <a id="manageDiscountsAndConcessions" href="manageDiscountsAndConcessions">Manage
					Discounts and Concessions</a> | <a id="feePayment" href="feePayment">Fee Payment</a> |

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->



	<!-- ======== Main Content ======== -->
<div id="sidebar1" >							
			
				
			<table width="1224" border="1">
  <tr>
    <th width="95" scope="col"><u><span class="style2">Session</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Batch</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Month</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Examination Fee </span></u></th>
    <th width="96" scope="col"><u><span class="style2">Maintainance Fee </span></u></th>
    <th width="80" scope="col"><u><span class="style2">Tuition Fee </span></u></th>
    <th width="88" scope="col"><u><span class="style2">Report Card Fee </span></u></th>
    <th width="76" scope="col"><u><span class="style2">Book Fee</span></u></th>
    <th width="76" scope="col"><u><span class="style2">Icard Fee</span></u></th>
    <th width="76" scope="col"><u><span class="style2">Water &amp; Electric Fee</span></u></th>
    <th width="65" scope="col"><u><span class="style2">Misc Fee </span></u></th>
    <th width="84" scope="col"><u><span class="style2">Sports &amp; Culture Fee </span></u></th>
    <th width="60" scope="col"><u><span class="style2">Library Fee </span></u></th>
    <th width="68" scope="col"><u><span class="style2">Activity Fee </span></u></th>
    <th width="93" scope="col"><u><span class="style2">Registration Fee </span></u></th>
  </tr>
  <c:forEach var="fixedFee" items="${listFixedFeeStructure}">
  <tr>
    <td>${fixedFee.session}</td>
    <td>${fixedFee.batchId}</td>
    <td>${fixedFee.month}</td>
    <td>${fixedFee.examinationFee}</td>
    <td>${fixedFee.maintainanceFee}</td>
    <td>${fixedFee.tuitionFee}</td>
    <td>${fixedFee.reportCardFee}</td>
    <td>${fixedFee.bookFee}</td>
    <td>${fixedFee.icardFee}</td>
    <td>${fixedFee.waterElectricFee}</td>
    <td>${fixedFee.miscFee}</td>
    <td>${fixedFee.sportsCultureFee}</td>
    <td>${fixedFee.libraryFee}</td>
    <td>${fixedFee.activityFee}</td>
    <td>${fixedFee.registrationFee}</td>
  </tr>
  </c:forEach>
</table>
            
		</div>




	









	<br id="endmain" />



	<!-- ======== Footer ======== -->

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
