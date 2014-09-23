<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>Report Generation</title>
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
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<%-- <script src="<c:url value='/resources/js/multi.js'/>"
	type="text/javascript" charset="utf-8"></script> --%>
<%-- <script src="<c:url value='/resources/js/jquery.uniform.min.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script> --%>
 
<script type="text/javascript">


$(document).ready(function(){
	$('.link').click(function(event) {
		$('#links li').removeClass("highlight"); 
		$(this).parent().addClass("highlight");
		//alert();
		$('.report').hide();
		if($(this).attr("id")=="collectionDateWise"){
			$('#feeCollectionDateWise').show();
		}
		if($(this).attr("id")=="feeCollectionDetails"){
			$('#feeCollection').show();
		}
		if($(this).attr("id")=="collectionDateSessionBatchWise"){
			$('#feeCollectionDateSessionBatchWise').show();
		}
		if($(this).attr("id")=="transportfeePendingLink"){
			$('#transportfeePending').show();
		}
		if($(this).attr("id")=="feeCollectionPendingLink"){
			$('#feeCollectionPending').show();
		}
		if($(this).attr("id")=="dayBookLink"){
			$('#dayBookDiv').show();
		}
	    //$('#userType').val($(this).text().split(" ")[0]);
	    $('#user_type').val($(this).attr("id"));
	    //alert($('#user_type').val());
	  // or use return false;
	});
	 $(".dateWiseFeeCalender").datepicker({
		 changeMonth: true,
		 changeYear: true,
		 yearRange:'-90:+0',
         showOn: "button",
         dateFormat: "dd/mm/yy",
         disabled: false,
         buttonImage: "<c:url value='/resources/images/calendar.png'/>",
         buttonImageOnly: true
     });
	 $(".dateWiseFeeCalender1").datepicker({
		 changeMonth: true,
		 changeYear: true,
		 yearRange:'-90:+0',
         showOn: "button",
         dateFormat: "dd/mm/yy",
         disabled: false,
         buttonImage: "<c:url value='/resources/images/calendar.png'/>",
         buttonImageOnly: true
     });
	 $(".dayBookCalender").datepicker({
		 changeMonth: true,
		 changeYear: true,
		 yearRange:'-90:+0',
         showOn: "button",
         dateFormat: "dd/mm/yy",
         disabled: false,
         buttonImage: "<c:url value='/resources/images/calendar.png'/>",
         buttonImageOnly: true
     });
});

</script>

