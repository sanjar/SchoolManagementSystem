<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Salary Master Form</title>
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
      });
    </script>
    <script type="text/javascript">
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
				<span class="hidden">Navigation:</span> <a href="" class="highlight">Home</a>
				|  <a href="">Contact</a> |

			</p>
		</div>
	</div>







	<article>

		<form:form class="mrg-top" id="salary_master"
			action="processSalary">

			<ul>

				<li class="f">
					<h3 class="back">Salary Master</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				<c:if test="${salaryProcessInitiated}">
						<span style="color: red">Salary Process Initiated!!!.</span>
				</c:if>
				<li class="f"><label for="name" class="fl">Salary Code<span style="color: red">*</span></label> 
				<form:select path="salaryMaster.salaryId" class="fl">
						<option value="-1">Please Select Salary</option>
						<form:options items="${salaryMasterList}" itemLabel="salaryName" itemValue="salaryId"/>
					</form:select></li>
				


				<li class="f"><label for="name" class="fl">Year <span style="color: red">*</span></label> <form:input
					type="text" size="25" id="year" class="fl" path="year" />
				</li>

				<li class="f"><label for="name" class="fl">Month <span style="color: red">*</span></label> 
				<form:select path="month" class="fl">
						<option value="-1">Please Select Month</option>
						<form:options items="${monthList}"/>
					</form:select>
				</li>

				
				<li class="f"><label for="name" class="fl">Comments </label> 
						<form:textarea type="text" style="width:500px;height:41px" id="comments" class="fl" path="comments" /> 
				</li>

				<br/>

				<li  class="f">
				 <button class="left" name="action" value="process">Process</button>
				 <button class="left" name="action" value="delete" onclick="window.opener=null; window.close(); return false;">Exit</button>
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