package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acte_traitement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id_acte;
	private String Ref_tacheBPU;
	private String type_prestation;
	private String type_element;
	private int quantite;
	private Date date_reception;
	private Date date_livraison;
	private Date date_validation;
	private String affectation;
	private int duree;
	private String commentaire;
	private String motif;
	private String statut_facturation;
	private Date date_reprise;
	private String reprise_facturable;
	public String getId_acte() {
		return Id_acte;
	}
	public void setId_acte(String id_acte) {
		Id_acte = id_acte;
	}
	public String getRef_tacheBPU() {
		return Ref_tacheBPU;
	}
	public void setRef_tacheBPU(String ref_tacheBPU) {
		Ref_tacheBPU = ref_tacheBPU;
	}
	public String getType_prestation() {
		return type_prestation;
	}
	public void setType_prestation(String type_prestation) {
		this.type_prestation = type_prestation;
	}
	public String getType_element() {
		return type_element;
	}
	public void setType_element(String type_element) {
		this.type_element = type_element;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Date getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}
	public Date getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}
	public Date getDate_validation() {
		return date_validation;
	}
	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}
	public String getAffectation() {
		return affectation;
	}
	public void setAffectation(String affectation) {
		this.affectation = affectation;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getStatut_facturation() {
		return statut_facturation;
	}
	public void setStatut_facturation(String statut_facturation) {
		this.statut_facturation = statut_facturation;
	}
	public Date getDate_reprise() {
		return date_reprise;
	}
	public void setDate_reprise(Date date_reprise) {
		this.date_reprise = date_reprise;
	}
	public String getReprise_facturable() {
		return reprise_facturable;
	}
	public void setReprise_facturable(String reprise_facturable) {
		this.reprise_facturable = reprise_facturable;
	}
	public Acte_traitement() {
		super();
	}
	public Acte_traitement(String id_acte, String ref_tacheBPU, String type_prestation, String type_element, int quantite,
			Date date_reception, Date date_livraison, Date date_validation, String affectation, int duree,
			String commentaire, String motif, String statut_facturation, Date date_reprise, String reprise_facturable) {
		super();
		this.Id_acte = id_acte;
		this.Ref_tacheBPU = ref_tacheBPU;
		this.type_prestation = type_prestation;
		this.type_element = type_element;
		this.quantite = quantite;
		this.date_reception = date_reception;
		this.date_livraison = date_livraison;
		this.date_validation = date_validation;
		this.affectation = affectation;
		this.duree = duree;
		this.commentaire = commentaire;
		this.motif = motif;
		this.statut_facturation = statut_facturation;
		this.date_reprise = date_reprise;
		this.reprise_facturable = reprise_facturable;
	}
	public Acte_traitement(String id_acte, String type_prestation, String type_element, int quantite, Date date_reception,
			Date date_livraison, Date date_validation, String affectation, int duree, String commentaire, String motif,
			String statut_facturation, Date date_reprise, String reprise_facturable) {
		super();
		this.Id_acte = id_acte;
		this.type_prestation = type_prestation;
		this.type_element = type_element;
		this.quantite = quantite;
		this.date_reception = date_reception;
		this.date_livraison = date_livraison;
		this.date_validation = date_validation;
		this.affectation = affectation;
		this.duree = duree;
		this.commentaire = commentaire;
		this.motif = motif;
		this.statut_facturation = statut_facturation;
		this.date_reprise = date_reprise;
		this.reprise_facturable = reprise_facturable;
	}
	@Override
	public String toString() {
		return "Acte_traitement [Id_acte=" + Id_acte + ", Ref_tacheBPU=" + Ref_tacheBPU + ", type_prestation="
				+ type_prestation + ", type_element=" + type_element + ", quantite=" + quantite + ", date_reception="
				+ date_reception + ", date_livraison=" + date_livraison + ", date_validation=" + date_validation
				+ ", affectation=" + affectation + ", duree=" + duree + ", commentaire=" + commentaire + ", motif="
				+ motif + ", statut_facturation=" + statut_facturation + ", date_reprise=" + date_reprise
				+ ", reprise_facturable=" + reprise_facturable + "]";
	}
	
	
	
	
	
	

}
