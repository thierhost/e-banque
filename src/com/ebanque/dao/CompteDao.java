package com.ebanque.dao;

import java.util.List;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;

public interface CompteDao {
	void creercompte (Compte compte,User user);
	List<Compte> listercompte(User user);

}
