package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NRO_PM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_acte;
	private Date date_refus;
	public String getId_acte() {
		return id_acte;
	}
	public void setId_acte(String id_acte) {
		this.id_acte = id_acte;
	}
	public Date getDate_refus() {
		return date_refus;
	}
	public void setDate_refus(Date date_refus) {
		this.date_refus = date_refus;
	}
	public NRO_PM() {
		super();
	}
	public NRO_PM(String id_acte, Date date_refus) {
		super();
		this.id_acte = id_acte;
		this.date_refus = date_refus;
	}
	@Override
	public String toString() {
		return "NRO_PM [id_acte=" + id_acte + ", date_refus=" + date_refus + "]";
	}
	
	
	

}
