package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.ChefDAO;

public class GestionChef {
	private static ArrayList<Chef> listeChefs;
	
	static {
		listeChefs = ChefDAO.getAll();
	}
	
	public static Chef getChef(int id) {
		Optional<Chef> chef = listeChefs.stream().filter(ch -> ch.getChef_id() == id).findAny();
		return chef.isPresent() == true ? chef.get() : null;
	}
	
	public static ArrayList<Chef> getAllChefs() {
		return listeChefs;
	}
	
	public static boolean addChef(Chef chef) {
		if(chef == null) return false;
		if( listeChefs.stream().anyMatch(ch -> ch.getEmploye().getCIN().equals(chef.getEmploye().getCIN())) ) return false;
		if(GestionUser.addUser(chef.getUser()) == false) return false;
		int id = ChefDAO.add(chef);
		if(id == 0) return false;
		else chef.setChef_id(id);
		listeChefs.add(chef);
		return true;
	}
}
