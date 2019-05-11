package Business;

import java.time.LocalDateTime;

public class Chef implements IDInterface {
	private int chef_id;
	private Employe employe;
	private User user;
	private String service_nom;
	private LocalDateTime date_creation;
	private LocalDateTime date_modification;
	private boolean archived;
	
	public int getChef_id() {
		return chef_id;
	}
	
	
	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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


	@Override
	public int getID() {
		return this.getChef_id();
	}


	@Override
	public String getText() {
		return this.getEmploye().getNom() + " " + this.getEmploye().getPrenom();
	}
	
	
}
