package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prestation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_prestation;
	private String nom_prestation;
	public String getId_prestation() {
		return id_prestation;
	}
	public void setId_prestation(String id_prestation) {
		this.id_prestation = id_prestation;
	}
	public String getNom_prestation() {
		return nom_prestation;
	}
	public void setNom_prestation(String nom_prestation) {
		this.nom_prestation = nom_prestation;
	}
	public Prestation() {
		super();
	}
	public Prestation(String id_prestation, String nom_prestation) {
		super();
		this.id_prestation = id_prestation;
		this.nom_prestation = nom_prestation;
	}
	@Override
	public String toString() {
		return "Prestation [id_prestation=" + id_prestation + ", nom_prestation=" + nom_prestation + "]";
	}
	
	

}
