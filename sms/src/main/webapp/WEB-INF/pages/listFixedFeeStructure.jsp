<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>Welcome Admin</title>
       
       <!-- Fluid 960 Grid System - CSS framework -->
		<link rel="stylesheet" type="text/css" href="css/grid.css"  media="screen" />
		
<!-- Main stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/styles.css"  media="screen" />
        <link rel="StyleSheet" href="css/main-screen.css" type="text/css" media="screen" />
  <link rel="StyleSheet" href="css/main-print.css" type="text/css" media="print" />

<!-- Table sorter stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/tablesorter.css" media="screen" />
        
        <!-- Thickbox stylesheet -->
        <link rel="stylesheet" type="text/css" href="css/thickbox.css" media="screen" />
         
  
        
        
        <link rel="stylesheet" type="text/css" href="css/theme-blue.css" media="screen" />
       
        
		<!-- JQuery engine script-->
		<script type="text/javascript" src="js/jquery-1.3.2.min.js" ></script>
        
		<!-- JQuery WYSIWYG plugin script -->
		<script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
        
        <!-- JQuery tablesorter plugin script-->
		<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
        
		<!-- JQuery pager plugin script for tablesorter tables -->
		<script type="text/javascript" src="js/jquery.tablesorter.pager.js" ></script>
        
		<!-- JQuery password strength plugin script -->
		<script type="text/javascript" src="js/jquery.pstrength-min.1.2.js" ></script>
        
		<!-- JQuery thickbox plugin script -->
		<script type="text/javascript" src="js/thickbox.js" ></script>
        
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
		}); 
		</script>
        
        <!-- Initiate password strength script -->
		<script type="text/javascript">
			$(function() {
			$('.password').pstrength();
			});
        </script>
	</head>
	<body>
    	<!-- Header -->
        <div id="header">
  <div class="left">
    <p><a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a></p>
  </div>

  

  <div class="subheader">
    <p>
      <span class="hidden">Navigation:</span>
      <a href=""class="highlight">Home</a> |
      <a href="">Contact</a> |
     
    </p>
  </div>
</div>
                        
                    
                <div style="clear: both;"></div>
            
        
		 <!-- End .container_12 -->
         	<div id="sidebar" >							
			
				<table>
				
				<tr>
				<td></td>
				
				
				</tr>
				
				
				
				</table>
			
            
		</div>
           
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
 <a href="www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div> <!-- End #footer -->
	</body>
</html>