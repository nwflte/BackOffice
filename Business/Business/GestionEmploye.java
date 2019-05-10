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
	
}
