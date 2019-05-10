package Business;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Etape {
	private int etape_id;
	private Employe employe;
	private String etape_nom;
	private LocalDateTime date_creation;
	private LocalDateTime date_modification;
	private boolean archived;
	private int nbr_documents;
	private ArrayList<Document> documents;
	
	public int getEtape_id() {
		return etape_id;
	}
	public void setEtape_id(int etape_id) {
		this.etape_id = etape_id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getEtape_nom() {
		return etape_nom;
	}
	public void setEtape_nom(String etape_nom) {
		this.etape_nom = etape_nom;
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
	public int getNbr_documents() {
		return nbr_documents;
	}
	public void setNbr_documents(int nbr_documents) {
		this.nbr_documents = nbr_documents;
	}
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
}
