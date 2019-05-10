package Business;

import java.util.List;

public interface IProcedure {
	Procedure getProcedure(int id);
	List<Procedure> getAllProcedures();
	Procedure getProcedure(String nom);
}
