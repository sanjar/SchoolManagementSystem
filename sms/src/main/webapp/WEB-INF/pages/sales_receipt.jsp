<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sales Receipt</title>
<style type="text/css">
<!--
.style2 {color: #0000FF}
-->
</style>
<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css" media="screen" />
  <link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css" media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js">
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
    
    <script src="<c:url value='/resources/js/multi.js'/>" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value='/resources/js/jquery.uniform.min.js'/>" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8">
      $(function(){
        $("input:checkbox, input:radio, input:file, select").uniform();
      });
    </script>
    <script type="text/javascript">
    
    $(document).ready(function(){
    	$( "#receiptDate" ).datepicker({
            dateFormat: "dd/mm/yy",
            disabled: false
        });
    	$( "#challanDate" ).datepicker({
            dateFormat: "dd/mm/yy",
            disabled: false
        });
    	$( "#chequeDate" ).datepicker({
            dateFormat: "dd/mm/yy",
            disabled: false
        });
    	
    /* 	if('${disableNext}'){
    		$('#nextButton').attr('disabled','disabled');
    	}
    	if('${disablePrevious}'){
    		$('#previousButton').attr('disabled','disabled');
    	} */
    });
    
    </script>
</head>
<body>

<div id="header">
  <div class="left">
    <p><a href="">SCHOOL ACCOUNTS MANAGEMENT SYSTEM<!-- <span class="alt">Management</span> --></a></p>
  </div>

  

  <div class="subheader">
    <p>
      <span class="hidden">Navigation:</span>
      <a href="/sms/home" class="highlight">Home</a> |
      <a href="">Contact</a> |
     
    </p>
  </div>
</div>







<article>

<form:form class="mrg-top" id="processSalesReceipt" action="processSalesReceipt">

	<ul>
    
    <li class="f">
<h3 class="back">Sales Receipt</h3>
</li>
 
					<c:if test="${noSalesReceiptFound}">
					<li class="f">
						<label style="color:red">No Sales Receipt Found.</label>
						</li>
					</c:if>
					<c:if test="${salesReceiptSaved}">
					<li class="f">
						<label style="color: green">Sales Receipt Saved!!!</label>
						</li>
					</c:if> <c:if test="${salesReceiptDeleted}">
					<li class="f">
						<label style="color: green">Sales Receipt Deleted!!!</label>
						</li>
					</c:if>
					<c:if test="${isFormIncomplete}">
					  <li class="f">
						<span style="color: red">Form Incomplete!!! All mandatory fields are required.</span>
						</li>
				</c:if>
				
        <li class="f">
        
        	<label for="name" class="fl">Challan No. </label>
            <form:input type="text" size="20" id="challanNo" class="fl" path="challanNo" readonly="false"/>
           
            <label for="name" class="fl" style="margin-left: 53px">Date </label>
            <form:input type="text" size="20" id="challanDate"  class="fl" path="challanDate"/>
            
            <label for="name" class="fl" style="margin-left: 53px">Invoice No. </label>
            <form:input type="text" size="20" id="invoiceNo" class="fl" path="invoiceNo" />
            
</li>
        <li  class="f">
        
            <label for="name" class="fl">Customer Name </label>
            <form:input type="text" size="20" id="customerName"  class="fl" path="customerName"/>
            <label for="name" class="fl" style="margin-left: 53px">Customer Code </label>
            <form:input type="text" size="20" id="customerCode"  class="fl" path="customerCode"/>
             <label for="name" class="fl" style="margin-left: 53px">Sale Type </label>
            <form:select id="saleType" path="saleType" >
            	<form:options items="${saleTypeList}" />
            </form:select>
        </li>
        	

 

<li  class="f">
				 <button class="left" name="action" value="save">Save</button>
				 <button class="left" name="action" value="delete">Delete</button>
				 <button class="left" name="print" value="print" onclick="window.print(); return false;">Print</button>
				 <button class="left" name="action" value="new">Create New</button>
				 <button class="left" name="exit" value="exit" onclick="window.close(); return false;">Exit</button>
				 <button class="left" name="action" value="search">Search</button>
				 <button class="left" name="action" value="calculate">Calculate Now</button>
				 <!-- <button id="nextButton" class="left" name="action" value="next">Next</button>
				 <button id="previousButton" class="left" name="action" value="previous">Previous</button>
				 <button class="left" name="action" value="last">Last</button>
				 <button class="left" name="action" value="first">First</button> -->
				</li>

</ul>
<%-- <iframe name="items" src="<c:url value='/resources/jsp/item_table.jsp'/>" height="1000" width="1250" style="overflow:auto" draggable="true"></iframe> --%>

<table border="1" style="width:100px;height: 500px;overflow: scroll;" >
<thead>
  <tr>
    <th width="10" scope="col"><span class="style2">S.No </span></th>
    <th width="20" scope="col"><span class="style2">P. Code </span></th>
    <th width="80" scope="col"><span class="style2">Description</span></th>
    <th width="78" scope="col"><span class="style2">Type </span></th>
    <th width="78" scope="col"><span class="style2">Qty(Box)</span></th>
    <th width="78" scope="col"><span class="style2">Discount</span></th>
    <th width="115" scope="col"><span class="style2">Total Amount </span></th>
  </tr>
</thead>
<tbody>
  <c:forEach begin="0" end="19" var="x" >
  <tr>
    <th scope="row">${x+1}</th>
    <td style="width: 100px"><form:input  path="salesReceiptItemList[${x}].productCode" id="productCode" style="width: 100px"/></td>
    <td style="width: 300px"><form:input path="salesReceiptItemList[${x}].description" id="description" style="width: 300px"/></td>
    <td style="width: 100px"><form:input path="salesReceiptItemList[${x}].type"  id="type" style="width: 100px"/></td>
    <td style="width: 78px"><form:input path="salesReceiptItemList[${x}].quantityBox"  id="quantityBox" style="width: 78px"/></td>
    <td style="width: 100px"><form:input path="salesReceiptItemList[${x}].discount"  id="discount" style="width: 100px"/></td>
    <td style="width: 100px"><form:input path="salesReceiptItemList[${x}].totalAmount"  id="totalAmount" style="width: 100px"/></td>
    <form:input type="hidden" path="salesReceiptItemList[${x}].salesReceipt.challanNo"/>
    <form:input type="hidden" path="salesReceiptItemList[${x}].itemId"/>
  </tr>
  </c:forEach>
  </tbody>
</table>


<table>
	<tr>
	<td><span >Gross Value :</span></td>
	<td><form:label id="grossValue" path="grossValue" cssStyle="color:blue">${command.grossValue}</form:label></td>
	<td><span>Scheme :</span></td>
	<td><form:label id="scheme" path="scheme" cssStyle="color:blue">${command.scheme}</form:label></td>
	<td><span>Discount :</span></td>
	<td><form:label id="discount" path="discount" cssStyle="color:blue">${command.discount}</form:label></td>
	<td><span>Tax </span></td>
	<td><form:label id="tax" path="tax" cssStyle="color:blue">${command.tax}</form:label></td>
	<td style="float:right"><span>Net Value :</span></td>
	<td><form:label id="netValue" path="netValue" cssStyle="color:blue">${command.netValue}</form:label></td>
	</tr>
	<tr>
	<td><span>Commission :</span></td>
	<td><form:label id="commission" path="commission" cssStyle="color:blue">${command.commission}</form:label></td>
	<td><span>TDS :</span></td>
	<td><form:label id="TDS" path="TDS" cssStyle="color:blue">${command.TDS}</form:label></td>
	
	
	
	</tr>


</table>
</form:form>

</article>
<div id="footer">
  <hr />
  Copyright &copy; 2013&ndash;2014, <a href="">Institute Name.</a>  All rights reserved.
  <span class="notprinted">
    <a href="index.html">Terms of Use</a>.
    <a href="index.html">Privacy Policy</a>.
  </span>
  <br />

  This web site is maintained by
 <a href="http://www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div>