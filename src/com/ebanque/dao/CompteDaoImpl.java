package com.ebanque.dao;

import java.sql.SQLException;
import java.util.List;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CompteDaoImpl implements CompteDao{
	private DaoFactory daoFactory;
	public CompteDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void creercompte(Compte compte, User user) {
		UtilisateurDao utilisateurDao;
		utilisateurDao = daoFactory.getUtilisateurDao();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        /* l'ajout d'un compte se fait en 2 etapes on ajoute d'abord le User
         * puis la clé primaire (login) de User migre vers le models du compte bancaire
         */
        
        // appel de la methode d'ajout d'un compte 
        utilisateurDao.ajouterUser(user);
        
        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO compte(solde,decouvertmaximal,debitmaximal,login_user) VALUES(?,?,?,?);");
            preparedStatement.setFloat(1, compte.getSolde());
            preparedStatement.setInt(2, compte.getDebitmaximal());
            preparedStatement.setInt(3, compte.getDebitmaximal());
            preparedStatement.setString(4,user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		

	
		
	}
	@Override
	public List<Compte> listercompte(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
