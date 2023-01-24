package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type_element {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_acte;
	private String type_element;
	public String getId_acte() {
		return id_acte;
	}
	public void setId_acte(String id_acte) {
		this.id_acte = id_acte;
	}
	public String getType_element() {
		return type_element;
	}
	public void setType_element(String type_element) {
		this.type_element = type_element;
	}
	public Type_element() {
		super();
	}
	public Type_element(String id_acte, String type_element) {
		super();
		this.id_acte = id_acte;
		this.type_element = type_element;
	}
	@Override
	public String toString() {
		return "Type_element [id_acte=" + id_acte + ", type_element=" + type_element + "]";
	}
	
	

}
