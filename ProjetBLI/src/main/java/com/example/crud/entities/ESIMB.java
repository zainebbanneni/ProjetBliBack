package com.example.crud.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Indexed;

@Indexed
@Entity
public class ESIMB extends Acte_traitement{

	private String codeIMB;
	private String dateVerification;

	
	
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
	
	public ESIMB() {
		super();
	}
	public ESIMB( String codeIMB, String dateVerification) {
		super();
		this.codeIMB = codeIMB;
		this.dateVerification = dateVerification;
	}
	

	public ESIMB(String idacte, String codeIMB2, String dateLivraison, String dateReception, String commentaire,
			String affectation, String dateReprise, String idactetrait, String string, int duree, String commentaire2) {
		// TODO Auto-generated constructor stub
	}
	public ESIMB(String idacte, String codeIMB2, String dateLivraison, String dateReception, String commentaire,
			String affectation, String dateReprise, String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ESIMB [ codeIMB=" + codeIMB + ", date_verification=" + dateVerification + "]";
	}
	
	

}
