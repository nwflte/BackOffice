package Business;

import java.util.ArrayList;
import java.util.Optional;

import DAO.EtapeDAO;

public class GestionEtape {
	private static ArrayList<Etape> listeEtapes;
	
	static {
		listeEtapes = EtapeDAO.getAll();
	}
	
	public static ArrayList<Etape> getAllEtapes() {
		return listeEtapes;
	}
	
	public static Etape getEtape(int id) {
		Optional<Etape> etape = listeEtapes.stream().filter(et -> et.getEtape_id() == id).findAny();
		return etape.isPresent() == true ? etape.get() : null;
	}
	
	public static boolean addEtape(Etape etape) {
		if( etape == null ) return false;
		if( listeEtapes.stream().anyMatch(et -> et.getEtape_nom().equals(etape.getEtape_nom())) && 
				listeEtapes.stream().anyMatch(et -> et.getEmploye().getEmploye_id() == etape.getEmploye().getEmploye_id()) )
			return false;
		
		int id = EtapeDAO.add(etape);
		if(id == 0) return false;
		else etape.setEtape_id(id);
		listeEtapes.add(etape);
		return true;
	}
	
	
	/**
	 * Retourne la liste de toutes les etapes qui ont les ids passés en parametre
	 * @param ids
	 * @return
	 */
	public static ArrayList<Etape> getEtapes(int[] ids) {
		ArrayList<Etape> etapes = new ArrayList<Etape>();
		
		for(int i = 0; i < ids.length ; i++) {
			Etape etape = getEtape(ids[i]);
			if(etape != null) etapes.add(etape);
		}
		return etapes;
	}
}
