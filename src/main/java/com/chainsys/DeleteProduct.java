package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductImple pi=new ProductImple();
		Product p=new Product();
		
		String d=(request.getParameter("pid"));
		p.setProductname(d);
				try {
			pi.deleteproductDetails(p);
			request.setAttribute("order", "Deleted Succesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProduct.jsp");
			dispatcher.forward(request, response);

		} catch (DbException e) {
			e.printStackTrace();
		}
		
	}

	
}
