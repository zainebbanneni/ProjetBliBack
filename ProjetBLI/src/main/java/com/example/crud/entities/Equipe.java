package com.example.crud.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_equipe;
	private String nom;
	
	@OneToMany(mappedBy = "equipe")
	private List<Collaborateur> collaborateurs;
	
	public String getId_equipe() {
		return id_equipe;
	}
	public void setId_equipe(String id_equipe) {
		this.id_equipe = id_equipe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public Equipe() {
		super();
	}
	public Equipe(String id_equipe, String nom) {
		super();
		this.id_equipe = id_equipe;
		this.nom = nom;
	}
	public Equipe(String id_equipe, String nom, List<Collaborateur> collaborateurs) {
		super();
		this.id_equipe = id_equipe;
		this.nom = nom;
		this.collaborateurs = collaborateurs;
	}
	@Override
	public String toString() {
		return "Equipe [id_equipe=" + id_equipe + ", nom=" + nom + ", collaborateurs=" + collaborateurs + "]";
	}

	
	
	
	
	

}
