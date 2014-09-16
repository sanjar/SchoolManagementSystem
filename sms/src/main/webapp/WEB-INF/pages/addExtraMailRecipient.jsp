<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Extra Mail Recipient Form</title>
<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css" media="screen" />
  <link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css" media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
    
    <script src="<c:url value='/resources/js/multi.js'/>" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value='/resources/js/jquery.uniform.min.js'/>" type="text/javascript" charset="utf-8"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <script type="text/javascript" charset="utf-8">
      $(function(){
        $("input:checkbox, input:radio, input:file, select").uniform();
      });
    </script>
    
    <script type="text/javascript">
    $(document).ready(function(){
    	$("#addExtraMailRecipient").validate({
			rules: {
				name:"required",
				phoneNo:"required"
			},
			messages: {
				name:"Please enter Name",
				phoneNo:"Please enter Phone No"
			}
			
		});
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
<form:form class="mrg-top" id="addExtraMailRecipient" action="addExtraMailRecipient">
	<ul>

				<li class="f">
					<h3 class="back">Extra Mail Recipient Form</h3>
				</li>
				<c:if test="${addExtraMailRecipientSaved}">
				<li class="f">
				<label style="color:green">Extra Mail Recipient Saved!!!</label>
				</li>
				</c:if>
				<li class="f"><label for="name" class="fl">Name<span style="color: red">*</span></label> <form:input
					type="text" size="25" id="name" class="fl" path="name" />
				</li>

				<li class="f"><label for="name" class="fl">Phone No <span style="color: red">*</span> </label> 
				<form:input	type="text" size="25" id="phoneNo" class="fl" path="phoneNo" /> 
				</li>

				<li class="f"><label for="name" class="fl">Email Id </label> 
						<form:input type="text" size="25" id="email" class="fl" path="email" /> 
				</li>
				
				<li class="f"><label for="name" class="fl">Grade<span style="color: red">*</span></label>
				 <form:select
						path="mailType" class="fl" id="mailType" >
						<form:options items="${mailTypeList}" />
					</form:select></li>

<li  class="f">
 <button class="left" name="action" value="save" onclick="return checkGradeId();">Save</button>
<!--  <button class="left" name="action" value="delete" id="delete" >Delete</button> -->
<button class="left" value="new" name="action"> Create New </button>
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
 <a href="www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div>