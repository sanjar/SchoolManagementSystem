<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Fee Management</title>

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
		
		/* $('#manageFixedFee').click(function(event){
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
		
		$('#feePayment').click(function(event){
			event.preventDefault();
			window.open('feePayment',"_blank",'scrollbars=1,toolbar=0,location=0,menubar=0');
		}); */
	});
</script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">  
        $(document).ready(function(){
           /*  $("#report tr.head:odd").addClass("odd");
            $("#report tr.head:not(.odd)").hide();
            $("#report tr.head:first-child").show(); */
            $("tr.head").hide();
            $("tr.odd").click(function(){
                $(this).next("tr").toggle();
                $(this).find(".arrow").toggleClass("up");
            });
            //$("#report").jExpand();
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
				<a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a>
			</p>
		</div>

		

		<div class="subheader">
			<p>
				<span class="hidden">Navigation:</span> <a href="/home">Home</a> | <a href="">Contact</a> |

			</p>
		</div>
	</div>


	<!-- ======== Left Sidebar ======== -->



	<!-- ======== Main Content ======== -->
<div><h2> <span ><center>Sales Receipt List</center></span></h2></div>	
<div id="sidebar1" >							

		
<br />				
<table width="1224" border="1" id="report">
  <tr>
    <th width="95" scope="col"><u><span style="color: yellow">Challan No</span></u></th>
    <th width="95" scope="col"><u><span style="color: yellow">Challan Date</span></u></th>
    <th width="95" scope="col"><u><span style="color: yellow">Customer Name</span></u></th>
    <th width="76" scope="col"><u><span style="color: yellow">Customer Code</span></u></th>
    <th width="76" scope="col"><u><span style="color: yellow">Invoice No</span></u></th>
    <th width="76" scope="col"><u><span style="color: yellow">Gross Value</span></u></th>
    <th width="76" scope="col"><u><span style="color: yellow">Net Value</span></u></th>
    <th></th>
    
  </tr>
  <c:forEach var="salesReceipt" items="${salesReceipts}">
  <tr class="odd">
    <td>${salesReceipt.challanNo}</td>
    <td>${salesReceipt.challanDate}</td>
    <td>${salesReceipt.customerName}</td>
    <td>${salesReceipt.customerCode}</td>
    <td>${salesReceipt.invoiceNo}</td>
    <td>${salesReceipt.grossValue}</td>
    <td>${salesReceipt.netValue}</td>
    <td style="width: 1px" ><div class="arrow"></div></td>
  </tr>
  <tr class="head"><td colspan="7">
  <div>
  <table id="inner">
  		<tr>
		  	<th width="95" scope="col"><u><span style="color: yellow">product Code</span></u></th>
		    <th width="95" scope="col"><u><span style="color: yellow">Description</span></u></th>
		    <th width="95" scope="col"><u><span style="color: yellow">Type</span></u></th>
		    <th width="76" scope="col"><u><span style="color: yellow">Quantity</span></u></th>
		    <th width="76" scope="col"><u><span style="color: yellow">Discount</span></u></th>
		    <th width="76" scope="col"><u><span style="color: yellow">Total Amount</span></u></th>
  		</tr>
  <c:forEach var="salesReceiptItem" items="${salesReceipt.salesReceiptItemList}">
  <tr>
    <td>${salesReceiptItem.productCode}</td>
    <td>${salesReceiptItem.description}</td>
    <td>${salesReceiptItem.type}</td>
    <td>${salesReceiptItem.quantityBox}</td>
    <td>${salesReceiptItem.discount}</td>
    <td>${salesReceiptItem.totalAmount}</td>
    
  </tr>
  </c:forEach>
  </table></div></td></tr>
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
