package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanque.beans.Compte;
import com.ebanque.dao.CompteDao;
import com.ebanque.dao.DaoFactory;

public class DebiterServelet extends HttpServlet {
	private CompteDao compteDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.compteDao = daoFactory.getCompteDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/client/debiter.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int debiteur = Integer.parseInt(req.getParameter("debiteur"));
		int crediteur = Integer.parseInt(req.getParameter("crediteur"));
		float montant = Float.parseFloat(req.getParameter("montant"));
		// on verifie si le compt exite
		Compte compte_crediteur = compteDao.getComptebyNumero(crediteur);
		Compte compte_debiteur = compteDao.getComptebyNumero(debiteur);
		if(compte_crediteur!=null && compte_debiteur!=null)
		{
			if(compteDao.debiter(compte_debiteur, compte_crediteur, montant)==true){
				resp.sendRedirect("/e-banque/client/index");
				
			}else
			{
				// erroor
			}
		}else
		{
			//eroorrr
		}
	}
	

}
