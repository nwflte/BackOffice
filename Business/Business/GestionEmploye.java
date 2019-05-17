package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.EmployeDAO;

public class GestionEmploye {
	private static ArrayList<Employe> listeEmployes;
	
	static {
		listeEmployes = EmployeDAO.getAll();
	}
	
	public static Employe getEmploye(int id) {
		Optional<Employe> employe = listeEmployes.stream().filter(emp -> emp.getEmploye_id() == id).findAny();
		return employe.isPresent() == true ? employe.get() : null;
	}
	
	public static ArrayList<Employe> getAllEmployes() {
		return listeEmployes;
	}
	
	public static boolean addEmploye(Employe employe) {
		if ( employe == null) return false;
		if ( listeEmployes.stream().anyMatch(em -> em.getCIN().equals(employe.getCIN())) ) return false;
		if(GestionUser.addUser(employe.getUser()) == false) return false;
		int id = EmployeDAO.add(employe);
		if(id == 0) {
			GestionUser.removeUser(employe.getUser());
			return false;
		}
		else employe.setEmploye_id(id);
		listeEmployes.add(employe);
		return true;
	}
	
}
