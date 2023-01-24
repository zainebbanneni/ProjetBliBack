package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ESIMB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id_acte;
	private String code_IMB;
	private Date date_verification;
	public String getId_acte() {
		return Id_acte;
	}
	public void setId_acte(String id_acte) {
		Id_acte = id_acte;
	}
	public String getCode_IMB() {
		return code_IMB;
	}
	public void setCode_IMB(String code_IMB) {
		this.code_IMB = code_IMB;
	}
	public Date getDate_verification() {
		return date_verification;
	}
	public void setDate_verification(Date date_verification) {
		this.date_verification = date_verification;
	}
	public ESIMB() {
		super();
	}
	public ESIMB(String id_acte, String code_IMB, Date date_verification) {
		super();
		this.Id_acte = id_acte;
		this.code_IMB = code_IMB;
		this.date_verification = date_verification;
	}
	@Override
	public String toString() {
		return "ESIMB [Id_acte=" + Id_acte + ", code_IMB=" + code_IMB + ", date_verification=" + date_verification
				+ "]";
	}
	
	
	

}
