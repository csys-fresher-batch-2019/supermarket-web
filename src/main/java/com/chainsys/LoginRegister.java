package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.LoginImple;
import com.chainsys.supermarketapp.model.Login;

public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pword = request.getParameter("pwd");
		LoginImple log = new LoginImple();
		Login log1 = new Login();
		log1.setUsername(uname);
		log1.setPassword(pword);
		boolean inserted = false;
		PrintWriter out = response.getWriter();
		boolean alreadyRegistered = false;
		try {
			alreadyRegistered = log.isUsernameExists(log1.getUsername());
			System.out.println(alreadyRegistered);
			if (alreadyRegistered) {

				System.out.println("already");// Username already exists

			} else {
				log.add(log1);
				inserted = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
			inserted = false;
		}

		out.println(inserted);

		if (alreadyRegistered) {
			request.setAttribute("Error-message", "username Already Exist");
			RequestDispatcher dispatcher = request.getRequestDispatcher("NewUserRegistration.jsp");
			dispatcher.forward(request, response);
		} else if (inserted) {
			request.setAttribute("Success", "registration succesfull");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
