<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>Settings</title>
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
 <script>
        history.forward();
    </script>
<script type="text/javascript">


$(document).ready(function(){
	$('.link').click(function(event) {
		$('#links li').removeClass("highlight"); 
		$(this).parent().addClass("highlight");
		//alert();
		$('.settings').hide();
		if($(this).attr("id")=="generalSettings"){
			$('#generalSettingsDiv').show();
		}
		
	    //alert($('#user_type').val());
	  // or use return false;
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
				<span class="hidden">Navigation:</span> <a href="">Home</a> | <a href="">Contact</a> |

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->

	<div id="sidebar1">
		<div>

			<ul id="links">
				<li class="highlight"><a id="generalSettings" class="link" href="#">General Settings</a></li>
				
			</ul>
		</div>
		<input type="hidden" name="user_type" id ="user_type" value="" />
	</div>


	<!-- ======== Main Content ======== -->

	<div id="main">
			<div id="generalSettingsDiv">
				
				<h1>General Settings</h1>
				<form action="settings" method="POST">
				<article>
				<ul>
				<li class="f">
				<c:if test="${sessionSaved}">
						<span style="color:Green"><b>Settings Saved for this session.</b></span>
					</c:if>
				<li class="f">
				<label class="fl">Select current Session : </label>
				<c:set var="currentSession" value="<%=request.getSession().getAttribute(\"currentSavedSession\") %>"></c:set>
				<select name="session" class="fl">
						<option value="-1">Please Select</option>
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
					
					<li  class="f">
				 <button class="left" name="action" value="save" id="view">Save</button>
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
