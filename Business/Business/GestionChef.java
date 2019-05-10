package Business;

import java.util.ArrayList;
import java.util.Optional;

public class GestionChef {
	private static ArrayList<Chef> listeChefs;
	
	static {
		listeChefs = ChefDAO.getAll();
	}
	
	public static Chef getChef(int id) {
		Optional<Chef> chef = listeChefs.stream().filter(ch -> ch.getChef_id() == id).findAny();
		return chef.isPresent() == true ? chef.get() : null;
	}
	
	public static List<Chef> getAllChefs() {
		return listeChefs;
	}
}