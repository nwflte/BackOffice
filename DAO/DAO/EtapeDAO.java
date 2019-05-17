package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Etape;
import Business.GestionDocument;
import Business.GestionEmploye;
import Business.User;


public class EtapeDAO {
	
	public static ArrayList<Etape> getAll() {
		ArrayList<Etape> listeAllEtapes = new  ArrayList<Etape>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM etapes";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllEtapes.add(resultToEtape(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllEtapes;
	}
	
	public static int add(Etape etape) {
		String addEtape = "INSERT INTO etapes(employe_id, etape_nom, date_creation, date_modification, archived, nbr_documents, documents)"
				+ " VALUES(?,?,?,?,?,?,?)";
		String generatedColumns[] = {"etape_id"};
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addEtape, generatedColumns);
			st.setInt(1, etape.getEmploye().getEmploye_id());
			st.setString(2, etape.getEtape_nom());
			st.setDate(3, Date.valueOf(etape.getDate_creation().toLocalDate()));
			st.setDate(4, Date.valueOf(etape.getDate_modification().toLocalDate()));
			st.setBoolean(5, false);
			st.setInt(6, etape.getNbr_documents());
			st.setString(7, HelpersDAO.documentsListToString(etape.getDocuments()));
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			return rs.getInt("etape_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}


	private static Etape resultToEtape(ResultSet result) {
		Etape etape = new Etape();
		try {
			etape.setEtape_id(result.getInt("etape_id"));
			etape.setEmploye(GestionEmploye.getEmploye(result.getInt("employe_id")));
			etape.setEtape_nom(result.getString("etape_nom"));
			etape.setDate_creation(HelpersDAO.dateToLocalDateTime(result.getDate("date_creation")));
			etape.setDate_modification(HelpersDAO.dateToLocalDateTime(result.getDate("date_modification")));
			etape.setArchived(result.getBoolean("archived"));
			etape.setNbr_documents(result.getInt("nbr_documents"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int[] DocumentIds = HelpersDAO.stringToInt(HelpersDAO.stringSplit(result.getString("documents")));
			etape.setDocuments(GestionDocument.getDocuments(DocumentIds));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etape;
	}
}
