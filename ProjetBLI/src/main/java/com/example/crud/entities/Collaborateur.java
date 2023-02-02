package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborateur {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String CUID;
	private String nom;
	private String prenom;
	private String adresse;
	private String mdp;
	private Date date_integration;
	private String fonction;
	private String id_equipe;
	
	public String getCUID() {
		return CUID;
	}
	public void setCUID(String cUID) {
		CUID = cUID;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Date getDate_integration() {
		return date_integration;
	}
	public void setDate_integration(Date date_integration) {
		this.date_integration = date_integration;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	public String getId_equipe() {
		return id_equipe;
	}
	public void setId_equipe(String id_equipe) {
		this.id_equipe = id_equipe;
	}
	public Collaborateur() {
		super();
	}
	public Collaborateur(String cUID, String nom, String prenom, String adresse, String mdp, Date date_integration,
			 String fonction) {
		super();
		CUID = cUID;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.date_integration = date_integration;
		this.fonction = fonction;
	}
	
	
	public Collaborateur(String cUID, String nom, String prenom, String id_equipe) {
		super();
		CUID = cUID;
		this.nom = nom;
		this.prenom = prenom;
		this.id_equipe = id_equipe;
	}

	public Collaborateur(String cUID, String nom, String prenom, String adresse, String mdp, Date date_integration,
			String fonction, String id_equipe) {
		super();
		CUID = cUID;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.date_integration = date_integration;
		this.fonction = fonction;
		this.id_equipe = id_equipe;
	}
	@Override
	public String toString() {
		return "Collaborateur [CUID=" + CUID + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", mdp="
				+ mdp + ", date_integration=" + date_integration + ", fonction=" + fonction + ", id_equipe=" + id_equipe
				+ "]";
	}

	
	
	
	
	
	
	

}
