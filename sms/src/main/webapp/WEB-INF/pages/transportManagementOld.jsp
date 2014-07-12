<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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

</body>
</html>