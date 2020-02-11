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

<%
Order order = (Order) request.getAttribute("ORDER_DETAILS");
//out.println(order);
%>

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
<button type="submit" value="Submit">pay</button>
<a href="orderitem.jsp"> Next Bill</a>
<a href="Cancel.jsp"> cancel Bill</a>
</body>
</html>