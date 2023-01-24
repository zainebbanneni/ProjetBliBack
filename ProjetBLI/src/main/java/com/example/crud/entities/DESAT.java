package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DESAT {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_acte;
	private String type_desat;
	private String zone;
	private String FI;
	private Date date_refus;
	public String getId_acte() {
		return id_acte;
	}
	public void setId_acte(String id_acte) {
		this.id_acte = id_acte;
	}
	public String getType_desat() {
		return type_desat;
	}
	public void setType_desat(String type_desat) {
		this.type_desat = type_desat;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getFI() {
		return FI;
	}
	public void setFI(String fI) {
		FI = fI;
	}
	public Date getDate_refus() {
		return date_refus;
	}
	public void setDate_refus(Date date_refus) {
		this.date_refus = date_refus;
	}
	public DESAT() {
		super();
	}
	public DESAT(String id_acte, String type_desat, String zone, String fI, Date date_refus) {
		super();
		this.id_acte = id_acte;
		this.type_desat = type_desat;
		this.zone = zone;
		FI = fI;
		this.date_refus = date_refus;
	}
	@Override
	public String toString() {
		return "DESAT [id_acte=" + id_acte + ", type_desat=" + type_desat + ", zone=" + zone + ", FI=" + FI
				+ ", date_refus=" + date_refus + "]";
	}
	
	
	

}
