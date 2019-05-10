package Business;

import java.time.LocalDateTime;

public class Employe {
	private int employe_id;
	private User user;
	private String somme;
	private String nom;
	private String prenom;
	private String email;
	private String genre; // Enum ?
	private String CIN;
	private String telephone;
	private LocalDateTime date_naissance;
	private LocalDateTime date_recrutement;
	private LocalDateTime date_creation;
	private LocalDateTime date_modification;
	private boolean archived;
	
	
	public int getEmploye_id() {
		return employe_id;
	}
	public void setEmploye_id(int employe_id) {
		this.employe_id = employe_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSomme() {
		return somme;
	}
	public void setSomme(String somme) {
		this.somme = somme;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public LocalDateTime getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(LocalDateTime date_naissance) {
		this.date_naissance = date_naissance;
	}
	public LocalDateTime getDate_recrutement() {
		return date_recrutement;
	}
	public void setDate_recrutement(LocalDateTime date_recrutement) {
		this.date_recrutement = date_recrutement;
	}
	public LocalDateTime getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDateTime date_creation) {
		this.date_creation = date_creation;
	}
	public LocalDateTime getDate_modification() {
		return date_modification;
	}
	public void setDate_modification(LocalDateTime date_modification) {
		this.date_modification = date_modification;
	}
	public boolean isArchived() {
		return archived;
	}
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	
}
