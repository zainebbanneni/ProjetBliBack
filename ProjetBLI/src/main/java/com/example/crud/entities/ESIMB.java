package com.example.crud.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Indexed;


@Entity
public class ESIMB extends Acte_traitement {
	
	private String codeBanbou;
	private String codeIMB;
	private String dateVerification;
	private boolean active;
	
	


	public String getCodeBanbou() {
		return codeBanbou;
	}
	public void setCodeBanbou(String codeBanbou) {
		this.codeBanbou = codeBanbou;
	}
	public String getCodeIMB() {
		return codeIMB;
	}
	public void setCodeIMB(String codeIMB) {
		this.codeIMB = codeIMB;
	}
	
	public String getDateVerification() {
		return dateVerification;
	}
	public void setDateVerification(String dateVerification) {
		this.dateVerification = dateVerification;
	}
	

	public ESIMB(String codeIMB, String dateVerification) {
		super();
		this.codeIMB = codeIMB;
		this.dateVerification = dateVerification;
	}
	public ESIMB() {
		super();
	}
	public ESIMB(String dateVerification2, String codeIMB2, String idactetrait, String string, int duree,
			String commentaire) {
		// TODO Auto-generated constructor stub
	}

	public ESIMB(String idacte, String refTacheBPU, String type_prestation, String type_element, int quantite,
			String dateReception, String dateLivraison, String dateValidation, String affectation, int duree,
			String commentaire, String motif, String statutFacturation, String dateReprise, String repriseFacturable,
			String codeBanbou, String codeIMB, String dateVerification, boolean active) {
		super(idacte, refTacheBPU, type_prestation, type_element, quantite, dateReception, dateLivraison,
				dateValidation, affectation, duree, commentaire, motif, statutFacturation, dateReprise,
				repriseFacturable);
		this.codeBanbou = codeBanbou;
		this.codeIMB = codeIMB;
		this.dateVerification = dateVerification;
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "ESIMB [codeBanbou=" + codeBanbou + ", codeIMB=" + codeIMB + ", dateVerification=" + dateVerification
				+ ", active=" + active + "]";
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	
	
	
	
	


	

	
	
	
	

}
