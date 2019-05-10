package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
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
		procedure.setProcedure_id(result.getInt("procedure_id"));
		procedure.se
		
		
		
		
	}
	
}
