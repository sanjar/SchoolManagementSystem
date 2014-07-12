<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Welcome Admin</title>
       <script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
	 	<script>
       	 history.forward();
    	</script>
        <!-- CSS Reset -->
        <link rel="StyleSheet" href="<c:url value='/resources/css/reset.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/grid.css'/>" type="text/css"
	media="screen" />
        
        
		
       
        
        <!-- Main stylesheet -->
        
        
        <link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css'/>" type="text/css"
	media="print" />
<link href="<c:url value='/resources/css/styles.css'/>" media="screen"  rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="<c:url value='/resources/css/jquery.wysiwyg.css'/>" type="text/css"
	media="screen" />
<link rel="StyleSheet" href="<c:url value='/resources/css/tablesorter.css'/>" type="text/css"
	media="screen" />
<link href="<c:url value='/resources/css/thickbox.css'/>" media="screen" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/theme-blue.css'/>" media="screen" rel="stylesheet" type="text/css" />
        

       
        
		
	</head>
	<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
    	<!-- Header -->
        <div id="header">
            <!-- Header. Status part -->
            <div id="header-status">
                <div class="container_12">
                    <div class="grid_8">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
						Welcome ${pageContext.request.userPrincipal.name}
					</c:if>
                    </div>
                    <div class="grid_4">
                        <a href="javascript:formSubmit();" id="logout">
                        Logout
                        </a>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div> 
            </div><!-- End #header-status -->
            <div>
	       <table>
	       <tr>
	       			<td>     </td>
	       			<td>     </td>
	       		</tr>
	       		<tr>
	       			<td> First Name </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Middle Name </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Last Name </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Date of Birth </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Email Id </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Phone No. </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Mobile No. </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Date of Admission </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td> Address </td>
	       			<td> <input type="text" value=""/> </td>
	       		</tr>
	       		<tr>
	       			<td>  </td>
	       			<td>  </td>
	       		</tr>
	       		<tr>
	       			<td> <input type="button" value="Create"/></td>
	       			<td> <input type="button" value="Reset"/> </td>
	       		</tr>
	       
	       </table>
       
       </div>
            
           
        <!-- Footer -->
        <div id="footer">
        	<div class="container_12">
            	<div class="grid_12">
                	
                	
        		</div>
            </div>
            <div style="clear:both;"></div>
        </div> <!-- End #footer -->
	</body>
</html>