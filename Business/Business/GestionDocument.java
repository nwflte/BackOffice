package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.DocumentDAO;
import DAO.UserDAO;

public class GestionDocument {
	private static ArrayList<Document> listeDocuments;
	
	static {
		listeDocuments = DocumentDAO.getAll();
	}
	
	public static ArrayList<Document> getAllDocuments() {
		return listeDocuments;
	}
	
	public static Document getDocument(int id) {
		Optional<Document> document = listeDocuments.stream().filter(et -> et.getDocument_id() == id).findAny();
		return document.isPresent() == true ? document.get() : null;
	}
	
	public static boolean addDocument(Document document) {
		if(document == null) return false;
		if(listeDocuments.stream().anyMatch(doc -> doc.getDocument_nom().equals(document.getDocument_nom()))
				&& listeDocuments.stream().anyMatch(doc -> doc.getDocument_type().equals(document.getDocument_type())))
			return false;
		
		int id = DocumentDAO.add(document);
		if(id == 0) return false;
		else document.setDocument_id(id);
		listeDocuments.add(document);
		return true;
	}
	
	/**
	 * Retourne la liste des documents qui ont les ids passés en paramètre
	 * @param ids
	 * @return
	 */
	public static ArrayList<Document> getDocuments(int[] ids) {
		ArrayList<Document> documents = new ArrayList<Document>();
		
		for(int i = 0; i < ids.length ; i++) {
			Document document = getDocument(ids[i]);
			if(document != null) documents.add(document);
		}
		return documents;
	}
}
