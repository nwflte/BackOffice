package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Document;
import Business.User;

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
	
	
	public static int add(Document document) {
		String addDoc = "INSERT INTO documents(document_nom, document_type) values(?, ?)";
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addDoc, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, document.getDocument_nom());
			st.setString(2, document.getDocument_type());
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
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
