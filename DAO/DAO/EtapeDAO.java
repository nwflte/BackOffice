package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.Etape;
import Business.GestionDocument;
import Business.GestionEmploye;


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
