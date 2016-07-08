package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanque.beans.User;
import com.ebanque.dao.CompteDao;
import com.ebanque.dao.DaoFactory;
import com.ebanque.dao.UtilisateurDao;

public class AccueilClientServelt  extends HttpServlet{
	private CompteDao comptedao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.comptedao = daoFactory.getCompteDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// On appelra ici la methode pour lister les compte pour un client :)))
		User user = (User) req.getSession().getAttribute("user");
		if(user != null)
		{
			req.setAttribute("mescomptes",comptedao.mescomptes(user));	
		}
	    req.getRequestDispatcher("/WEB-INF/client/index.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}
