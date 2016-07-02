package com.ebanque.beans;

import com.ebanque.beans.Compte;

import java.util.ArrayList;
import java.util.List;


public class User {
	private String login,password,nom,prenom,adresse;
	private boolean est_admin;
    private List<Compte> mescomptes;
    
    public User(String nom, String prenom, String adresse, Compte a)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		mescomptes = new ArrayList<Compte>();
		mescomptes.add(a);
		
	}
	
	// getters
	
	public String getNom()
	{
		return this.nom;
	}
	public String getPrenom()
	{
		return this.prenom;
	}
	public String getAdresse()
	{
		return this.adresse;
	}
	
	public List<Compte> getCompte()
	{
		return this.mescomptes;
	}
	
	// ajouter un nouveau compte
	
	public void addCompte(Compte a)
	{
		this.mescomptes.add(a);
	}
}
