package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Acte_traitement {
	@Id
	private String idactetrait;
	private String ref_tacheBPU;
	private String type_prestation;
	private String type_element;
	private int quantite;
	private String date_reception;
	private String date_livraison;
	private String date_validation;
	private String affectation;
	private int duree;
	private String commentaire;
	private String motif;
	private String statut_facturation;
	private String date_reprise;
	private String reprise_facturable;
	
	public String getIdactetrait() {
		return idactetrait;
	}
	public void setIdactetrait(String idactetrait) {
		this.idactetrait = idactetrait;
	}
	public String getRef_tacheBPU() {
		return ref_tacheBPU;
	}
	public void setRef_tacheBPU(String ref_tacheBPU) {
		this.ref_tacheBPU = ref_tacheBPU;
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
	public String getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}
	public String getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(String date_livraison) {
		this.date_livraison = date_livraison;
	}
	public String getDate_validation() {
		return date_validation;
	}
	public void setDate_validation(String date_validation) {
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
	public String getDate_reprise() {
		return date_reprise;
	}
	public void setDate_reprise(String date_reprise) {
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
			String date_reception, String date_livraison, String date_validation, String affectation, int duree,
			String commentaire, String motif, String statut_facturation, String date_reprise, String reprise_facturable) {
		super();
		this.idactetrait = id_acte;
		this.ref_tacheBPU = ref_tacheBPU;
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
	public Acte_traitement(String id_acte, String type_prestation, String type_element, int quantite, String date_reception,
			String date_livraison, String date_validation, String affectation, int duree, String commentaire, String motif,
			String statut_facturation, String date_reprise, String reprise_facturable) {
		super();
		this.idactetrait = id_acte;
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
	
	
	public Acte_traitement(String id_acte, String ref_tacheBPU, String type_prestation, String type_element) {
		super();
		this.idactetrait = id_acte;
		this.ref_tacheBPU = ref_tacheBPU;
		this.type_prestation = type_prestation;
		this.type_element = type_element;
	}
	@Override
	public String toString() {
		return "Acte_traitement [Id_acte=" + idactetrait + ", Ref_tacheBPU=" + ref_tacheBPU + ", type_prestation="
				+ type_prestation + ", type_element=" + type_element + ", quantite=" + quantite + ", date_reception="
				+ date_reception + ", date_livraison=" + date_livraison + ", date_validation=" + date_validation
				+ ", affectation=" + affectation + ", duree=" + duree + ", commentaire=" + commentaire + ", motif="
				+ motif + ", statut_facturation=" + statut_facturation + ", date_reprise=" + date_reprise
				+ ", reprise_facturable=" + reprise_facturable + "]";
	}
	
	
	
	
	
	

}
