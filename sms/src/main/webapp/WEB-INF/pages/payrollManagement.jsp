<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>A School Management Template</title>

<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-screen.css' />" type="text/css"
	media="screen" />
<link rel="StyleSheet"
	href="<c:url value='/resources/css/main-print.css' />" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/login-box.css' />"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/style1.css' />" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script>
	$(document)
			.ready(
					function() {
						function checkFileSelection() {
							alert("fff");
							if ("" == $('#file').val()) {
								$('#fileSelectionError').css("display:inline");
								return;
							}
							document.backuprestore.submit();
						}

					/* 	$('#manageEmployeeMaster')
								.click(
										function(event) {
											event.preventDefault();
											window
													.open(
															'payrollManagement/manageEmployeeMaster',
															"_blank",
															'scrollbars=1,toolbar=0,location=0,menubar=0');
										}); */
						/* $('#manageGradeMaster')
								.click(
										function(event) {
											event.preventDefault();
											window
													.open('payrollManagement/manageGradeMaster',
															"_blank",
															'scrollbars=1,toolbar=0,location=0,menubar=0');
										}); */
						/* $('#manageSalaryMaster')
								.click(
										function(event) {
											event.preventDefault();
											window
													.open(
															'payrollManagement/manageSalaryMaster',
															"_blank",
															'scrollbars=1,toolbar=0,location=0,menubar=0');
										}); */
						/* $('#manageDepartmentMaster')
						.click(
								function(event) {
									event.preventDefault();
									window
											.open(
													'payrollManagement/manageDepartmentMaster',
													"_blank",
													'scrollbars=1,toolbar=0,location=0,menubar=0');
								}); */
						/* $('#processSalary')
						.click(
								function(event) {
									event.preventDefault();
									window
											.open(
													'payrollManagement/processSalary',
													"_blank",
													'scrollbars=1,toolbar=0,location=0,menubar=0');
								}); */
					});
</script>
<style type="text/css">
.style2 {
	color: #0080FF
}
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
				<span class="hidden">Navigation:</span> <a id="manageEmployeeMaster"
					href="payrollManagement/manageEmployeeMaster">Manage Employee Master</a> | <a id="manageGradeMaster"
					href="payrollManagement/manageGradeMaster">Manage Grade Master</a> | <a id="manageSalaryMaster"
					href="payrollManagement/manageSalaryMaster">Manage Salary Master</a> |<a id="manageDepartmentMaster"
					href="payrollManagement/manageDepartmentMaster">Manage Department Master</a>|<a id="processSalary" href="payrollManagement/processSalary">Process
					Salary</a> 

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->



	<!-- ======== Main Content ======== -->
	<div id="sidebar1">


		<table width="1224" border="1">
			<tr>
				<th width="95" scope="col"><u>
					<span class="style2">Employee Id</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">Employee Name</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">Gender</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">DOB </span></u></th>
				<th width="96" scope="col"><u>
					<span class="style2">DOJ </span></u></th>
				<th width="80" scope="col"><u>
					<span class="style2">Designation</span></u></th>
				<th width="88" scope="col"><u>
					<span class="style2">ICard No</span></u></th>
				<th width="76" scope="col"><u>
					<span class="style2">EPS No</span></u></th>
				<th width="76" scope="col"><u>
					<span class="style2">ESI No</span></u></th>
				<th width="76" scope="col"><u>
					<span class="style2">PAN No</span></u></th>
				<th width="65" scope="col"><u>
					<span class="style2">PF No</span></u></th>
				<th width="84" scope="col"><u>
					<span class="style2">Bank A/c No </span></u></th>
				<th width="60" scope="col"><u>
					<span class="style2">Department </span></u></th>
				<th width="68" scope="col"><u>
					<span class="style2">Grade </span></u></th>
				<th width="93" scope="col"><u>
					<span class="style2">Salary Code</span></u></th>
			</tr>
			<c:forEach var="employeeMaster" items="${employeeMasterList}">
				<tr>
					<td>${employeeMaster.employeeId}</td>
					<td>${employeeMaster.employeeName}</td>
					<td>${employeeMaster.gender}</td>
					<td>${employeeMaster.dateOfBirth}</td>
					<td>${employeeMaster.dateOfJoining}</td>
					<td>${employeeMaster.designation}</td>
					<td>${employeeMaster.iCardNo}</td>
					<td>${employeeMaster.EPSNo}</td>
					<td>${employeeMaster.ESINo}</td>
					<td>${employeeMaster.PANNo}</td>
					<td>${employeeMaster.PFNo}</td>
					<td>${employeeMaster.bankAccountNo}</td>
					<td>${employeeMaster.department.departmentName}</td>
					<td>${employeeMaster.grade.gradeId}</td>
					<td>${employeeMaster.salaryCode}</td>
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
