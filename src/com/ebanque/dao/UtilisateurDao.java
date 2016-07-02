package com.ebanque.dao;

import java.util.List;

import com.ebanque.beans.User;

public interface UtilisateurDao {
	User connexion(User utilisateur);
	void ajouter( User utilisateur );
	void modifier( User utilisateur );
	void supprimer( User utilisateur );
    List<User> lister();

}
