<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>form</title>
<link rel="StyleSheet" href="<c:url value='/resources/css/main-screen.css' />" type="text/css" media="screen" />
  <link rel="StyleSheet" href="<c:url value='/resources/css/main-print.css' />" type="text/css" media="print" />
<link rel="stylesheet" href="<c:url value='/resources/css/style4.css' />" />
<link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>
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
</head>
<body>

<div id="header">
  <div class="left">
    <p><a href="">School<span class="alt">Management</span></a></p>
  </div>

  <div class="right">
    <span class="hidden">Useful links:</span>
    <a href="">Home</a> |
    <a href="">Login</a> |
    <a href="">Contact</a> |
    
  </div>

  <div class="subheader">
    <p>
      <span class="hidden">Navigation:</span>
      <a href="" class="highlight">Home</a> |
      <a  href="">Login</a> |
      <a href="">Contact</a> |
     
    </p>
  </div>
</div>







<article>

<form class="mrg-top" id="new">

	<ul>
    
    <li class="f">
<h3 class="back">Employee Master</h3>
</li>
        <li class="f">
        
        	<label for="name" class="fl">Employee Id:</label>
            <input type="text" size="25" id="name" class="fl" />
            
 </div>          
           
      
            <label for="name" class="fl" id="mrgn">Employee Name:</label>
            <input type="text" size="25" id="name"  class="fl"/>
 
 </div>      
</li>
        <li  class="f">
        <label for="name" class="fl">Id Card No:</label>
            <input type="text" size="25" id="name" class="fl" />
            
           <label for="name" class="fl" id="mrgn">Gender:</label>
            <select id="">
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
            </select>
        
        </li>
        	
       
 <li  class="f">
        	<label for="name" class="fl">P.F. No.:</label>
            <input type="text" size="25" id="name" class="fl" />
            
            <label for="name" class="fl" id="mrgn">Esi No.:</label>
            <input type="text" size="25" id="name"  class="fl"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">Pan No.:</label>
            <input type="text" size="25" id="name" class="fl" />
            
            <label for="name" class="fl" id="mrgn">Eps No.:</label>
            <input type="text" size="25" id="name"  class="fl"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">Bank a/c no.:</label>
            <input type="text" size="25" id="name" class="fl" />
            
            <label for="name" class="fl" id="mrgn">DOB:</label>
            <input type="text" size="25" id="name"  class="fl"/>
       
</li>

 <li  class="f">
        	<label for="name" class="fl">DOJ:</label>
            <input type="text" size="25" id="name" class="fl" />
            
            
             <label for="name" class="fl" id="mrgn">Salary Code:</label>
            <select id="">
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
            </select>
       
</li>
<li  class="f">
<label for="name" class="fl" >Department:</label>
            <select id="">
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
            </select>
</li>


<li  class="f">
<label for="name" class="fl" >Designation:</label>
            <select id="car">
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
            </select>
</li>


<li  class="f">
<label for="name" class="fl" >Grade:</label>
            <select id="">
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
                <option>xyz</option>
            </select>
</li>

<li  class="f">
 <button type="" class="left">Add</button>
 <button type="" class="left">Modify</button>
 <button type="" class="left">Delete</button>
 <button type="" class="left">Next</button>
 <button type="" class="left">Previous</button>
 <button type="" class="left">Last</button>
 <button type="" class="left">First</button>
 <button type="" class="left">Search</button>
</li>










       
    
</form>

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
 <a href="www.dsisoftware.net" target="_blank">www.dsisoftware.net</a>.
  
</div>