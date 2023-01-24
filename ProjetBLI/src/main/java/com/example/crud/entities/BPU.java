package com.example.crud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Ref_tacheBPU;
	private String Unite;
	private int PU;
	private Date date_validite;
	private Date date_expiration;
	private int penalité;
	public String getRef_tacheBPU() {
		return Ref_tacheBPU;
	}
	public void setRef_tacheBPU(String ref_tacheBPU) {
		Ref_tacheBPU = ref_tacheBPU;
	}
	public String getUnite() {
		return Unite;
	}
	public void setUnite(String unite) {
		Unite = unite;
	}
	public int getPU() {
		return PU;
	}
	public void setPU(int pU) {
		PU = pU;
	}
	public Date getDate_validite() {
		return date_validite;
	}
	public void setDate_validite(Date date_validite) {
		this.date_validite = date_validite;
	}
	public Date getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
	}
	public int getPenalité() {
		return penalité;
	}
	public void setPenalité(int penalité) {
		this.penalité = penalité;
	}
	public BPU() {
		super();
	}
	public BPU(String ref_tacheBPU, String unite, int pU, Date date_validite, Date date_expiration, int penalité) {
		super();
		Ref_tacheBPU = ref_tacheBPU;
		Unite = unite;
		PU = pU;
		this.date_validite = date_validite;
		this.date_expiration = date_expiration;
		this.penalité = penalité;
	}
	
	
	
	
	
}
