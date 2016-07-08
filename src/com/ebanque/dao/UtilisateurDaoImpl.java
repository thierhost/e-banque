package com.ebanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebanque.beans.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UtilisateurDaoImpl implements UtilisateurDao {
	private DaoFactory daoFactory;
	
	UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }



	@Override
	public void modifier(User utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(User utilisateur) {
		// TODO Auto-generated method stub

	}


	@Override
	public User connexion(User utilisateur) {
		User user = new User();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        PreparedStatement preparedStatement = null;


        try {
            connexion = (Connection) daoFactory.getConnection();
            statement = (Statement) connexion.createStatement();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * from user where login=? and password=?");
            preparedStatement.setString(1, utilisateur.getLogin());
            preparedStatement.setString(2, utilisateur.getPassword());
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String adresse = resultat.getString("adresse");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                boolean admin  = resultat.getBoolean("est_admin");
                
                user.setLogin(login);
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setPassword(password);
                user.setAdresse(adresse);
                user.setEst_admin(admin);
                            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	@Override
	public void ajouterUser(User utilisateur) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connexion.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?);");
            preparedStatement.setString(1, utilisateur.getLogin());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getAdresse());
            preparedStatement.setBoolean(6, utilisateur.getEst_admin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}




	@Override
	public List<User> listeradmin() {
		 List<User> admin = new ArrayList<User>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = (Connection) daoFactory.getConnection();
	            statement = (Statement) connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM user where est_admin=true;");

	            while (resultat.next()) {
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String login = resultat.getString("login");
	                String adresse = resultat.getString("adresse");
	                
	                User utilisateur = new User();
	                utilisateur.setNom(nom);
	                utilisateur.setPrenom(prenom);
	                utilisateur.setAdresse(adresse);
	                utilisateur.setLogin(login);
	                admin.add(utilisateur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return admin;
	    }

		
	

	@Override
	public List<User> listerclient() {
		
		 List<User> client = new ArrayList<User>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = (Connection) daoFactory.getConnection();
	            statement = (Statement) connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM user where est_admin=false;");

	            while (resultat.next()) {
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String login = resultat.getString("login");
	                String adresse = resultat.getString("adresse");
	                
	                User utilisateur = new User();
	                utilisateur.setNom(nom);
	                utilisateur.setPrenom(prenom);
	                utilisateur.setAdresse(adresse);
	                utilisateur.setLogin(login);
	                client.add(utilisateur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return client;
	    }


	}

		
	



