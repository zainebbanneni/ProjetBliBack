package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Motif_traitement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_motif;
	private String type_prestation;
	private String description;
	public String getId_motif() {
		return id_motif;
	}
	public void setId_motif(String id_motif) {
		this.id_motif = id_motif;
	}
	public String getType_prestation() {
		return type_prestation;
	}
	public void setType_prestation(String type_prestation) {
		this.type_prestation = type_prestation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
