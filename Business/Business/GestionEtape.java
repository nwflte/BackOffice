package Business;

import java.util.ArrayList;
import java.util.Optional;

public class GestionEtape {
	private static ArrayList<Etape> listeEtapes;
	
	
	public static Etape getEtape(int id) {
		Optional<Etape> etape = listeEtapes.stream().filter(et -> et.getEtape_id() == id).findAny();
		return etape.isPresent() == true ? etape.get() : null;
	}
	
	public static ArrayList<Etape> getEtapes(int[] ids) {
		ArrayList<Etape> etapes = new ArrayList<Etape>();
		
		for(int i = 0; i < ids.length ; i++) {
			Etape etape = getEtape(ids[i]);
			if(etape != null) etapes.add(etape);
		}
		return etapes;
	}
}
