package com.chainsys;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.model.ProductStock;

public class AddProductStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		int prno=Integer.parseInt(request.getParameter("pno"));
    		int qty=Integer.parseInt(request.getParameter("qut"));
    		LocalDate d=LocalDate.now("");
    		Date da=Date.valueOf("ed");
    		
    		ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			ps.setProductno(prno);
			ps.setQuantity(qty);
			ps.setProductarrival(d);
    	}

}
