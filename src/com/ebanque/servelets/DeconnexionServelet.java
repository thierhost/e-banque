package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeconnexionServelet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.getSession().setAttribute("user", null);
		req.getSession().removeAttribute("user");
		resp.sendRedirect("/e-banque/index");
	}


	

}
