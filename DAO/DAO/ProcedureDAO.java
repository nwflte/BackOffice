package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Business.Procedure;

public class ProcedureDAO {
	
	public static ArrayList<Procedure> getAll() {
		ArrayList<Procedure> listeAllProcedures = new  ArrayList<Procedure>();
		try {
		Statement st = ConnectionSingleton.getConn().createStatement();
		String getAll = "SELECT * FROM procedures";
		ResultSet result = st.executeQuery(getAll);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeAllProcedures;
	}
	
	
	private static Procedure resultToProcedure(ResultSet result) {
		Procedure procedure = new Procedure();
		try {
		procedure.setProcedure_id(result.getInt("procedure_id"));
		procedure.setProcedure_nom(result.getString("procedure_nom"));
		procedure.setService_nom(result.getString("service_nom"));
		procedure.setDate_creation(LocalDateTime.from(Instant.ofEpochMilli(result.getDate("date_creation").getTime())));
		procedure.setDate_modification(LocalDateTime.from(Instant.ofEpochMilli(result.getDate("date_modification").getTime())));
		procedure.setArchived(result.getBoolean("archived"));
		procedure.setNbr_documents(result.getInt("nbr_documents"));
		procedure.setNbr_etapes(result.getInt("nbr_etapes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return procedure;		
		
	}
	
}
