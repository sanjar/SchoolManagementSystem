<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Department Form</title>
<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css" media="screen" />
  <link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css" media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
    
    <script src="<c:url value='/resources/js/multi.js'/>" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value='/resources/js/jquery.uniform.min.js'/>" type="text/javascript" charset="utf-8"></script>
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

<form:form class="mrg-top" id="department_master" action="processDepartmentMaster">

<li class="f">
	<table>
	<tr>
		<td><label>Department Id</label></td> 
		<td><form:input path="departmentId"/></td><td><button class="left" name="action" value="search">Search</button></td>
		<td><c:if test="${noDepartmentFound}">
						<label style="color:red">No Department Found.</label>
					</c:if></td>
	</tr>
	<tr>
	<td><span><input type="hidden"/></span></td>
	
	</tr>
	<tr>
		<td><label>Department Name</label></td>
		<td><form:input path="departmentName"/></td>
		<td>
		<c:if test="${departmentSaved}">
				<label style="color:green">Department Saved!!!</label>
		</c:if>
		<c:if test="${departmentDeleted}">
				<label style="color:green">Department Deleted!!!</label>
		</c:if>
		<c:if test="${isFormIncomplete}">
				<label style="color:red">Form Incomplete!!!</label>
		</c:if>
		
		</td>
	</tr>
	</table> 
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