package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Business.GestionChef;
import Business.GestionDocument;
import Business.GestionEtape;
import Business.Procedure;

public class ProcedureDAO {
	
	public static ArrayList<Procedure> getAll() {
		ArrayList<Procedure> listeAllProcedures = new  ArrayList<Procedure>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM procedures";
		ResultSet result = st.executeQuery(getAll);
		while(result.next()) {
			listeAllProcedures.add(resultToProcedure(result));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllProcedures;
	}
		
	
	private static Procedure resultToProcedure(ResultSet result) {
		Procedure procedure = new Procedure();
		try {
		procedure.setProcedure_id(result.getInt("procedure_id"));
		procedure.setChef(GestionChef.getChef(result.getInt("chef_id")));
		procedure.setProcedure_nom(result.getString("procedure_nom"));
		procedure.setService_nom(result.getString("service_nom"));
		procedure.setDate_creation(HelpersDAO.dateToLocalDateTime(result.getDate("date_creation")));
		procedure.setDate_modification(HelpersDAO.dateToLocalDateTime(result.getDate("date_modification")));
		procedure.setArchived(result.getBoolean("archived"));
		procedure.setNbr_documents(result.getInt("nbr_documents"));
		procedure.setNbr_etapes(result.getInt("nbr_etapes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			int[] EtapeIds = HelpersDAO.stringToInt(HelpersDAO.stringSplit(result.getString("etapes")));
			procedure.setEtapes(GestionEtape.getEtapes(EtapeIds));
			int[] DocumentIds = HelpersDAO.stringToInt(HelpersDAO.stringSplit(result.getString("documents")));
			procedure.setDocuments(GestionDocument.getDocuments(DocumentIds));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return procedure;		
		
	}
	
}
