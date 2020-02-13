<%@page import="com.chainsys.supermarketapp.model.OrderItem"%>
<%@page import="com.chainsys.supermarketapp.model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#85C1E9">
<form action="BillPay.jsp">
<center><h1>* Gk SuperMarket *</h1></center>
<center><h2>* Bills *</h2></center>

<%
Order order = (Order) request.getAttribute("ORDER_DETAILS");
//out.println(order);
%>


<table>
<thead>
<th>ProductID </th>
<th>Quantity</th>
<th>price</th>
<th>Status</th>
</tr>
</thead>

<tbody>
<%
for(OrderItem item: order.getItems()){
%>
<tr>
<td><%=item.getProductId() %>  </td>
<td><%=item.getQuantity()%></td>
<td>Rs.<%=item.getTotalAmount() %></td>
<td><%= item.getStatus() %></td>

</tr>
<%} %>
</tbody>
</table>
</br>
</br>
<table>
<thead>
<tr><th>Bill NO</th>
<th>Customer Number</th>
<th>Total Amount</th>
<th>orderedDate</th></tr>
</thead>
<tbody>
<tr>
<td> <%= order.getOrderId() %> </td>
<td><%=order.getCustomerno() %>  </td>
<td> <%=order.getTotalAmount() %> </td>
<td>  <%=order.getOrderedDate() %></td>

</tr>
</tbody>
</table>

<pre>						<button type="submit" value="Submit">pay</button></br>
							<a href="orderitem.jsp">Next Bill</a></br>
							<a href="Cancel.jsp">cancel Bill</a></br>
</pre>
</form>
</body>
</html>