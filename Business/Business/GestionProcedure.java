package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.ProcedureDAO;

public class GestionProcedure{
	
	private static ArrayList<Procedure> listeProcedures;
	
	static {
		listeProcedures = ProcedureDAO.getAll();
	}
	
	public static Procedure getProcedure(int id) {
		Optional<Procedure> procedure = listeProcedures.stream().filter(proc -> proc.getProcedure_id() == id).findAny();
		return procedure.isPresent() == true ? procedure.get() : null;
	}

	
	public static ArrayList<Procedure> getAllProcedures() {
		return listeProcedures;
	}

	
	public static Procedure getProcedure(String nom) {
		Optional<Procedure> procedure = listeProcedures.stream().filter(proc -> proc.getProcedure_nom().equalsIgnoreCase(nom)).findAny();
		return procedure.isPresent() == true ? procedure.get() : null;
	}
	
	public static Procedure getProcedureCommencePar(String debut) {
		Optional<Procedure> procedure = listeProcedures.stream().filter(proc -> proc.getProcedure_nom().startsWith(debut)).findAny();
		return procedure.isPresent() == true ? procedure.get() : null;
	}
	
	public static boolean addProcedure(Procedure procedure) {
		if ( procedure == null ) return false;
		if( listeProcedures.stream().anyMatch(pr -> pr.getProcedure_nom().equals(procedure.getProcedure_nom())) 
				&& listeProcedures.stream().anyMatch(pr -> pr.getService_nom().equals(procedure.getService_nom())))
			return false;
		
		int id = ProcedureDAO.add(procedure);
		if( id == 0) return false;
		else procedure.setProcedure_id(id);
		listeProcedures.add(procedure);
		return true;
	}
}
