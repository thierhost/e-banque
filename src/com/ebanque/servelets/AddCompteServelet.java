package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;
import com.ebanque.dao.CompteDao;
import com.ebanque.dao.DaoFactory;
import com.ebanque.dao.UtilisateurDao;

public class AddCompteServelet  extends HttpServlet{
	private CompteDao compteDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.compteDao = daoFactory.getCompteDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/admin/addcompte.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// recuperation des inputs provenenant du formulaire
		User client= new User();
		
		client.setPrenom(req.getParameter("prenom"));
		client.setNom(req.getParameter("nom"));
		client.setAdresse(req.getParameter("adresse"));
		client.setLogin(req.getParameter("login"));
		client.setPassword(req.getParameter("password"));
		client.setEst_admin(false);
		float solde = Float.parseFloat(req.getParameter("solde"));
		int decouvertmaximal = Integer.parseInt(req.getParameter("decouvertmaximal"));
		int debitmaximal = Integer.parseInt(req.getParameter("debitmaximal"));
		
		Compte compte = new Compte(solde,decouvertmaximal,debitmaximal);
		compteDao.creercompte(compte, client);
		
	
		
	}
	

}
