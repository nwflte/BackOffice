package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Document;

public class DocumentDAO {
	
	public static ArrayList<Document> getAll() {
		ArrayList<Document> listeAllDocuments = new  ArrayList<Document>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM documents";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllDocuments.add(resultToDocument(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllDocuments;
	}
	
	private static Document resultToDocument(ResultSet result) {
		Document document = new Document();
		try {
			document.setDocument_id(result.getInt("document_id"));
			document.setDocument_nom(result.getString("document_nom"));
			document.setDocument_type(result.getString("document_type"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return document;
	}
}
