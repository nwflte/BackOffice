package Business;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Procedure {
	private int procedure_id;
	private Chef chef;
	private String procedure_nom;
	private String service_nom;
	private LocalDateTime date_creation;
	private LocalDateTime date_modification;
	private boolean archived;
	private int nbr_documents;
	private ArrayList<Document> documents;
	private int nbr_etapes;
	private ArrayList<Etape> etapes;
	
	
	public int getProcedure_id() {
		return procedure_id;
	}
	public void setProcedure_id(int procedure_id) {
		this.procedure_id = procedure_id;
	}

	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getProcedure_nom() {
		return procedure_nom;
	}
	public void setProcedure_nom(String procedure_nom) {
		this.procedure_nom = procedure_nom;
	}
	public String getService_nom() {
		return service_nom;
	}
	public void setService_nom(String service_nom) {
		this.service_nom = service_nom;
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
	public int getNbr_etapes() {
		return nbr_etapes;
	}
	public void setNbr_etapes(int nbr_etapes) {
		this.nbr_etapes = nbr_etapes;
	}
	public ArrayList<Etape> getEtapes() {
		return etapes;
	}
	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}
	
	
}
