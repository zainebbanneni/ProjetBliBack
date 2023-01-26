package com.example.crud.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Indexed;

@Indexed
@Entity
public class ESIMB{
	@Id
	 @GeneratedValue(generator="system-uuid")
		@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String idacte;
	private String codeIMB;
	private String date_verification;
	public String getIdacte() {
		return idacte;
	}
	public void setIdacte(String idacte) {
		this.idacte = idacte;
	}
	
	
	public String getCodeIMB() {
		return codeIMB;
	}
	public void setCodeIMB(String codeIMB) {
		this.codeIMB = codeIMB;
	}
	public String getDate_verification() {
		return date_verification;
	}
	public void setDate_verification(String date_verification) {
		this.date_verification = date_verification;
	}
	
	public ESIMB() {
		super();
	}
	public ESIMB(String idacte, String codeIMB, String date_verification) {
		super();
		this.idacte = idacte;
		this.codeIMB = codeIMB;
		this.date_verification = date_verification;
	}
	
	
	public ESIMB(String idacte, String codeIMB) {
		super();
		this.idacte = idacte;
		this.codeIMB = codeIMB;
	}
	@Override
	public String toString() {
		return "ESIMB [idacte=" + idacte + ", codeIMB=" + codeIMB + ", date_verification=" + date_verification + "]";
	}
	
	

}
