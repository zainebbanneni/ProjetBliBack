package com.example.crud.entities.models;

public class Esimb_Resp {
	
	private String codeIMB;
	private String dateVerification;
	
	
	   private String idactetrait;
	   private String idacte;
	    private String affectation;
		private int duree;
		private int quantite;
		private String dateLivraison;
		private String commentaire;
		private String motif;
		
		
		
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
		public String getIdactetrait() {
			return idactetrait;
		}
		public void setIdactetrait(String idactetrait) {
			this.idactetrait = idactetrait;
		}
		
		public String getIdacte() {
			return idacte;
		}
		public void setIdacte(String idacte) {
			this.idacte = idacte;
		}
		public String getAffectation() {
			return affectation;
		}
		public void setAffectation(String affectation) {
			this.affectation = affectation;
		}
		public int getDuree() {
			return duree;
		}
		public void setDuree(int duree) {
			this.duree = duree;
		}
		
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public String getDateLivraison() {
			return dateLivraison;
		}
		public void setDateLivraison(String dateLivraison) {
			this.dateLivraison = dateLivraison;
		}
		public String getCommentaire() {
			return commentaire;
		}
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
		
	
	
		public String getMotif() {
			return motif;
		}
		public void setMotif(String motif) {
			this.motif = motif;
		}
		
		
		public Esimb_Resp(String codeIMB, String dateVerification, String idactetrait, String idacte,
				String affectation, int duree, int quantite, String dateLivraison, String commentaire, String motif) {
			super();
			this.codeIMB = codeIMB;
			this.dateVerification = dateVerification;
			this.idactetrait = idactetrait;
			this.idacte = idacte;
			this.affectation = affectation;
			this.duree = duree;
			this.quantite = quantite;
			this.dateLivraison = dateLivraison;
			this.commentaire = commentaire;
			this.motif = motif;
		}
		public Esimb_Resp() {
			// TODO Auto-generated constructor stub
		}
	
	
		
		

}
