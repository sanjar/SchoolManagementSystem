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
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
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
    	/* $("#salary_master").validate({
    		rules: {
    			salaryId:"required",
    			gradeId: {
    	            required: {
    	                depends: function(element) {
    	                    return $("#gradeId").val() == -1;
    	                }
    	            }
    	        }
    		},
    		messages: {
    			salaryId:"<br/><li class='f'>Please enter salary Id </li>" ,
    			gradeId:"<br>Please select Grade Code"
    		}
    		
    	}); */
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

		<form:form class="mrg-top" id="salary_master"
			action="processSalaryMaster">

			<ul>

				<li class="f">
					<h3 class="back">Salary Master</h3>
				</li>
				<c:if test="${isFormIncomplete}">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
				</c:if>
				<li class="f"><label for="name" class="fl">Grade<span style="color: red">*</span></label> <form:select
						path="grade.gradeId" class="fl" onChange="document.getElementById('gradeName').value=this[this.selectedIndex].text;" id="gradeId" >
						<option value="-1">Please Select Grade</option>
						<form:options items="${gradeList}" itemLabel="gradeName" itemValue="gradeId"/>
						<form:input id="gradeName" type="hidden" path="grade.gradeName"/>
					</form:select></li>
				<li class="f"><label for="name" class="fl">Salary Id<span style="color: red">*</span> </label>
					<form:input type="text" size="25" id="salaryId" class="fl" path="salaryId" />
					<button class="left" name="action" value="search" style="margin-left: 30px">Search</button>
					<c:if test="${noSalaryMasterFound}">
						<span style="color:red">No Salary Master Found.</span>
					</c:if>
					<c:if test="${salarySaved}">
						<label style="color: green">Grade Saved!!!</label>
					</c:if> <c:if test="${salaryDeleted}">
						<label style="color: green">Grade Deleted!!!</label>
					</c:if> 
				</li>


				<li class="f"><label for="name" class="fl">Salary Name<span style="color: red">*</span></label> <form:input
					type="text" size="25" id="salaryName" class="fl" path="salaryName" />
				</li>

				<li class="f"><label for="name" class="fl">Basic Salary </label> 
				<form:input	type="text" size="25" id="basicSalary" class="fl" path="basicSalary" /> 
				</li>

				<li class="f"><label for="name" class="fl">HRA </label> 
						<form:input type="text" size="25" id="hra" class="fl" path="HRA" /> 
				</li>
				<li class="f"><label for="name" class="fl">Conveyance </label> 
						<form:input type="text" size="25" id="conveyance" class="fl" path="conveyance" /> 
				</li>
				<li class="f"><label for="name" class="fl">Medical </label> 
						<form:input type="text" size="25" id="medical" class="fl" path="medical" /> 
				</li>
				<li class="f"><label for="name" class="fl">Extra1 </label> 
						<form:input type="text" size="25" id="extra1" class="fl" path="extra1" /> 
				</li>
				<li class="f"><label for="name" class="fl">Extra2 </label> 
						<form:input type="text" size="25" id="extra2" class="fl" path="extra2" /> 
				</li>
				<li class="f"><label for="name" class="fl">Extra3 </label> 
						<form:input type="text" size="25" id="extra3" class="fl" path="extra3" /> 
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