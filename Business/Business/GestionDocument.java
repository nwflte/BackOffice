package Business;

import java.util.ArrayList;
import java.util.Optional;

public class GestionDocument {
	private static ArrayList<Document> listeDocuments;
	
	
	public static Document getDocument(int id) {
		Optional<Document> document = listeDocuments.stream().filter(et -> et.getDocument_id() == id).findAny();
		return document.isPresent() == true ? document.get() : null;
	}
	
	public static ArrayList<Document> getDocuments(int[] ids) {
		ArrayList<Document> documents = new ArrayList<Document>();
		
		for(int i = 0; i < ids.length ; i++) {
			Document document = getDocument(ids[i]);
			if(document != null) documents.add(document);
		}
		return documents;
	}
}
