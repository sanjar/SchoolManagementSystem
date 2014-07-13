<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>A School Management Template</title>

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
		
		$('#manageFixedFee').click(function(event){
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
				<a href="">School<span class="alt">Management</span></a>
			</p>
		</div>

		<div class="right">
			<span class="hidden">Useful links:</span> <a href="">Home</a> | <a
				href="">Login</a> | <a href="">Contact</a> |

		</div>

		<div class="subheader">
			<p>
				<span class="hidden">Navigation:</span> <a id="manageTransport" href="">Manage Transport</a> 
			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->



	<!-- ======== Main Content ======== -->
<div id="sidebar1" >							
			
				
			<table width="1224" border="1">
  <tr>
    <th width="95" scope="col"><u><span class="style2">Route Code</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Vehicle Code</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Pick Up Time</span></u></th>
    <th width="95" scope="col"><u><span class="style2">Jan Transport Fee</span></u></th>
    <th width="96" scope="col"><u><span class="style2">Feb Transport Fee </span></u></th>
    <th width="80" scope="col"><u><span class="style2">Mar Transport Fee</span></u></th>
    <th width="88" scope="col"><u><span class="style2">Apr Transport Fee </span></u></th>
    <th width="76" scope="col"><u><span class="style2">May Transport Fee</span></u></th>
    <th width="76" scope="col"><u><span class="style2">Jun Transport Fee</span></u></th>
    <th width="76" scope="col"><u><span class="style2">Jul Transport Fee</span></u></th>
    <th width="65" scope="col"><u><span class="style2">Aug Transport Fee </span></u></th>
    <th width="84" scope="col"><u><span class="style2">Sep Transport Fee</span></u></th>
    <th width="60" scope="col"><u><span class="style2">Oct Transport Fee</span></u></th>
    <th width="68" scope="col"><u><span class="style2">Nov Transport Fee</span></u></th>
    <th width="93" scope="col"><u><span class="style2">Dec Transport Fee</span></u></th>
  </tr>
  <c:forEach var="transportFee" items="${listTransportStructure}">
  <tr>
    <td>${transportFee.routeCode}</td>
    <td>${transportFee.vehicleId}</td>
    <td>${transportFee.pickUpTime}</td>
    <td>${transportFee.transportCostJan}</td>
    <td>${transportFee.transportCostFeb}</td>
    <td>${transportFee.transportCostMar}</td>
    <td>${transportFee.transportCostApr}</td>
    <td>${transportFee.transportCostMay}</td>
    <td>${transportFee.transportCostJun}</td>
    <td>${transportFee.transportCostJul}</td>
    <td>${transportFee.transportCostAug}</td>
    <td>${transportFee.transportCostSep}</td>
    <td>${transportFee.transportCostOct}</td>
    <td>${transportFee.transportCostNov}</td>
    <td>${transportFee.transportCostDec}</td>
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
