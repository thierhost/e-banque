package com.ebanque.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanque.beans.User;
import com.ebanque.dao.DaoFactory;
import com.ebanque.dao.UtilisateurDao;

public class ConnexionServelet extends HttpServlet {
	private UtilisateurDao utilisateurDao;
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ce servelet permet de gerer la connexion d'un utilisateur
		// on lui renvoie le formulaire de connexion
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		User user = new User();
		User userconnecte;
		user.setLogin(req.getParameter("login"));
		user.setPassword(req.getParameter("password"));
		userconnecte = utilisateurDao.connexion(user);
		System.out.println(userconnecte.getEst_admin());
		//  on verifie si le user est bien connecte
		if(userconnecte.getNom()!=null)
		{
			// on verifie si le user est admin ou pas
			if(userconnecte.getEst_admin()==true)
			{
				// alors c'est un admin on le redirege vers la partie admin
				req.getSession().setAttribute("user",userconnecte);
				resp.sendRedirect("/e-banque/admin/index");
			}else
			{
				// on le redirige vers la partie client
				req.getSession().setAttribute("user",userconnecte);
				//req.getRequestDispatcher().forward(req, resp);
				resp.sendRedirect("/e-banque/client/index");
			}
			
		}else
		{
			// on renvoie la page avec une erreur
			String erreur ="error";
			req.setAttribute("error", erreur);
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		
	}
	

}
