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
					window.open('admin/databackupNrestore',"_blank",'toolbar=0,location=0,menubar=0');
				});
				$('#userManagement').click(function(event){
					event.preventDefault();
					window.open('admin/userManagement',"_blank",'toolbar=0,location=0,menubar=0');
				});
				$('#feeManagement').click(function(event){
					event.preventDefault();
					window.open('admin/feeManagement',"_blank",'toolbar=0,location=0,menubar=0');
				});
				$('#payrollManagement').click(function(event){
					event.preventDefault();
					window.open('admin/payrollManagement',"_blank",'toolbar=0,location=0,menubar=0');
				});
				$('#transportManagement').click(function(event){
					event.preventDefault();
					window.open('admin/transportManagement',"_blank",'toolbar=0,location=0,menubar=0');
				});
				$('#purchase').click(function(event){
					event.preventDefault();
					window.open('admin/purchase/manageCustomer',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
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
				window.open('admin/createUser',"_blank",'toolbar=0,location=0,menubar=0');
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
      <a href="" class="highlight">Home</a> |
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
                
                <a href="" class="dashboard-module">
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
                                <strong>User: </strong>User X<br />
                                <strong>Your last visit was on: </strong>20 January 2010,<br />
                                <strong>From IP: </strong>000.000.00.00
                            </p>
                        

                        </div>
                </div>
                <div style="clear:both;"></div>
            </div> <!-- End .grid_5 -->
            <div>
            Create User:
            <select id="userCreationType" class="input-short">
            	<option value="" selected="selected">Select User Type</option>
            	<option value="Admin">Admin</option>
            	<option value="Student">Student</option>
            	<option value="Teacher">Teacher</option>
            	<option value="Vendor">Vendor</option>
            </select>
            <input type="button" onclick="createUser()" value='GO>>'></input>
            </div>
            <div style="clear:both;"></div>
            
            
            
            <div class="grid_12">
                
                <!-- Notification boxes -->
                <span class="notification n-success">Success notification.</span>
                
                <span class="notification n-information">Information notification.</span>
                
                <span class="notification n-attention">Attention notification.</span>
                
                <span class="notification n-error">Error notification.</span>
                
                
                <div class="bottom-spacing">
                
                  
                    
                    <!-- Table records filtering -->
                    Filter: 
                    <select class="input-short">
                    	<option value="1" selected="selected">Select filter</option>
                        <option value="2">Created last week</option>
                        <option value="3">Created last month</option>
                        <option value="4">Edited last week</option>
                        <option value="5">Edited last month</option>
                    </select>
                    
                </div>
                
                
                <!-- Example table -->
                <div class="module">
                	<h2><span>Sample table</span></h2>
                    
                    <div class="module-table-body">
                    	<form action="">
                        <table id="myTable" class="tablesorter">
                        	<thead>
                                <tr>
                                    <th style="width:5%">#</th>
                                    <th style="width:20%">Teacher Name</th>
                                    <th style="width:21%">Student Name</th>
                                    <th style="width:13%">Category</th>
                                    <th style="width:13%">Marks</th>
                                    <th style="width:13%">Div.</th>
                                    <th style="width:15%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="align-center">1</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>992</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif'/>" alt="" width="16" height="16" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif'/>" alt="" width="16" height="16" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif'/>" alt="" width="16" height="16" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif'/>" alt="" width="16" height="16" /></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">2</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>400</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif'/>" alt="" width="16" height="16" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif'/>" /></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">3</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>528</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif'/>" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif'/>"/></a>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif'/>" /></a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif'/>" /></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">4</td>
                                    <td><a href=""></a>xyz</td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>1024</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/> </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">5</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>592</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">6</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>464</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/> </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">7</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>190</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> </a>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/> </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">8</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>304</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> 
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/> 
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">9</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>112</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> 
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/> </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">10</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>144</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/> 
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/> 
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">11</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>256</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">12</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>94</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">13</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>288</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">14</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>464</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">15</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>176</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">16</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>448</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">17</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>512</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">18</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>113</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/minus-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">19</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>400</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">20</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>288</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-center">21</td>
                                    <td><a href="">xyz</a></td>
                                    <td>xyz</td>
                                    <td>xyz</td>
                                    <td>384</td>
                                    <td>1</td>
                                    <td>
                                    	<input type="checkbox" />
                                        <a href=""><img src="<c:url value='/resources/images/tick-circle.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/pencil.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/balloon.gif' />"/>
                                        <a href=""><img src="<c:url value='/resources/images/bin.gif' />"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        </form>
                        <div class="pager" id="pager">
                            <form action="">
                                <div>
                                <img class="first" src="<c:url value='/resources/images/arrow-stop-180.gif' />"/> 
                                <img class="prev" src="<c:url value='/resources/images/arrow-180.gif' />"/>  
                                <input type="text" class="pagedisplay input-short align-center' />"/> 
                                <img class="next" src="<c:url value='/resources/images/arrow.gif' />"/> 
                                <img class="last" src="<c:url value='/resources/images/arrow-stop.gif' />"/>  
                                <select class="pagesize input-short align-center">
                                    <option value="10" selected="selected">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                </select>
                                </div>
                            </form>
                        </div>
                        <div class="table-apply">
                            <form action="">
                            <div>
                            <span>Apply action to selected:</span> 
                            <select class="input-medium">
                                <option value="1" selected="selected">Select action</option>
                                <option value="2">Publish</option>
                                <option value="3">Unpublish</option>
                                <option value="4">Delete</option>
                            </select>
                            </div>
                            </form>
                        </div>
                        <div style="clear: both"></div>
                     </div> <!-- End .module-table-body -->
                </div> <!-- End .module -->
                
                
                     <div class="pagination">           
                		<a href="" class="button"><span><img src="<c:url value='/resources/images/arrow-stop-180-small.gif' />"/>  First</span></a> 
                        <a href="" class="button"><span><img src="<c:url value='/resources/images/arrow-180-small.gif' />"/>  Prev</span></a>
                        <div class="numbers">
                            <span>Page:</span> 
                            <a href="">1</a> 
                            <span>|</span> 
                            <a href="">2</a> 
                            <span>|</span> 
                            <span class="current">3</span> 
                            <span>|</span> 
                            <a href="">4</a> 
                            <span>|</span> 
                            <a href="">5</a> 
                            <span>|</span> 
                            <a href="">6</a> 
                            <span>|</span> 
                            <a href="">7</a> 
                            <span>|</span> 
                            <span>...</span> 
                            <span>|</span> 
                            <a href="">99</a>
                        </div> 
                        <a href="" class="button"><span>Next <img src="<c:url value='/resources/images/arrow-000-small.gif' />"/> </span></a> 
                        <a href="" class="button last"><span>Last <img src="<c:url value='/resources/images/arrow-stop-000-small.gif' />"/> </span></a>
                        <div style="clear: both;"></div> 
                     </div>
                
                

                
			</div> <!-- End .grid_12 -->
                

                
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
        </div> <!-- End .container_12 -->
		
           
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