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
        

       
        
		<!-- JQuery engine script-->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.3.2.min.js'/>" ></script>
        
		<!-- JQuery WYSIWYG plugin script -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery.wysiwyg.js' />" ></script>
        
        <!-- JQuery tablesorter plugin script-->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery.tablesorter.min.js'/>"></script>
        
		<!-- JQuery pager plugin script for tablesorter tables -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery.tablesorter.pager.js'/>" ></script>
        
		<!-- JQuery password strength plugin script -->
		<script type="text/javascript" src="<c:url value='/resources/js/jquery.pstrength-min.1.2.js'/>" ></script>
        
		<!-- JQuery thickbox plugin script -->
		<script type="text/javascript" src="<c:url value='/resources/js/thickbox.js'/>" ></script>
        
        <!-- Initiate WYIWYG text area -->
		<script type="text/javascript">
			$(function()
			{
			$('#wysiwyg').wysiwyg(
			{
			controls : {
			separator01 : { visible : true },
			separator03 : { visible : true },
			separator04 : { visible : true },
			separator00 : { visible : true },
			separator07 : { visible : false },
			separator02 : { visible : false },
			separator08 : { visible : false },
			insertOrderedList : { visible : true },
			insertUnorderedList : { visible : true },
			undo: { visible : true },
			redo: { visible : true },
			justifyLeft: { visible : true },
			justifyCenter: { visible : true },
			justifyRight: { visible : true },
			justifyFull: { visible : true },
			subscript: { visible : true },
			superscript: { visible : true },
			underline: { visible : true },
            increaseFontSize : { visible : false },
            decreaseFontSize : { visible : false }
			}
			} );
			});
        </script>
        
        <!-- Initiate tablesorter script -->
        <script type="text/javascript">
			$(document).ready(function() { 
				$("#myTable") 
				.tablesorter({
					// zebra coloring
					widgets: ['zebra'],
					// pass the headers argument and assing a object 
					headers: { 
						// assign the sixth column (we start counting zero) 
						6: { 
							// disable it by setting the property sorter to false 
							sorter: false 
						} 
					}
				}) 
			.tablesorterPager({container: $("#pager")}); 
				
				$('#dataBackup').click(function(event){
					event.preventDefault();
					window.open('admin/databackupNrestore',"_blank" /* ,'toolbar=0,location=0,menubar=0' */);
				});
				$('#userManagement').click(function(event){
					event.preventDefault();
					window.open('admin/userManagement',"_blank"/* ,'toolbar=0,location=0,menubar=0' */);
				});
				$('#feeManagement').click(function(event){
					event.preventDefault();
					window.open('admin/feeManagement',"_blank"/* ,'toolbar=0,location=0,menubar=0' */);
				});
				$('#payrollManagement').click(function(event){
					event.preventDefault();
					window.open('admin/payrollManagement',"_blank");
				});
				$('#transportManagement').click(function(event){
					event.preventDefault();
					window.open('admin/transportManagement',"_blank"/* ,'toolbar=0,location=0,menubar=0' */);
				});
				$('#purchase').click(function(event){
					event.preventDefault();
					window.open('admin/purchase/manageCustomer',"_blank"/* ,'scrollbars=1,toolbar=0,location=0,menubar=0' */);
				});
				$('#reportGeneration').click(function(event){
					event.preventDefault();
					window.open('admin/generateReport',"_blank"/* ,'scrollbars=1,toolbar=0,location=0,menubar=0' */);
				});
			}); 
			
		
		</script>
        
        <!-- Initiate password strength script -->
		<script type="text/javascript">
			$(function() {
			$('.password').pstrength();
			});
        </script>
        <script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
			
			function createUser(){
				window.open('admin/createUser',"_blank"/* ,'toolbar=0,location=0,menubar=0' */);
			}
		</script>
	</head>
	<body>
	
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
    	<!-- Header -->
        <div id="header">
  <div class="left">
    <p><a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a></p>
  </div>

  

  <div class="subheader">
    <p>
      <span class="hidden">Navigation:</span>
      <a href="/sms/home" class="highlight">Home</a> |
      <a href="">Contact</a> |
      <a href="javascript:formSubmit();" id="logout">Logout</a>
     
    </p>
    
  </div>
