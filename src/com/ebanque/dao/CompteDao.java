package com.ebanque.dao;

import java.util.List;

import com.ebanque.beans.Compte;
import com.ebanque.beans.User;

public interface CompteDao {
	void creercompte (Compte compte,User user);
	List<Compte> mescomptes(User user);
	boolean crediter(Compte compte,float montant);
	boolean debiter (Compte compte,Compte compte_re, float montant);
	Compte getComptebyNumero(int numero);
}
