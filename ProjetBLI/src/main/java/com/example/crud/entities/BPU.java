package com.example.crud.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String refTacheBPU; //version+type_prest+tarification
	private String type_element;
	private float PU;
	private String dateValidite;
	private String dateExpiration;
	private String type_penalite;//variable ou fixe
	private float penalite;// pourc ou prix
	private String type_prestation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRefTacheBPU() {
		return refTacheBPU;
	}
	public void setRefTacheBPU(String refTacheBPU) {
		this.refTacheBPU = refTacheBPU;
	}
	public String getType_element() {
		return type_element;
	}
	public void setType_element(String type_element) {
		this.type_element = type_element;
	}
	public float getPU() {
		return PU;
	}
	public void setPU(float pU) {
		PU = pU;
	}
	public String getDateValidite() {
		return dateValidite;
	}
	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}
	public String getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getType_penalite() {
		return type_penalite;
	}
	public void setType_penalite(String type_penalite) {
		this.type_penalite = type_penalite;
	}
	public float getPenalite() {
		return penalite;
	}
	public void setPenalite(float penalite) {
		this.penalite = penalite;
	}
	public String getType_prestation() {
		return type_prestation;
	}
	public void setType_prestation(String type_prestation) {
		this.type_prestation = type_prestation;
	}
	public BPU() {
		super();
	}
	
	
	public BPU(long id, String refTacheBPU, String type_element, float pU, String dateValidite, String dateExpiration,
			String type_penalite, float penalite, String type_prestation) {
		super();
		this.id = id;
		this.refTacheBPU = refTacheBPU;
		this.type_element = type_element;
		PU = pU;
		this.dateValidite = dateValidite;
		this.dateExpiration = dateExpiration;
		this.type_penalite = type_penalite;
		this.penalite = penalite;
		this.type_prestation = type_prestation;
	}
	
	public BPU(String refTacheBPU, String type_element, float pU, String dateValidite, String dateExpiration,
			String type_penalite, float penalite, String type_prestation) {
		super();
		this.refTacheBPU = refTacheBPU;
		this.type_element = type_element;
		PU = pU;
		this.dateValidite = dateValidite;
		this.dateExpiration = dateExpiration;
		this.type_penalite = type_penalite;
		this.penalite = penalite;
		this.type_prestation = type_prestation;
	}
	@Override
	public String toString() {
		return "BPU [id=" + id + ", refTacheBPU=" + refTacheBPU + ", type_element=" + type_element + ", PU=" + PU
				+ ", dateValidite=" + dateValidite + ", dateExpiration=" + dateExpiration + ", type_penalite="
				+ type_penalite + ", penalite=" + penalite + ", type_prestation=" + type_prestation + "]";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
