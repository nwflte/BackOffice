package Business;

import java.util.ArrayList;
import java.util.List;
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

	
	public static List<Procedure> getAllProcedures() {
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
}
