package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Indexed;

@Indexed
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Acte_traitement {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String idactetrait;
	private String idacte;
	private String refTacheBPU;
	 @Value("ESIMB")
	private String type_prestation;
	 @Value("Forfait")
	private String type_element;
	private int quantite;
	private String dateReception;
	private String dateLivraison;
	private String dateValidation;
	private String affectation;
	private int duree;
	private String commentaire;
	private String motif;
	private String statutFacturation;
	private String dateReprise;
	private String repriseFacturable;
	
	
	public String getIdactetrait() {
		return idactetrait;
	}
	public void setIdactetrait(String idactetrait) {
		this.idactetrait = idactetrait;
	}
	public String getIdacte() {
		return idacte;
	}
	public void setIdacte(String idacte) {
		this.idacte = idacte;
	}
	public String getRefTacheBPU() {
		return refTacheBPU;
	}
	public void setRefTacheBPU(String refTacheBPU) {
		this.refTacheBPU = refTacheBPU;
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
	public String getDateReception() {
		return dateReception;
	}
	public void setDateReception(String dateReception) {
		this.dateReception = dateReception;
	}
	public String getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public String getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(String dateValidation) {
		this.dateValidation = dateValidation;
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
	public String getStatutFacturation() {
		return statutFacturation;
	}
	public void setStatutFacturation(String statutFacturation) {
		this.statutFacturation = statutFacturation;
	}
	public String getDateReprise() {
		return dateReprise;
	}
	public void setDateReprise(String dateReprise) {
		this.dateReprise = dateReprise;
	}
	public String getRepriseFacturable() {
		return repriseFacturable;
	}
	public void setRepriseFacturable(String repriseFacturable) {
		this.repriseFacturable = repriseFacturable;
	}
	public Acte_traitement() {
		super();
	}
	public Acte_traitement(String idactetrait, String idacte, String refTacheBPU, String type_prestation,
			String type_element, int quantite, String dateReception, String dateLivraison, String dateValidation,
			String affectation, int duree, String commentaire, String motif, String statutFacturation,
			String dateReprise, String repriseFacturable) {
		super();
		this.idactetrait = idactetrait;
		this.idacte = idacte;
		this.refTacheBPU = refTacheBPU;
		this.type_prestation = type_prestation;
		this.type_element = type_element;
		this.quantite = quantite;
		this.dateReception = dateReception;
		this.dateLivraison = dateLivraison;
		this.dateValidation = dateValidation;
		this.affectation = affectation;
		this.duree = duree;
		this.commentaire = commentaire;
		this.motif = motif;
		this.statutFacturation = statutFacturation;
		this.dateReprise = dateReprise;
		this.repriseFacturable = repriseFacturable;
	}
	public Acte_traitement(String idacte, String refTacheBPU, String type_prestation, String type_element, int quantite,
			String dateReception, String dateLivraison, String dateValidation, String affectation, int duree,
			String commentaire, String motif, String statutFacturation, String dateReprise, String repriseFacturable) {
		super();
		this.idacte = idacte;
		this.refTacheBPU = refTacheBPU;
		this.type_prestation = type_prestation;
		this.type_element = type_element;
		this.quantite = quantite;
		this.dateReception = dateReception;
		this.dateLivraison = dateLivraison;
		this.dateValidation = dateValidation;
		this.affectation = affectation;
		this.duree = duree;
		this.commentaire = commentaire;
		this.motif = motif;
		this.statutFacturation = statutFacturation;
		this.dateReprise = dateReprise;
		this.repriseFacturable = repriseFacturable;
	}
	@Override
	public String toString() {
		return "Acte_traitement [idactetrait=" + idactetrait + ", idacte=" + idacte + ", refTacheBPU=" + refTacheBPU
				+ ", type_prestation=" + type_prestation + ", type_element=" + type_element + ", quantite=" + quantite
				+ ", dateReception=" + dateReception + ", dateLivraison=" + dateLivraison + ", dateValidation="
				+ dateValidation + ", affectation=" + affectation + ", duree=" + duree + ", commentaire=" + commentaire
				+ ", motif=" + motif + ", statutFacturation=" + statutFacturation + ", dateReprise=" + dateReprise
				+ ", repriseFacturable=" + repriseFacturable + "]";
	}
	public Acte_traitement(String idactetrait, String refTacheBPU) {
		super();
		this.idactetrait = idactetrait;
		this.refTacheBPU = refTacheBPU;
	}
	
	
	
	
	
	
	

}
