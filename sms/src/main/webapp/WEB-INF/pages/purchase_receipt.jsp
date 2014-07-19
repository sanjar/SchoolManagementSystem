<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Purchase Receipt</title>
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
      <a href="" class="highlight">Home</a> |
      <a href="">Contact</a> |
     
    </p>
  </div>
</div>







<article>

<form:form class="mrg-top" id="employee_master" action="processEmployeeMaster">

	<ul>
    
    <li class="f">
<h3 class="back">Purchase Receipt</h3>
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
				
        <li class="f">
        
        	<label for="name" class="fl">Receipt No. </label>
            <form:input type="text" size="20" id="receiptNo" class="fl" path="receiptNo" />
           
            
     
           
      
            <label for="name" class="fl" style="margin-left: 53px">Date </label>
            <form:input type="text" size="20" id="receiptDate"  class="fl" path="receiptDate"/>
            
            <label for="name" class="fl" style="margin-left: 55px">Ag. St1 </label>
            <form:select id="agSt1" path="agSt1">
            	<form:options items="${yesNoList}" />
            </form:select>
 			
   
</li>
        <li  class="f">
        <label for="name" class="fl">Invoice No. </label>
            <form:input type="text" size="20" id="invoiceNo" class="fl" path="invoiceNo" />
           
            
     
           
      
            <label for="name" class="fl" style="margin-left: 53px">Date </label>
            <form:input type="text" size="20" id="invoiceDate"  class="fl" path="invoiceDate"/>
            
            <label for="name" class="fl" style="margin-left: 53px">Company </label>
            <form:input type="text" size="20" id="company"  class="fl" path="company"/>
        
        </li>
        	
       
 <li  class="f">
        	<label for="name" class="fl">Cheque No. </label>
            <form:input type="text" size="20" id="chequeNo" class="fl" path="chequeNo" />
           
            
     
           
      
            <label for="name" class="fl" style="margin-left: 53px">Date </label>
            <form:input type="text" size="20" id="chequeDate"  class="fl" path="chequeDate"/>
            
            <label for="name" class="fl" style="margin-left: 53px">Amount </label>
            <form:input type="text" size="20" id="amount"  class="fl" path="amount"/>
       
</li>

 <li  class="f">
 			<label for="name" class="fl">Purchase Type </label>
            <form:select id="purchaseType" path="purchaseType" >
            	<form:options items="${purchaseTypeList}" />
            </form:select>
        	<label for="name" class="fl" style="margin-left: 365px">Stk Pnt</label>
            <form:input type="text" size="20" id="stkPnt" class="fl" path="stkPnt" />
            
            
       
</li>

 

<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="delete">Delete</button>
				 <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button>
				</li>

</ul>
<iframe name="items" src="<c:url value='/resources/jsp/item_table.jsp'/>" height="1000" width="1250" style="overflow:auto" draggable="true"></iframe>
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