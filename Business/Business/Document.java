package Business;

public class Document {
	private int document_id;
	private String document_nom;
	private String document_type; //Enum?
	
	public int getDocument_id() {
		return document_id;
	}
	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}
	public String getDocument_nom() {
		return document_nom;
	}
	public void setDocument_nom(String document_nom) {
		this.document_nom = document_nom;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	
	
}
