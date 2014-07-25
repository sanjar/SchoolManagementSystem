<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Empolyee Form</title>
<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css" media="screen" />
  <link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css" media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>

   
    <script src="<c:url value='/resources/js/multi.js'/>" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value='/resources/js/jquery.uniform.min.js'/>" type="text/javascript" charset="utf-8"></script>
     <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
     <script src="<c:url value='/resources/js/main.js'/>"
	type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8">
      $(function(){
        $("input:checkbox, input:radio, input:file, select").uniform();
      });
    </script>
    <script type="text/javascript">
    
    $(document).ready(function(){
    	$('#grade').change(function(){
    		$('#gradeName').val(this[this.selectedIndex].text);
    		$('#salaryCode').val('-1');
    		$('#salaryCode option:contains("Select Salary Code")').attr('selected',true);
    		//$('#salaryCode option[value="-1"]').attr("selected",true);
    		$('.gradeOption').hide();
    		var x = this[this.selectedIndex].value;
    		//$('.'+x).css('display','inline');
    		$('.'+x).show();
    	});
    	
    	if('${disableNext}'){
    		$('#nextButton').attr('disabled','disabled');
    	}
    	if('${disablePrevious}'){
    		$('#previousButton').attr('disabled','disabled');
    	}
    	
    	/*  $("#employee_master").validate({
			rules: {
				department:"required"
			},
			messages: {
				department:"<br>Please select Department"
			}
			
			
	  });  */
	  
	  $('#employeeId').change(function(){
		  if($('#employeeId').val().trim()==""){
	    		$('#employeeIdMissing').show();
	    	}
		  else{
			  $('#employeeIdMissing').hide();
		  }
	  });
    });
    function checkEmployeeId(){
    	
    	if($('#employeeId').val().trim()==""){
    		$('#employeeIdMissing').show();
    		return false;
    	}
    	return true;
    }
    </script>
</head>
<body>

<div id="header">
  <div class="left">
    <p><a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a></p>
  </div>

  

  <div class="subheader">
    <p>
      <span class="hidden">Navigation:</span>
      <a href="/sms/home" class="highlight">Home</a> |
      <a href="">Contact</a> |
     
    </p>
  </div>
</div>







<article>

<form:form class="mrg-top" id="employee_master" action="processEmployeeMaster">

	<ul>
	
    <li class="f">
<h3 class="back">Employee Master</h3>
</li>
 
					<c:if test="${noEmployeeMasterFound}">
					<li class="f">
						<label style="color:red">No Employee Found.</label>
						</li>
					</c:if>
					<c:if test="${employeeSaved}">
					<li class="f">
						<label style="color: green">Employee Saved!!!</label>
						</li>
					</c:if> <c:if test="${employeeDeleted}">
					<li class="f">
						<label style="color: green">Employee Deleted!!!</label>
						</li>
					</c:if>
					<c:if test="${isFormIncomplete}">
					  <li class="f">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
						</li>
				</c:if>
		<li class="f" hidden="true" style="color:red" id="employeeIdMissing">
		<span>Please Enter Employee Id</span>
		</li>		
        <li class="f">
        
        	<label for="name" class="fl">Employee Id:</label>
            <form:input type="text" size="25" id="employeeId" class="fl numeric" path="employeeId"  />
            <button class="left" name="action" value="search" style="margin-left: 30px" id="searchButton" onclick="return checkEmployeeId();">Search</button>
            
     
           
      
            <label for="name" class="fl" style="margin-left: 53px">Employee Name:</label>
            <form:input type="text" size="25" id="employeeName"  class="fl" path="employeeName"/>
 
   
</li>
        <li  class="f">
        <label for="name" class="fl">Id Card No:</label>
            <form:input type="text" size="25" id="iCardNo" class="fl" path="iCardNo" />
            
           <label for="name" class="fl" style="margin-left: 200px">Gender:</label>
            <form:select id="gender" path="gender">
            	<form:options items="${genderList}" />
            </form:select>
        
        </li>
        	
       
 <li  class="f">
        	<label for="name" class="fl">P.F. No.:</label>
            <form:input type="text" size="25" id="PFNo" class="fl"  path="PFNo"/>
            
            <label for="name" class="fl" style="margin-left: 200px">Esi No.:</label>
            <form:input type="text" size="25" id="ESINo"  class="fl" path="ESINo"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">Pan No.:</label>
            <form:input type="text" size="25" id="PANNo" class="fl" path="PANNo" />
            
            <label for="name" class="fl" style="margin-left: 200px">Eps No.:</label>
            <form:input type="text" size="25" id="EPSNo"  class="fl" path="EPSNo"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">Bank a/c no.:</label>
            <form:input type="text" size="25" id="bankAccountNo" class="fl"  path="bankAccountNo"/>
            
            <label for="name" class="fl" style="margin-left: 200px">DOB:</label>
            <form:input type="text" size="25" id="dateOfBirth"  class="fl" path="dateOfBirth"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">DOJ:</label>
            <form:input type="text" size="25" id="dateOfJoining" class="fl" path="dateOfJoining" />
            
            
            <label for="name" class="fl" style="margin-left: 200px">Salary Code<span style="color: red">*</span></label> <form:select
						path="salaryCode" class="fl" id="salaryCode">
						<option value="-1">Select Salary Code</option>
						<c:forEach items="${gradeSalaryCodeMap}" var="map">
							
								<form:options class="${map.key.gradeId} gradeOption" items="${map.value}" cssStyle="display:none" />
							
						</c:forEach>
					</form:select>
           </li>
<li  class="f">

<label for="name" class="fl">Department<span style="color: red">*</span></label> <form:select id="department" 
						path="department.departmentId" class="fl" onChange="document.getElementById('departmentName').value=this[this.selectedIndex].text;">
						<option value="-1">Please Select Department</option>
						<form:options items="${departmentList}" itemLabel="departmentName" itemValue="departmentId"/>
						<form:input id="departmentName" type="hidden" path="department.departmentName"/>
					</form:select>
</li>


<li  class="f">
<label for="name" class="fl" >Designation:</label>
            <form:select id="designation" path="designation">
             <option value="-1">Please Select Designation</option>
            	<form:options items="${designationList}" />
            </form:select>
</li>


<li  class="f">
<label for="name" class="fl">Grade<span style="color: red">*</span></label> <form:select id="grade"
						path="grade.gradeId" class="fl" >
							<option value="-1">Please Select Grade</option>
						 <c:forEach items="${gradeSalaryCodeMap}" var="map">
						 
						 <c:choose>
							<c:when test="${map.key.gradeId==command.grade.gradeId}">
								<option value="${map.key.gradeId}" selected="selected">${map.key.gradeName}</option>
							</c:when>
							<c:otherwise>
								<option value="${map.key.gradeId}">${map.key.gradeName}</option>
							</c:otherwise>
							</c:choose>
       						 
    					 </c:forEach>
						<form:hidden id="gradeName" path="grade.gradeName"/>
					</form:select>
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
  Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a>  All rights reserved.
  <span class="notprinted">
    <a href="index.html">Terms of Use</a>.
    <a href="index.html">Privacy Policy</a>.
  </span>
  <br />

  This web site is maintained by
 <a href="http://www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div>