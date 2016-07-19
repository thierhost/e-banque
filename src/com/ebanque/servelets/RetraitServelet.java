package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanque.beans.Compte;
import com.ebanque.dao.CompteDao;
import com.ebanque.dao.DaoFactory;

public class RetraitServelet  extends HttpServlet{
	private CompteDao compteDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.compteDao = daoFactory.getCompteDao();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/client/retrait.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// recuperaion des input
				int numero = Integer.parseInt(req.getParameter("numero_compte"));
				float montant = Float.parseFloat(req.getParameter("montant"));
				// on verifie si le compt exite
				Compte compte = compteDao.getComptebyNumero(numero);
				if(compte!=null)
				{
					// on credite ici
					if(compteDao.retrait(compte, montant)==true)
					{
						// on affiche success
						resp.sendRedirect("/e-banque/client/index");
					}else
					{
						// on affiche error
					}
					
				}else
				{
					// on affiche error
				}
				
			}
			

	}
	


