package com.ebanque.dao;

import java.util.List;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;

public interface UtilisateurDao {
	User connexion(User utilisateur);
	void ajouterUser( User utilisateur );
	void modifier( User utilisateur );
	void supprimer( User utilisateur );
    List<User> listeradmin();
    List<User> listerclient();
    

}
