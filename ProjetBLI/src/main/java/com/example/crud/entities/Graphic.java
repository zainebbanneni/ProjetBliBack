package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Graphic {
	    @Id
	    private String idGrafic;
	    private String iar;
	    private String code_imb;
	    private String groupe_operation;
	    private String dateTraitement;
	    private String statut_graphic;
	    private String traitement_effectue;
	    private String type_traitement;
		private String id_acte;

	    public String getId_acte() {
			return id_acte;
		}

		public void setId_acte(String id_acte) {
			this.id_acte = id_acte;
		}

		public String getidGrafic() {
	        return idGrafic;
	    }

	    public void setidGrafic(String idGrafic) {
	        this.idGrafic = idGrafic;
	    }

	    public String getIar() {  
	        return this.iar;
	     }
	     public void setIar(String iar) {
	        this.iar = iar;
	     }

	     public String getCode_imb() {
	        return code_imb;
	    }
	    public void setCode_imb(String code_imb) {
	        this.code_imb = code_imb;
	    }

	    public String getgroupe_operation() {
	        return groupe_operation;
	    }

	    public void setgroupe_operation(String groupe_operation) {
	        this.groupe_operation = groupe_operation;
	    }

	    public String getdateTraitement() {
	        return dateTraitement;
	    }

	    public void setdateTraitement(String dateTraitement) {
	        this.dateTraitement = dateTraitement;
	    }

	    public String getStatut_graphic() {
	        return statut_graphic;
	    }

	    public void setStatut_graphic(String statut_graphic) {
	        this.statut_graphic = statut_graphic;
	    }

	    public String getTraitement_effectue() {
	        return traitement_effectue;
	    }

	    public void setTraitement_effectue(String traitement_effectue) {
	        this.traitement_effectue = traitement_effectue;
	    }

	    public String getType_traitement() {
	        return type_traitement;
	    }

	    public void setType_traitement(String type_traitement) {
	        this.type_traitement = type_traitement;
	    }

	    public Graphic(String idGrafic, String iar, String code_imb, String groupe_operation, String dateTraitement,
	            String statut_graphic, String traitement_effectue, String type_traitement,String id_acte) {
	        this.idGrafic = idGrafic;
	        this.iar = iar;
	        this.code_imb = code_imb;
	        this.groupe_operation = groupe_operation;
	        this.dateTraitement = dateTraitement;
	        this.statut_graphic = statut_graphic;
	        this.traitement_effectue = traitement_effectue;
	        this.type_traitement = type_traitement;
			this.id_acte = id_acte;
	    }

	    public Graphic() {
	    }

}
