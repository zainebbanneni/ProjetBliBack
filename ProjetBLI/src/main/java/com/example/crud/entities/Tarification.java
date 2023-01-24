package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code_tarif;
	private String nom_prestation;
	private long valeur;
	public String getCode_tarif() {
		return code_tarif;
	}
	public void setCode_tarif(String code_tarif) {
		this.code_tarif = code_tarif;
	}
	public String getNom_prestation() {
		return nom_prestation;
	}
	public void setNom_prestation(String nom_prestation) {
		this.nom_prestation = nom_prestation;
	}
	public long getValeur() {
		return valeur;
	}
	public void setValeur(long valeur) {
		this.valeur = valeur;
	}
	public Tarification() {
		super();
	}
	public Tarification(String code_tarif, String nom_prestation, long valeur) {
		super();
		this.code_tarif = code_tarif;
		this.nom_prestation = nom_prestation;
		this.valeur = valeur;
	}
	@Override
	public String toString() {
		return "Tarification [code_tarif=" + code_tarif + ", nom_prestation=" + nom_prestation + ", valeur=" + valeur
				+ "]";
	}
	
	
	
	

}
