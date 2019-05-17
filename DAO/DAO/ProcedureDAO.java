package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Business.GestionChef;
import Business.GestionDocument;
import Business.GestionEtape;
import Business.Procedure;
import Business.User;

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
	
	public static int add(Procedure procedure) {
		String addProc = "INSER INTO procedures(chef_id, procedure_nom, service_nom, date_creation, date_modification, archived, nbr_documents, nbr_etapes,"
				+ "etapes, documents) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String generatedColumns[] = {"procedure_id"};
		
		PreparedStatement st;
		try {
			st = ConnectionSingleton.getConn().prepareStatement(addProc, generatedColumns);
			st.setInt(1, procedure.getChef().getChef_id());
			st.setString(2, procedure.getProcedure_nom());
			st.setString(3, procedure.getService_nom());
			st.setDate(4, Date.valueOf(procedure.getDate_creation().toLocalDate()));
			st.setDate(5, Date.valueOf(procedure.getDate_modification().toLocalDate()));
			st.setBoolean(6, false);
			st.setInt(7, procedure.getNbr_documents());
			st.setInt(8, procedure.getNbr_etapes());
			st.setString(9, HelpersDAO.etapesListToString(procedure.getEtapes()));
			st.setString(10, HelpersDAO.documentsListToString(procedure.getDocuments()));
			
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			return rs.getInt("procedure_id");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
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
