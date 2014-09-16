<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>List Customers</title>
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
		
		<ul>

				<li class="f">
					<h3 class="back">List Customers</h3>
				</li>
		</ul>			
		
		
		<div id="sidebar1" style="border-right:0px solid #999999">


		<table width="1224" border="1">
			<tr>
				<th width="96" scope="col"><u>
					<span class="style2">Customer Code </span></u></th>
				<th width="95" scope="col"><u>
					<span class="style2">Customer Type</span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">Customer Name </span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">Address</span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">pin</span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">Phone</span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">Date of Creation</span></u></th>
					<th width="95" scope="col"><u>
					<span class="style2">Tin No</span></u></th>
					
			</tr>
			<c:forEach var="customer" items="${listCustomers}">
				<tr>
					<td>${customer.customerCode}</td>
					<td>${customer.customerType}</td>
					<td>${customer.customerName}</td>
					<td>${customer.address}</td>
					<td>${customer.pin}</td>
					<td>${customer.phone}</td>
					<td>${customer.dateOfCreation}</td>
					<td>${customer.tinNo}</td>
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