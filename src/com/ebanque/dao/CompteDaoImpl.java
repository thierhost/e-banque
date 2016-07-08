package com.ebanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

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
	public List<Compte> mescomptes(User user) {
		// TODO Auto-generated method stub
		 List<Compte> mescomptes = new ArrayList<Compte>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        PreparedStatement preparedStatement = null;


	        try {
	            connexion = (Connection) daoFactory.getConnection();
	          //  statement = (Statement) connexion.createStatement();
	            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM compte where  login_user=?;");
	            preparedStatement.setString(1, user.getLogin());
	            resultat = preparedStatement.executeQuery();	
	            while (resultat.next()) {
	                int  numero = resultat.getInt("numero_compte");
	                float solde = resultat.getFloat("solde");
	                int decouvertmax = resultat.getInt("decouvertmaximal");
	                int debitmaximal = resultat.getInt("debitmaximal");
	                
	                Compte compte = new Compte(solde, decouvertmax, debitmaximal);
	                compte.setNumero(numero);
	                mescomptes.add(compte);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return mescomptes;
	    }


	}
	


