<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<title>Adding Product Stock</title>
</head>
<body><pre>
	
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		<center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
			
Enter the Product Number	<input type="number" name="pno" placeholder="Product Number" required autofocus/>
Enter the quantity			<input type="number" name="qut" placeholder="Quantity" required autofocus/>
Enter the arrival date		<input type="date" name="ad" placeholder="Arrival Date" required autofocus/>
Enter the Expery date		<input type="date" name="ed" placeholder="Expery Date" required autofocus/>
				<input type="submit" value="Adding Stock">
</pre>
</body>
</html>