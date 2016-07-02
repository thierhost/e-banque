package com.ebanque.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	public void ajouter(User utilisateur) {
		// TODO Auto-generated method stub

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
	public List<User> lister() {
		// TODO Auto-generated method stub
		return null;
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
            preparedStatement = (PreparedStatement) connexion.prepareStatement("SELECT * user where login=? and password=?");
            preparedStatement.setString(1, utilisateur.getLogin());
            preparedStatement.setString(2, utilisateur.getPassword());

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

		
	

}

