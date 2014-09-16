<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>List Students</title>
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
				<span class="hidden">Navigation:</span> <a href="/sms/home" class="highlight">Home</a>
				|  <a href="">Contact</a> |

			</p>
		</div>
	</div>







	<article>

		<form:form class="mrg-top" id="listStudents"
			action="listStudents">

			<ul>

				<li class="f">
					<h3 class="back">List Students</h3>
				</li>
				
				<li class="f"><label for="name" class="fl" style="margin-top:8px;width: 50px">Class </label> 
				<select class="fl" name="class">
						<c:forEach items="${classList}" var="x">
						<option value="${x}">${x}</option>
						</c:forEach>
					</select>
					
					<label for="name" class="fl" style="margin-top:8px;width: 60px">Section </label> <input
					type="text" size="25" id="section" name="section" class="fl"/>
					
					<label for="name" class="fl" style="margin-top:8px;width: 60px;margin-left: 40px">Roll </label> <input
					type="text" size="25" id="roll" name= "roll" class="fl" />
					
					<button class="left" name="action" value="listStudents" style="margin-left: 30px">List Students</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;" style="margin-left: 30px">Exit</button>
					</li>

				<br/>

				
				</ul>
		</form:form>
		<div id="sidebar1">


		<table width="1224" border="1">
			<tr>
				<th width="95" scope="col"><u>
					<span class="style2">Enrolement No</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">Name</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">DOB</span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">Father Name </span></u></th>
				<th width="96" scope="col"><u>
					<span class="style2">Class </span></u></th>
				<th width="80" scope="col"><u>
					<span class="style2">Section</span></u></th>
				<th width="88" scope="col"><u>
					<span class="style2">Roll</span></u></th>
				<th width="76" scope="col"><u>
					<span class="style2">DOA</span></u></th>
			</tr>
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>${student.enrolementNo}</td>
					<td>${student.firstName} &nbsp ${student.middleName} &nbsp ${student.lastName}</td>
					<td>${student.dateOfBirth}</td>
					<td>${student.fathername}</td>
					<td>${student.currentClassBatch}</td>
					<td>${student.currentClassSection}</td>
					<td>${student.roll}</td>
					<td>${student.dateOfAdmission}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	</article>
	<div id="footer">
		<hr />
		Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a> All
		rights reserved. <span class="notprinted"> <a href="index.html">Terms
				of Use</a>. <a href="index.html">Privacy Policy</a>.
		</span> <br /> This web site is maintained by <a href="http://www.dsisoftware.net"
			target="_blank">www.dsisoftware.net</a>.

	</div>