<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css'/>" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/login-box.css'/>" rel="stylesheet" type="text/css" />
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
				<span class="hidden">Navigation:</span> <a href="/sms/home">Home</a> | <a href="">Contact</a> | <a href="addExtraMailRecipient">Add Extra Mail Recipient </a> | <a href="listExtraMailRecipients">List Extra Mail Recipients </a> |<a href="sendCustomSMS">Send Custom SMS </a> |

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->

	<div id="sidebar1">
		<div>

			<ul id="links">
				<li class="highlight"><a id="feeCollectionDetails" class="link" href="#">Fee Collection details</a></li>
				<li><a id="collectionDateWise" class="link" href="#">Fee Collection Date Wise</a></li>
				<li><a id="collectionDateSessionBatchWise" class="link" href="#">Fee Collection Date/Session/Batch Wise</a></li>
				<li><a id="transportfeePendingLink" class="link" href="#">Transport Pending Fee</a></li>
				<li><a id="feeCollectionPendingLink" class="link" href="#">Pending Fee Collection</a></li>
				<li><a id="dayBookLink" class="link" href="#">Day Book</a></li>
			</ul>
		</div>
		<input type="hidden" name="user_type" id ="user_type" value="" />
	</div>


	<!-- ======== Main Content ======== -->

	<div id="main">
			<div id="feeCollection" class="report">
				
				<h1>Fee Collection Details</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">Select Session : </label>
				<c:set var="currentSession" value="<%=request.getSession().getAttribute(\"currentSavedSession\") %>"></c:set>
				<select name="session" class="fl">
						<option value="-1">Please Select Session</option>
						<c:forEach items="${sessionList}" var="session">
							<c:choose>
							<c:when test="${session==currentSession}">
								<option value="${session}" selected="selected">${session}</option>
							</c:when>
							<c:otherwise>
								<option value="${session}">${session}</option>
							</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Batch : </label>
				<select name="batch" class="fl">
						<option value="-1">Please Select Batch</option>
						<c:forEach items="${batchList}" var="batch">
							<option value="${batch}">${batch}</option>
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Month : </label>
				<select name="month" class="fl">
						<option value="-1">Please Select Month</option>
						<c:forEach items="${monthList}" var="month">
							<option value="${month}">${month}</option>
						</c:forEach>
					</select></li>
					
					<li  class="f">
				<input type="hidden" name ="feeCollectionRequest" value="feeCollectionRequest">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>

			<div id="feeCollectionDateWise" class="report" hidden="true">
				
				<h1>Fee Collection Details Date Wise</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">From Date : </label>
				<input type="text" size="25" style="margin-right:10px" id="fromDate" class="fl dateWiseFeeCalender" name="fromDate" readonly="readonly"/>
				</li>
					
					<li class="f">
				<label class="fl">To Date : </label>
				<input type="text" size="25" style="margin-right:10px" id="toDate" class="fl dateWiseFeeCalender" name="toDate" readonly="readonly"/>
				</li>
					
					<li  class="f">
				<input type="hidden" name ="feeCollectionRequestDateWise" value="feeCollectionRequestDateWise">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>
			<div id="feeCollectionDateSessionBatchWise" class="report" hidden="true">
				
				<h1>Fee Collection Date/Session/Batch Wise</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">From Date : </label>
				<input type="text" size="25" style="margin-right:10px" id="fromDate1" class="fl dateWiseFeeCalender1" name="fromDate" readonly="readonly"/>
				</li>
					
					<li class="f">
				<label class="fl">To Date : </label>
				<input type="text" size="25" style="margin-right:10px" id="toDate1" class="fl dateWiseFeeCalender1" name="toDate" readonly="readonly"/>
				</li>
					<li class="f">
				<label class="fl">Select Session : </label>
				<c:set var="currentSession" value="<%=request.getSession().getAttribute(\"currentSavedSession\") %>"></c:set>
				<select name="session" class="fl">
						<option value="-1">Please Select Session</option>
						<c:forEach items="${sessionList}" var="session">
							<c:choose>
							<c:when test="${session==currentSession}">
								<option value="${session}" selected="selected">${session}</option>
							</c:when>
							<c:otherwise>
								<option value="${session}">${session}</option>
							</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select></li>
					<li class="f">
				<label class="fl">Select Batch : </label>
				<select name="batch" class="fl">
						<option value="-1">Please Select Batch</option>
						<c:forEach items="${batchList}" var="batch">
							<option value="${batch}">${batch}</option>
						</c:forEach>
					</select></li>
					<li  class="f">
				<input type="hidden" name ="feeCollectionType" value="feeCollectionDateSessionBatchWise">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>
			<div id="transportfeePending" class="report" hidden="true">
				
				<h1>Transport Fee Pending Report</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">Select Session : </label>
				<c:set var="currentSession" value="<%=request.getSession().getAttribute(\"currentSavedSession\") %>"></c:set>
				<select name="session" class="fl">
						<option value="-1">Please Select Session</option>
						<c:forEach items="${sessionList}" var="session">
							<c:choose>
							<c:when test="${session==currentSession}">
								<option value="${session}" selected="selected">${session}</option>
							</c:when>
							<c:otherwise>
								<option value="${session}">${session}</option>
							</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Route : </label>
				<select name="routeCode" class="fl">
						<option value="-1">Please Select Route</option>
						<c:forEach items="${routeCodeList}" var="route">
							<option value="${route.routeCode}">${route.routeName}</option>
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Month : </label>
				<select name="month" class="fl">
						<option value="-1">Please Select Month</option>
						<c:forEach items="${monthList}" var="month">
							<option value="${month}">${month}</option>
						</c:forEach>
					</select></li>
					
					<li  class="f">
				<input type="hidden" name ="reportType" value="transportfeePending">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>
			<div id="feeCollectionPending" class="report" hidden="true">
				
				<h1>Fee Collection Pending Report</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">Select Session : </label>
				<c:set var="currentSession" value="<%=request.getSession().getAttribute(\"currentSavedSession\") %>"></c:set>
				<select name="session" class="fl">
						<option value="-1">Please Select Session</option>
						<c:forEach items="${sessionList}" var="session">
							<c:choose>
							<c:when test="${session==currentSession}">
								<option value="${session}" selected="selected">${session}</option>
							</c:when>
							<c:otherwise>
								<option value="${session}">${session}</option>
							</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Batch : </label>
				<select name="batch" class="fl">
						<option value="-1">Please Select Batch</option>
						<c:forEach items="${batchList}" var="batch">
							<option value="${batch}">${batch}</option>
						</c:forEach>
					</select></li>
					
					<li class="f">
				<label class="fl">Select Month : </label>
				<select name="month" class="fl">
						<option value="-1">Please Select Month</option>
						<c:forEach items="${monthList}" var="month">
							<option value="${month}">${month}</option>
						</c:forEach>
					</select></li>
					
					<li  class="f">
				<input type="hidden" name ="reportType" value="feeCollectionPending">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>
			<div id="dayBookDiv" class="report" hidden="true">
				
				<h1>Day Book</h1>
				<form action="generateReport" method="POST" target="_blank">
				<article>
				<ul>
				<li class="f">
				<label class="fl">Date : </label>
				<input type="text" size="25" style="margin-right:10px" id="dayBookDate" class="fl dayBookCalender" name="dayBookDate" readonly="readonly"/>
				</li>
					<li  class="f">
				<input type="hidden" name ="reportType" value="dayBook">	
				 <button class="left" name="action" value="view" id="view">View</button>
				 <button class="left" name="action" value="sendSMS" id="view">Send SMS</button>
				 <button class="left" name="action" value="exit" onclick="window.opener=null; window.close(); return false;">Exit</button>
				</li>
					</ul>
					</article>
					</form>
			</div>
			<br id="endmain" />
	</div>


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