</div>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
						Welcome ${pageContext.request.userPrincipal.name}
	</c:if>
    
    </div>
<div>
                <ul id="nav">
                                <li id="current"><a href="">Dashboard</a></li>
                                <li><a href="">Authorisation</a></li>
                                <li><a id="purchase" href="">Purchase</a></li>
                                <li><a id="transportManagement" href="">Transport</a></li>
                                <li><a href="">Discounts</a></li>
                            </ul>
                        </div>
                        
                    
                <div style="clear: both;"></div>
            
        
		<div class="container_12">
        

            
            <!-- Dashboard icons -->
            <div class="grid_7">
            	<a id="userManagement" href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_write.gif'/>" alt="" width="64" height="64" /> <span>User Management</span>
                </a>
                
                <a id="payrollManagement" href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_file.gif'/>" alt="" width="64" height="64" /> <span>Payroll Management</span>
                </a>
                
                <a id="dataBackup" href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_files.gif'/>" alt="" width="64" height="64" /> <span>Data Backup</span>
                </a>
                
                <a id="feeManagement" href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_calendar.gif'/>" alt="" width="64" height="64" /> <span>Fee Collection</span>
                </a>
                
                <a href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_user.gif'/>" alt="" width="64" height="64" /> <span>My profile</span>
                </a>
                
                <a id="reportGeneration" href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_stats.gif'/>" alt="" width="64" height="64" /> <span>Reports</span>
                </a>
                
                <a href="" class="dashboard-module">
                	<img src="<c:url value='/resources/images/Crystal_Clear_settings.gif'/>" alt="" width="64" height="64" /> <span>Settings</span>
                </a>
              <div style="clear: both"></div>
            </div> <!-- End .grid_7 -->
            
            <!-- Account overview -->
            <div class="grid_5">
                <div class="module">
                        <h2><span>Account overview</span></h2>
                        
                        <div class="module-body">
                        
                        	<p>
                                <strong>User: </strong>
                                
                                 <c:if test="${pageContext.request.userPrincipal.name != null}">
									${pageContext.request.userPrincipal.name}
								</c:if>
                                
                                
                                <br />
                               <!--  <strong>Your last visit was on: </strong>20 January 2010,<br />
                                <strong>From IP: </strong>000.000.00.00 -->
                            </p>
                        

                        </div>
                </div>
                <div style="clear:both;"></div>
            </div> <!-- End .grid_5 -->
            
            <div style="clear:both;"></div>
            
            
         <%--    
            <div class="grid_12">
                
                <!-- Notification boxes -->
                <span class="notification n-success">Success notification.</span>
                
                <span class="notification n-information">Information notification.</span>
                
                <span class="notification n-attention">Attention notification.</span>
                
                <span class="notification n-error">Error notification.</span>
                
                
              

                
            <!-- Password -->
            <div class="grid_6">
                <div class="module">
                     <h2><span>Password</span></h2>
                        
                     <div class="module-body">
                        <form action="">
                            <p>
                                <label>Type in new password</label>
                                <input class="input-medium password" type="password" />
                            </p>
                            <p>
                                <label>Repeat password</label>
                                <input type="password" class="input-medium" />
                            </p>
                            <fieldset>
                                <input class="submit-green" type="submit" value="Submit" /> 
                                <input class="submit-gray" type="submit" value="Cancel" />
                            </fieldset>
                        </form>
                        
                     </div> <!-- End .module-body -->
                </div> <!-- End .module -->
                <div style="clear:both;"></div>
            </div> <!-- End .grid_6 -->
            <div style="clear:both;"></div>
            


            
            <div style="clear:both;"></div>
        </div>  --%><!-- End .container_12 -->
		
           
        <!-- Footer -->
        <div id="footer">
  <hr />
  Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a>  All rights reserved.
  <span class="notprinted">
    <a href="index.html">Terms of Use</a>.
    <a href="index.html">Privacy Policy</a>.
  </span>
  <br />

  This web site is maintained by
 <a href="https://www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div> <!-- End #footer -->
	</body>
</html>