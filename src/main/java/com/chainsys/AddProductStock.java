package com.chainsys;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;

public class AddProductStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		int prno=Integer.parseInt(request.getParameter("pno"));
    		int qty=Integer.parseInt(request.getParameter("qut"));
    		String ad=request.getParameter("ad");
    		LocalDate a=LocalDate.parse(ad);
    		String ed=request.getParameter("ed");
    		LocalDate ex=LocalDate.parse(ed);
    		ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			
			ps.setProductno(prno);
			ps.setQuantity(qty);
			ps.setProductarrival(a);
			ps.setExperydate(ex);
			try {
				psi.addProductStock(ps);
				
				request.setAttribute("AddStock", "Adding Stock Details Suucesfully");

				RequestDispatcher dispatcher = request.getRequestDispatcher("AddProductStock.jsp");
				dispatcher.forward(request, response);

			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

}
