<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@  page import="com.chainsys.supermarketapp.dao.impl.ProductImple"%>
<%@  page import="com.chainsys.supermarketapp.model.Product"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
<html>
<head>
<title>orderItem</title>
</head>
<body bgcolor="crey">
	<form action="Bill">

		<pre>							
							<b>GK-SuperMarket </b>
	</pre>
			
		<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>

Enter the Customer No : <input type="number" name="cusnum" required autofocus/> <br/><br/> <br/><br/>
<%		 
	ProductImple pi = new ProductImple();
 	List<Product> list = pi.displayproduct();
 	 %>
 			<table >
				<thead>
					<tr>
						<th>S.no</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Order</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
						for (Product p : list) {
					%>
					<tr>
						<td><%=(i++)%></td>
						<td><%=p.getPid()%></td>
						<td><%=p.getProductname()%></td>
						<td>Rs.<%=p.getPrice()%></td>
						<td><input type="checkbox" name="pid" value="<%=p.getPid() %>"></td>
						<td><input type="text" name="q1<%=p.getPid() %>"></td>

					</tr>
					<%
						}
					%>
				</tbody>
			</table> <br>
		<pre>
		<button type="submit">Submit</button>
				<a href="bill.jsp">goto bills</a>		
				<a href="Login.jsp">back to login</a>
</pre>
	</form>
</body>
</html>