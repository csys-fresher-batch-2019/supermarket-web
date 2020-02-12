package com.chainsys;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.util.Logger;

public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cus = request.getParameter("cusnum");
		int cusno = Integer.valueOf(cus);
		String[] arr = request.getParameterValues("pid");

		int totalAmount = 0;
		ProductImple pi = new ProductImple();
		Order order = new Order();
		order.setCustomerno(cusno);
		try {
			for (String string : arr) {

				int product_id = Integer.parseInt(string);
				int quantity = Integer.parseInt(request.getParameter("qty_" + string));

				int price = pi.getProductPrice(product_id);
				int tprice = price * quantity;
				
				OrderItem item = new OrderItem();
				item.setProductId(product_id);
				item.setQuantity(quantity);
				item.setTotalAmount(tprice);
				order.addItem(item);
				
				//add amount to total
				totalAmount = totalAmount + tprice;
				

			}
			
			order.setTotalAmount(totalAmount);
			order.setOrderedDate(LocalDateTime.now());
			order.setStatus("ORDERED");
			
			BillOrderImple boi = new BillOrderImple();
			int orderId = boi.addBillOrder(order);
			order.setOrderId(orderId);
			
			request.setAttribute("ORDER_DETAILS", order);

			RequestDispatcher dispatcher = request.getRequestDispatcher("BillReceipt.jsp");
			dispatcher.forward(request, response);
			
		} catch (DbException e) {
			e.printStackTrace();
			log.error(e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("orderitem.jsp");
			dispatcher.forward(request, response);
		}
		

		
		
	}

}
