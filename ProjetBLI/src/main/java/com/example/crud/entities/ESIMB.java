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
	

	@Override
	public String toString() {
		return "ESIMB [ codeIMB=" + codeIMB + ", date_verification=" + dateVerification + "]";
	}
	
	

}
